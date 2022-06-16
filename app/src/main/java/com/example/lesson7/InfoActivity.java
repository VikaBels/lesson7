package com.example.lesson7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Objects;

public class InfoActivity extends AppCompatActivity {
    public static final String KEY_LOGIN = "textEditLogin";
    public static final String KEY_PASSWORD = "textEditPassword";
    public static final String KEY_NAME = "textEditName";
    public static final String KEY_SURNAME = "textEditSurname";
    public static final String KEY_SOME_INFO = "textEditSomeInfo";
    public static final String KEY_VIEW = "View";
    public static final String KEY_REGISTER = "Register";
    public static final String KEY_RADIO = "radio";
    public static final String KEY_ENTRANCE = "Entrance";

    public static final String[] info = {
            "Логин: ", "\nПароль: ", "\nИмя: ", "\nФамилия: ", "\nПол: ", "\nДоплнительная\nинформация: "
    };

    private final StringBuilder allInfo = new StringBuilder();

    private Button buttonBack;
    private TextView textViewInfo;

    private String login;
    private String password;
    private String name;
    private String surname;
    private String anotherInfo;
    private String pol;

    public void findViewById() {
        buttonBack = findViewById(R.id.btnBack);
        textViewInfo = findViewById(R.id.textAboutPerson);
    }

    @SuppressLint("SetTextI18n")
    public void workWithArguments() {
        Bundle arguments = getIntent().getExtras();

        if (arguments != null) {
            login = arguments.get(KEY_LOGIN).toString();
            password = arguments.get(KEY_PASSWORD).toString();
            if (arguments.get(KEY_VIEW).toString().equals(KEY_REGISTER)) {
                name = arguments.get(KEY_NAME).toString();
                surname = arguments.getString(KEY_SURNAME);
                anotherInfo = arguments.getString(KEY_SOME_INFO);
                pol = arguments.getString(KEY_RADIO);

                if (Objects.equals(pol, null)) {
                    pol = getString(R.string.dontKnow);
                }

                String[] aboutPersonReg = {login, password, name, surname, pol, anotherInfo};

                for (int i = 0; i < info.length; i++) {
                    allInfo.append(info[i]);
                    allInfo.append(aboutPersonReg[i]);
                }

                textViewInfo.setText(allInfo);
            } else {
                String[] aboutPersonEnt = {login, password};

                for (int i = 0; i < aboutPersonEnt.length; i++) {
                    allInfo.append(info[i]);
                    allInfo.append(aboutPersonEnt[i]);
                }

                textViewInfo.setText(allInfo);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        findViewById();

        workWithArguments();

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Bundle arguments = getIntent().getExtras();
                if (arguments.get("View").toString().equals("Register")) {
                    startActivity(intentBackToReg);
                } else {
                    startActivity(intentBackToEnt);
                }*/
                onBackPressed();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        buttonBack = null;
        textViewInfo = null;
    }
}