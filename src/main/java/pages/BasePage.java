package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class BasePage {
    WebDriver driver;
    int duration = 5;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    public void enterData(By locator, String text) {
        find(locator).sendKeys(text);
    }

    public String getText(By locator) {
        return find(locator).getText();
    }

    public void clickElement(By locator) {
        find(locator).click();
    }

    public boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public void waitForVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
