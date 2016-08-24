package com.epam.tam.module5.task2.ui.pages;

import com.epam.tam.module5.task2.util.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    protected WebDriver driver;
    private static final String BASE_URL = TestProperties.getInstance().getURL();

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public abstract void openPage();

    protected String getBasePageUrl(){
        return BASE_URL;
    }
}
