package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    //Locators
    private final By logoLocator = By.className("app_logo");
    private final By productSortLocator = By.className("product_sort_container");
    private final By productSortFrom_A_to_Z_Locator = By.cssSelector("[value='az']");
    private final By productSortFrom_Z_to_A_Locator = By.cssSelector("[value='za']");
    private final By productSortFromLowPriceToHighPriceLocator = By.cssSelector("[value='lohi']");
    private final By productSortFromHighPriceToLowPriceLocator = By.cssSelector("[value='hilo']");
    private final By productItemNamesLocator = By.className("inventory_item_name");
    private final By productItemPricesLocator=By.className("inventory_item_price");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageOpened() {
        waitForVisibility(logoLocator);
        return isDisplayed(logoLocator);
    }

    public void clickProductSortField() {
        waitForClickable(productSortLocator);
        clickElement(productSortLocator);
    }

    public void selectProductSortingType(String sortingType) {
        switch (sortingType) {
            case "az":
                waitForClickable(productSortFrom_A_to_Z_Locator);
                clickElement(productSortFrom_A_to_Z_Locator);
                break;
            case "za":
                waitForClickable(productSortFrom_Z_to_A_Locator);
                clickElement(productSortFrom_Z_to_A_Locator);
                break;
            case "lohi":
                waitForClickable(productSortFromLowPriceToHighPriceLocator);
                clickElement(productSortFromLowPriceToHighPriceLocator);
                break;
            case "hilo":
                waitForClickable(productSortFromHighPriceToLowPriceLocator);
                clickElement(productSortFromHighPriceToLowPriceLocator);
                break;
        }

    }

    // Returns the names of the sorted products.
    public List<String> getSortedProductNames() {
        List<String> actualProductNamesList = new ArrayList<>();
        waitForVisibility(productItemNamesLocator);
        List<WebElement> productElements = findAll(productItemNamesLocator);
        for (WebElement productElement: productElements) {
            actualProductNamesList.add(productElement.getText());
        }
        return actualProductNamesList;
    }

    // Returns the prices of the sorted products.
    public List<String> getSortedProductPrices() {
        List<String> actualProductPricesList = new ArrayList<>();
        waitForVisibility(productItemPricesLocator);
        List<WebElement> productElements = findAll(productItemPricesLocator);
        for (WebElement productElement: productElements) {
            actualProductPricesList.add(productElement.getText());
        }
        return actualProductPricesList;
    }
}
