package ng.com.obkm.bottomnavviewwithfragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class Zamowienie extends AppCompatActivity implements View.OnClickListener {

    TextView tvhamburger, tvCena, tvCheeseburger, tvRB, tvCB;
    Button btnHamburger, btnOczysc, btnCheeseburger, btnRB, btnCB, btnNapoje;
    SeekBar sbHamburger, sbCheeseburger, sbRB, sbCB;
    int ilHamburger = 0;
    int ilCheeseburger = 0;
    int ilRB = 0;
    int ilCB = 0;
    double cena =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zamowienie);

        sbHamburger = (SeekBar) findViewById(R.id.sbhamburger);
        sbCheeseburger = (SeekBar) findViewById(R.id.sbCheeseburger);
        sbRB = (SeekBar) findViewById(R.id.sbRB);
        sbCB = (SeekBar) findViewById(R.id.sbCB);
        sbHamburger.setMax(10);
        sbCheeseburger.setMax(10);
        sbRB.setMax(10);
        sbCB.setMax(10);

        tvhamburger = (TextView) findViewById(R.id.tvhamburder);
        tvCheeseburger = (TextView) findViewById(R.id.tvCheeseburger);
        tvRB = (TextView) findViewById(R.id.tvRB);
        tvCB = (TextView) findViewById(R.id.tvCB);
        tvCena = (TextView) findViewById(R.id.cena);

        btnHamburger = (Button) findViewById(R.id.btnhumburger);
        btnOczysc = (Button) findViewById(R.id.btnOczysc);
        btnCheeseburger = (Button) findViewById(R.id.btnCheeseburger);
        btnRB = (Button) findViewById(R.id.btnRB);
        btnCB = (Button) findViewById(R.id.btnCB);
        btnNapoje = (Button) findViewById(R.id.btnNapoje);

        btnHamburger.setOnClickListener(this);
        btnOczysc.setOnClickListener(this);
        btnCheeseburger.setOnClickListener(this);
        btnRB.setOnClickListener(this);
        btnCB.setOnClickListener(this);
        btnNapoje.setOnClickListener(this);

        sbCB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ilCB = i;
                tvCB.setText("Chicken burger: " +String.valueOf(ilCB));
                tvCB.setTextColor(getResources().getColor(R.color.colorPrimary));
                if(i==0){
                    tvCB.setTextColor(getResources().getColor(R.color.bd));
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbRB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ilRB = i;
                tvRB.setText("Royal burger: "+ String.valueOf(ilRB));
                tvRB.setTextColor(getResources().getColor(R.color.colorPrimary));
                if(i==0){
                    tvRB.setTextColor(getResources().getColor(R.color.bd));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbCheeseburger.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ilCheeseburger = i;
                tvCheeseburger.setText("Cheeseburger: "+ String.valueOf(ilCheeseburger));
                tvCheeseburger.setTextColor(getResources().getColor(R.color.colorPrimary));
                if(i==0){
                    tvCheeseburger.setTextColor(getResources().getColor(R.color.bd));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbHamburger.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ilHamburger = i;
                tvhamburger.setTextColor(getResources().getColor(R.color.colorPrimary));
                tvhamburger.setText("Hamburger: " + String.valueOf(ilHamburger));
                if(i==0){
                    tvhamburger.setTextColor(getResources().getColor(R.color.bd));
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



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnhumburger:
                cena+=(double) Math.round((ilHamburger*6.99)*100)/100;
                tvCena.setText("Do opłaty: "+ String.valueOf(cena)+" zł");
                break;
            case R.id.btnCheeseburger:
                cena+=ilCheeseburger*8;
                cena+=(double) Math.round((ilCheeseburger*8)*100)/100;
                tvCena.setText("Do opłaty: "+ String.valueOf(cena)+" zł");
                break;
            case R.id.btnRB:
                cena+=(double) Math.round((ilRB*12)*100)/100;
                tvCena.setText("Do opłaty: "+ String.valueOf(cena)+" zł");
                break;
            case R.id.btnCB:
                cena+=(double) Math.round((ilCB*13.99)*100)/100;
                tvCena.setText("Do opłaty: "+ String.valueOf(cena)+" zł");
                break;
            case R.id.btnOczysc:
                cena=0;
                tvCena.setText("Do opłaty: "+ String.valueOf(cena)+" zł");
                break;
            case R.id.btnNapoje:
                Intent intent = new Intent(this,Napoje.class);
                String old = String.valueOf(cena);
                intent.putExtra("cena",old);
                startActivity(intent);
                break;

        }
    }
}