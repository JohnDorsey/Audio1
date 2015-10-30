package com.github.JohnDorsey.audio1;

/**
 * Created by John on 10/26/15.
 */


public class Audio1 {

    public static int i;
    public static byte[] storedSound = new byte[65536];



    public static void main (String[] args) {
        //Line.moveSounds(0, 1);

        //for (int i = 0; i < 65536; i+= 4) {
            //System.out.println(":" + storedSound[i]);
        //    dotAt((int) storedSound[i]);
        //}

        InStream clink = new InStream("standard", "clink_sound (1).wav");
        clink.read();

        InStream synth = new InStream("synthOfTheDay", "clink_sound (1).wav");
        synth.read();

        //OutStream display = new OutStream("byteDisplay", "NA", clink.audioFormat);
        //display.write(storedSound);

        OutStream play = new OutStream("speakers", "NA", clink.audioFormat);
        play.write(storedSound);



    }


}
