package com.epam.tam.module5.task2.ui.service;
import com.epam.tam.module5.task2.ui.pages.OnePassPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Tatyana_Korobitsina on 8/22/2016.
 */
public class LoginService extends BaseService {

    public LoginService(WebDriver driver) {
        super(driver);
    }

    private OnePassPage onePassPage;

    public void loginOnePass(){
        onePassPage = new OnePassPage(driver);
        onePassPage.openPage();
        onePassPage.loginOnePass("username", "password");
    }

}
