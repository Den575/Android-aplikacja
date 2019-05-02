package ng.com.obkm.bottomnavviewwithfragments;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Invoice extends AppCompatActivity {

    TextView tv;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        tv = (TextView) findViewById(R.id.textView);

        db = openOrCreateDatabase("usersDB", Context.MODE_PRIVATE, null);
        Cursor c = db.rawQuery("SELECT * FROM Users WHERE UserId='" + 1 +"'",  null);
        if (c.moveToFirst()) {
            String dane = c.getString(1)+" ";
            dane+=c.getString(2)+" ";
            dane+=c.getString(3)+" ";
            tv.setText(dane);
        }

    }
    public void msg(Context context, String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
