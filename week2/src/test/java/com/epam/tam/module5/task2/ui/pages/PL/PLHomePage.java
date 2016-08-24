package com.epam.tam.module5.task2.ui.pages.PL;

import com.epam.tam.module5.task2.ui.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PLHomePage extends AbstractPage {
    private String URL;


    public PLHomePage(WebDriver driver) {
        super(driver);
        this.URL = getBasePageUrl();
    }
    public void openPage() {
        driver.navigate().to(URL);
    }

    public WebElement headerLink(String arg) {
        return driver.findElement(By.xpath("//div[@class='header-contain']//a[contains(text(),'" + arg + "')]"));
    }


}
