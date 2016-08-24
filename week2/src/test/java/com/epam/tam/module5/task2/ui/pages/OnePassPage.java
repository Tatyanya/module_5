package com.epam.tam.module5.task2.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnePassPage extends AbstractPage {
    private String URL;

    public OnePassPage(WebDriver driver) {
        super(driver);
        this.URL = getBasePageUrl();
    }
    public void openPage() {
        driver.navigate().to(URL);
    }
    private WebElement onePassUsername() {
        return driver.findElement(By.name("Username"));
    }

    private WebElement onePassPassword() {
        return driver.findElement(By.id("Password"));
    }

    /* private WebElement onePassSignInButton() {
         return driver.findElement(By.cssSelector("button#SignIn"));
     }*/

    @FindBy(xpath = "//button[contains(text(),'Sign In')]")
    private WebElement onePassSignInButton;


    private WebElement errorMessage() {
        return driver.findElement(By.xpath("//div[@id='errorMessageDialog']/span"));
    }

    public String getErrorMessage() {
        return errorMessage().getText();
    }

    public void loginOnePass(String login, String password) {
        onePassUsername().clear();
        onePassUsername().sendKeys(login);

        onePassPassword().clear();
        onePassPassword().sendKeys(password);

        onePassSignInButton.click();
    }


}

