package org.example;
import remotes.RemoteCover;
import remotes.LGTVRemote;
import remotes.LGACRemote;

public class Main {
    public static void main(String[] args) {
        String deviceType = (args.length > 0) ? args[0].toUpperCase() : "TV";

        RemoteCover remote;

        if (deviceType.equals("AC")) {
            remote = new LGACRemote();
        } else {
            remote = new LGTVRemote();
        }

        remote.placeButtons();
        System.out.println();

        remote.getInfoFromScreen();
        System.out.println();

        remote.turnOn();
        remote.getInfoFromScreen();
        System.out.println();

        remote.turnCounterUp();
        remote.getInfoFromScreen();
        System.out.println();

        remote.turnCounterDown();
        remote.getInfoFromScreen();
        System.out.println();

        remote.turnOff();
        remote.getInfoFromScreen();
    }
}