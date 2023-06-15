package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    WebDriver driver;

    //Locators
    private final By login_logo = By.cssSelector(".login_logo");
    private final By usernameInputLocator = By.id("user-name");
    private final By passwordInputLocator = By.id("password");
    private final By loginButtonLocator = By.id("login-button");
    private final By errorMessageLocator = By.cssSelector("h3");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isLoginPageOpened() {
        waitForVisibility(login_logo);
        return isDisplayed(login_logo);
    }

    public void enterUsername(String username) {
        waitForClickable(usernameInputLocator);
        enterData(usernameInputLocator, username);
    }

    public void enterPassword(String password) {
        waitForClickable(passwordInputLocator);
        enterData(passwordInputLocator, password);
    }

    public void clickLoginButton() {
        waitForClickable(loginButtonLocator);
        clickElement(loginButtonLocator);
    }

    public String getErrorMessage() {
        waitForVisibility(errorMessageLocator);
        return getText(errorMessageLocator);
    }

}
