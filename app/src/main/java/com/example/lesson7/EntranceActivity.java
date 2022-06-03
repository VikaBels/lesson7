package com.example.lesson7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EntranceActivity extends AppCompatActivity {

    Button buttonEntrance;
    Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

        buttonEntrance = findViewById(R.id.btnEntrance);
        buttonBack = findViewById(R.id.btnBack);

        Intent intentEntrance = new Intent(this, InfoActivity.class);
        Intent intentBack = new Intent(this, MainActivity.class);

        buttonEntrance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText loginText = findViewById(R.id.textEditLogin);
                EditText passwordText = findViewById(R.id.textEditPassword);

                String login = loginText.getText().toString();
                String password = passwordText.getText().toString();

                if (!login.equals("") && !password.equals("")) {
                    intentEntrance.putExtra("textEditLogin", login);
                    intentEntrance.putExtra("textEditPassword", password);
                    intentEntrance.putExtra("View", "Entrance");

                    startActivity(intentEntrance);
                }
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentBack);
            }
        });
    }
}