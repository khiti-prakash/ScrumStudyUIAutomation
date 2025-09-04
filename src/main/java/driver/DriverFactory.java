package driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import config.ConfigReader;
import org.openqa.selenium.safari.SafariOptions;

public class DriverFactory {
    public static WebDriver createInstance()
    {
        Logger logger = LogManager.getLogger(DriverFactory.class);
        String browser = ConfigReader.getProperty("browser").toLowerCase();

        switch (browser)
        {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--disable-extensions");
                logger.info("====Chrome browser opened successfully====");
                return new ChromeDriver(chromeOptions);
                case "firefox":
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("--start-maximized");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--disable-extensions");
                    logger.info("====Firefox browser opened successfully====");
                    return new FirefoxDriver(options);
                    case "safari":
                        SafariOptions safariOptions = new SafariOptions();
                        // Accept insecure certs (if needed)
                        safariOptions.setAcceptInsecureCerts(true);

                        // Automatic inspection / dev tools
                        safariOptions.setCapability("safari:automaticInspection", true);
                        safariOptions.setCapability("safari:automaticProfiling", true);
                        logger.info("====Safari browser opened successfully====");
                        return new SafariDriver(safariOptions);
                        case "edge":
                            logger.info("====Edge browser opened successfully====");
                            return new EdgeDriver();

                    default:
                        logger.info("====Default browser open as a Chrome====");
                        logger.info("====Chrome browser opened successfully====");
                        return new ChromeDriver();
        }

    }
}
