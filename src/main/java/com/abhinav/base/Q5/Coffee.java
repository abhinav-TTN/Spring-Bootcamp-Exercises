package com.abhinav.base.Q5;

import org.springframework.stereotype.Component;

// giving a default name value to the bean
@Component("coffee")
public class Coffee implements Drink {
    public void serveDrink() {
        System.out.println("COFFEE served!!");
    }
}
