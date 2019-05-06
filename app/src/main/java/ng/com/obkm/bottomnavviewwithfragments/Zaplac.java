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
    String oldCena="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zaplac);

        tvzaplac = (TextView) findViewById(R.id.zaplata);
        Intent intent = getIntent();
        oldCena = intent.getStringExtra("cena3");
        double cena = cenaDouble(oldCena);
        tvzaplac.setText("Suma do zapłaty: "+String.valueOf(cena)+"0 zł");

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
            case R.id.btnZero:
                Intent intent;
                intent = new Intent("android.intent.action.MAIN");
                startActivity(intent);
                break;
            case R.id.btnZaplac:
                String nrK = String.valueOf(etnrkarty.getText().toString());
                String data = String.valueOf(etData.getText().toString());
                String cvc = String.valueOf(etCVC.getText().toString());
                if(nrK.length()==19 && data.length()==4 && cvc.length()==3){
                    Intent intent1 = new Intent(this,Invoice.class);
                    intent1.putExtra("cena4",oldCena);
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
