package com.epam.tam.module5.task2.ui.pages.PL;

import com.epam.tam.module5.task2.ui.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlLoginPage extends AbstractPage {
    private String URL;

    public PlLoginPage(WebDriver driver) {
        super(driver);
        this.URL = getBasePageUrl();
    }

    public void openPage() {
        driver.navigate().to(URL);
    }


    private WebElement onePassButton() {
        return driver.findElement(By.id("onePassLoginButton"));
    }

    public void clickOnePassButton() {
        onePassButton().click();
    }
}
