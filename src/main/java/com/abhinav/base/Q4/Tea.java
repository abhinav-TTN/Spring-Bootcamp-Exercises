package com.abhinav.base.Q4;

import org.springframework.stereotype.Component;

@Component("tea")
public class Tea implements Drink {
    public void serveDrink() {
        System.out.println("TEA served!!");
    }
}
