package ng.com.obkm.bottomnavviewwithfragments.home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import ng.com.obkm.bottomnavviewwithfragments.R;


public class HomeFragment extends Fragment implements View.OnClickListener {

    Button btnLokal, btnNawynos;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btnLokal = (Button) view.findViewById(R.id.btnLokal);
        btnNawynos = (Button) view.findViewById(R.id.btnNawynos);

        btnLokal.setOnClickListener(this);
        btnNawynos.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btnLokal:
                intent = new Intent("android.intent.action.Zamowienie");
                startActivity(intent);
                break;
            case  R.id.btnNawynos:
                intent = new Intent("android.intent.action.Zamowienie");
                startActivity(intent);
                break;
        }
    }
}
