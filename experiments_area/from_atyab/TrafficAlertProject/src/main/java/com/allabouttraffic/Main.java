package com.allabouttraffic;

import com.allabouttraffic.models.*;

import java.util.*;

public class Main {
    /**
     * Entrypoint of the application.
     *
     * @param args: External Arguments
     */
    public static void main(String[] args) {
        Tyre frontLeftTyre = new Tyre();
        Tyre frontrightTyre = new Tyre();
        Tyre backLeftTyre = new Tyre();
        Tyre backRightTyre = new Tyre();
        Tyre secBackLeftTyre = new Tyre();
        Tyre secBackRightTyre = new Tyre();

        {
            System.out.println("[MAIN] Going to create a CAR object");
            Car generalCar = new Car();
            generalCar.attachFrontTyres(frontLeftTyre);
            generalCar.attachFrontTyres(frontrightTyre);
            generalCar.attachFrontTyres(frontrightTyre);

            generalCar.attachBackTyres(backLeftTyre);
            generalCar.attachBackTyres(backRightTyre);

            System.out.println("[MAIN] Now I am going to exit and destroy the CAR");
        }
        System.out.printf("Number of tyres are %d", 6);




    }
}