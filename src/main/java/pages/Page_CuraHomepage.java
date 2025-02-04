package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_CuraHomepage {
    WebDriver driver;

    // Locators
    By btn_MakeAppointment = By.cssSelector("#btn-make-appointment");

    // Constructor
    public Page_CuraHomepage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMakeAppointment() {
        driver.findElement(btn_MakeAppointment).click();
    }
}
