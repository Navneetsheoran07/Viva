package com.example.viva;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListviewActivity extends AppCompatActivity {
ListView listView;

String []data ={"java","python","C","c++","Dart","java","python","C","c++","Dart","java",
        "python","C","c++","Dart","java","python","C","c++","Dart","java","python","C",
        "c++","Dart","java","python","C","c++","Dart"};
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listView = findViewById(R.id.lv);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = (String) parent.getItemAtPosition(position);

                Toast.makeText(ListviewActivity.this, data.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}