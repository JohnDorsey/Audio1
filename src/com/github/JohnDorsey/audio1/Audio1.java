package com.github.JohnDorsey.audio1;

/**
 * Created by John on 10/26/15.
 */


public class Audio1 {

    public static int i;
    public static byte[] storedSound = new byte[65536];
    public static String blank = "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ";


    public static void main (String[] args) {
        Line.moveSounds(0, 1);

        for (int i = 0; i < 65536; i+= 4) {
            //System.out.println(":" + storedSound[i]);
            dotAt((int) storedSound[i]);
        }

    }

    public static void dotAt(int pos) {
        System.out.println(blank.substring(0, (pos + 256))  + "#");
    }

}
