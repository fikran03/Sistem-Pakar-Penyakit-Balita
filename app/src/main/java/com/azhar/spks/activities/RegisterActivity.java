package com.azhar.spks.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.azhar.spks.R;
import com.azhar.spks.database.DatabaseHelper;
import com.google.android.material.button.MaterialButton;

public class RegisterActivity extends AppCompatActivity {

    MaterialButton btnRegister;
    EditText editTextRegisterUsername, editTextRegisterAnak, editTextRegisterEmail, editTextRegisterPassword;
    TextView TextLog;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        editTextRegisterUsername = findViewById(R.id.editTextRegisterUsername);
        editTextRegisterAnak = findViewById(R.id.editTextRegisterAnak);
        editTextRegisterEmail = findViewById(R.id.editTextRegisterEmail);
        editTextRegisterPassword = findViewById(R.id.editTextRegisterPassword);
        TextLog = findViewById(R.id.TextLog);
        MaterialButton buttonRegister = findViewById(R.id.btnRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mendapatkan nilai dari input fields
                String username = editTextRegisterUsername.getText().toString();
                String anak = editTextRegisterUsername.getText().toString();
                String email = editTextRegisterEmail.getText().toString();
                String password = editTextRegisterPassword.getText().toString();

                // Validasi sederhana
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(RegisterActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Cek apakah email sudah terdaftar
                if (databaseHelper.checkUserExists(email)) {
                    Toast.makeText(RegisterActivity.this, "Email is already registered", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Menambahkan pengguna baru ke database
                boolean isInserted = databaseHelper.addUser(username, anak, email, password);

                if (isInserted) {
                    Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();

                    // Setelah registrasi berhasil, arahkan pengguna ke halaman login
                    redirectToLogin();
                } else {
                    Toast.makeText(RegisterActivity.this, "Failed to register user", Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void redirectToLogin() {
        Intent intent = new Intent(RegisterActivity.this, Login.class);
        startActivity(intent);
        finish(); // Optional, agar pengguna tidak dapat kembali ke halaman registrasi dengan tombol "back"
    }
}
