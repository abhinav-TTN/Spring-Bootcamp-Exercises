package com.abhinav.base.Q3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Cafe {

    private final Drink tea;
    private final Drink coffee;

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