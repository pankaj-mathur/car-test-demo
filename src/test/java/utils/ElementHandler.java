package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

/**
 * Utility class for handling web elements in Selenium.
 * Provides methods to locate elements with safe error handling for absent elements.
 */
public class ElementHandler {

    /**
     * Attempts to locate a web element using the specified locator.
     * If the element is not present, returns null instead of throwing an exception.
     *
     * @param driver the WebDriver instance used to interact with the web page
     * @param locator the locator used to find the web element
     * @return the WebElement if found, or null if the element is not present
     */
    public static WebElement findElementIfPresent(WebDriver driver, By locator) {
        try {
            return driver.findElement(locator);
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + locator);
            return null;
        }
    }
}
