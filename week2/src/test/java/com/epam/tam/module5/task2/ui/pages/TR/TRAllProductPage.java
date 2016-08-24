package com.epam.tam.module5.task2.ui.pages.TR;

import com.epam.tam.module5.task2.ui.pages.AbstractPage;
import com.epam.tam.module5.task2.util.TimeOutUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class TRAllProductPage extends AbstractPage {

    private String URL;

    @FindBys(@FindBy(xpath = "//div[@class='list-of-links']//self::div[@class='col-xs-12 col-sm-4 column']"))
    public List<WebElement> columnElements;

    public void openPage() {
        driver.navigate().to(URL);
    }

    public TRAllProductPage(WebDriver driver) {
        super(driver);
        this.URL = getBasePageUrl();
    }

    private WebElement resourceLink(String arg) {
        return driver.findElement(By.xpath("//div[@class='list-of-links']//a[contains(text(),'" + arg + "')]"));
    }

    public int countOfColunm() {
        return columnElements.size();
    }

    public void openResourceLink(String arg) {
        resourceLink(arg).click();
        TimeOutUtils.sleepInSeconds(2);
    }

    public boolean openResourceLinkIsDisplayed(String arg) {
        return resourceLink(arg).isDisplayed();
    }
}


