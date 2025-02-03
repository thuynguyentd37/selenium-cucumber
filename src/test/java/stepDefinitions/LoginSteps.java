package stepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginSteps {
    WebDriver driver;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        WebDriverManager.chromedriver().clearDriverCache().setup(); // Auto-detect & download the correct driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.get("http://demoaut.katalon.com");
    }

    @When("the user enters a valid username and password")
    public void the_user_enters_a_valid_username_and_password() {
        driver.findElement(By.cssSelector("#btn-make-appointment")).click();
        driver.findElement(By.cssSelector("input#txt-username")).sendKeys("John Doe");
        driver.findElement(By.cssSelector("input#txt-password")).sendKeys("ThisIsNotAPassword");
    }

    @When("clicks on the login button")
    public void clicks_on_the_login_button() {
        driver.findElement(By.cssSelector(".btn-default")).click();
    }

    @Then("the user should be redirected to the homepage")
    public void the_user_should_be_redirected_to_the_homepage() {
        String expectedURL = "https://katalon-demo-cura.herokuapp.com/#appointment";
        String actualURL = driver.getCurrentUrl();
        if (!actualURL.equals(expectedURL)) {
            throw new AssertionError("User was not redirected to the homepage.");
        }
        driver.quit();
    }
}
