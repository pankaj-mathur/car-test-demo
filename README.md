# Selenium Cucumber Testing Framework

This framework is designed to automate web tests using **Selenium** with **Cucumber** for behavior-driven development (BDD). It leverages **JUnit** for test execution and **cucumber-reporting** for enhanced HTML reports.
Some of the capability of thid framework is as equested:
#### Can read car reg from the file input
#### Compare the output
#### Can ad more input filrs using example in featute file
#### Used design pattern
#### can be reused for any other domain
#### can be run on Edge without updating Edge driver

## Table of Contents
- [Project Structure](#project-structure)
- [Features](#features)
- [Setup and Installation](#setup-and-installation)
- [Running Tests](#running-tests)
- [Generating Enhanced HTML Reports](#generating-enhanced-html-reports)
- [Configuration](#configuration)
- [Logging](#logging)
- [Troubleshooting](#troubleshooting)
- [Extending the Framework](#extending-the-framework)

## Project Structure

The framework is organized as follows:

- **`models`**: Holds data models, such as `Vehicle.java`.
- **`pages`**: Contains Page Object Model classes like `CarValuationPage.java` to interact with web pages.
- **`steps`**: Defines step definitions in Cucumber, mapping feature file steps to Java code.
- **`utils`**: Includes utility classes for WebDriver setup, file reading, cookie handling, and report generation.
- **`runners`**: Contains the main test runner class, `TestRunner.java`, which configures and runs Cucumber tests.

## Features

- **Behavior-Driven Development (BDD)** with Cucumber for readable and maintainable tests.
- **Page Object Model (POM)** for organized and reusable interactions with web pages.
- **JSON Reporting and Enhanced HTML Reports** with `cucumber-reporting` for detailed and visually appealing test results.
- **Automated WebDriver Management** using WebDriverManager.
- **Custom Logging** for tracking actions and errors during test execution.

## Setup and Installation

### Prerequisites

- **Java JDK 8+**
- **Maven**
- **Google Chrome** or **Microsoft Edge**

### Installation

1. **Clone the repository**:
   ```bash
   git clone <your-repo-url>
   cd <your-repo-directory>

## Key Classes and Utilities

### 1. **`Vehicle` (Model)**
   Represents vehicle data with fields for registration number, make, model, and year.

### 2. **`CarValuationPage` (Page Object)**
   A Page Object Model class for interacting with the car valuation page, including:
   - Entering vehicle registration and mileage.
   - Retrieving car valuation details.

### 3. **`CarValuationSteps` (Step Definitions)**
   Step definitions for Cucumber scenarios, implementing steps for reading files, extracting registrations, fetching valuations, and validating test results.

### 4. **`FileUtil` (Utility)**
   Reads input and output files for vehicle data:
   - `readInputFile`: Reads registration numbers from a file.
   - `readOutputFile`: Reads vehicle details and maps them by registration number.

### 5. **`CookieHandler` (Utility)**
   Handles cookie consent pop-ups:
   - `acceptCookies`: Attempts to accept cookies if the consent button is visible on the page and logs actions.

### 6. **`WebDriverUtil` (Utility)**
   Configures the WebDriver for running tests in headless mode with various options.

### 7. **`TestRunner` (Runner)**
   Configures Cucumber options and runs tests with JUnit. It defines:
   - `features`: Path to feature files.
   - `glue`: Path to step definition classes.
   - `plugin`: Report format and output location.

### Configuration
Browser Setup: The WebDriverUtil class uses WebDriverManager to download the appropriate WebDriver binary for Edge. Ensure you have the correct version of Edge installed, or modify the browser configuration if using Chrome.

### Properties File: In the config.properties file (located in src/test/resources), specify any required configuration values:

properties
api.url=https://example.com/car-valuation

### Data Files: Place car_input.txt and car_output.txt in the src/test/resources directory. These files contain input and expected output data for vehicle registrations.

### Running Tests
Run Tests with Maven: Execute the following Maven command to run the test suite:
bash
mvn test

Run Individual Tests with JUnit: Run TestRunner.java directly from your IDE (e.g., IntelliJ IDEA or Eclipse) to execute Cucumber tests.

### Viewing Test Reports
After running tests, reports are generated in the target directory:
HTML Report: target/cucumber-report.html provides a summary of the test results.

### Logging
The CookieHandler class logs actions and test outcomes to selenium_results.log:
Located in the root project directory.

Logs details about cookie acceptance, errors, and timeouts.# car-test-demo
