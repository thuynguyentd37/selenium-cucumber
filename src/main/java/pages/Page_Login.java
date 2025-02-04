package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_Login {
    WebDriver driver;

    // Locators
    By usernameField = By.cssSelector("input#txt-username");
    By passwordField = By.cssSelector("input#txt-password");
    By loginButton = By.cssSelector(".btn-default");

    // Constructor
    public Page_Login(WebDriver driver) {
        this.driver = driver;
    }

    // Page Actions
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}
