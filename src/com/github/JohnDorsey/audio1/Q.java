package com.github.JohnDorsey.audio1;

/**
 * Created by John on 11/7/2015.
 */
public class Q {
    public byte[] bytes = new byte[65536];
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
            if (end == 65536) { end = 0; }
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
        //System.out.println("Q asked for " + bytes[start-1]);
        return bytes[start-1];
    }

    public byte peek() {
        return bytes[start];
    }


}
