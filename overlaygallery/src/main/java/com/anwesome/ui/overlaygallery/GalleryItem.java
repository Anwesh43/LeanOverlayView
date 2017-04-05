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
        canvas.save();
        canvas.translate(x,y);
        canvas.drawBitmap(bitmap,-bitmap.getWidth()/2,-bitmap.getHeight()/2,paint);
        canvas.restore();
    }
    public boolean inScreen(float x) {
        return this.x+x == 0;
    }
    public int hashCode() {
        return (int)(x+y)+bitmap.hashCode();
    }
}
