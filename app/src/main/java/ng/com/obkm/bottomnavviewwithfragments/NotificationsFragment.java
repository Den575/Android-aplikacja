package ng.com.obkm.bottomnavviewwithfragments;


import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;



public class NotificationsFragment extends Fragment implements View.OnClickListener {

    Button btnInfo,btnLogOut;
    public NotificationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);

        btnInfo = (Button) view.findViewById(R.id.btnInfo);
        btnLogOut = (Button) view.findViewById(R.id.btnLogOut);
        btnInfo.setOnClickListener(this);
        btnLogOut.setOnClickListener(this);


        return view;
    }



    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btnLogOut:
                Toast.makeText(getActivity(), "Successful logout" , Toast.LENGTH_SHORT).show();
                intent = new Intent("android.intent.action.RegisterLogin");
                startActivity(intent);
                break;
            case R.id.btnInfo:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://den575.github.io/"));
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
