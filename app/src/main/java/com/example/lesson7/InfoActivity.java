package com.example.lesson7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {
    private Button buttonBack;
    private TextView textViewInfo;

    private String login;
    private String password;
    private String name;
    private String surname;
    private String anotherInfo;
    private String pol;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        buttonBack = (Button) findViewById(R.id.btnBack);
        textViewInfo = (TextView) findViewById(R.id.textAboutPerson);

        //Intent intentBackToReg = new Intent(this, RegisterActivity.class);
        //Intent intentBackToEnt = new Intent(this, EntranceActivity.class);
        Intent intent = new Intent(this, MainActivity.class);

        Bundle arguments = getIntent().getExtras();

        if (arguments != null) {
             login = arguments.get("textEditLogin").toString();
             password = arguments.get("textEditPassword").toString();
            if (arguments.get("View").toString().equals("Register")) {
                 name = arguments.get("textEditName").toString();
                 surname = arguments.getString("textEditSurname");
                 anotherInfo = arguments.getString("textEditSomeInfo");
                 pol = arguments.getString("radio");

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
                /*Bundle arguments = getIntent().getExtras();
                if (arguments.get("View").toString().equals("Register")) {
                    startActivity(intentBackToReg);
                } else {
                    startActivity(intentBackToEnt);
                }*/
                startActivity(intent);
                finish();
            }
        });
    }
}