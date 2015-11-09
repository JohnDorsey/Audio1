package com.github.JohnDorsey.audio1;

/**
 * Created by John on 11/7/2015.
 */
public class Q {
    public int bufferSize = 32768;
    public byte[] bytes = new byte[bufferSize];
    public int start = 0;
    public int end = 0;
    public boolean isNew = true;

    public Q () {

    }



    public boolean add(byte toAdd) {
       // System.out.println("Q told to add " + toAdd);

        if (end == start && isNew == false) {
            return false;
        } else {
            bytes[end] = toAdd;
            end++;
            if (end == bufferSize) { end = 0; }
        }
        isNew = false;
        return true;
    }

    public boolean add(int toAdd) {
        return (add((byte) toAdd));
    }

    public byte get() {
        if (start == end - 1) { return 0; }
        start++;
        if (start == bufferSize) { start = 1; }
        if (start == 0) { start++; }
        //System.out.println("Q asked for " + bytes[start-1]);
        return bytes[start-1];
    }

    public boolean canFit(int number) {
        return (number < bufferSize - ((start < end)? end - start : start - end));
    }

    public byte peek() {
        return bytes[start];
    }


}
