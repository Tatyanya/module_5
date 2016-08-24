package com.epam.tam.module5.task2.factory;

import com.epam.tam.module5.task2.browsers.BrowserType;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BrowserFactoryManager {

    private final static Logger logger = Logger.getLogger(BrowserFactoryManager.class);

    private String baseBinariesPath = "src\\main\\resources\\";
    private String chromeBinary = baseBinariesPath + "chromedriver.exe";

    private static BrowserType defaultBrowserType = BrowserType.FIREFOX;

    public static BrowserType getDefaultBrowserType() {
        return defaultBrowserType;
    }

    public BrowserFactoryManager() {
    }

    public BrowserFactoryManager(BrowserType browserType) {
        defaultBrowserType = browserType;
    }

    public WebDriver createWedDriverForBrowser() {
        return createWedDriverForBrowser(defaultBrowserType);
    }

    public WebDriver createWedDriverForBrowser(BrowserType browserType) {
        logger.info("Creating WebDriver instance by Type: '" + browserType + "'");
        WebDriverCreator result;
        switch (browserType) {
            case FIREFOX:
                result = new FirefoxDriverCreator();
                break;
            case CHROME:
                if (chromeBinary == null) {
                    throw new ExceptionInInitializerError("Please set ieBinary using setChromeBinary method");
                }
                result = new ChromeDriverCreator(chromeBinary);
                break;
            default:
                throw new ExceptionInInitializerError("There is no WebDriverFactory implementation for '"
                        + browserType.name() + "'");
        }
        return result.createWebDriver();
    }
}
