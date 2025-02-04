package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;


public class LoginSteps {
    WebDriver driver = Hooks.getDriver();
    Page_Login LoginPage;
    Page_CuraHomepage CuraHomepage ;


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver.get("http://demoaut.katalon.com");
        LoginPage = new Page_Login(driver);
        CuraHomepage = new Page_CuraHomepage(driver);
    }

    @When("the user enters a valid username and password")
    public void the_user_enters_a_valid_username_and_password() {
        CuraHomepage.clickMakeAppointment();
        LoginPage.enterUsername("John Doe");
        LoginPage.enterPassword("ThisIsNotAPassword");
    }
    @When("the user enters an invalid username and password")
    public void the_user_enters_an_invalid_username_and_password() {
        CuraHomepage.clickMakeAppointment();
        LoginPage.enterUsername("John Doe 1");
        LoginPage.enterPassword("ThisIsNotAPassword");
    }


    @When("clicks on the login button")
    public void clicks_on_the_login_button() {
        LoginPage.clickLogin();
    }

    @Then("the user should be redirected to the homepage")
    public void the_user_should_be_redirected_to_the_homepage() {
        String expectedURL = "https://katalon-demo-cura.herokuapp.com/#appointment";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals("User is not redirected to homepage!", expectedURL, actualURL);
    }

    @Then("the user should see an error message")
    public void the_user_should_see_an_error_message() {
        String expectedURL = "https://katalon-demo-cura.herokuapp.com/#appointment";
        String actualURL = driver.getCurrentUrl();
        Assert.assertNotEquals("Username or password is correct!", expectedURL, actualURL);
    }
}
