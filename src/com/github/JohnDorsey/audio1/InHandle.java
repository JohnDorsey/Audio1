package com.github.JohnDorsey.audio1;


import java.util.PriorityQueue;

/**
 * Created by John on 11/5/15.
 */
public class InHandle {

    String type;
    String fileName;
    InStream inStream;
    PriorityQueue<Byte> currentData = new PriorityQueue<Byte>();
    int currentLocation;


    public InHandle(String nType, String nFileName) {
        type = nType;
        fileName = nFileName;
        currentLocation = 0;
        inStream = new InStream(type, fileName, this);
    }

    public void read() {
        inStream.read();
        //Audio1.storedSound = (byte[]) currentData.toArray(Audio1.storedSound);
        for (int i = 0; i < 65536; i++) {
            Audio1.storedSound.add(currentData.poll());
        }
    }



}
