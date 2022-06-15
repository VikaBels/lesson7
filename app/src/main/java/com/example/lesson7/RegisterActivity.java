package com.example.lesson7;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class RegisterActivity extends AppCompatActivity {
    private Button buttonRegister;
    private Button buttonBack;

    private RadioButton radioWoman;
    private RadioButton radioMan;
    private RadioButton radioDontKnow;
    private RadioButton radioAgree;

    private EditText loginTextView;
    private EditText passwordTextView;
    private EditText repeatPasswordTextView;
    private EditText nameTextView;
    private EditText surnameTextView;
    private EditText anotherInfoTextView;

    private String fieldRequiredText;
    private String passwordDoNotMatchText;
    private String minLengthFormat;

    private String login;
    private String password;
    private String repeatPassword;
    private String name;
    private String surname;
    private String anotherInfo;

    public void findViewById() {
        buttonRegister = findViewById(R.id.btnRegisterTwo);
        buttonBack = findViewById(R.id.btnBack);

        radioWoman = findViewById(R.id.radioWoman);
        radioMan = findViewById(R.id.radioMan);
        radioDontKnow = findViewById(R.id.radioDontKnow);
        radioAgree = findViewById(R.id.radioAg);

        loginTextView = findViewById(R.id.textEditLogin);
        passwordTextView = findViewById(R.id.textEditPassword);
        repeatPasswordTextView = findViewById(R.id.textEditPasswordRepeat);
        nameTextView = findViewById(R.id.textEditName);
        surnameTextView = findViewById(R.id.textEditSurname);
        anotherInfoTextView = findViewById(R.id.textEditSomeInfo);
    }

    public void setOnClickListener(View.OnClickListener allButton) {
        buttonBack.setOnClickListener(allButton);
        buttonRegister.setOnClickListener(allButton);
        radioAgree.setOnClickListener(allButton);
        radioDontKnow.setOnClickListener(allButton);
        radioWoman.setOnClickListener(allButton);
        radioMan.setOnClickListener(allButton);
    }

    public void setError() {
        loginTextView.setError(null);
        passwordTextView.setError(null);
        repeatPasswordTextView.setError(null);
        nameTextView.setError(null);
        surnameTextView.setError(null);
        anotherInfoTextView.setError(null);
    }

    public void getText() {
        login = loginTextView.getText().toString().trim();
        password = passwordTextView.getText().toString().trim();
        repeatPassword = repeatPasswordTextView.getText().toString().trim();
        name = nameTextView.getText().toString().trim();
        surname = surnameTextView.getText().toString().trim();
        anotherInfo = anotherInfoTextView.getText().toString().trim();
    }

    public boolean validate() {
        boolean hasError = false;

        if (login.length() == 0) {
            loginTextView.setError(fieldRequiredText);
            hasError = true;
        } else if (login.length() < 4) {
            loginTextView.setError(String.format(minLengthFormat, 4));
            hasError = true;
        }

        if (password.length() == 0) {
            passwordTextView.setError(fieldRequiredText);
            hasError = true;
        } else if (password.length() < 8) {
            passwordTextView.setError(String.format(minLengthFormat, 8));
            hasError = true;
        }

        if (repeatPassword.length() == 0) {
            repeatPasswordTextView.setError(fieldRequiredText);
            hasError = true;
        } else if (!repeatPassword.equals(password)) {
            repeatPasswordTextView.setError(passwordDoNotMatchText);
            hasError = true;
        }

        if (name.length() == 0) {
            nameTextView.setError(fieldRequiredText);
            hasError = true;
        }
        if (surname.length() == 0) {
            surnameTextView.setError(fieldRequiredText);
            hasError = true;
        }

        return hasError;
    }

    public void tryRegister(String[] gender) {
        setError();

        getText();

        if (validate()) {
            return;
        }

        //static method start activity
        startActivity(MainActivity.createRegisterIntentForInfo(login, name, surname, password, anotherInfo, gender[0], this));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        findViewById();

        fieldRequiredText = getString(R.string.error_required);
        passwordDoNotMatchText = getString(R.string.error_not_match);
        minLengthFormat = getString(R.string.error_min_length);

        radioDontKnow.setChecked(true);
        buttonRegister.setEnabled(false);

        final String[] gender = new String[1];

        View.OnClickListener allButton = new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnBack:
                        onBackPressed();
                        break;
                    case R.id.btnRegisterTwo:
                        tryRegister(gender);
                        break;
                    case R.id.radioAg:
                        buttonRegister.setEnabled(true);
                        break;
                    case R.id.radioDontKnow: {
                        ///////////
                        RadioButton radioButtonD = findViewById(R.id.radioDontKnow);
                        gender[0] = radioButtonD.getHint().toString();
                    }
                    break;
                    case R.id.radioWoman: {
                        RadioButton radioButtonW = findViewById(R.id.radioWoman);
                        gender[0] = radioButtonW.getHint().toString();
                    }
                    break;
                    case R.id.radioMan: {
                        RadioButton radioButtonM = findViewById(R.id.radioMan);
                        gender[0] = radioButtonM.getHint().toString();
                    }
                    break;
                }
            }
        };

        setOnClickListener(allButton);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}