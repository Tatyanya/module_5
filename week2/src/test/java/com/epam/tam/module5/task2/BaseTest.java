package com.epam.tam.module5.task2;

import com.epam.tam.module5.task2.browsers.Browser;

import com.epam.tam.module5.task2.util.TestProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected static TestProperties testProperties;

    protected WebDriver driver;

    protected String USERNAME;
    protected String PASSWORD;
    protected String URL;

    @BeforeSuite(alwaysRun = true, description = "")
    public void initTestProperties() {
        testProperties = TestProperties.getInstance();
        USERNAME = testProperties.getUserName();
        PASSWORD = testProperties.getUserPassword();
        URL = testProperties.getURL();
    }


/*    @BeforeClass(description = "Start browser")
    public void initBrowser() {
       // driver = Browser.initBrowser();
    }*/

    @BeforeTest
    public void setUp() {
        driver = Browser.initBrowser();
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser() {
        Browser.closeDriver();
    }
}

