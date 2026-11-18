package com.allabouttraffic.models;

public class Tyre {
    public Tyre() {
        noOfManufacturedTyres++;
        this.width = 10;
        this.height = 10;
    }
    public static int noOfManufacturedTyres = 0;
    public int width;
    public int height;
}
