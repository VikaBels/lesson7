package com.example.lesson7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    Button buttonBack;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        buttonBack = findViewById(R.id.btnBack);
        Intent intentBackToReg = new Intent(this, RegisterActivity.class);
        Intent intentBackToEnt = new Intent(this, EntranceActivity.class);

        TextView textViewInfo = findViewById(R.id.textAboutPerson);

        Bundle arguments = getIntent().getExtras();

        if (arguments != null) {
            String login = arguments.get("textEditLogin").toString();
            String password = arguments.get("textEditPassword").toString();
            if (arguments.get("View").toString().equals("Register")) {
                String name = arguments.get("textEditName").toString();
                String surname = arguments.getString("textEditSurname");
                String anotherInfo = arguments.getString("textEditSomeInfo");
                String pol = arguments.getString("radio");

                textViewInfo.setText(
                        "Логин: " + login + "\nПароль: " + password + "\nИмя: " + name +
                                "\nФамилия: " + surname + "\nПол: " + pol + "\nДоплнительная\nинформация: " + anotherInfo);
            } else {
                textViewInfo.setText("Логин: " + login + "\nПароль: " + password);
            }
        }

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle arguments = getIntent().getExtras();
                if (arguments.get("View").toString().equals("Register")) {
                    startActivity(intentBackToReg);
                } else {
                    startActivity(intentBackToEnt);
                }

            }
        });
    }
}