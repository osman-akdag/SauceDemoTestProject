package helpers;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class LoginHelper {
    WebDriver driver;
    BasePage basePage;
    LoginPage loginPage;
    HomePage homePage;

    public LoginHelper(WebDriver driver, BasePage basePage, LoginPage loginPage, HomePage homePage) {
        this.driver = driver;
        this.basePage = basePage;
        this.loginPage = loginPage;
        this.homePage = homePage;
    }

    private void login(String username,String password){
        basePage.goToUrl("https://www.saucedemo.com");
        Assertions.assertTrue(loginPage.isLoginPageOpened());
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }
    public void loginSuccessful(String username,String password) {
        login(username,password);
        Assertions.assertTrue(homePage.isHomePageOpened());
    }
    public void loginFailed(String username,String password,String errorMessage){
        login(username,password);
        Assertions.assertEquals(errorMessage, loginPage.getErrorMessage());
    }
}
