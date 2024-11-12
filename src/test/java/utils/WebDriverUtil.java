package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtil {
    public static WebDriver getWebDriver() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();

        options.addArguments("--no-sandbox"); // Optional
        options.addArguments("--disable-dev-shm-usage"); // Optional
        // Disable pop-ups or location prompts as general practice
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        return new EdgeDriver(options);
    }
}