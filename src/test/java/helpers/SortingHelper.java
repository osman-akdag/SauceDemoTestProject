package helpers;

import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class SortingHelper {
    LoginHelper loginHelper;
    HomePage homePage;
    public SortingHelper(WebDriver driver) {
        loginHelper = new LoginHelper(driver);
        homePage = new HomePage(driver);
    }
    public void sorting(String sortingType){
        loginHelper.loginSuccessful("standard_user","secret_sauce");
        homePage.clickProductSortField();
        homePage.selectProductSortingType(sortingType);
    }
}
