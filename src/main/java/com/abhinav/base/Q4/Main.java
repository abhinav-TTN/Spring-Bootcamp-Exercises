package com.abhinav.base.Q4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        // Running the Main class as a SpringApplication to initialize Beans
        // Storing the ApplicationContext returned by SpringApplication.run(), use it to get the bean and print its properties
        ApplicationContext applicationContext = SpringApplication.run(Main.class, args);

        System.out.println(applicationContext.getBean(Cafe.class));

    }
}
