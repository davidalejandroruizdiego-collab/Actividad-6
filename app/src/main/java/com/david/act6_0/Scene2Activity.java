package com.david.act6_0;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import com.david.act6_0.databinding.ActivityScene2Binding;

public class Scene2Activity extends AppCompatActivity {

    private ActivityScene2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScene2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Animation zoomFade = AnimationUtils.loadAnimation(this, R.anim.zoom_fade_in);
        binding.ivScene.startAnimation(zoomFade);

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        binding.btnBack.setOnClickListener(v -> {
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });

        binding.btnToScene1.setOnClickListener(v -> {
            Intent intent = new Intent(Scene2Activity.this, Scene1Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });


    }
}
