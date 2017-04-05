package com.anwesome.ui.overlaygallery;

import android.graphics.*;
import java.util.*;

/**
 * Created by anweshmishra on 05/04/17.
 */
public class Gallery {
    private List<GalleryItem> galleryItems = new ArrayList<>();
    private Screen screen;
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
    }
    public void updateScreen() {
        screen.move();
    }
    public boolean stop() {
        return screen.stoppedMoving();
    }
    public void startMovingScreen(int dir) {
        screen.startMoving(dir);
    }
}
