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
    Button buttonRegister;
    Button buttonBack;

    RadioButton radioWoman;
    RadioButton radioMan;
    RadioButton radioDontKnow;

    RadioButton radioAgree;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        buttonRegister = findViewById(R.id.btnRegisterTwo);
        buttonBack = findViewById(R.id.btnBack);

        radioWoman = findViewById(R.id.radioWoman);
        radioMan = findViewById(R.id.radioMan);
        radioDontKnow = findViewById(R.id.radioDontKnow);
        radioAgree = findViewById(R.id.radioAg);

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
                        break;
                    case R.id.btnRegisterTwo:
                        forRegister(intentInfo, gender);
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

    public void forRegister(Intent intentInfo, String[] gender) {
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
}