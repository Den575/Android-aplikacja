package ng.com.obkm.bottomnavviewwithfragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class Zamowienie extends AppCompatActivity implements View.OnClickListener {

    TextView tvhamburger, tvCena;
    Button btnHamburger, btnOrder;
    SeekBar sbHamburger;
    int ilH = 0;
    int cena =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zamowienie);

        sbHamburger = (SeekBar) findViewById(R.id.sbhamburger);
        sbHamburger.setMax(5);

        tvhamburger = (TextView) findViewById(R.id.tvhamburder);
        tvhamburger.setText("Hamburger: 0");
        tvCena = (TextView) findViewById(R.id.cena);

        btnHamburger = (Button) findViewById(R.id.btnhumburger);
        btnOrder = (Button) findViewById(R.id.btnOrder);

        btnHamburger.setOnClickListener(this);
        btnOrder.setOnClickListener(this);

        sbHamburger.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ilH = i;
                tvhamburger.setText("Hamburger: " + String.valueOf(ilH));
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
                cena+=ilH;
                tvCena.setText(String.valueOf(cena)+"zł");
        }
    }
}