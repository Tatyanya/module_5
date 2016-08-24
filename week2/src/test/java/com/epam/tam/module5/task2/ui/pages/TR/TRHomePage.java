package com.epam.tam.module5.task2.ui.pages.TR;

import com.epam.tam.module5.task2.ui.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TRHomePage extends AbstractPage {
    private String URL;

    @FindBy(xpath = "//a[contains(text(),'Login')]")
    private WebElement loginLink;

    @FindBy(xpath = "//header//a[contains(@href, '/en.html')]/span[contains(@class,'logo')]")
    public WebElement companyLogo;

    public void openPage() {
        driver.navigate().to(URL);
    }

    public TRHomePage(WebDriver driver) {
        super(driver);
        this.URL = getBasePageUrl();
    }

    public void openSignInPage() {
        loginLink.click();
    }

    public void clickToLogo() {
        companyLogo.click();
    }

}
