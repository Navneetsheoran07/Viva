package com.example.viva;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Contactactivity extends AppCompatActivity {

    ArrayList userlist;
    ListView listView ;
    
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactactivity);
        listView = findViewById(R.id.lvcontact);
        userlist = new ArrayList();
        
        fatchContact();
    }
    @SuppressLint("Range")
    private void fatchContact() {
        if (checkSelfPermission(Manifest.permission.READ_CONTACTS)== PackageManager.PERMISSION_GRANTED){
            ContentResolver resolver = getContentResolver();
            Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

            Cursor cursor = resolver.query(uri,null,null,null,null);
            if (cursor.getCount()>0){
                while (cursor.moveToNext()){
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                userlist.add(name+"\n"+number);

                }
            }
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,userlist);
            listView.setAdapter(adapter);
        }
        else {
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS},243);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==243){
            if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                fatchContact();
            }
            else {
                Toast.makeText(this, "Permission Required", Toast.LENGTH_SHORT).show();
                requestPermissions(new String[]{Manifest.permission.READ_CONTACTS},243);
            }
        }
    }
}