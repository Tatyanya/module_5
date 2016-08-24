package com.epam.tam.module5.task2.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface WebDriverCreator {

    WebDriver createWebDriver();

    WebDriver createWebDriver(DesiredCapabilities capabilities);


}
