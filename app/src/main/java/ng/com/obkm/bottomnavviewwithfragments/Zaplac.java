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

import com.santalu.maskedittext.MaskEditText;

public class Zaplac extends AppCompatActivity implements View.OnClickListener {

    TextView tvzaplac;
    Button btnZero, btnZaplac;
    MaskEditText etnrkarty, etData, etCVC;

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

        etnrkarty = findViewById(R.id.nrkarty);
        etData = findViewById(R.id.data);
        etCVC = findViewById(R.id.cvc);
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
                String data = String.valueOf(etData.getText().toString());
                String cvc = String.valueOf(etCVC.getText().toString());
                if(nrK.length()==16 && data.length()==4 && cvc.length()==3){
                    msg(this,"Dziękujemy za zamówienie");
                    intent1 = new Intent("android.intent.action.MAIN");
                    startActivity(intent1);
                }
                else{
                    msg(this,"Niepoprawny format danych");
                    etnrkarty.setTextColor(getResources().getColor(R.color.colorPrimary));
                    etData.setTextColor(getResources().getColor(R.color.colorPrimary));
                    etCVC.setTextColor(getResources().getColor(R.color.colorPrimary));
                }
        }

    }
}
