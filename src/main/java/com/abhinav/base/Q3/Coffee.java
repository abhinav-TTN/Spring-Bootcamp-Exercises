package com.abhinav.base.Q3;

import org.springframework.stereotype.Component;

@Component("coffee")
public class Coffee implements Drink{
    public void serveDrink() {
        System.out.println("COFFEE served!!");
    }
}
