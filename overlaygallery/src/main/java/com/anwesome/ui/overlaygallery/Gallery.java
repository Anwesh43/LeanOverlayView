package com.anwesome.ui.overlaygallery;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 05/04/17.
 */
public class Gallery {
    private List<Bitmap> bitmaps = new ArrayList<>();
    private float x,y;
    public Gallery(List<Bitmap> bitmaps,int w,int h) {
        init(bitmaps,w,h);
    }
    private void init(List<Bitmap> bitmaps,int w,int h) {
        for(Bitmap bitmap:bitmaps) {
            Bitmap newBitmap = bitmap.createScaledBitmap(bitmap,w,h/2,true);
            this.bitmaps.add(newBitmap);
        }
    }
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawColor(Color.parseColor("#AAFFFFFF"));
    }
}
