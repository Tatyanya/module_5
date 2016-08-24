package com.epam.tam.module5.task2.factory;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverCreator implements WebDriverCreator {
    private String pathToBinary;

    public ChromeDriverCreator(String pathToBinary) {
        this.pathToBinary = pathToBinary;
    }

    public synchronized ChromeDriver createWebDriver() {
        DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, pathToBinary);
        return new ChromeDriver(chromeCapabilities);
    }

    public synchronized ChromeDriver createWebDriver(DesiredCapabilities extraCapabilities) {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, pathToBinary);
        return new ChromeDriver(DesiredCapabilities.chrome().merge(extraCapabilities));
    }
}

