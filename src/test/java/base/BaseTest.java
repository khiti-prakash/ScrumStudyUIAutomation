package base;

import driver.DriverManager;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import config.ConfigReader;

public class BaseTest {
//    protected WebDriver driver; // <-- declare this
//    protected Logger logger = LogManager.getLogger(BaseTest.class);
//
//    @BeforeMethod(alwaysRun = true)
//    public void setUp()
//    {
//        logger.info("=========== Test Setup Started ===========");
//        Allure.step("Test Teardown Started", () -> {
//
//            driver = DriverManager.getDriver();
//
//            String baseUrl = ConfigReader.getProperty("base.url");
//            driver.get(baseUrl);
//
//            logger.info("Browser started successfully"+ baseUrl);
//            //Allure.step("Browser started successfully, "+ baseUrl);
//        });
//    }
//
//    @AfterMethod(alwaysRun = true)
//    public void tearDown()
//    {
//        logger.info("=========== Test Teardown Started ===========");
//
//        Allure.step("Test Teardown Started", () -> {
//            // browser init here
//            if (driver != null) {
//                driver.quit();
//                logger.info("Browser closed successfully");
//                //  Allure.step("Browser closed successfully");
//            } else {
//                logger.warn("Driver was null at teardown");
//            }
//        });
//
//    }
//
//    public WebDriver getDriver() {
//        return driver;
//    }
}
