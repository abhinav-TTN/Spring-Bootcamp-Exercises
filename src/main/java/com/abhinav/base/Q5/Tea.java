package com.abhinav.base.Q5;

import org.springframework.stereotype.Component;

// giving a default name value to the bean
@Component("tea")
public class Tea implements Drink {
    public void serveDrink() {
        System.out.println("TEA served!!");
    }
}
