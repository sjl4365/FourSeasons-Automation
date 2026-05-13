//src/test/java/steps/StepDef.java
package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import testContext.TestContext;

public class StepDef {

    @Given("User navigates to the Four Seasons homepage")
    public void iAmOnThePage() {
    }

    @And("User accepts cookie banner")
    public void selectCookie(){
        TestContext.homePage.selectCookie();
    }
    
    @And("User clicks All Hotels and Resorts")
    public void clickAllHotelsAndResort(){
        TestContext.homePage.clickAllHotelsAndResorts();
    }
    
    @And("User clicks North America button")
    public void clickNorthAmericaHotelsButton(){
        TestContext.homePage.clickNorthAmericaHotelsButton();
    }

    @And("User selects Los Cabos CDS hotel")
    public void clickLosCabosHotel(){
        TestContext.homePage.selectLosCabosHotel();
    }

    @And("User opens date picker")
    public void clickDate(){
        TestContext.homePage.openDatePicker();
    }

    @And("User selects check-in date")
    public void selectCheckInDate(){
        TestContext.homePage.selectCheckInDate();
    }

    @And("User selects check-out date")
    public void selectCheckOutDate(){
        TestContext.homePage.selectCheckOutDate();
    }

    @And ("User submit rates")
    public void submitRates(){
        TestContext.homePage.submitRates();
    }
    @And("User adds first room to cart")
    public void selectfirstAddCart(){
        TestContext.homePage.selectfirstAddCart();
    }

    @And("User clicks cart icon")
    public void clickCartIcon(){
        TestContext.homePage.clickCartIcon();
    }

    @And("User verifies cart price")
    public void verifyCartPrice(){
        TestContext.homePage.verifyCartPrice();
    }
}