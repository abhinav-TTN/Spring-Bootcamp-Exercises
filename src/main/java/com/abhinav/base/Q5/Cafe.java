package com.abhinav.base.Q5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Cafe {

    private final Drink tea;
    private final Drink coffee;

    // Using Qualifier annotation to specify which bean of type Drink to provide in the parameter of the constructor
    @Autowired
    public Cafe(@Qualifier("tea") Drink tea, @Qualifier("coffee") Drink coffee) {
        this.tea = tea;
        this.coffee = coffee;
    }

    public void serveTea() {
        tea.serveDrink();
    }

    public void serveCoffee() {
        coffee.serveDrink();
    }
}