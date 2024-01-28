package com.azhar.spks.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.widget.Toolbar;

import com.azhar.spks.R;

public class Tentang extends AppCompatActivity {

    Button btnPakar;
    VideoView videoViewK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);

        btnPakar = findViewById(R.id.btnPakar);

        VideoView videoView = findViewById(R.id.videoViewK);
        // Tentukan lokasi video dari raw resources
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.kami; // Ganti nama_video dengan nama file video Anda

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

        btnPakar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tentang.this, Tentang2.class);
                startActivity(intent);
                finish();
            }
        });
    }

}