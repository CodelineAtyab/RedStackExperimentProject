package com.allabouttraffic.models;

import java.util.ArrayList;

public class Car {

    public Car() {
        System.out.println("[CAR] Creating a CAR instance and attaching Engine...");
        this.v8Engine = new Engine();
        this.frontTyres = new ArrayList<Tyre>();
        this.backTyres = new ArrayList<Tyre>();
    }
    // Composition as Engine will be created and destryed by the car object when it gets created.

    public void attachFrontTyres(Tyre incomginTyre) {
        if (this.frontTyres.size() < 2) {
            this.frontTyres.add(incomginTyre);
            System.out.println("Attached %d Tyre at the front!!!".formatted(frontTyres.size()));
        } else {
            System.out.println("Already at full capacity on the front!!!");
        }
    }

    public void attachBackTyres(Tyre incomginTyre) {
        if (this.backTyres.size() <= 4) {
            this.backTyres.add(incomginTyre);
            System.out.println("Attached %d Tyre at the back!!!".formatted(backTyres.size()));
        } else {
            System.out.println("Already at full capacity on the back!!!");
        }
    }
    public Engine v8Engine;
    private ArrayList<Tyre> frontTyres;
    private ArrayList<Tyre> backTyres;
}
