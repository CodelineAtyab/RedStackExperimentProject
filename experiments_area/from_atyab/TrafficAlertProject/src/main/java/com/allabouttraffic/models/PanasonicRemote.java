package com.allabouttraffic.models;

public class PanasonicRemote extends ACRemote {

    public void setSpecifics() {
        radiusOfButtons = 2;
        screenWidth = 20;
        screenHeight = 12;
    }

    public Integer[] getSpecifics() {
        return new Integer[]{radiusOfButtons, screenHeight, screenHeight};
    }


    /*
    * State of Object is stored in the following variables
    * */
    public int radiusOfButtons;
    public int screenWidth;
    public int screenHeight;

}
