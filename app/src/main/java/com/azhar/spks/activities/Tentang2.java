package com.azhar.spks.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.azhar.spks.R;

public class Tentang2 extends AppCompatActivity {

    Button btnKami;
    VideoView videoViewP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang2);

        btnKami = findViewById(R.id.btnKami);

        VideoView videoView = findViewById(R.id.videoViewP);
        // Tentukan lokasi video dari raw resources
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.pakar; // Ganti nama_video dengan nama file video Anda

        // Set URI video ke VideoView
        videoView.setVideoURI(Uri.parse(videoPath));

        // Atur listener untuk mendeteksi ketika persiapan video selesai
        videoView.setOnPreparedListener(mp -> {

                    // Mulai pemutaran video
                    videoView.start();
                });

        // Atur listener untuk mendeteksi ketika video selesai diputar
        videoView.setOnCompletionListener(mp -> {
            // Mengatur ulang pemutaran video ke awal
            videoView.seekTo(0);
            videoView.start();
        });

        btnKami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tentang2.this, Tentang.class);
                startActivity(intent);
                finish();
            }
        });
    }
}