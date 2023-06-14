
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    BasePage basePage;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeAll
    void initialize() {
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    @Description("username empty && password empty")
    @Tag("Negative")
    void empty_username_and_empty_password_test() {
        basePage.goToUrl("https://www.saucedemo.com");
        Assertions.assertTrue(loginPage.isLoginPageOpened());
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        String errorMessage = "Epic sadface: Username is required";
        Assertions.assertEquals(errorMessage, loginPage.getErrorMessage());
    }

    @Test
    @Description("username empty && password not empty")
    @Tag("Negative")
    void empty_username_and_not_empty_password_test() {
        basePage.goToUrl("https://www.saucedemo.com");
        Assertions.assertTrue(loginPage.isLoginPageOpened());
        loginPage.enterUsername("");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        String errorMessage = "Epic sadface: Username is required";
        Assertions.assertEquals(errorMessage, loginPage.getErrorMessage());
    }
    @Test
    @Description("username not empty && password empty")
    @Tag("Negative")
    void not_empty_username_and_empty_password_test() {
        basePage.goToUrl("https://www.saucedemo.com");
        Assertions.assertTrue(loginPage.isLoginPageOpened());
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        String errorMessage = "Epic sadface: Password is required";
        Assertions.assertEquals(errorMessage, loginPage.getErrorMessage());
    }

    @Test
    @Description("username incorrect && password incorrect")
    @Tag("Negative")
    void incorrect_username_and_incorrect_password_test() {
        basePage.goToUrl("https://www.saucedemo.com");
        Assertions.assertTrue(loginPage.isLoginPageOpened());
        loginPage.enterUsername("incorrect_username");
        loginPage.enterPassword("incorrect_password");
        loginPage.clickLoginButton();
        String errorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assertions.assertEquals(errorMessage, loginPage.getErrorMessage());
    }

    @Test
    @Description("username correct && password incorrect")
    @Tag("Negative")
    void correct_username_and_incorrect_password_test() {
        basePage.goToUrl("https://www.saucedemo.com");
        Assertions.assertTrue(loginPage.isLoginPageOpened());
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("incorrect_password");
        loginPage.clickLoginButton();
        String errorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assertions.assertEquals(errorMessage, loginPage.getErrorMessage());
    }

    @Test
    @Description("username incorrect && password correct")
    @Tag("Negative")
    void incorrect_username_and_correct_password_test() {
        basePage.goToUrl("https://www.saucedemo.com");
        Assertions.assertTrue(loginPage.isLoginPageOpened());
        loginPage.enterUsername("incorrect_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        String errorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assertions.assertEquals(errorMessage, loginPage.getErrorMessage());
    }

    @Test
    @Description("username correct && password correct")
    @Tag("Positive")
    void correct_username_and_correct_password_test() {
        basePage.goToUrl("https://www.saucedemo.com");
        Assertions.assertTrue(loginPage.isLoginPageOpened());
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assertions.assertTrue(homePage.isHomePageOpened());
    }

}
