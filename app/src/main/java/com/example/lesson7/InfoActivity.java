package com.example.lesson7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

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

    public static final String dontKnowGender="Не определилось";

    private Button buttonBack;
    private TextView textViewInfo;

    private String login;
    private String password;
    private String name;
    private String surname;
    private String anotherInfo;
    private String pol;

    public void findViewById(){
        buttonBack = findViewById(R.id.btnBack);
        textViewInfo = findViewById(R.id.textAboutPerson);
    }

    @SuppressLint("SetTextI18n")
    public void workWithArguments(){
        Bundle arguments = getIntent().getExtras();

        if (arguments != null) {
            login = arguments.get(KEY_LOGIN).toString();
            password = arguments.get(KEY_PASSWORD).toString();
            if (arguments.get(KEY_VIEW).toString().equals(KEY_REGISTER)) {
                name = arguments.get(KEY_NAME).toString();
                surname = arguments.getString(KEY_SURNAME);
                anotherInfo = arguments.getString(KEY_SOME_INFO);
                pol = arguments.getString(KEY_RADIO);

                if(Objects.equals(pol, null)){
                    pol=dontKnowGender;
                }

                //stringBuilder!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                StringBuilder sb=new StringBuilder();
                sb.append(info[0]);

                textViewInfo.setText(
                        info[0] + login + info[1] + password + info[2] + name +
                                info[3] + surname + info[4] + pol + info[5] + anotherInfo);
            } else {
                textViewInfo.setText(info[0] + login + info[1] + password);
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
                //!!!!!!!!!!!!!!!!onBackPressed();
                onBackPressed();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}