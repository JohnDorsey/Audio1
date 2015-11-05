package com.github.JohnDorsey.audio1;

import javax.sound.sampled.*;
import java.io.File;

/**
 * Created by John on 10/26/15.
 */
public class Line {

    /*


    static AudioFormat audioFormat;
    static AudioInputStream audioInputStream;
    static SourceDataLine sourceDataLine;

    private static void playAudio() {
        try{
            File soundFile = new File("clink_sound (1).wav");
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            audioFormat = audioInputStream.getFormat();
            System.out.println(audioFormat);

            DataLine.Info dataLineInfo =
                    new DataLine.Info(
                            SourceDataLine.class,
                            audioFormat);

            sourceDataLine =
                    (SourceDataLine)AudioSystem.getLine(
                            dataLineInfo);

            //Create a thread to play back the data and
            // start it running.  It will run until the
            // end of file, or the Stop button is
            // clicked, whichever occurs first.
            // Because of the data buffers involved,
            // there will normally be a delay between
            // the click on the Stop button and the
            // actual termination of playback.

            //new PlayThread().start();
        }catch (Exception e) {
            System.err.println(e);
        }//end catch
    }//end playAudio




    //=============================================//
//Inner class to play back the data from the
// audio file.
    class PlayThread extends Thread{
        public void run(){
            playTo(0);
        }//end run
    }//end inner class PlayThread
//===================================//

    public static void playTo(int destination) {
        byte tempBuffer[] = new byte[10000];
        try{
            sourceDataLine.open(audioFormat);
            sourceDataLine.start();

            int cnt;
            //Keep looping until the input read method
            // returns -1 for empty stream or the
            // user clicks the Stop button causing
            // stopPlayback to switch from false to
            // true.
                while((cnt = audioInputStream.read(
                        tempBuffer,0,tempBuffer.length)) != -1){
                    if(cnt > 0){
                        //Write data to the internal buffer of
                        // the data line where it will be
                        // delivered to the speaker.

                        if (destination == 0) {
                            sourceDataLine.write(tempBuffer, 0, cnt);
                        } else if (destination == 1) {
                            for (byte cb : tempBuffer) {
                                Audio1.storedSound[Audio1.i] = cb;
                                Audio1.i++;
                            }
                        }

                    }//end if
                }//end while

            //Block and wait for internal buffer of the
            // data line to empty.
            sourceDataLine.drain();
            sourceDataLine.close();

        }catch (Exception e) {
            System.err.println(e);
        }//end catch
    }


    public static void moveSounds(int source, int destination) {
        switch (source) {
            case 0: { playAudio(); } break;
        }
        switch (destination) {
            case 0: { playTo(0); /*new PlayThread().start(); }
            case 1: { playTo(1); }
        }



    }

*/


}
