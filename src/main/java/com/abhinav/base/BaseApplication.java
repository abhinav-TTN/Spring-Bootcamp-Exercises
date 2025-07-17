package com.abhinav.base;

import com.abhinav.base.utils.PropertiesReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BaseApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(BaseApplication.class, args);
        applicationContext.getBean(PropertiesReader.class).showAppProperties();
    }

}
