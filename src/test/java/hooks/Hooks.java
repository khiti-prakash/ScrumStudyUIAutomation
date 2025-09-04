package hooks;

import base.BaseTest;
import config.ConfigReader;
import driver.DriverFactory;
import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import reporting.AllureScreenshotHelper;

public class Hooks {
    protected WebDriver driver; // <-- declare this
    protected Logger logger = LogManager.getLogger(BaseTest.class);

    @Before()
    public void setUp()
    {
        logger.info("=========== Test Setup Started ===========");

        driver = DriverManager.getDriver();

//        String baseUrl = ConfigReader.getProperty("base.url");
//        // Validate URL
//        if (baseUrl == null || baseUrl.trim().isEmpty()) {
//            throw new RuntimeException("❌ base.url is not set in config.properties");
//        }
//        // Launch application
//        driver.get(baseUrl);
//        driver.manage().window().maximize();

        logger.info("Browser started successfully");
    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverManager.getDriver();

        logger.info("=========== Test Teardown Started ===========");

        try {
            if (scenario.isFailed() && driver != null) {
                AllureScreenshotHelper.saveScreenshot(driver);
                logger.error("Scenario failed: " + scenario.getName());
            }

            if (driver != null) {
//                driver.quit();
//                logger.info("Browser closed successfully");

            } else {
                logger.warn("Driver was null at teardown");
            }
        } catch (Exception e) {
            logger.error("Error during teardown", e);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
