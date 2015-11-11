package com.github.JohnDorsey.audio1;

/**
 * Created by John on 11/7/2015.
 */
public class Q {
    public int bufferSize = 4;
    public byte[] bytes;
    public int start = 0;
    public int end = 1;
    public boolean isNew = true;
    public boolean print = false;
    public int ou = 0;

    public Q (int nBufferSize) {
        bufferSize = nBufferSize;
        bytes = new byte[bufferSize];
    }



    public boolean add(byte toAdd) {
        //if (print) { System.out.print(" Qtta " + toAdd + " " + start + " " + end); }
        //ou++;
        //if (ou == 64) { System.out.println(); ou = 0; }
        //if (print) { System.out.println(end); }
        if (end == start && isNew == false) {
            return false;
        } else {
            bytes[end] = toAdd;
            end++;
            //if (print) { System.out.println("   " + end); }
            if (end == bufferSize) { end = 0; }
            //if (print) { System.out.println("       " + end); }
        }
        isNew = false;
        return true;
    }

    public boolean add(int toAdd) {
        return (add((byte) toAdd));
    }

    public byte get() {
        byte result;
        //if (start == end - 1) { return 0; }
        start++;
        if (start == bufferSize + 1) { start = 1; }
        //if (start == 0) { start++; }
        //System.out.println("Q asked for " + bytes[start-1]);
        result = bytes[start-1];
        bytes[start-1] = (byte) 2;
        return result;
    }

    public boolean canFit(int number) {
        //return (number < bufferSize - ((start < end)? end - start : start - end));
        boolean result;
        if (start < end) {
            result = number < bufferSize - (end - start);
        } else {
            result = number < bufferSize - (start - end);
        }
        if (print && !result) { System.out.println("Q could not fit another byte! " + start + " " + end); }
        return result;
    }

    public byte peek() {
        return bytes[start];
    }


}
