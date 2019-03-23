package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    SQLiteDatabase db;
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

        db = openOrCreateDatabase("EmployeeDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Employee(EmpId INTEGER PRIMARY KEY AUTOINCREMENT, EmpName VARCHAR, EmpMail VARCHAR); ");
    }

    public void msg(Context context, String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btnLog:
                if (etEmail.getText().toString().trim().length() == 0 || etPass.getText().toString().trim().length() == 0) {
                    msg(this, "Enter E-mail and Password");
                    return;
                }
                Cursor c = db.rawQuery("SELECT * FROM Employee WHERE EmpName='" + etEmail.getText() + "' AND EmpMail='" +etPass.getText()+"'",  null);
                if (c.moveToFirst()) {
                    etEmail.setText(c.getString(1));
                    etPass.setText(c.getString(2));
                } else {
                    msg(this, "Invalid E-mail or Password");
                }
                break;
            case R.id.btnReg:
                if (etEmail.getText().toString().trim().length() == 0 ||
                        etPass.getText().toString().trim().length() == 0) {
                    msg(this, "Please enter all values");
                    return;
                }
                db.execSQL("INSERT INTO Employee(EmpName,EmpMail)VALUES('" + etEmail.getText() + "','" + etPass.getText() + "');");
                msg(this, "User has been successfully registered");
                break;
            default:
                break;
        }

    }
}
