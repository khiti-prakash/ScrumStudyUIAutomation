package reporting;

import base.BaseTest;
import hooks.Hooks;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class AllureTestListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(AllureTestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test failed: " + result.getMethod().getMethodName());

        Object testClass = result.getInstance();
        WebDriver driver = ((Hooks) testClass).getDriver();

        if (driver != null) {
            saveScreenshotPNG(driver);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test suite started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test suite finished: " + context.getName());
    }

    // Allure attachment for screenshot
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
