package com.anwesome.ui.overlaygallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.List;

/**
 * Created by anweshmishra on 05/04/17.
 */
public class GalleryView extends View {
    private List<Bitmap> bitmaps;
    private Gallery gallery;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int time = 0,w,h;
    private boolean isAnimated = false;
    private GestureDetector galleryGestureDetector;
    public GalleryView(Context context, List<Bitmap> bitmaps) {
        super(context);
        this.bitmaps = bitmaps;
        galleryGestureDetector = new GestureDetector(context,new GalleryGestureListener());
    }
    public void onDraw(Canvas canvas) {
        if(time == 0) {
            w = canvas.getWidth();
            h = canvas.getHeight();
            gallery = new Gallery(bitmaps,w,h);
        }
        canvas.drawColor(Color.BLACK);
        gallery.draw(canvas,paint);
        time++;
        if(isAnimated) {
            gallery.updateScreen();
            if(gallery.stop()) {
                isAnimated = false;
            }
            try {
                Thread.sleep(50);
                invalidate();
            }
            catch (Exception ex) {

            }
        }
    }
    public boolean onTouchEvent(MotionEvent event) {
        return galleryGestureDetector.onTouchEvent(event);
    }
    private class GalleryGestureListener extends GestureDetector.SimpleOnGestureListener {
        public boolean onDown(MotionEvent event) {
            return true;
        }
        public boolean onSingleTapUp(MotionEvent event) {
            return true;
        }
        public boolean onFling(MotionEvent e1,MotionEvent e2,float velx,float vely) {
            boolean yDir = Math.abs(velx)>Math.abs(vely);
            if(yDir && vely!=0 && !isAnimated) {
                int dir = (int)(vely/Math.abs(vely));
                gallery.startMovingScreen(dir);
                isAnimated = true;
                postInvalidate();
            }
            return true;
        }
    }
}
