package ng.com.obkm.bottomnavviewwithfragments;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Napoje extends AppCompatActivity implements View.OnClickListener {

    Button btnCC, btnFa, btnSp, btnAnuluj,btnZaplac;
    TextView tvCC, tvFa, tvSp, tvcena1, cenaCola, cenaFanta, cenaSprite;
    SeekBar sbCC, sbFa, sbSp;
    double cena =0;
    int liC, liF, liS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_napoje);

        btnCC = (Button) findViewById(R.id.btnCC);
        btnFa = (Button) findViewById(R.id.btnFa);
        btnSp = (Button) findViewById(R.id.btnSp);
        btnAnuluj = (Button) findViewById(R.id.btnAnuluj);
        btnZaplac = (Button) findViewById(R.id.btnOrder);

        btnCC.setOnClickListener(this);
        btnFa.setOnClickListener(this);
        btnSp.setOnClickListener(this);
        btnAnuluj.setOnClickListener(this);
        btnZaplac.setOnClickListener(this);

        tvCC = (TextView) findViewById(R.id.tvCC);
        tvFa = (TextView) findViewById(R.id.tvFa);
        tvSp = (TextView) findViewById(R.id.tvSp);
        tvcena1 = (TextView) findViewById(R.id.cena1);
        cenaCola = (TextView) findViewById(R.id.cenaCola);
        cenaFanta = (TextView) findViewById(R.id.cenaFanta);
        cenaSprite = (TextView) findViewById(R.id.cenaSprite);

        sbCC = (SeekBar) findViewById(R.id.sbCC);
        sbFa = (SeekBar) findViewById(R.id.sbFa);
        sbSp = (SeekBar) findViewById(R.id.sbSp);
        sbCC.setMax(10);
        sbFa.setMax(10);
        sbSp.setMax(10);

        Intent intent = getIntent();
        String oldcena = intent.getStringExtra("cena");
        cena = Double.valueOf(oldcena);
        tvcena1.setText("Do opłaty: "+String.valueOf(cena)+" zł");


        sbCC.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                liC = i;
                tvCC.setText("Coca-cola: "+String.valueOf(liC));
                tvCC.setTextColor(getResources().getColor(R.color.colorPrimary));
                cenaCola.setText(String.valueOf(4*i)+" zł");
                if(i==0){
                    tvCC.setTextColor(getResources().getColor(R.color.bd));
                    tvCC.setText("Coca-cola");
                    cenaCola.setText("4 zł");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbFa.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                liF = i;
                tvFa.setText("Fanta: "+String.valueOf(liF));
                tvFa.setTextColor(getResources().getColor(R.color.colorPrimary));
                cenaFanta.setText(String.valueOf(3.50*i)+" zł");
                if(i==0){
                    tvFa.setTextColor(getResources().getColor(R.color.bd));
                    tvFa.setText("Fanta");
                    cenaFanta.setText("3,50 zł");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbSp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                liS = i;
                tvSp.setText("Sprite: "+String.valueOf(liS));
                tvSp.setTextColor(getResources().getColor(R.color.colorPrimary));
                cenaSprite.setText(String.valueOf(4.50*i)+" zł");
                if(i==0){
                    tvSp.setTextColor(getResources().getColor(R.color.bd));
                    tvSp.setText("Sprite");
                    cenaSprite.setText("4,50 zł");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void msg(Context context, String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCC:
                cena+=liC*4;
                tvcena1.setText("Do opłaty: "+ String.valueOf(cena)+" zł");
                break;
            case R.id.btnFa:
                cena+=liF*3.5;
                tvcena1.setText("Do opłaty: "+ String.valueOf(cena)+" zł");
                break;
            case R.id.btnSp:
                cena+=liS*4.5;
                tvcena1.setText("Do opłaty: "+ String.valueOf(cena)+" zł");
                break;
            case R.id.btnAnuluj:
                cena=0;
                tvcena1.setText("Do opłaty: "+ String.valueOf(cena)+" zł");
                break;
            case R.id.btnOrder:
                if(cena==0){
                    msg(this,"Nic nie zostało wybrano!");
                    return;
                }
                Intent intent1 = new Intent(this,Zaplac.class);
                String old = String.valueOf(cena);
                intent1.putExtra("cena1",old);
                startActivity(intent1);
                break;
        }
    }
}
