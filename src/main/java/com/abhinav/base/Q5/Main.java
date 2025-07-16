// Q5) Demonstrate how you will resolve ambiguity while autowiring bean
package com.abhinav.base.Q5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class Main {
    private static Cafe cafe;

    // Injecting Cafe class object into Main application
    public Main(Cafe cafe) {
        this.cafe = cafe;
    }

    public static void main(String[] args) {

        // Running the Main class as a SpringApplication to initialize Beans
        SpringApplication.run(Main.class, args);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter choice (1:Tea, 2:Coffee) :");
        int choice = sc.nextInt();
        if (choice == 1)
            cafe.serveTea();
        else if (choice == 2)
            cafe.serveCoffee();
    }
}
