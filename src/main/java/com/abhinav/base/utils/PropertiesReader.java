package com.abhinav.base.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesReader {
    @Value("${spring.application.name}")
    private String appName;
    @Value("${spring.application.version}")
    private String appVersion;
    @Value("${app.owner}")
    private String appOwner;

    public void showAppProperties() {
        System.out.println("Application Name = " + appName +
                "\nApplication Version = " + appVersion +
                "\nApplication Owner = " + appOwner);
    }
}
