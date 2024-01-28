package com.azhar.spks.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.azhar.spks.R;

public class SplashScreen extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView persentase;
    private VideoView videoView;
    private int Value = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        progressBar = findViewById(R.id.progress);
        persentase = findViewById(R.id.persentase);
        progressBar.setProgress(0); //Set Progress Dimulai Dari O

        VideoView videoView = findViewById(R.id.videoView);
        // Tentukan lokasi video dari raw resources
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.intro; // Ganti nama_video dengan nama file video Anda

        // Set URI video ke VideoView
        videoView.setVideoURI(Uri.parse(videoPath));

        // Mulai pemutaran video
        videoView.start();

        // Handler untuk Updating data pada latar belakang
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                // Menampung semua data yang ingin diproses oleh thread
                persentase.setText(String.valueOf(Value)+"%");
                if(Value == progressBar.getMax()){
                    Toast.makeText(getApplicationContext(), "Progress Completed", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    finish();
                }
                Value++;
            }
        };

        // Thread untuk updating progress pada ProgressBar di Latar Belakang
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int w=0; w<=progressBar.getMax(); w++){
                        progressBar.setProgress(w); // Memasukan Value pada ProgressBar
                        // Mengirim pesan dari handler, untuk diproses didalam thread
                        handler.sendMessage(handler.obtainMessage());
                        Thread.sleep(50); // Waktu Pending 100ms/0.1 detik
                    }
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
