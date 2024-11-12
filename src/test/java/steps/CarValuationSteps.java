package steps;

import io.cucumber.java.en.*;
import models.Vehicle;
import pages.CarValuationPage;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import utils.Config;
import utils.CookieHandler;
import utils.FileUtil;
import utils.WebDriverUtil;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Step definitions for the car valuation Cucumber feature. 
 * This class defines the Cucumber steps used to read input files, extract registration numbers, 
 * fetch car valuation details, and compare with expected results.
 */
public class CarValuationSteps {
    
    /**
     * WebDriver instance used to interact with the web page.
     */
    private WebDriver driver;

    /**
     * Page object for the car valuation page.
     */
    private CarValuationPage carValuationPage;

    /**
     * List of registration numbers extracted from the input file.
     */
    private List<String> regNumbers;

    /**
     * Map of expected vehicle data from the output file.
     */
    private Map<String, Vehicle> expectedVehicles;

    /**
     * Flag to track if all registrations have matched expected data.
     */
    private boolean result = false;

    /**
     * String to track any registration numbers with mismatched data.
     */
    private String missingReg = null;

    /**
     * Reads the input and output files, extracting registration numbers and expected vehicles.
     *
     * @param inputFilePath  the path to the input file containing registration numbers
     * @param outputFilePath the path to the output file containing expected vehicle data
     * @throws IOException if an error occurs while reading the files
     */
    @Given("the input file {string} and output file {string}")
    public void readFiles(String inputFilePath, String outputFilePath) throws IOException {
        regNumbers = FileUtil.readInputFile(inputFilePath);
        expectedVehicles = FileUtil.readOutputFile(outputFilePath);
    }

    /**
     * Verifies that registration numbers have been successfully extracted from the input file.
     */
    @When("I extract registration numbers from the input file")
    public void extractRegistrations() {
        Assert.assertNotNull("Failed to extract registration numbers.", regNumbers);
    }

    /**
     * Fetches car valuations from the website for each registration number, 
     * comparing the result with expected vehicle data.
     *
     * @throws InterruptedException if interrupted while waiting
     */
    @When("I fetch car valuation from the website for each registration")
    public void fetchCarValuation() throws InterruptedException {
        driver = WebDriverUtil.getWebDriver();
        carValuationPage = new CarValuationPage(driver);

        for (String reg : regNumbers) {
            carValuationPage.open(Config.getSetting("api.url").toString());
            CookieHandler.acceptCookies(driver);
            carValuationPage.searchCar(reg, String.valueOf((int) (Math.random() * 100000))); // Random mileage

            String valuation = carValuationPage.getCarValuation();
            Vehicle expectedVehicle = expectedVehicles.get(reg);
            Assert.assertNotNull("No expected data for registration: " + reg, expectedVehicle);
            Assert.assertTrue("Mismatch in make for: " + reg, valuation.contains(expectedVehicle.getMake()));

            if (valuation.contains(expectedVehicle.getMake())) {
                result = true;
            } else {
                result = false;
                missingReg = (missingReg == null ? "" : missingReg) + " " + reg;
            }
        }
    }

    /**
     * Compares the retrieved valuations with expected output, 
     * asserting if any registration numbers did not match expected data.
     */
    @Then("I compare the valuations with the expected output")
    public void compareValuations() {
        Assert.assertTrue("Mismatch in registration, these regs are having issues: " + missingReg, result);
        driver.quit();
    }
}
