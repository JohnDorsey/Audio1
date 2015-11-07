package com.github.JohnDorsey.audio1;

import java.util.PriorityQueue;

/**
 * Created by John on 10/26/15.
 */


public class Audio1 {

    public static int i;
    //public static Byte[] storedSound = new Byte[65536];
    //public static PriorityQueue<Byte> storedSound = new PriorityQueue<Byte>();
    public static Q storedSound = new Q();


    public static void main (String[] args) {
        //Line.moveSounds(0, 1);

        //for (int i = 0; i < 65536; i+= 4) {
            //System.out.println(":" + storedSound[i]);
        //    dotAt((int) storedSound[i]);
        //}

        //InStream clink = new InStream("standard", "clink_sound (1).wav");
        //clink.read();

        //InStream synth = new InStream("synthOfTheDay", "clink_sound (1).wav");
        //synth.read();

        //OutStream display = new OutStream("byteDisplay", "NA", clink.audioFormat);
        //display.write(storedSound);

        InHandle clink = new InHandle("standard", "clink_sound (1).wav");
        clink.read();

        OutStream play = new OutStream("speakers", "NA", clink.inStream.audioFormat);

        OutStream show = new OutStream("dotDisplay", "NA", clink.inStream.audioFormat);
        //play.write(storedSound);

        //byte[] temprim = new byte[65536];
        //Byte[] tempc = new Byte[65536];
        //tempc = storedSound.toArray(tempc);
        //for (int i = 0; i < 65536; i++) {
        //    //System.out.println("Audio1 converting Byte to byte :" + i);
        //    temprim[i] = tempc[i];
        //}
        play.write(storedSound.bytes);
        play.write(storedSound.bytes);
        play.write(storedSound.bytes);
        play.write(storedSound.bytes);
        show.write(storedSound.bytes);
        //show.write(temprim);



    }


}
