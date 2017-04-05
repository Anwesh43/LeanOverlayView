package com.anwesome.ui.overlaygallery;

import android.graphics.PointF;

/**
 * Created by anweshmishra on 05/04/17.
 */
public class Screen {
    private float x=0,prevX=0,w;
    private int dir = 0;
    public Screen(float w) {
        this.w = w;
    }
    public float getX() {
        return x;
    }
    public void startMoving(int dir) {
        this.dir = dir;
    }
    public void move() {
        this.x+=w/10*dir;
        if(Math.abs(x-prevX) >= w) {
            prevX = x;
            dir = 0;
        }
    }
    public boolean stoppedMoving() {
        return dir == 0;
    }
}
