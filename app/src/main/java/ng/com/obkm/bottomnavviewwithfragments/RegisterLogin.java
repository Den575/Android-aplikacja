package ng.com.obkm.bottomnavviewwithfragments;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ng.com.obkm.bottomnavviewwithfragments.R;

public class RegisterLogin extends AppCompatActivity implements View.OnClickListener {

    SQLiteDatabase db;
    Button btnLog, btnReg;
    EditText etEmail, etPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_login);

        btnLog = (Button) findViewById(R.id.btnLog);
        btnReg = (Button) findViewById(R.id.btnReg);
        btnLog.setOnClickListener(this);
        btnReg.setOnClickListener(this);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPass = (EditText) findViewById(R.id.etPass);

        db = openOrCreateDatabase("usersDB", Context.MODE_PRIVATE, null);
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
                Cursor c = db.rawQuery("SELECT * FROM Users WHERE UsrEmail='" + etEmail.getText() + "' AND UsrPass='" +etPass.getText()+"'",  null);
                if (c.moveToFirst()) {
                    intent = new Intent("android.intent.action.qr");
                    startActivity(intent);
                    etEmail.setText(c.getString(1));
                    etPass.setText(c.getString(2));
                } else {
                    msg(this, "Invalid E-mail or Password");
                    etEmail.setTextColor(getResources().getColor(R.color.colorPrimary));
                    etPass.setTextColor(getResources().getColor(R.color.colorPrimary));
                }
                break;
            case R.id.btnReg:
                intent = new Intent("android.intent.action.Registration");
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}
