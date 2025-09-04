package driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>(); //use for parall execution
    public static WebDriverWait wait;


    public static WebDriver getDriver()
    {
        if(driver.get()==null)
        {
            driver.set(DriverFactory.createInstance());
        }
        return driver.get();

    }

    public static void quitDriver()
    {
        if(driver.get() != null)
        {
            driver.get().quit();
            driver.remove(); // Clears memory for thread
        }
    }
}
