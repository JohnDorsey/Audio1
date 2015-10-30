package com.github.JohnDorsey.audio1;

import javax.sound.sampled.*;
import java.io.File;

/**
 * Created by John on 10/30/15.
 */
public class InStream {
    public String type;
    public String fileName;
    public File openFile;

    static AudioFormat audioFormat;
    static AudioInputStream audioInputStream;
    static SourceDataLine sourceDataLine;


    public InStream(String nType, String nFileName) {
        type = nType;
        fileName = nFileName;
        openFile = new File(fileName);
        if (type == "standard") {
            try {
                audioInputStream = AudioSystem.getAudioInputStream(openFile);
                audioFormat = audioInputStream.getFormat();
                DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
                sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
                System.out.println(audioFormat);
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
        //byte tempBuffer[] = new byte[4096];
        try{
            sourceDataLine.open(audioFormat);
            sourceDataLine.start();

            int amount;
            //Keep looping until the input read method
            // returns -1 for empty stream
            while((amount = audioInputStream.read(
                    Audio1.storedSound,0,Audio1.storedSound.length)) != -1){
                //if(amount > 0){
                //}//end if
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
        Byte cb;
        for (int i = 0; i < Audio1.storedSound.length; i++) {
            cb = new Byte(Integer.toString((((i%920) /16) + ((i%800) /16))-128));
            Audio1.storedSound[i] = cb;
        }
    }




}
