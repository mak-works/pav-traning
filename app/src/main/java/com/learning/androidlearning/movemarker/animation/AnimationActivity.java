package com.learning.androidlearning.movemarker.animation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.learning.androidlearning.R;

public class AnimationActivity extends AppCompatActivity {
    boolean isEqual = true;
    AnimatedVectorDrawable equalAnim, plusAnim;
    Context context;
    Button animate_equal;
    AnimationActivity animationActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ImageView animateImageOne = findViewById(R.id.animate_image);
        ImageView animateImageTwo = findViewById(R.id.animate_image_two);
        ImageView animateImageThree = findViewById(R.id.animate_image_three);
        ImageView animateImageFour = findViewById(R.id.animate_image_four);
        animate_equal = findViewById(R.id.animate_equal);


        animateImageThree.setVisibility(View.INVISIBLE);

        Animatable animatable = (Animatable) animateImageOne.getDrawable();
        animatable.start();
        Animatable animatableTwo = (Animatable) animateImageTwo.getDrawable();
        animatableTwo.start();
        animateImageTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (animateImageThree.getVisibility() == View.INVISIBLE) {
                    animateImageThree.setVisibility(View.VISIBLE);
                    Animatable animatableThree = (Animatable) animateImageThree.getDrawable();
                    animatableThree.start();
                }

            }
        });
        animate_equal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View v) {
                equalAnim = (AnimatedVectorDrawable) ContextCompat.getDrawable(getApplicationContext(), R.drawable.animation_equal);
                plusAnim = (AnimatedVectorDrawable) ContextCompat.getDrawable(getApplicationContext(), R.drawable.animation_plus);
                AnimatedVectorDrawable drawable = isEqual ? equalAnim : plusAnim;
                animateImageFour.setImageDrawable(drawable);
                drawable.start();
                isEqual = !isEqual;

            }
        });
    }
}


