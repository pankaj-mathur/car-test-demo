package utils;

import java.io.IOException;
import java.time.Duration;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Utility class for handling cookie consent on webpages.
 * Provides a method to accept cookies if a consent button is visible, 
 * with logging to track actions and outcomes.
 */
public class CookieHandler {

    /**
     * Logger for tracking actions and outcomes, configured to write to "selenium_results.log".
     */
    private static final Logger logger = Logger.getLogger(CookieHandler.class.getName());

    // Static initializer to set up the logger with file handling and a simple formatter
    static {
        try {
            FileHandler fileHandler = new FileHandler("selenium_results.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false); // Avoid console logs if not needed
        } catch (IOException e) {
            System.err.println("Failed to set up logger: " + e.getMessage());
        }
    }

    /**
     * Attempts to accept cookies on a webpage by clicking the consent button if visible.
     * Uses an explicit wait to locate the button within a specified timeout.
     * Logs success or failure of the action to the file.
     *
     * @param driver the WebDriver instance controlling the browser
     * @throws InterruptedException if the thread is interrupted while waiting
     */
    public static void acceptCookies(WebDriver driver) throws InterruptedException {
        try {
            logger.info("Attempting to accept cookies...");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement acceptButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-accept-btn-handler")));
            
            if (acceptButton != null) {
                acceptButton.click();
                logger.info("Cookie consent button found and clicked.");
            } else {
                logger.warning("Cookie consent button not found, proceeding without clicking.");
            }
            
        } catch (TimeoutException e) {
            logger.warning("Cookie consent banner not found within the timeout period.");
        } catch (Exception e) {
            logger.severe("An error occurred while trying to accept cookies: " + e.getMessage());
        }
    }
}
