package com.abhinav.base.Q1;

public class Cafe {
    private Tea tea = new Tea();
    private Coffee coffee = new Coffee();

    public void serveTea() {
        tea.serveDrink();
    }

    public void serveCoffee() {
        coffee.serveDrink();
    }
}