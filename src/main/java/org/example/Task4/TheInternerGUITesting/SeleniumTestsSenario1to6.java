package org.example.Task4.TheInternerGUITesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class SeleniumTestsSenario1to6 {
  // Declare WebDriver and WebDriverWait as static class variables
  private static WebDriver driver;
  private static WebDriverWait wait;

  public static void main(String[] args) {
    // Set the path to ChromeDriver (update this to your ChromeDriver location)
    System.setProperty("webdriver.chrome.driver", "/usr/local/chromedriver/");

    // Configure Chrome options
    ChromeOptions options = new ChromeOptions();
    // options.addArguments("--headless"); // Uncomment for headless mode

    // Initialize the WebDriver and WebDriverWait
    driver = new ChromeDriver(options);
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    try {
      // Run the test scenarios
      testScenario1(); // Upload with no file
      testScenario2(); // Homepage and A/B testing
      // Add more scenarios here as needed: testScenario3(), testScenario4(), etc.
    } finally {
      // Clean up: close the browser after all tests
      driver.quit();
    }
  }

  // Test Scenario 1: Assert that uploading with no file fails
  public static void testScenario1() {
    try {
      System.out.println("Running Test Scenario 1: Upload with no file...");
      driver.get("https://the-internet.herokuapp.com/upload");

      // Verify the file uploader
      WebElement fileUploader = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("file-upload")));
      if (fileUploader == null || !fileUploader.isDisplayed()) {
        System.out.println("Test Scenario 1 Failed: File uploader element not found.");
        return;
      }

      //We don't choose any files

      // Click upload button without selecting a file
      WebElement uploadButton = driver.findElement(By.id("file-submit"));
      uploadButton.click();

      // Wait briefly for any potential page change
      Thread.sleep(1000);

      Boolean resultMessage = wait.until(ExpectedConditions.or(
              ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='File Uploaded!']"))
      ));

      if ( !resultMessage) {
        System.out.println("Test Scenario 1 Passed: Upload attempt with no file failed as expected.");
      } else {
        System.out.println("Test Scenario 1 Failed: Upload succeeded unexpectedly with no file.");
      }

    } catch (Exception e) {
      System.out.println("Test Scenario 1 Failed: An error occurred - " + e.getMessage());
    }
  }

  // Test Scenario 2: Verify homepage heading and A/B testing page
  public static void testScenario2() {
    try {
      System.out.println("Running Test Scenario 2: Homepage and A/B Testing...");
      driver.get("https://the-internet.herokuapp.com/");

      // Verify homepage heading
      WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
      String headingText = heading.getText();
      if (headingText.equals("Welcome to the-internet")) {
        System.out.println("Test Scenario 2 Passed (Part 1): Homepage loaded, heading 'Welcome to the-internet' found.");
      } else {
        System.out.println("Test Scenario 2 Failed (Part 1): Expected heading not found. Found: " + headingText);
        return;
      }

      // Click A/B Testing link and verify page
      WebElement abTestLink = driver.findElement(By.linkText("A/B Testing"));
      abTestLink.click();

      WebElement abHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
      String abHeadingText = abHeading.getText();
      if (abHeadingText.contains("A/B Test")) {
        System.out.println("Test Scenario 2 Passed (Part 2): A/B Testing page loaded successfully.");
      } else {
        System.out.println("Test Scenario 2 Failed (Part 2): A/B Testing page heading not as expected. Found: " + abHeadingText);
      }
    } catch (Exception e) {
      System.out.println("Test Scenario 2 Failed: An error occurred - " + e.getMessage());
    }
  }

  // Placeholder for additional scenarios
  public static void testScenario3() {
    System.out.println("Running Test Scenario 3: [Not implemented yet]");
    // Add your test logic here
  }

  public static void testScenario4() {
    System.out.println("Running Test Scenario 4: [Not implemented yet]");
    // Add your test logic here
  }

  public static void testScenario5() {
    System.out.println("Running Test Scenario 5: [Not implemented yet]");
    // Add your test logic here
  }

  public static void testScenario6() {
    System.out.println("Running Test Scenario 6: [Not implemented yet]");
    // Add your test logic here
  }
}