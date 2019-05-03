package ng.com.obkm.bottomnavviewwithfragments;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity implements View.OnClickListener {
    SQLiteDatabase db;

    EditText etrName, etrSurname, etrEmail, etrPassword;
    Button btnRegister;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        checkBox = (CheckBox) findViewById(R.id.checkBox);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);

        etrName = (EditText) findViewById(R.id.etrName);
        etrSurname = (EditText) findViewById(R.id.etrSurname);
        etrEmail = (EditText) findViewById(R.id.etrEmail);
        etrPassword = (EditText) findViewById(R.id.etrPass);

        db = openOrCreateDatabase("usersDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Users(UserId INTEGER PRIMARY KEY AUTOINCREMENT, UsrName VARCHAR, UsrSurN VARCHAR, UsrEmail VARCHAR, UsrPass VARCHAR, nrStolika VARCHAR); ");
    }

    public void msg(Context context, String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btnRegister:
                boolean check;
                if (etrName.getText().toString().trim().length() == 0 ||
                        etrSurname.getText().toString().trim().length() == 0 ||
                        etrEmail.getText().toString().trim().length() == 0 ||
                        etrPassword.getText().toString().trim().length() == 0) {
                    msg(this, "Please enter all values");
                    return;
                }
                if(checkBox.isChecked()){
                    check = true;
                }else {
                    check = false;
                    msg(this, "Please check CheckBox");
                    return;
                }
                String text="0";
                db.execSQL("INSERT INTO Users(UsrName,UsrSurN,UsrEmail,UsrPass,nrStolika)VALUES('" + etrName.getText() + "','" + etrSurname.getText() + "','" + etrEmail.getText() + "','"+etrPassword.getText() +"','"+text+"');");
                msg(this, "User has been successfully registered");
                intent = new Intent("android.intent.action.RegisterLogin");
                startActivity(intent);
            default:
                break;
        }
    }
}
