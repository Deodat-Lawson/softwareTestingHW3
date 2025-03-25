package org.example.Task4.TheInternerGUITesting;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class SeleniumTestsSenario1to6 {
  // Declare WebDriver and WebDriverWait as static class variables
  private static WebDriver driver;
  private static WebDriverWait wait;

  public static void main(String[] args) {
    // Set the path to ChromeDriver (update this to your ChromeDriver location)
    System.setProperty("webdriver.chrome.driver", "/Users/timothylin/Downloads/chromedriver-mac-arm64 2/chromedriver");

    // Configure Chrome options
    ChromeOptions options = new ChromeOptions();
    // options.addArguments("--headless"); // Uncomment for headless mode

    // Initialize the WebDriver and WebDriverWait
    driver = new ChromeDriver(options);
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    try {
      // Run the test scenarios
//      testScenario1();
//      testScenario2();
//      testScenario3();
//      testScenario4();
//      testScenario5();
//      testScenario6();
//      testScenario7();
//      testScenario8();
//      testScenario9();
//      testScenario10();
      testScenario11();


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

  public static void testScenario2() {
    try {
      System.out.println("Running Test Scenario 2: Hovers...");
      driver.get("https://the-internet.herokuapp.com/hovers");

      //find the leftmostImage
      WebElement leftmostImage = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));
      new Actions(driver).moveToElement(leftmostImage).perform();

      WebElement user1Text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='name: user1']")));
      System.out.println(user1Text.isDisplayed() ? "Test Scenario 2 Passed" : "Test Scenario 2 Failed");
    } catch (Exception e) {
      System.out.println("Test Scenario 2 Failed: " + e.getMessage());
    }
  }

  // Test Scenario 3: Checkboxes - Checkbox 1 unchecked, Checkbox 2 checked
  public static void testScenario3() {
    try {
      System.out.println("Running Test Scenario 3: Checkboxes...");
      driver.get("https://the-internet.herokuapp.com/checkboxes");
      WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
      WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
      boolean cb1Unchecked = !checkbox1.isSelected();
      boolean cb2Checked = checkbox2.isSelected();
      System.out.println(cb1Unchecked && cb2Checked ? "Test Scenario 3 Passed" : "Test Scenario 3 Failed");
    } catch (Exception e) {
      System.out.println("Test Scenario 3 Failed: " + e.getMessage());
    }
  }

  // Test Scenario 4: Context menu - Right-click pops up message box
  public static void testScenario4() {
    try {
      System.out.println("Running Test Scenario 4: Context Menu...");
      driver.get("https://the-internet.herokuapp.com/context_menu");

      WebElement box = driver.findElement(By.id("hot-spot"));

      // First, check that alert doesn't exist before right-click
      boolean alertExistsBefore = ExpectedConditions.alertIsPresent().apply(driver) != null;
      if (alertExistsBefore) {
        System.out.println("Test Scenario 4 Failed: Alert exists before right-click");
        return;
      }

      new Actions(driver).contextClick(box).perform();
      org.openqa.selenium.Alert alert = wait.until(ExpectedConditions.alertIsPresent());
      String alertText = ((org.openqa.selenium.Alert) alert).getText();
      alert.accept();


      System.out.println(alertText.equals("You selected a context menu") ? "Test Scenario 4 Passed" : "Test Scenario 4 Failed");
    } catch (Exception e) {
      System.out.println("Test Scenario 4 Failed: " + e.getMessage());
    }
  }

  // Test Scenario 5: Broken images - Assert 2 broken images
  public static void testScenario5() {
    try {
      System.out.println("Running Test Scenario 5: Broken Images...");
      driver.get("https://the-internet.herokuapp.com/broken_images");

      int brokenCount = 0;
      for (WebElement img : driver.findElements(By.tagName("img"))) {
        if (img.getAttribute("naturalWidth").equals("0")) { //broken images has a width of 0
          brokenCount++;
        }
      }
      System.out.println(brokenCount == 2 ? "Test Scenario 5 Passed" : "Test Scenario 5 Failed");
    } catch (Exception e) {
      System.out.println("Test Scenario 5 Failed: " + e.getMessage());
    }
  }

  // Test Scenario 6: Infinite scroll - Scroll down by 195
  public static void testScenario6() {
    try {
      System.out.println("Running Test Scenario 6: Infinite Scroll...");
      driver.get("https://the-internet.herokuapp.com/infinite_scroll");

      ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 195);");
      Thread.sleep(1000); // Wait to observe scroll
      System.out.println("Test Scenario 6 Passed: Scrolled down by 195 pixels.");
    } catch (Exception e) {
      System.out.println("Test Scenario 6 Failed: " + e.getMessage());
    }
  }

  // Test Scenario 7: Dropdown - Select Option 2
  public static void testScenario7() {
    try {
      System.out.println("Running Test Scenario 7: Dropdown...");
      driver.get("https://the-internet.herokuapp.com/dropdown");

      WebElement dropdown = driver.findElement(By.id("dropdown"));
      dropdown.findElement(By.xpath("//option[@value='2']")).click();

      //after clicked, check that the value equals 2
      System.out.println(dropdown.getAttribute("value").equals("2") ? "Test Scenario 7 Passed" : "Test Scenario 7 Failed");
    } catch (Exception e) {
      System.out.println("Test Scenario 7 Failed: " + e.getMessage());
    }
  }

  // Test Scenario 8: Key presses - Press DOWN key
  public static void testScenario8() {
    try {
      System.out.println("Running Test Scenario 8: Key Presses...");
      driver.get("https://the-internet.herokuapp.com/key_presses");

      WebElement input = driver.findElement(By.id("target"));
      input.sendKeys(Keys.DOWN); //system pressed down key

      WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
      System.out.println(result.getText().equals("You entered: DOWN") ? "Test Scenario 8 Passed" : "Test Scenario 8 Failed");
    } catch (Exception e) {
      System.out.println("Test Scenario 8 Failed: " + e.getMessage());
    }
  }

  // Test Scenario 9: Login - Empty username and password
  public static void testScenario9() {
    try {
      System.out.println("Running Test Scenario 9: Login with empty credentials...");
      driver.get("https://the-internet.herokuapp.com/login");

      driver.findElement(By.id("login")).findElement(By.tagName("button")).click();
      //find login button

      WebElement flash = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
      System.out.println(flash.getText().contains("Your username is invalid!") ? "Test Scenario 9 Passed" : "Test Scenario 9 Failed");
    } catch (Exception e) {
      System.out.println("Test Scenario 9 Failed: " + e.getMessage());
    }
  }

  // Test Scenario 10: Login - tomsmith with empty password
  public static void testScenario10() {
    try {
      System.out.println("Running Test Scenario 10: Login with tomsmith and empty password...");
      driver.get("https://the-internet.herokuapp.com/login");

      driver.findElement(By.id("username")).sendKeys("tomsmith");
      driver.findElement(By.id("login")).findElement(By.tagName("button")).click();
      WebElement flash = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
      System.out.println(flash.getText().contains("Your password is invalid!") ? "Test Scenario 10 Passed" : "Test Scenario 10 Failed");
    } catch (Exception e) {
      System.out.println("Test Scenario 10 Failed: " + e.getMessage());
    }
  }

  // Test Scenario 11: Login - tomsmith with SuperSecretPassword!, logout
  public static void testScenario11() {
    try {
      System.out.println("Running Test Scenario 11: Login with valid credentials and logout...");
      driver.get("https://the-internet.herokuapp.com/login");

      driver.findElement(By.id("username")).sendKeys("tomsmith");
      driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
      driver.findElement(By.id("login")).findElement(By.tagName("button")).click();

      // Assert redirect to secure page
      wait.until(ExpectedConditions.urlContains("/secure"));
      boolean isSecurePage = driver.getCurrentUrl().contains("/secure");

      // Assert success message
      WebElement flash = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
      boolean successMessage = flash.getText().contains("You logged into a secure area!");

      // Assert logout button is visible and enabled
      WebElement logoutButton = driver.findElement(By.xpath("//a[@href='/logout']"));
      boolean logoutVisibleEnabled = logoutButton.isDisplayed() && logoutButton.isEnabled();

      // Click logout
      logoutButton.click();
      wait.until(ExpectedConditions.urlContains("/login"));
      boolean isLoginPage = driver.getCurrentUrl().contains("/login");
      WebElement logoutFlash = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
      boolean logoutMessage = logoutFlash.getText().contains("You logged out of the secure area!");

      // Combine assertions
      if (isSecurePage && successMessage && logoutVisibleEnabled && isLoginPage && logoutMessage) {
        System.out.println("Test Scenario 11 Passed");
      } else {
        System.out.println("Test Scenario 11 Failed");
      }
    } catch (Exception e) {
      System.out.println("Test Scenario 11 Failed: " + e.getMessage());
    }
  }
}