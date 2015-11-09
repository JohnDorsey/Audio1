package com.github.JohnDorsey.audio1;

import javax.sound.sampled.*;
import java.io.File;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by John on 10/30/15.
 */
public class InStream {
    public String type;
    public String fileName;
    public File openFile;
    public InHandle parent;

    static AudioFormat audioFormat;
    static AudioInputStream audioInputStream;
    static SourceDataLine sourceDataLine;


    Random rnd = new Random();


    public InStream(String nType, String nFileName, InHandle nParent) {
        type = nType;
        fileName = nFileName;
        openFile = new File(fileName);
        parent = nParent;
        if (type == "standard") {
            try {
                audioInputStream = AudioSystem.getAudioInputStream(openFile);
                audioFormat = audioInputStream.getFormat();
                DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
                sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
                System.out.println("InStream:");
                System.out.println("audioInputStream: " + audioInputStream);
                System.out.println("audioFormat: " + audioFormat);
                System.out.println("sourceDataLine: " + sourceDataLine);
                System.out.println("dataLineInfo: " + dataLineInfo);
            } catch (Exception e) { System.err.println(e); }
        }

    }


    public void read() {
        if (type == "standard") {
            readStandard();
        } else if (type == "synthOfTheDay") {
            synthOfTheDay();
        }
    }


    public void readStandard() {
        try{
            sourceDataLine.open(audioFormat);
            sourceDataLine.start();

            System.out.println("InStream: Read started:");
            System.out.println("audioInputStream: " + audioInputStream);
            System.out.println("audioFormat: " + audioFormat);
            System.out.println("sourceDataLine: " + sourceDataLine);

            int amount;

            //while((amount = audioInputStream.read(Audio1.storedSound, 0, Audio1.storedSound.length)) != -1) {
            //    parent.currentLocation += amount;
            //}//end while


            //System.out.println(audioInputStream);

            //Byte cbi;
            get:
            //while((amount = audioInputStream.read(cb, 0, 1)) != -1) {

            //while (audioInputStream.read(cb, 0, 1) != -1) {

            while (1==1) {
                byte cb[] = new byte[2];
                cb[0] = 4;
                cb[1] = 6;
                //cb[0] = audioInputStream.read();
                amount = audioInputStream.read(cb, 0, 2);




                //sotd
                //for (int i = 0; i < 65536; i++) {
                //int i = parent.currentLocation;

                //cbi = new Byte(Integer.toString((parent.currentLocation%16)*4));

                System.out.println(Arrays.toString(cb));
                parent.currentData.add(cb[0]);
                parent.currentData.add(cb[1]);
                //parent.currentData.add((parent.currentLocation%252)/2);


                parent.currentLocation += 1;
                System.out.println(amount);
                if (parent.currentLocation >= 65536) { break get; }
            }//end while

            //Block and wait for internal buffer of the
            // data line to empty.
            sourceDataLine.drain();
            sourceDataLine.close();

        }catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }//end catch
    }




    public void synthOfTheDay() {
        //Byte cb;
        //for (int i = 0; i < Audio1.storedSound.length(); i++) {
        //    cb = new Byte(Integer.toString(((((i%400)/12) + (i%600) /16) + ((i%750) /16))-128));
        //    Audio1.storedSound[i] = cb;
        //}
    }







    //System.out.println("InStream redStandard");
    //parent.currentData.add(cb[0]);
    //parent.currentData.add((byte) rnd.nextInt(127));

    //System.out.println(parent.currentLocation + " " + cbi);
    //parent.currentData.add(cbi);
    //OutStream.dotAt((int) cbi);
    //}



}
