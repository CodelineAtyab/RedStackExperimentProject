package com.allabouttraffic;

import com.allabouttraffic.models.*;

import java.io.ObjectInputFilter;
import java.util.*;

public class Main {
    /**
     * Entrypoint of the application.
     *
     * @param args: External Arguments
     */
    public static void main(String[] args) {
        {
            Configuration appConfig = Configuration.getControlledObject();
            System.out.println(appConfig.theme);
            appConfig.theme = "Light";
        }


        Configuration appConfig2 = Configuration.getControlledObject();
        System.out.println(appConfig2.theme);
//        System.out.println(Tyre.noOfManufacturedTyres);
//
//        Tyre t1 = new Tyre();
//        System.out.println(t1.width);
//        Tyre t2 = new Tyre();
//        Tyre t3 = new Tyre();
//        System.out.println(Tyre.noOfManufacturedTyres);


//        Tyre frontLeftTyre = new Tyre();
//        Tyre frontrightTyre = new Tyre();
//        Tyre backLeftTyre = new Tyre();
//        Tyre backRightTyre = new Tyre();
//        Tyre secBackLeftTyre = new Tyre();
//        Tyre secBackRightTyre = new Tyre();
//
//        {
//            System.out.println("[MAIN] Going to create a CAR object");
//            Car generalCar = new Car();
//            generalCar.attachFrontTyres(frontLeftTyre);
//            generalCar.attachFrontTyres(frontrightTyre);
//            generalCar.attachFrontTyres(frontrightTyre);
//
//            generalCar.attachBackTyres(backLeftTyre);
//            generalCar.attachBackTyres(backRightTyre);
//
//            System.out.println("[MAIN] Now I am going to exit and destroy the CAR");
//        }





    }
}