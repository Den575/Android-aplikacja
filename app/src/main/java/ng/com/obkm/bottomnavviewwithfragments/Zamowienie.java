package ng.com.obkm.bottomnavviewwithfragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class Zamowienie extends AppCompatActivity implements View.OnClickListener {

    TextView tvhamburger, tvCena, tvCheeseburger, tvRB, tvCB;
    Button btnHamburger, btnOrder, btnCheeseburger, btnRB, btnCB;
    SeekBar sbHamburger, sbCheeseburger, sbRB, sbCB;
    int ilHamburger = 0;
    int ilCheeseburger = 0;
    int ilRB = 0;
    int ilCB = 0;
    int cena =0;

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
        btnOrder = (Button) findViewById(R.id.btnOrder);
        btnCheeseburger = (Button) findViewById(R.id.btnCheeseburger);
        btnRB = (Button) findViewById(R.id.btnRB);
        btnCB = (Button) findViewById(R.id.btnCB);

        btnHamburger.setOnClickListener(this);
        btnOrder.setOnClickListener(this);
        btnCheeseburger.setOnClickListener(this);
        btnRB.setOnClickListener(this);
        btnCB.setOnClickListener(this);

        sbCB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ilCB = i;
                tvCB.setText("Chicken burger: " +String.valueOf(ilCB));
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
                tvhamburger.setText("Hamburger: " + String.valueOf(ilHamburger));
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
                cena+=ilHamburger;
                tvCena.setText("Do opłaty: "+ String.valueOf(cena)+" zł");
                break;
            case R.id.btnCheeseburger:
                cena+=ilCheeseburger;
                tvCena.setText("Do opłaty: "+ String.valueOf(cena)+" zł");
                break;
            case R.id.btnRB:
                cena+=ilRB;
                tvCena.setText("Do opłaty: "+ String.valueOf(cena)+" zł");
            case R.id.btnCB:
                cena+=ilCB;
                tvCena.setText("Do opłaty: "+ String.valueOf(cena)+" zł");
        }
    }
}