package com.example.viva;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    RecyclerView recyclerView ;
    ArrayList<ModelClass> userlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        recyclerView = findViewById(R.id.rcview);
        userlist = new ArrayList<>();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),
                2,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);

        userlist.add(new ModelClass("heloo",R.drawable.aax));

        userlist.add(new ModelClass("heloo",R.drawable.aax));
        userlist.add(new ModelClass("a",R.drawable.a));
        userlist.add(new ModelClass("aabb",R.drawable.aabb));
        userlist.add(new ModelClass("aabc",R.drawable.aabc));
        userlist.add(new ModelClass("aax",R.drawable.aax));
        userlist.add(new ModelClass("ab",R.drawable.ab));
        userlist.add(new ModelClass("abb",R.drawable.abb));
        userlist.add(new ModelClass("abs",R.drawable.abs));
        userlist.add(new ModelClass("bhgy",R.drawable.bhgy));

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(userlist,getApplicationContext());
        recyclerView.setAdapter(recyclerAdapter);
    }
}