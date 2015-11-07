package com.github.JohnDorsey.audio1;


import java.util.PriorityQueue;

/**
 * Created by John on 11/5/15.
 */
public class InHandle {

    String type;
    String fileName;
    InStream inStream;
    //PriorityQueue<Byte> currentData = new PriorityQueue<Byte>();
    Q currentData = new Q();
    int currentLocation;


    public InHandle(String nType, String nFileName) {
        type = nType;
        fileName = nFileName;
        currentLocation = 0;
        inStream = new InStream(type, fileName, this);
    }

    public void read() {
        inStream.read();
        //for (int i = 0; i < 512; i++) {System.out.println(currentData.poll());}
        Byte cb = new Byte("0");
        //System.out.println("inHandle reading");
        for (int i = 0; i < 65536; i++) {
            cb = currentData.get();
            //System.out.println(i + " " + cb);
            Audio1.storedSound.add(cb);
            //Audio1.storedSound.add(currentData.poll());
        }
    }



}
