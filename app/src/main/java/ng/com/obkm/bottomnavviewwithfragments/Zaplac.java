package ng.com.obkm.bottomnavviewwithfragments;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Zaplac extends AppCompatActivity implements View.OnClickListener {

    TextView tvzaplac;
    Button btnZero, btnZaplac;
    EditText etnrkarty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zaplac);

        tvzaplac = (TextView) findViewById(R.id.zaplata);
        Intent intent = getIntent();
        String oldcena = intent.getStringExtra("cena1");
        double cena = Double.valueOf(oldcena);
        tvzaplac.setText("Suma do zapłaty: "+String.valueOf(cena)+" zł");

        btnZero = (Button) findViewById(R.id.btnZero);
        btnZaplac = (Button) findViewById(R.id.btnZaplac);
        btnZero.setOnClickListener(this);
        btnZaplac.setOnClickListener(this);

        etnrkarty = (EditText) findViewById(R.id.nrkarty);
    }

    public void msg(Context context, String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        Intent intent1;
        switch (view.getId()){
            case R.id.btnZero:
                intent1 = new Intent("android.intent.action.MAIN");
                startActivity(intent1);
                break;
            case R.id.btnZaplac:
                String nrK = String.valueOf(etnrkarty.getText().toString());
                if(nrK.length()==16){
                    msg(this,"Dziękujemy za zamówienie");
                    intent1 = new Intent("android.intent.action.MAIN");
                    startActivity(intent1);
                }
                else{
                    msg(this,"Nr karty musi zawierac 26 cyfr");
                    etnrkarty.setTextColor(getResources().getColor(R.color.colorPrimary));
                }
        }

    }
}
