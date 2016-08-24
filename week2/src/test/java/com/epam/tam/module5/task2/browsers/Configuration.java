package com.epam.tam.module5.task2.browsers;

import com.epam.tam.module5.task2.util.TestProperties;

public class Configuration {

    private static Configuration configuration;

    private BrowserType browserType;

    private Configuration() {
        this.browserType = BrowserType.byName(TestProperties.getInstance().getBrowserType());
    }

    public static Configuration getInstance() {
        if (configuration == null)
            configuration = new Configuration();
        return configuration;
    }


    public BrowserType getBrowserType() {
        return browserType;
    }

    public void setBrowserType(BrowserType browserType) {
        this.browserType = browserType;
    }


    @Override
    public String toString() {
        return "GlobalConfiguration [driverType=" + browserType + "]";
    }
}
