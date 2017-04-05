package com.anwesome.ui.overlaygallerydemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.anwesome.ui.overlaygallery.OverlayGallery;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int drawables[] = {R.drawable.back1,R.drawable.back2,R.drawable.back3,R.drawable.back4};
    private List<Bitmap> bitmaps = new ArrayList<>();
    private OverlayGallery overlayGallery;
    private Button showBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int drawable:drawables) {
            bitmaps.add(BitmapFactory.decodeResource(getResources(),drawable));
        }
        overlayGallery = new OverlayGallery(this,bitmaps);
        showBtn = (Button)findViewById(R.id.show);
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                overlayGallery.show();
            }
        });
    }
    public void onBackPressed() {
        if(overlayGallery.isShown()) {
            overlayGallery.hide();
        }
        else {
            super.onBackPressed();
        }
    }
}
