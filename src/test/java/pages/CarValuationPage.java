package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

/**
 * Represents the Car Valuation page in a web application, providing methods 
 * to perform car valuation searches and retrieve vehicle details.
 */
public class CarValuationPage {

    /**
     * Timeout duration for explicit waits in seconds.
     */
    private static final int EXPLICIT_WAIT_TIME_SECS = 10;

    /**
     * Timeout duration for page load waits in seconds.
     */
    private static final int PAGE_LOAD_WAIT_TIME_SECS = 5;

    private WebDriver driver;

    /**
     * Locator for the registration input field on the car valuation page.
     */
    private By regField = By.id("vehicleReg");

    /**
     * Locator for the mileage input field on the car valuation page.
     */
    private By mileageField = By.id("Mileage");

    /**
     * Locator for the "Get Valuation" button on the car valuation page.
     */
    private By getValuationButton = By.id("btn-go");

    /**
     * Locator for the email input field on the car valuation page.
     */
    private By emailField = By.id("EmailAddress");

    /**
     * Locator for the vehicle details text element on the car valuation page.
     */
    private By carDetailsText = By.xpath("//div[3]//div[contains(@class, 'vehicle-details')]/div[2]");

    /**
     * Constructs a new CarValuationPage with the specified WebDriver instance.
     * Sets a page load timeout for the WebDriver.
     *
     * @param driver the WebDriver instance to interact with the page
     */
    public CarValuationPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_WAIT_TIME_SECS));
    }

    /**
     * Opens the Car Valuation page with the specified URL.
     *
     * @param url the URL of the car valuation page
     */
    public void open(String url) {
        driver.get(url);
    }

    /**
     * Searches for a car valuation by entering the registration number and mileage.
     * Waits until the registration field is visible before entering details.
     *
     * @param regNumber the registration number of the vehicle
     * @param mileage the mileage of the vehicle
     */
    public void searchCar(String regNumber, String mileage) { 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIME_SECS));
        WebElement regInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(regField));
        regInputField.sendKeys(regNumber);
        driver.findElement(mileageField).sendKeys(mileage);
        driver.findElement(getValuationButton).click();
    }

    /**
     * Retrieves the car valuation details after performing a search.
     * Waits until the email field is visible before attempting to retrieve details.
     *
     * @return the car valuation details as a String
     */
    public String getCarValuation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIME_SECS));
        WebElement carDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        Assert.assertTrue("Car details not found", carDetails.isDisplayed());
        return driver.findElement(carDetailsText).getText();
    }
}
