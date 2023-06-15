package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    //Locators
    private final By logoLocator = By.className("app_logo");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageOpened() {
        waitForVisibility(logoLocator);
        return isDisplayed(logoLocator);
    }
}
