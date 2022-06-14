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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

        buttonEntrance = (Button) findViewById(R.id.btnEntrance);
        buttonBack = (Button) findViewById(R.id.btnBack);
        loginTextView = (EditText) findViewById(R.id.textEditLogin);
        passwordTextView = (EditText) findViewById(R.id.textEditPassword);

        fieldRequiredTextLogin = getString(R.string.error_empty);
        fieldRequiredTextPassword = getString(R.string.error_empty);

        Intent intentEntrance = new Intent(this, InfoActivity.class);
        Intent intentBack = new Intent(this, MainActivity.class);

        buttonEntrance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryEntrance(intentEntrance);
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentBack);
                finish();
            }
        });
    }

    public void tryEntrance(Intent intentEntrance) {
        loginTextView.setError(null);
        passwordTextView.setError(null);

        String loginText = loginTextView.getText().toString().trim();
        String passwordText = passwordTextView.getText().toString().trim();

        boolean hasError = false;

        if (loginText.length() == 0) {
            loginTextView.setError(fieldRequiredTextLogin);
            hasError = true;
        } else if (passwordText.length() == 0) {
            passwordTextView.setError(fieldRequiredTextPassword);
            hasError = true;
        }

        if(hasError){
            return;
        }

        intentEntrance.putExtra("textEditLogin", loginText)
                .putExtra("textEditPassword", passwordText)
                .putExtra("View", "Entrance");

        startActivity(intentEntrance);
        finish();
    }
}