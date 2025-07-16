//Q1) Write a program to demonstrate Tightly Coupled code.
package com.abhinav.base.Q2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Drink tea = new Tea();
        Drink coffee = new Coffee();

        // This time we created two drinks and passed it into cafe via constructor.
        // We are injecting it ourselves but in spring the IOC and applicationContext does this for us.
        Cafe cafe = new Cafe(tea,coffee);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter choice (1:Tea, 2:Coffee) :");
        int choice = sc.nextInt();
        if (choice == 1)
            cafe.serveTea();
        else if (choice == 2)
            cafe.serveCoffee();
    }
}
