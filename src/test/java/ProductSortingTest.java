import helpers.SortingHelper;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import pages.HomePage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProductSortingTest extends BaseTest {

    HomePage homePage;
    SortingHelper sortingHelper;
    List<String> expectedProductNamesList;
    List<String> expectedProductPricesList;

    @BeforeAll
    void initialize() {
        this.homePage = new HomePage(driver);
        this.sortingHelper = new SortingHelper(driver);
    }

    @BeforeEach
    void initializeData() {
        expectedProductNamesList = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)");
        expectedProductPricesList = Arrays.asList("$7.99","$9.99","$15.99","$15.99","$29.99","$49.99");
    }


    @Test
    @Description("Product sorting A to Z")
    void sorting_product_a_to_z() {
        sortingHelper.sorting("az");
        Assertions.assertEquals(expectedProductNamesList, homePage.getSortedProductNames());
    }

    @Test
    @Description("Product sorting Z to A")
    void sorting_product_z_to_a() {
        expectedProductNamesList.sort(Collections.reverseOrder());
        sortingHelper.sorting("za");
        Assertions.assertEquals(expectedProductNamesList, homePage.getSortedProductNames());
    }

    @Test
    @Description("Product sorting low price to high price")
    void sorting_product_low_price_to_high_price() {
        sortingHelper.sorting("lohi");
        Assertions.assertEquals(expectedProductPricesList, homePage.getSortedProductPrices());
    }

    @Test
    @Description("Product sorting high price to low price")
    void sorting_product_high_price_to_low_price() {
        Collections.reverse(expectedProductPricesList);
        sortingHelper.sorting("hilo");
        Assertions.assertEquals(expectedProductPricesList, homePage.getSortedProductPrices());
    }
}
