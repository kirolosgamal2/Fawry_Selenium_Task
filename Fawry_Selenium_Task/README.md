# Fawry_Selenium_Task

 * This class serves as the foundation for running automated tests using Selenium. It contains methods for setting up the driver, navigating to the home page, quitting the driver, and taking a screenshot in case a test fails. 
 * The BaseClass imports the HomePage class and utilizes the WebDriver interface to interact with a browser window. The driver instance is set up using the FirefoxDriver, but this can be changed to another browser driver as needed. 
 * To follow the Page Object Model (POM) pattern, the BaseClass also declares and initializes a HomePage object. This page object can then be used in other test classes to access and interact with elements on the home page.

 * To prevent unwanted behavior in the case of test failure, the BaseClass also includes a recordFailure() method which takes an argument of type ITestResult. In case the ITestResult status is FAILURE, the method uses the TakesScreenshot interface to capture a screenshot of the current browser window and saves it to the resources/screenshots folder with a filename corresponding to the name of the failed test.
 * To use this framework, create new test classes which extend BaseClass and utilize the HomePage object to interact with page elements. This pattern ensures that tests are easy to maintain and update as the page structure changes over time.
 
