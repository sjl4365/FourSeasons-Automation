package pages;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage{
    private final By homePageTitle = By.xpath("//*[@id='all-hotels-and-resorts-hotel-hero-tab']//h1[contains(text(), 'Discover')]");
    private final By selectCookie = By.id("onetrust-accept-btn-handler");
    private final By topNavHotelsandResort = By.xpath("//*[@id='TopNav-mainNav']//a[contains(text(), 'All Hotels and Resorts')]");
    private final By topNavHotelsandResortNA= By.xpath("//*[@id='button-north-america-BWTAE']");
    private final By losCabosHotelLink = By.xpath("//*[@id='region-north-america-BWTAE']//a[contains(text(), 'Los Cabos (Cabo Del Sol)')]");
    private final By checkInOutDateButton = By.id("datefield-id");
    private final By checkInDate = By.xpath("(//button[contains(@aria-label, 'Available check-in date')])[1]");
    private final By checkOutDate = By.xpath("(//button[contains(@aria-label, 'Available check-out date')])[3]");
    private final By doneButton = By.xpath("//button[contains(@class, 'flexdates-done-b')]");
    private final By checkRates = By.xpath("//div[contains(@class, 'Submit-container')]//button");
    private final By firstAddToCart = By.xpath("(//button[normalize-space()='Add to Cart'])[1]");
    private final By shoppingCartIcon = By.xpath("//*[@id='shopping_cart_icon']");
    private final By cartPriceLocator = By.xpath("//span[contains(@class, 'text-subtitle2') and contains(@class, 'text-right')]");
    
    String savedPrice;

    public void selectCookie(){
    
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if(!driver.findElements(selectCookie).isEmpty()){
            click(selectCookie);
        }
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(homePageTitle));
    }
    public void clickAllHotelsAndResorts(){
        click(topNavHotelsandResort);
    }
    public void clickNorthAmericaHotelsButton(){
        if(!driver.findElements(topNavHotelsandResortNA).isEmpty()){
            click(topNavHotelsandResortNA);
        }else{
            Assert.fail("Couldn't find NA button");
        }
    }
    public void selectLosCabosHotel(){
        if(!driver.findElements(losCabosHotelLink).isEmpty()){
            click(losCabosHotelLink);
        }
        else{
            Assert.fail("Couldn't find LosCabosbutton");
        }
    }

    public void openDatePicker(){
        if(!driver.findElements(checkInOutDateButton).isEmpty()){
            click(checkInOutDateButton);
        }else{
            Assert.fail("Couldn't find Date button");
        }
    }

    public void selectCheckInDate(){
        if(!driver.findElements(checkInDate).isEmpty()){
            click(checkInDate);
        }else{
            Assert.fail("Couldn't find check in date");
        }
        
    }

    public void selectCheckOutDate(){
        if(!driver.findElements(checkOutDate).isEmpty()){
            click(checkOutDate);
            click(doneButton);
        }else{
            Assert.fail("Couldn't find check out date");
        }

    }

    public void submitRates(){
        if(!driver.findElements(checkRates).isEmpty()){
            click(checkRates);
        }else{
            Assert.fail("Couldn't find submit button");
        }
    }

        public void selectfirstAddCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(firstAddToCart));
        if(!driver.findElements(firstAddToCart).isEmpty()){
            click(firstAddToCart);
        }else{
            Assert.fail("Couldn't find Add to Cart button");
        }
    }

    public void clickCartIcon(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        if(!driver.findElements(shoppingCartIcon).isEmpty()){
            click(shoppingCartIcon);
        }else{
            Assert.fail("Couldn't find Cart Icon");
        }
    }

    /**
     * @return price text shown in cart
     */
    public String getCartPrice(){
        try { Thread.sleep(2000); } catch (Exception e) {}
        System.err.println("inside getcart price");
        List<WebElement> spans = driver.findElements(By.tagName("span"));
        for (WebElement span : spans) {
            String txt = span.getText().trim();
            String cls = span.getAttribute("class");
        if (txt.matches(".*\\d+.*") && !txt.isEmpty()) {
            System.out.println("SPAN class='" + cls + "' text='" + txt + "'");
        }
    }
    return "";
    }

    public void verifyCartPrice(){
        String cartPrice =getCartPrice().trim();
        System.out.println("Saved price: " + this.savedPrice);
        System.out.println("Cart price: " + cartPrice);
    }

}
