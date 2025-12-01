package com.david.act6_0;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import com.david.act6_0.databinding.ActivityScene1Binding;

public class Scene1Activity extends AppCompatActivity {

    private ActivityScene1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScene1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Anima la imagen al entrar (zoom + fade)
        Animation zoomFade = AnimationUtils.loadAnimation(this, R.anim.zoom_fade_in);
        binding.ivScene.startAnimation(zoomFade);

        // Botón para ir a la escena 2
        binding.btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(Scene1Activity.this, Scene2Activity.class);
            startActivity(intent);
            // Transición "viaje mágico"
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

        // Manejo de back
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Reaplica un pequeño fade a la imagen si vuelven
        binding.ivScene.clearAnimation();
        binding.ivScene.setAlpha(0f);
        binding.ivScene.animate().alpha(1f).setDuration(500).start();
    }
}
