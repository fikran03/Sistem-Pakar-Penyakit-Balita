package com.azhar.spks.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.azhar.spks.R;
import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    MaterialCardView mcDiagnosa, mcKonsultasi, mcTentang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setStatusBar();

        mcDiagnosa = findViewById(R.id.mcDiagnosa);
        mcKonsultasi = findViewById(R.id.mcKonsultasi);
        mcTentang = findViewById(R.id.mcTentang);

        mcDiagnosa.setOnClickListener(view -> {
                    Intent intent = new Intent(getApplicationContext(), DaftarPenyakitActivity.class);
                    startActivity(intent);
                }
        );

        mcKonsultasi.setOnClickListener(view -> {
                    Intent intent = new Intent(getApplicationContext(), KonsultasiActivity.class);
                    startActivity(intent);
                }
        );

        mcTentang.setOnClickListener(view -> {
                    Intent intent = new Intent(getApplicationContext(), Tentang.class);
                    startActivity(intent);
                }
        );

    }


    private void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        if (on) {
            layoutParams.flags |= bits;
        } else {
            layoutParams.flags &= ~bits;
        }
        window.setAttributes(layoutParams);
    }


}