package com.example.flash_blink;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraAccessException;

import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private CameraManager cameraManager;
    private String cameraId;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        EditText text = findViewById(R.id.editTextText);

        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            if (cameraManager != null) {
                cameraId = cameraManager.getCameraIdList()[0];
                Toast.makeText(MainActivity.this, "Camera Accessible!!!", Toast.LENGTH_SHORT).show();
            }
        } catch (CameraAccessException e) {
            Toast.makeText(MainActivity.this, "Camera Not Accessible!!!", Toast.LENGTH_SHORT).show();
        }

        btn.setOnClickListener(v -> {
            String input = text.getText().toString().trim();

            int times;
            try {
                times = Integer.parseInt(input);
                if (times <= 0) {
                    Toast.makeText(MainActivity.this, "Please enter a positive number", Toast.LENGTH_SHORT).show();
                    return;
                }
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Invalid number", Toast.LENGTH_SHORT).show();
                return;
            }

            blinkFlash(times);
        });
    }

    private void blinkFlash(int times) {
        final int delay = 500;
        for (int i = 0; i < times * 2; i++) {
            int finalI = i;
            handler.postDelayed(() -> {
                try {
                    boolean state = (finalI % 2 == 0); // ON at even, OFF at odd
                    cameraManager.setTorchMode(cameraId, state);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Flashlight error!", Toast.LENGTH_SHORT).show();
                }
            }, finalI * delay);
        }
    }
}
