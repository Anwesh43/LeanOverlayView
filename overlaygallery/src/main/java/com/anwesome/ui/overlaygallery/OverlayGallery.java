package com.anwesome.ui.overlaygallery;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 05/04/17.
 */
public class OverlayGallery {
    private List<Bitmap> bitmaps = new ArrayList<>();
    private Activity activity;
    private GalleryView galleryView;
    public OverlayGallery(Activity activity, List<Bitmap> bitmaps) {
        this.activity = activity;
        this.bitmaps = bitmaps;
    }
    public void show() {
        if(galleryView == null) {
            galleryView = new GalleryView(activity,bitmaps);
            activity.addContentView(galleryView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }
        if(galleryView.getVisibility() == View.INVISIBLE) {
            galleryView.setVisibility(View.VISIBLE);
        }
        hideOrShowActionBar(false);
    }
    public void hide() {
        if(galleryView!=null) {
            galleryView.setVisibility(View.INVISIBLE);
            hideOrShowActionBar(true);
        }
    }
    public boolean isShown() {
        return galleryView!=null && galleryView.getVisibility() == View.VISIBLE;
    }
    private void hideOrShowActionBar(boolean show) {
        ActionBar supportActionBar = null;
        android.app.ActionBar actionBar = null;
        if(activity instanceof AppCompatActivity) {
            supportActionBar = ((AppCompatActivity)activity).getSupportActionBar();
        }
        else {
            actionBar = activity.getActionBar();
        }
        if(show) {
            if(actionBar!=null) {
                actionBar.show();
            }
            if(supportActionBar!=null) {
                supportActionBar.show();
            }
        }
        else {
            if(actionBar!=null) {
                actionBar.hide();
            }
            if(supportActionBar!=null) {
                supportActionBar.hide();
            }
        }
    }
}
