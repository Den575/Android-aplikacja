package ng.com.obkm.bottomnavviewwithfragments;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Invoice extends AppCompatActivity implements View.OnClickListener {

    TextView tvName, tvWZ, tvNRS, tvZamowienie;
    Button btnHome;
    SQLiteDatabase db;
    String oldcena="";
    double cena = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        tvName = (TextView) findViewById(R.id.tvName);
        tvWZ = (TextView) findViewById(R.id.tvWZ);
        tvNRS = (TextView) findViewById(R.id.tvNRS);
        tvZamowienie = (TextView) findViewById(R.id.tvZamow);

        btnHome = (Button) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(this);

        Intent intent = getIntent();
        oldcena = intent.getStringExtra("cena4");
        cena = Double.valueOf(oldcena.substring(0,2));
        String zamowienie = oldcena.substring(7);


        db = openOrCreateDatabase("usersDB", Context.MODE_PRIVATE, null);
        Cursor c = db.rawQuery("SELECT * FROM Users WHERE UserId='" + 1 +"'",  null);
        if (c.moveToFirst()) {
            String nameSurname = c.getString(1)+" ";
            nameSurname+=" "+c.getString(2);
            String nrStolika=c.getString(5);
            tvName.setText("Imię i Nazwisko: "+nameSurname);
            tvWZ.setText("Wartość zamowienia: "+String.valueOf(cena)+" zł");
            tvNRS.setText("Nr stolika: "+nrStolika.substring(13,14));
            tvZamowienie.setText("Zamówienie:\n"+zamowienie);
        }

    }
    public void msg(Context context, String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnHome:
                Intent intent = new Intent("android.intent.action.MAIN");
                startActivity(intent);
        }
    }
}