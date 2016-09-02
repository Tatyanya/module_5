package com.epam.tam.module5.task2;

import com.epam.tam.module5.task2.browsers.Browser;

import com.epam.tam.module5.task2.business.User;
import com.epam.tam.module5.task2.util.TestProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected static TestProperties testProperties;

    protected WebDriver driver;
    protected User user;
    protected String URL;
    protected String USERNAME;
    protected String PASSWORD;

    @BeforeSuite(alwaysRun = true, description = "")
    public void initTestProperties() {
        testProperties = TestProperties.getInstance();
        user = new User();
        user.setUsername(testProperties.getUserName());
        user.setPassword(testProperties.getUserPassword());
        USERNAME = user.getUsername();
        PASSWORD = user.getPassword();
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

