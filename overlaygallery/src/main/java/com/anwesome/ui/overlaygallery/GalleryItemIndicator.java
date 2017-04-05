package com.anwesome.ui.overlaygallery;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 05/04/17.
 */
public class GalleryItemIndicator {
    private float x,y,size;
    private int n;
    private List<Indicator> indicators =new ArrayList<>();
    public GalleryItemIndicator(float x,float y,float size,int n) {
        this.x = x;
        this.y = y;
        this.n = n;
        this.size = size;
        init();
    }
    public void init() {
        float xInd = x-(size*n+size/2*(n-1))/2,yInd = y+size/2;
        for(int i=0;i<n;i++) {
            boolean isActive = false;
            if(i == 0) {
                isActive = true;
            }
            indicators.add(new Indicator(xInd,yInd,isActive));
            xInd+=(size*3)/2;
        }
    }
    public void draw(Canvas canvas,Paint paint) {
        for(Indicator indicator:indicators) {
            indicator.draw(canvas,paint);
        }
    }
    public void update(int index) {
        Indicator indicator = indicators.get(index);
        if(indicator!=null) {
            indicator.setActive(true);
        }
    }
    public void deactivate() {
        for(Indicator indicator:indicators) {
            indicator.setActive(false);
        }
    }
    private class Indicator {
        private float x,y;
        private boolean isActive = false;
        public Indicator(float x,float y,boolean isActive) {
            this.x = x;
            this.y = y;
            this.isActive = isActive;
        }
        public void setActive(boolean isActive) {
            this.isActive = isActive;
        }
        public void draw(Canvas canvas, Paint paint) {
            paint.setColor(Color.parseColor("#9E9E9E"));
            if(isActive) {
                paint.setColor(Color.parseColor("#FAFAFA"));
            }
            canvas.drawCircle(x,y,size/2,paint);
        }
    }
}
