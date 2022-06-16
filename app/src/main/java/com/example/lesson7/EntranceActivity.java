package com.example.lesson7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class EntranceActivity extends AppCompatActivity {
    private Button buttonEntrance;
    private Button buttonBack;

    private EditText loginTextView;
    private EditText passwordTextView;

    private String fieldRequiredTextLogin;
    private String fieldRequiredTextPassword;

    private String loginText;
    private String passwordText;

    public void findViewById() {
        buttonEntrance = findViewById(R.id.btnEntrance);
        buttonBack = findViewById(R.id.btnBack);
        loginTextView = findViewById(R.id.textEditLogin);
        passwordTextView = findViewById(R.id.textEditPassword);
    }

    public void setError() {
        loginTextView.setError(null);
        passwordTextView.setError(null);
    }

    public void getText() {
        loginText = loginTextView.getText().toString().trim();
        passwordText = passwordTextView.getText().toString().trim();
    }

    public boolean validate() {
        boolean hasError = false;

        if (loginText.length() == 0) {
            loginTextView.setError(fieldRequiredTextLogin);
            hasError = true;
        } else if (passwordText.length() == 0) {
            passwordTextView.setError(fieldRequiredTextPassword);
            hasError = true;
        }

        return hasError;
    }

    public void tryEntrance() {
        setError();

        getText();

        if (validate()) {
            return;
        }

        startActivity(MainActivity.createEntranceIntentForInfo(loginText, passwordText, this));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

        findViewById();

        fieldRequiredTextLogin = getString(R.string.error_empty);
        fieldRequiredTextPassword = getString(R.string.error_empty);

        buttonEntrance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryEntrance();
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                /////////////////onbackpressedDesp
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        buttonEntrance = null;
        buttonBack = null;
        loginTextView = null;
        passwordTextView = null;
    }
}