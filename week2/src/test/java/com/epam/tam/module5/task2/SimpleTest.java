package com.epam.tam.module5.task2;

import com.epam.tam.module5.task2.pages.OnePassPage;
import com.epam.tam.module5.task2.pages.TR.TRAllProductPage;
import com.epam.tam.module5.task2.pages.TR.TRHomePage;
import com.epam.tam.module5.task2.util.Constants;

import com.epam.tam.module5.task2.util.TestProperties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class SimpleTest extends BaseTest {
    private static final Logger LOG = LogManager.getLogger(SimpleTest.class);

    TRHomePage loginPage;
    TRAllProductPage allProductPage;
    OnePassPage onePassPage;
    protected static TestProperties testProperties;

    @BeforeTest
    public void setUp() {
        super.setUp();
        loginPage = new TRHomePage(driver);
        allProductPage = new TRAllProductPage(driver);
        onePassPage = new OnePassPage(driver);
    }

    @Test(description = "logo is displayed")
    public void openStartPage() {
        SoftAssert sa = new SoftAssert();
        LOG.info("Open start page");
        driver.navigate().to(URL);
        sa.assertEquals(driver.getTitle(), Constants.TR_HOME_PAGE_TITLE, "Incorrect title of page");
        sa.assertTrue(loginPage.companyLogo.isDisplayed(), "Logo is not displaing");
        sa.assertAll();
    }

    @Test(description = "logo is displayed", dependsOnMethods = "openStartPage")
    public void goToResources() {
        driver.navigate().to(URL);
        loginPage.openSignInPage();
        Assert.assertEquals(allProductPage.countOfColunm(), 3, "Incorrect quantity of column");
    }

    @Test(description = "logo is displayed", dependsOnMethods = "goToResources")
    public void displayLogoAndRedirectToHomePageFromResources() {
        driver.navigate().to(URL);
        loginPage.openSignInPage();
        loginPage.companyLogo.click();
        Assert.assertEquals(driver.getTitle(), Constants.TR_HOME_PAGE_TITLE, "Incorrect title of page");
    }

    @Test(description = "presence of link")
    public void presenceOfLink() {
        driver.navigate().to(URL);
        loginPage.openSignInPage();
        assertTrue(allProductPage.openResourceLinkIsDisplayed("Westlaw Classic"), "Link is not displaying");
    }

    @Test(description = "Go to WL", dependsOnMethods = "presenceOfLink")
    public void goToWL() {
        driver.navigate().to(URL);
        loginPage.openSignInPage();
        LOG.info("Open WL page");
        allProductPage.openResourceLink("Westlaw Classic");
        Assert.assertEquals(driver.getTitle(), Constants.WLC_PAGE_TITLE, "Incorrect title of page");
    }

    @Test(description = "LogIn to PL", dependsOnMethods = "goToWL")
    public void failedLogIn() {
        driver.navigate().to(URL);
        loginPage.openSignInPage();
        allProductPage.openResourceLink("Westlaw Classic");
        onePassPage.loginOnePass(USERNAME, PASSWORD);
        assertTrue(onePassPage.getErrorMessage().equalsIgnoreCase(Constants.ALERT_MESSAGE), "Error message is not the same");
    }


}
