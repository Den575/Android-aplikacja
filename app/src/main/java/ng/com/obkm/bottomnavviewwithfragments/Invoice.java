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

import java.util.Date;

public class Invoice extends AppCompatActivity implements View.OnClickListener {

    TextView tvName, tvWZ, tvNRS, tvZamowienie, tvDate;
    Button btnHome;
    SQLiteDatabase db;
    String oldcena="";
    double cena = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        Date date = new Date();

        tvName = (TextView) findViewById(R.id.tvName);
        tvWZ = (TextView) findViewById(R.id.tvWZ);
        tvNRS = (TextView) findViewById(R.id.tvNRS);
        tvZamowienie = (TextView) findViewById(R.id.tvZamow);
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvDate.setText(date.toString());

        btnHome = (Button) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(this);

        Intent intent = getIntent();
        oldcena = intent.getStringExtra("cena4");
        cena = cenaDouble(oldcena);
        String zamowienie = oldcena.substring(String.valueOf(cena).length()-1);


        db = openOrCreateDatabase("usersDB", Context.MODE_PRIVATE, null);
        Cursor c = db.rawQuery("SELECT * FROM Users WHERE UserId='" + 1 +"'",  null);
        if (c.moveToFirst()) {
            String nameSurname = c.getString(1)+" ";
            nameSurname+=" "+c.getString(2);
            String nrStolika=c.getString(5);
            tvName.setText("Imię i Nazwisko: "+nameSurname);
            tvWZ.setText("Wartość zamowienia: "+String.valueOf(cena)+"0 zł");
            tvNRS.setText("Nr stolika: "+nrStolika.substring(13,14));
            tvZamowienie.setText("Zamówienie:\n"+zamowienie);
        }

    }
    public void msg(Context context, String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    public static double cenaDouble(String oldcena){
        String newcena="";
        String liczby="0123456789";
        for(int i =0;i<oldcena.length();i++){
            for(int j=0;j<liczby.length();j++){
                if(liczby.charAt(j)==oldcena.charAt(i)){
                    newcena+=oldcena.charAt(i);

                }
                else if(oldcena.charAt(i)=='.'){
                    return Double.valueOf(newcena);
                }
            }
        }
        return Double.valueOf(newcena);
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
