package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLog, btnReg;
    EditText etEmail, etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2akc);

        btnLog = (Button) findViewById(R.id.btnLog);
        btnReg = (Button) findViewById(R.id.btnReg);
        btnLog.setOnClickListener(this);
        btnReg.setOnClickListener(this);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPass = (EditText) findViewById(R.id.etPass);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btnLog:
                break;
            case R.id.btnReg:
                intent = new Intent("");
                break;
            default:
                break;
        }

    }
}
