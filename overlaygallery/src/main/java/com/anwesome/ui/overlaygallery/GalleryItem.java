package com.anwesome.ui.overlaygallery;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by anweshmishra on 05/04/17.
 */
public class GalleryItem {
    private Bitmap bitmap;
    private float x,y;
    public GalleryItem(Bitmap bitmap,float x,float y) {
        this.bitmap = bitmap;
        this.x = x;
        this.y = y;
    }
    public void draw(Canvas canvas, Paint paint) {
        int w = bitmap.getWidth(),h = bitmap.getHeight();
        canvas.save();
        canvas.translate(x+w/2,y+h/2);
        canvas.drawBitmap(bitmap,-w/2,-h/2,paint);
        canvas.restore();
    }
    public boolean inScreen(float x) {
        return this.x+x == 0;
    }
    public int hashCode() {
        return (int)(x+y)+bitmap.hashCode();
    }
}
