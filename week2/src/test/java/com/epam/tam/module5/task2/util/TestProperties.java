package com.epam.tam.module5.task2.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
    private static final String PROPERTY_FILE_NAME = "test_properties.properties";

    private static ThreadLocal<TestProperties> instance = new ThreadLocal<TestProperties>();

    public static synchronized TestProperties getInstance() {
        if (null == instance.get())
            instance.set(new TestProperties());
        return instance.get();
    }

    private TestProperties() {
        setProperties();
    }

    private String userName, userPassword, url, browserType;

    public void setProperties() {
        InputStream inputStream = null;
        try {

            Properties prop = new Properties();
            inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTY_FILE_NAME);
            if (inputStream == null)
                throw new FileNotFoundException(
                        "property file '" + PROPERTY_FILE_NAME + "' not found in the classpath");

            prop.load(inputStream);

            userName = prop.getProperty("test.variable.user_name");
            userPassword = prop.getProperty("test.variable.password");
            url = prop.getProperty("test.variable.url");
            browserType = prop.getProperty("environment.variables.browser");

        } catch (Exception ex) {
            System.out.println("Exception while initializing test properties. Exception: " + ex);
        } finally {
            try {
                if (null != inputStream)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public String getURL() {
        return this.url;
    }

    public String getBrowserType() {
        return this.browserType;
    }

}