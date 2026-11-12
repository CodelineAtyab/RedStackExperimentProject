package com.allabouttraffic.models;

public class LGRemote extends ACRemote {
    public void setSpecifics() {
        screenWidth = 30;
        screenHeight = 15;
        buttonWidth = 2;
        buttonHeight = 2;
    }

    public Integer[] getSpecifics() {
        return new Integer[]{screenHeight, screenHeight};
    }
    /*
     * State of Object is stored in the following variables
     * */
    public int buttonWidth;
    public int buttonHeight;
    public int screenWidth;
    public int screenHeight;
}
