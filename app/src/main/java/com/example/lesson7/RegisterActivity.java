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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        buttonRegister = (Button) findViewById(R.id.btnRegisterTwo);
        buttonBack = (Button) findViewById(R.id.btnBack);

        radioWoman = (RadioButton) findViewById(R.id.radioWoman);
        radioMan = (RadioButton) findViewById(R.id.radioMan);
        radioDontKnow = (RadioButton) findViewById(R.id.radioDontKnow);
        radioAgree = (RadioButton) findViewById(R.id.radioAg);

        loginTextView = (EditText) findViewById(R.id.textEditLogin);
        passwordTextView = (EditText) findViewById(R.id.textEditPassword);
        repeatPasswordTextView = (EditText) findViewById(R.id.textEditPasswordRepeat);
        nameTextView = (EditText) findViewById(R.id.textEditName);
        surnameTextView = (EditText) findViewById(R.id.textEditSurname);
        anotherInfoTextView = (EditText) findViewById(R.id.textEditSomeInfo);

        fieldRequiredText = getString(R.string.error_required);
        passwordDoNotMatchText = getString(R.string.error_not_match);
        minLengthFormat = getString(R.string.error_min_length);

        Intent intentInfo = new Intent(this, InfoActivity.class);
        Intent intentBack = new Intent(this, MainActivity.class);

        radioDontKnow.setChecked(true);
        buttonRegister.setEnabled(false);

        final String[] gender = new String[1];

        /* radioAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               buttonRegister.setEnabled(true);
            }
        });

        radioDontKnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton radioButtonD=findViewById(R.id.radioDontKnow);
                gender[0] = radioButtonD.getHint().toString();
            }
        });
        radioWoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton radioButtonW=findViewById(R.id.radioWoman);
                gender[0] = radioButtonW.getHint().toString();
            }
        });
        radioMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton radioButtonM=findViewById(R.id.radioMan);
                gender[0] = radioButtonM.getHint().toString();
            }
        });

       buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText loginText = findViewById(R.id.textEditLogin);
                EditText passwordText = findViewById(R.id.textEditPassword);
                EditText repeatPasswordText = findViewById(R.id.textEditPasswordRepeat);
                EditText nameText = findViewById(R.id.textEditName);
                EditText surnameText = findViewById(R.id.textEditSurname);
                EditText anotherInfoText = findViewById(R.id.textEditSomeInfo);

                String login = loginText.getText().toString();
                String password = passwordText.getText().toString();
                String repeatPassword = repeatPasswordText.getText().toString();
                String name = nameText.getText().toString();
                String surname = surnameText.getText().toString();
                String anotherInfo = anotherInfoText.getText().toString();

                if(validate(login,password,repeatPassword,name,surname)){
                    intentInfo.putExtra("textEditLogin", login);
                    intentInfo.putExtra("textEditName", name);
                    intentInfo.putExtra("textEditSurname", surname);
                    intentInfo.putExtra("textEditPassword", password);
                    intentInfo.putExtra("textEditPasswordRepeat", repeatPassword);
                    intentInfo.putExtra("textEditSomeInfo", anotherInfo);
                    intentInfo.putExtra("radio",gender[0]);
                    intentInfo.putExtra("View","Register");

                    startActivity(intentInfo);
                }
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentBack);
            }
        });
*/
        View.OnClickListener allButton = new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnBack:
                        startActivity(intentBack);
                        finish();
                        break;
                    case R.id.btnRegisterTwo:
                        tryRegister(intentInfo, gender);
                        break;
                    case R.id.radioAg:
                        buttonRegister.setEnabled(true);
                        break;
                    case R.id.radioDontKnow: {
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
        buttonBack.setOnClickListener(allButton);
        buttonRegister.setOnClickListener(allButton);
        radioAgree.setOnClickListener(allButton);
        radioDontKnow.setOnClickListener(allButton);
        radioWoman.setOnClickListener(allButton);
        radioMan.setOnClickListener(allButton);
    }

    public void tryRegister(Intent intentInfo, String[] gender) {
        loginTextView.setError(null);
        passwordTextView.setError(null);
        repeatPasswordTextView.setError(null);
        nameTextView.setError(null);
        surnameTextView.setError(null);
        anotherInfoTextView.setError(null);

        String login = loginTextView.getText().toString().trim();
        String password = passwordTextView.getText().toString().trim();
        String repeatPassword = repeatPasswordTextView.getText().toString().trim();
        String name = nameTextView.getText().toString().trim();
        String surname = surnameTextView.getText().toString().trim();
        String anotherInfo = anotherInfoTextView.getText().toString().trim();

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

        if (hasError) {
            return;
        }

        intentInfo.putExtra("textEditLogin", login)
                .putExtra("textEditName", name)
                .putExtra("textEditSurname", surname)
                .putExtra("textEditPassword", password)
                .putExtra("textEditPasswordRepeat", repeatPassword)
                .putExtra("textEditSomeInfo", anotherInfo)
                .putExtra("radio", gender[0])
                .putExtra("View", "Register");

        startActivity(intentInfo);
        finish();
    }

   /* public void forRegister(Intent intentInfo, String[] gender) {
        String login = loginTextView.getText().toString();
        String password = passwordTextView.getText().toString();
        String repeatPassword = repeatPasswordTextView.getText().toString();
        String name = nameTextView.getText().toString();
        String surname = surnameTextView.getText().toString();
        String anotherInfo = anotherInfoTextView.getText().toString();

        if (validate(login, password, repeatPassword, name, surname)) {
            intentInfo.putExtra("textEditLogin", login);
            intentInfo.putExtra("textEditName", name);
            intentInfo.putExtra("textEditSurname", surname);
            intentInfo.putExtra("textEditPassword", password);
            intentInfo.putExtra("textEditPasswordRepeat", repeatPassword);
            intentInfo.putExtra("textEditSomeInfo", anotherInfo);
            intentInfo.putExtra("radio", gender[0]);
            intentInfo.putExtra("View", "Register");

            startActivity(intentInfo);
            finish();
        }
    }

    public boolean validate(String l, String p, String rp, String n, String s) {
        boolean value = true;
        if (l.equals("") || p.equals("") || rp.equals("")
                || n.equals("") || s.equals("")) {
            value = false;
        } else if (l.length() < 4 || p.length() < 8) {
            value = false;
        } else if (!p.equals(rp)) {
            value = false;
        }
        return value;
    }
*/
}