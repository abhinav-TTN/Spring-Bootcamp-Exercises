//Q1) Write a program to demonstrate Tightly Coupled code.
package com.abhinav.base.Q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // The cafe class has to manage separate objects for tea and coffee.
        Cafe cafe = new Cafe();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter choice (1:Tea, 2:Coffee) :");
        int choice = sc.nextInt();
        if (choice == 1)
            cafe.serveTea();
        else if (choice == 2)
            cafe.serveCoffee();
    }
}
