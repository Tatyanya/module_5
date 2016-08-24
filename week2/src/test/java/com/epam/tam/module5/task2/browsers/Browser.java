package com.epam.tam.module5.task2.browsers;

import com.epam.tam.module5.task2.factory.BrowserFactoryManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Browser {

    private final static Logger logger = Logger.getLogger(Browser.class);

    private static WebDriver webDriver;

    public static WebDriver getInstance() {
        return webDriver;
    }

    public static WebDriver initBrowser() {
        BrowserType browserType = Configuration.getInstance().getBrowserType();
        BrowserFactoryManager driverManager = new BrowserFactoryManager(browserType);

        webDriver = driverManager.createWedDriverForBrowser(browserType);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        logger.info("Browser started");
        return webDriver;
    }

    public static void closeDriver() {
        webDriver.quit();
        logger.info("Browser closed");
    }

}
