//src/test/java/testContext/TestContext.java
// package testContext;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;

// import pages.HomePage;
// import io.cucumber.java.After;
// import io.cucumber.java.Before;

// public class TestContext {

//     public static WebDriver driver;
//     public static HomePage homePage;
//     private static final String URL = "https://www.fourseasons.com/";

//     @Before
//     public void setUp() {
//         driver.manage().window().maximize();
//         driver.get(URL);
//         homePage = new HomePage();
//         homePage.setDriver(driver);
//     }

//     @After
//     public void tearDown() {
//         if (driver != null) {
//             driver.quit();
//         }
//     }
// }


//src/test/java/testContext/TestContext.java
package testContext;

import org.openqa.selenium.WebDriver;  // Auto-downloads the correct ChromeDriver
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
// import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;

public class TestContext {

    public static WebDriver driver;
    public static HomePage homePage;
    private static final String URL = "https://www.fourseasons.com";

    @Before
    public void setUp() {

        // WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get(URL);
        homePage = new HomePage();
        homePage.setDriver(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}