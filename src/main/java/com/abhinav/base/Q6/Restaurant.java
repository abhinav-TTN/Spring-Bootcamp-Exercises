package com.abhinav.base.Q6;

import org.springframework.stereotype.Component;

@Component
public class Restaurant {

    private final Noodles noodles;

    public Restaurant(Noodles noodles) {
        this.noodles = noodles;
    }

    public void serveNoodles() {
        noodles.serveFood();
    }
}
