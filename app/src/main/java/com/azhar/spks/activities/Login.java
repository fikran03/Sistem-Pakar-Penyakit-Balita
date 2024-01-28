package com.azhar.spks.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.azhar.spks.R;
import com.azhar.spks.database.DatabaseHelper;
import com.google.android.material.button.MaterialButton;

public class Login extends AppCompatActivity {


    MaterialButton btnLogin;
    private EditText editTextEmail, editTextPassword;
    TextView TextReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        TextReg = findViewById(R.id.TextReg);
        MaterialButton btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                Intent intent = new Intent(Intent.ACTION_VIEW);

                boolean isValid = databaseHelper.checkUser(email, password);

                if (isValid) {
                    Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
                    // Lanjutkan ke aktivitas berikutnya atau tampilkan pesan berhasil login
                    // Setelah login berhasil
                    String phoneNumber = "6281247493469"; // Ganti dengan nomor telepon yang Anda inginkan
                    String url = "https://wa.me/" + phoneNumber;

                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Login.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                    // Jika login gagal, alihkan ke RegisterActivity
                    intent = new Intent(Login.this, RegisterActivity.class);
                    startActivity(intent);
                }
            }
        });

        TextReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}