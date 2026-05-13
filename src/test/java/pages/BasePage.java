// //src/main/java/pagess/BasePage.java

// src/test/java/pages/BasePage.java
package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    private static final int TIMEOUT = 15;
    public static WebDriver driver;

    public void setDriver(WebDriver driver){
        BasePage.driver = driver;
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected WebElement waitForElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    protected void set(By locator, String text){
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void setDrop(By locator, String text){
        Select dropdown = new Select(find(locator));
        dropdown.selectByVisibleText(text);
    }

    protected void click(By locator) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    int attempts = 0;
    while (attempts < 3) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
            return;
        } catch (StaleElementReferenceException e) {
            attempts++;
        }
    }
}

    protected void jsClick(By locator) {
        WebElement element = waitForElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    protected void clear(By locator){
        find(locator).clear();
    }

    protected void pressTab(By locator){
        find(locator).sendKeys(Keys.TAB);
    }

    protected String getText(By locator) {
        return waitForElement(locator).getText();
    }

    protected void dismissOverlayIfPresent(By overlayLocator, By closeLocator) {
        if (isElementPresent(overlayLocator)) {
            try {
                jsClick(closeLocator);
            } catch (Exception e) {
                System.out.println("Overlay dismiss failed, continuing...");
            }
        }
    }

    protected void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(
            d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete")
        );
    }
}