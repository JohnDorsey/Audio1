package com.github.JohnDorsey.audio1;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

/**
 * Created by John on 10/30/15.
 */
public class OutStream {
    public String type;
    public String fileName;

    public static String blank = "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ";


    static SourceDataLine sourceDataLine;
    static AudioFormat audioFormat;

    public OutStream(String nType, String nFileName, AudioFormat nAudioFormat) {
        type = nType;
        fileName = nFileName;
        audioFormat = nAudioFormat;
        try {
            DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
            sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
        } catch (Exception e) { System.err.println(e); }
    }



    public void write(byte[] toWrite) {
        if (type == "speakers") { play(toWrite);
        } else if (type == "dotDisplay") { dotDisplay(toWrite);
        } else if (type == "byteDisplay") { byteDisplay(toWrite);
        }
    }


    public void play(byte[] toPlay) {
        try {
            sourceDataLine.open(audioFormat);
            sourceDataLine.start();
            sourceDataLine.write(toPlay, 0, toPlay.length);
            sourceDataLine.drain();
            sourceDataLine.close();
        } catch (Exception e) { System.err.println(e); }
    }


    public static void dotDisplay(byte[] toDisplay) {
        for (int i = 0; i < toDisplay.length; i+=4) {
            dotAt((int) toDisplay[i]); System.out.print("\n");
        }
    }

    public static void dotAt(int pos) {
        System.out.print(blank.substring(0, (pos + 129))  + "#" + pos);
    }

    public static void byteDisplay(byte[] toDisplay) {
        String thisByte;
        for (int i = 0; i < toDisplay.length; i+=2) {
            thisByte = "                ";
            thisByte += Integer.toBinaryString((int) /*Math.sqrt((double) */toDisplay[i]) + "  ";
            thisByte = thisByte.substring(thisByte.length()-12, thisByte.length());
            System.out.print(thisByte);
            if (i % 64 == 0) {
                dotAt(toDisplay[i]);
                System.out.print("\n");
            }
        }
    }



}
