package com.remotes;

public class Main {
    public static void main(String[] args) {

        RemoteCover r = new LGTVRemote();

        r.placeButtons();
        System.out.println(r.getInfoFromScreen());

        r.turnOn();
        System.out.println(r.getInfoFromScreen());

        System.out.println("Channel Up -> " + r.turnCounterUp());
        System.out.println(r.getInfoFromScreen());

        System.out.println("Channel Down -> " + r.turnCounterDown());
        System.out.println(r.getInfoFromScreen());

        r.turnOff();
        System.out.println(r.getInfoFromScreen());
    }
}
