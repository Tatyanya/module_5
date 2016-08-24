package com.epam.tam.module5.task2.ui.service;

import org.openqa.selenium.WebDriver;

public abstract class BaseService {
    protected WebDriver driver ;

    public BaseService(WebDriver driver){
        this.driver = driver;
    }
}
