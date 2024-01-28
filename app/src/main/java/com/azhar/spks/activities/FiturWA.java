package com.azhar.spks.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.azhar.spks.R;

public class FiturWA extends AppCompatActivity {

    Button button;
    EditText Edtnama, Edtemail, Edtnamaanak, Edtpesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitur_wa);

        Edtnama = findViewById(R.id.editnama);
        Edtemail = findViewById(R.id.editemail);
        Edtnamaanak = findViewById(R.id.editnamaanak);
        Edtpesan = findViewById(R.id.editpesan);

        button = findViewById(R.id.btnkirim);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pesan1 = Edtnama.getText().toString();
                String pesan2 = Edtemail.getText().toString();
                String pesan3 = Edtnamaanak.getText().toString();
                String pesan4 = Edtpesan.getText().toString();

                String semuapesan = "Nama: " + pesan1 + "\n" + "Email : " +pesan2 + "\n" + "No. HP : " + pesan3 + "\n"+ "Pesam : " + pesan4;

                Intent kirimWA = new Intent(Intent.ACTION_SEND);
                kirimWA.setType("text/plain");
                kirimWA.putExtra(Intent.EXTRA_TEXT, semuapesan);
                kirimWA.putExtra( "Alfikran", "625244542679" + "whatsapp.net");
                kirimWA.setPackage("com.whatsapp");

                startActivity(kirimWA);
            }
        });
    }
}