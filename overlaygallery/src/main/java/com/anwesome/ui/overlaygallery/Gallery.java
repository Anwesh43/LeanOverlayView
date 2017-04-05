package com.anwesome.ui.overlaygallery;

import android.graphics.*;
import java.util.*;

/**
 * Created by anweshmishra on 05/04/17.
 */
public class Gallery {
    private GalleryItemIndicator galleryItemIndicator;
    private List<GalleryItem> galleryItems = new ArrayList<>();
    private Screen screen;
    private int dir = 0,index = 0;
    public Gallery(List<Bitmap> bitmaps,int w,int h) {
        init(bitmaps,w,h);
        screen = new Screen(w);
    }
    private void init(List<Bitmap> bitmaps,int w,int h) {
        float x = 0,y =0;
        for(Bitmap bitmap:bitmaps) {
            Bitmap newBitmap = bitmap.createScaledBitmap(bitmap,w,h/2,true);
            galleryItems.add(new GalleryItem(newBitmap,x,y));
            x+=w;
        }
        galleryItemIndicator = new GalleryItemIndicator(w/2,(4*h)/5,w/30,bitmaps.size());
    }
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawColor(Color.parseColor("#AAFFFFFF"));
        float x = screen.getX();
        canvas.save();
        canvas.translate(x,0);
        for(GalleryItem galleryItem:galleryItems) {
            galleryItem.draw(canvas,paint);
        }
        canvas.restore();
        galleryItemIndicator.draw(canvas,paint);
    }
    public void updateScreen() {
        screen.move();
    }
    public boolean stop() {
        boolean stop = screen.stoppedMoving();
        galleryItemIndicator.update(index+=dir);
        dir = 0;
        return stop;
    }
    public void startMovingScreen(int dir) {
        this.dir = dir;
        screen.startMoving(dir);
    }
}
