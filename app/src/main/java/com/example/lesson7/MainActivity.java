package com.example.lesson7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonEntrance;
    Button buttonRegister;
    Button buttonAboutProgram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEntrance = findViewById(R.id.btnEntrance);
        buttonRegister = findViewById(R.id.btnRegisterOne);
        buttonAboutProgram = findViewById(R.id.btnAboutProgram);

        Intent intentEntrance = new Intent(this, EntranceActivity.class);
        Intent intentRegister = new Intent(this, RegisterActivity.class);

        buttonEntrance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentEntrance);
            }
        });
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentRegister);
            }
        });
        buttonAboutProgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri address = Uri.parse("http://developer.android.com/intl/ru/index.html");
                Intent intentAboutProgram = new Intent(Intent.ACTION_VIEW, address);
                startActivity(intentAboutProgram);
            }
        });

    }
}