
import helpers.LoginHelper;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    BasePage basePage;
    LoginPage loginPage;
    HomePage homePage;
    LoginHelper loginHelper;

    //constants
    String wrongLoginErrorMessage = "Epic sadface: Username and password do not match any user in this service";
    String emptyUsernameErrorMessage = "Epic sadface: Username is required";
    String emptyPasswordErrorMessage = "Epic sadface: Password is required";

    @BeforeAll
    void initialize() {
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginHelper = new LoginHelper(driver);
    }

    @Test
    @Description("username empty && password empty")
    @Tag("Negative")
    void empty_username_and_empty_password_test() {
        loginHelper.loginFailed("", "", emptyUsernameErrorMessage);
    }

    @Test
    @Description("username empty && password not empty")
    @Tag("Negative")
    void empty_username_and_not_empty_password_test() {
        loginHelper.loginFailed("", "secret_sauce", emptyUsernameErrorMessage);
    }

    @Test
    @Description("username not empty && password empty")
    @Tag("Negative")
    void not_empty_username_and_empty_password_test() {
        loginHelper.loginFailed("standard_user", "", emptyPasswordErrorMessage);
    }

    @Test
    @Description("username incorrect && password incorrect")
    @Tag("Negative")
    void incorrect_username_and_incorrect_password_test() {
        loginHelper.loginFailed("incorrect_username", "incorrect_password", wrongLoginErrorMessage);
    }

    @Test
    @Description("username correct && password incorrect")
    @Tag("Negative")
    void correct_username_and_incorrect_password_test() {
        loginHelper.loginFailed("standard_user", "incorrect_password", wrongLoginErrorMessage);
    }

    @Test
    @Description("username incorrect && password correct")
    @Tag("Negative")
    void incorrect_username_and_correct_password_test() {
        loginHelper.loginFailed("incorrect_username", "secret_sauce", wrongLoginErrorMessage);
    }

    @Test
    @Description("username correct && password correct")
    @Tag("Positive")
    void correct_username_and_correct_password_test() {
        loginHelper.loginSuccessful("standard_user", "secret_sauce");
    }

}
