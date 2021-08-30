package com.prakriti.viewflipperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewAnimator;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String animals[] = new String[] {"BEAR", "BIRD", "CAT", "COW", "DOLPHIN", "FISH", "FOX", "HORSE", "LION", "TIGER"};
    private int images[] = { R.drawable.bear, R.drawable.bird, R.drawable.cat, R.drawable.cow, R.drawable.dolphin, R.drawable.fish,
            R.drawable.fox, R.drawable.horse, R.drawable.lion, R.drawable.tiger };

    private ViewFlipper viewFlipper;
    private ViewAnimator viewAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFlipper = findViewById(R.id.viewFlipper);
        viewAnimator = findViewById(R.id.viewAnimator);
        ImageButton btnNextImage = findViewById(R.id.btnNextImage);
        ImageButton btnPreviousImage = findViewById(R.id.btnPreviousImage);

        btnNextImage.setOnClickListener(this);
        btnPreviousImage.setOnClickListener(this);

        // add images to flipper
        for(int i = 0; i < images.length; i++) {
            ImageView img = new ImageView(this);
            img.setImageResource(images[i]);
            img.setLayoutParams(new LinearLayout.LayoutParams(800, 800)); // for images inside linear layout only
            img.setPadding(100, 100, 100, 100);
            viewFlipper.addView(img);
        }
        // animation for flipper
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right));


        // add images to animator
        for(int i = 0; i < images.length; i++) {
            ImageView img = new ImageView(this);
            img.setImageResource(images[i]);
            img.setLayoutParams(new LinearLayout.LayoutParams(800, 800)); // for images inside linear layout only
            img.setPadding(100, 100, 100, 100);
            viewAnimator.addView(img);
        }
        // animation for animator
        viewAnimator.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        viewAnimator.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNextImage:
                viewFlipper.showNext();
                viewAnimator.showNext();
                break;
            case R.id.btnPreviousImage:
                viewFlipper.showPrevious();
                viewAnimator.showPrevious();
                break;
        }
    }
}