package com.epam.tam.module5.task2.factory;


import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxDriverCreator implements WebDriverCreator {

    private FirefoxProfile firefoxProfile;

    private FirefoxBinary pathToBinary;

    public FirefoxDriverCreator() {
        this.firefoxProfile = generateDefaultProfile();

    }

    public synchronized FirefoxDriver createWebDriver() {
        FirefoxDriver firefoxWebDriver = new FirefoxDriver(pathToBinary,
                firefoxProfile);

        return firefoxWebDriver;
    }

    public synchronized FirefoxDriver createWebDriver(DesiredCapabilities capabilities) {
        FirefoxDriver firefoxWebDriver = new FirefoxDriver(pathToBinary,
                firefoxProfile, capabilities);
        return firefoxWebDriver;
    }

    private FirefoxProfile generateDefaultProfile() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        return firefoxProfile;
    }
}
