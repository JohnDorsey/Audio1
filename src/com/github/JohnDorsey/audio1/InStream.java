package com.github.JohnDorsey.audio1;

import javax.sound.sampled.*;
import java.io.File;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by John on 10/30/15.
 */
public class InStream extends Thread {
    public String type;
    public String fileName;
    public File openFile;
    public InHandle parent;

    static AudioFormat audioFormat;
    static AudioInputStream audioInputStream;
    static SourceDataLine sourceDataLine;

    public static Q content = new Q(16384);


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
                //System.out.println("InStream:");
                //System.out.println("audioInputStream: " + audioInputStream);
                //System.out.println("audioFormat: " + audioFormat);
                //System.out.println("sourceDataLine: " + sourceDataLine);
                //System.out.println("dataLineInfo: " + dataLineInfo);
            } catch (Exception e) { System.err.println(e); }
        }

        content.print = true;

    }

    @Override
    public void run() {
        for (int i = 0; i < 262144; i++) {
            loadTwoBytes();
        }

    }

    public void loadTwoBytes() {
        if (content.canFit(2)) {
            try {
                byte cb[] = new byte[2];
                cb[0] = 0;
                cb[1] = 0;
                audioInputStream.read(cb, 0, 2);
                //cb[0] += 2;
                //cb[1] += 8;
                content.add(cb[1]);
                content.add(cb[1]);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }//end catch
        }
    }

    public byte read() {
        return content.get();
    }


    /*

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

            //System.out.println("InStream: Read started:");
            //System.out.println("audioInputStream: " + audioInputStream);
            //System.out.println("audioFormat: " + audioFormat);
            //System.out.println("sourceDataLine: " + sourceDataLine);

            //int amount;

            //while((amount = audioInputStream.read(Audio1.storedSound, 0, Audio1.storedSound.length)) != -1) {
            //    parent.currentLocation += amount;
            //}//end while


            //System.out.println(audioInputStream);

            //Byte cbi;

            get:
            while (1==1) {
                loadTwoBytes();
                parent.currentLocation += 1;
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



*/



    //System.out.println("InStream redStandard");
    //parent.currentData.add(cb[0]);
    //parent.currentData.add((byte) rnd.nextInt(127));

    //System.out.println(parent.currentLocation + " " + cbi);
    //parent.currentData.add(cbi);
    //OutStream.dotAt((int) cbi);
    //}



}
