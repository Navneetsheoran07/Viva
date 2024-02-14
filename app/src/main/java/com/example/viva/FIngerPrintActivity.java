package com.example.viva;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.widget.Toast;

@RequiresApi(api = Build.VERSION_CODES.P)
public class FIngerPrintActivity extends AppCompatActivity {


    BioMatricCallBacks bioMatricCallBacks;
    BiometricPrompt biometricPrompt ;
    CancellationSignal cancellationSignal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_print);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            bioMatricCallBacks = new BioMatricCallBacks(getApplicationContext());
            if (checkSelfPermission(Manifest.permission.USE_BIOMETRIC)== PackageManager.PERMISSION_GRANTED){
                Fingerprint();
            }
            else{
                requestPermissions(new String[]{Manifest.permission.USE_BIOMETRIC},234);
            }
        }
    }


    private void Fingerprint() {

        biometricPrompt = new BiometricPrompt.Builder(this)
                .setTitle("Context Data")
                .setSubtitle("authentication Required")
                .setDescription("Only for fingerprint Testing")
                .setNegativeButton("Cancel", getMainExecutor(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(FIngerPrintActivity.this, "Cancel By user", Toast.LENGTH_SHORT).show();
                    }
                }).build();
        biometricPrompt.authenticate(getCancelSignle(),getMainExecutor(),bioMatricCallBacks);
    }

    private CancellationSignal getCancelSignle() {


        cancellationSignal = new CancellationSignal();
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() {
            @Override
            public void onCancel() {
                Toast.makeText(FIngerPrintActivity.this, "Cancel signal Active", Toast.LENGTH_SHORT).show();
            }
        });
        return  cancellationSignal;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode==234){
            if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Fingerprint();
            }
            else {
                Toast.makeText(this, "Permission Required", Toast.LENGTH_SHORT).show();
                requestPermissions(new String[]{Manifest.permission.USE_BIOMETRIC},234);
            }
        }
    }
}