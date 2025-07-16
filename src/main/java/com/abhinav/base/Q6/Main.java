//Q6) Perform Constructor Injection in a Spring Bean
package com.abhinav.base.Q6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    private static Restaurant restaurant;

    public Main(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class);

        restaurant.serveNoodles();

    }
}
