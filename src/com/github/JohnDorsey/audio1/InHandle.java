package com.github.JohnDorsey.audio1;


import java.util.PriorityQueue;

/**
 * Created by John on 11/5/15.
 */
public class InHandle extends Thread {

    String type;
    String fileName;
    //PriorityQueue<Byte> currentData = new PriorityQueue<Byte>();
    Q currentData = new Q();
    int currentLocation;
    InStream inStream;


    public InHandle(String nType, String nFileName) {
        type = nType;
        fileName = nFileName;
        currentLocation = 0;
        inStream = new InStream(nType, nFileName, this);
    }

    public void read() {
        //inStream.read();
        //for (int i = 0; i < 512; i++) {System.out.println(currentData.poll());}
        //Byte cb = new Byte("0");
        //System.out.println("inHandle reading");
        for (int i = 0; i < 65536; i++) {
            //cb = inStream.content.get();
            //System.out.println(i + " " + cb);
            //Audio1.storedSound.add(cb);
            inStream.loadTwoBytes();
            Audio1.storedSound.add(inStream.read());
            //Audio1.storedSound.add(currentData.poll());
        }
    }



}
