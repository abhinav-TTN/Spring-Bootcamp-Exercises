package com.abhinav.base.Q2;

public class Cafe {
    private final Drink tea;
    private final Drink coffee;

    public Cafe(Drink tea, Drink coffee) {
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