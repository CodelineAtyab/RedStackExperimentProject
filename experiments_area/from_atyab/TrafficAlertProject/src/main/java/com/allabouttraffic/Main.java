package com.allabouttraffic;

import com.allabouttraffic.models.ACRemote;
import com.allabouttraffic.models.LGRemote;
import com.allabouttraffic.models.PanasonicRemote;

public class Main {
    /**
     * Entrypoint of the application.
     *
     * @param args: External Arguments
     */
    public static void main(String[] args) {
        ACRemote r1 = new PanasonicRemote();
        System.out.println(r1.setMode());
        System.out.println(r1.setMode());
        System.out.println(r1.setMode());
        System.out.println(r1.setMode());
        System.out.println(r1.setMode());
        System.out.println(r1.setMode());
        System.out.println(r1.setMode());
        System.out.println(r1.setMode());

        ACRemote r2 = new LGRemote();
        System.out.println(r1.setMode());
        System.out.println(r1.setMode());
        System.out.println(r1.setMode());
        System.out.println(r1.setMode());
        System.out.println(r1.setMode());
        System.out.println(r1.setMode());
        System.out.println(r1.setMode());
    }
}