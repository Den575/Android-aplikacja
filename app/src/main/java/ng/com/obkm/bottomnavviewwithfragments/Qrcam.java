package ng.com.obkm.bottomnavviewwithfragments;

import android.Manifest;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

import static android.view.Gravity.CENTER;

public class Qrcam extends AppCompatActivity implements View.OnClickListener {

    SurfaceView cameraPreview;
    SQLiteDatabase db;
    TextView txtResult;
    BarcodeDetector barcodeDetector;
    CameraSource cameraSource;
    final int RequestCameraPermissionID = 1001;
    Button btnNext;


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case RequestCameraPermissionID: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    try {
                        cameraSource.start(cameraPreview.getHolder());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr_cam);

        cameraPreview = (SurfaceView) findViewById(R.id.cameraPreview);
        txtResult = (TextView) findViewById(R.id.txtResult);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setEnabled(false);
        btnNext.setOnClickListener(this);

        db = openOrCreateDatabase("usersDB", Context.MODE_PRIVATE, null);

        Toast toast  = Toast.makeText(getApplicationContext(),"Please focus camera to QR Code",Toast.LENGTH_LONG);
        toast.setGravity(CENTER, 0, 0);
        toast.show();

        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.QR_CODE)
                .build();
        cameraSource = new CameraSource
                .Builder(this, barcodeDetector)
                .setRequestedPreviewSize(640, 480)
                .build();
        //Add Event
        cameraPreview.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    //Request permission
                    ActivityCompat.requestPermissions(Qrcam.this,
                            new String[]{Manifest.permission.CAMERA},RequestCameraPermissionID);
                    return;
                }
                try {
                    cameraSource.start(cameraPreview.getHolder());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                cameraSource.stop();

            }
        });



        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                Intent intent;
                final SparseArray<Barcode> qrcodes = detections.getDetectedItems();
                if(qrcodes.size() != 0){
                    txtResult.post(new Runnable() {
                                       @Override
                                       public void run() {
                                           Vibrator vibrator = (Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                                           txtResult.setText(qrcodes.valueAt(0).displayValue);
                                           String nrstolic = String.valueOf(qrcodes.valueAt(0).displayValue);
                                           txtResult.setText(nrstolic);
                                           if(nrstolic.equals("Table number 1 reserved")){
                                               btnNext.setEnabled(true);
                                               vibrator.vibrate(50);
                                           }
                                           else if(nrstolic.equals("Table number 2 reserved")){
                                               btnNext.setEnabled(true);
                                               vibrator.vibrate(50);
                                           }
                                           else if(nrstolic.equals("Table number 3 reserved")){
                                               btnNext.setEnabled(true);
                                               vibrator.vibrate(50);
                                           }
                                           else if(nrstolic.equals("Table number 4 reserved")){
                                               btnNext.setEnabled(true);
                                               vibrator.vibrate(50);
                                           }
                                           else if(nrstolic.equals("Table number 5 reserved")){
                                               btnNext.setEnabled(true);
                                               vibrator.vibrate(50);
                                           }
                                           else{
                                               txtResult.setText("Try again scan QrCode on your table");
                                           }

                                       }
                                   }
                    );
                }
            }

        });

    }
    public void msg(Context context,String str)
    {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btnNext:
                intent = new Intent("android.intent.action.MAIN");
                db.execSQL("UPDATE Users  SET nrStolika ='"+ txtResult.getText()+"' WHERE UserId ='"+1+"'");
                startActivity(intent);
                break;
            default:
                break;
        }

    }


    @Override
    public void onBackPressed() {
    }
}
