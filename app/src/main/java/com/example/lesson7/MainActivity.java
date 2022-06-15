package com.example.lesson7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonEntrance;
    private Button buttonRegister;
    private Button buttonAboutProgram;

    public Intent createEntranceIntent() {
        return new Intent(this, EntranceActivity.class);
    }

    public Intent createRegisterIntent() {
        return new Intent(this, RegisterActivity.class);
    }

    public Intent createAboutProgramIntent() {
        Uri address = Uri.parse("http://developer.android.com/intl/ru/index.html");
        return new Intent(Intent.ACTION_VIEW, address);
    }

    public static Intent createEntranceIntentForInfo(String loginText, String passwordText, EntranceActivity entranceActivity) {
        Intent intentEntrance = new Intent(entranceActivity, InfoActivity.class);

        intentEntrance.putExtra(InfoActivity.KEY_LOGIN, loginText)
                .putExtra(InfoActivity.KEY_PASSWORD, passwordText)
                .putExtra(InfoActivity.KEY_VIEW, InfoActivity.KEY_ENTRANCE);

        return intentEntrance;
    }

    public static Intent createRegisterIntentForInfo(String login, String name, String surname, String password,
                                                     String anotherInfo, String gender, RegisterActivity registerActivity) {
        Intent intentInfo = new Intent(registerActivity, InfoActivity.class);

        intentInfo.putExtra(InfoActivity.KEY_LOGIN, login)
                .putExtra(InfoActivity.KEY_NAME, name)
                .putExtra(InfoActivity.KEY_SURNAME, surname)
                .putExtra(InfoActivity.KEY_PASSWORD, password)
                .putExtra(InfoActivity.KEY_SOME_INFO, anotherInfo)
                .putExtra(InfoActivity.KEY_RADIO, gender)
                .putExtra(InfoActivity.KEY_VIEW, InfoActivity.KEY_REGISTER);

        return intentInfo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEntrance = findViewById(R.id.btnEntrance);
        buttonRegister = findViewById(R.id.btnRegisterOne);
        buttonAboutProgram = findViewById(R.id.btnAboutProgram);


        buttonEntrance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(createEntranceIntent());
            }
        });
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(createRegisterIntent());
            }
        });
        buttonAboutProgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(createAboutProgramIntent());
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ////////////
    }
}