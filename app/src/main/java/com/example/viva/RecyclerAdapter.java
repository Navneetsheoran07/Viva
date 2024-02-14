package com.example.viva;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewholder> {
    ArrayList <ModelClass> userlist;
    Context context;


    public RecyclerAdapter(ArrayList<ModelClass> userlist, Context context) {
        this.userlist = userlist;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
     View view = LayoutInflater.from(context).inflate(R.layout.format,viewGroup,false);
     MyViewholder myViewholder = new MyViewholder(view);
     return myViewholder;



    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewholder myViewholder, int i) {


        ModelClass modelClass = userlist.get(i);
        myViewholder.textView.setText(modelClass.getName());
        myViewholder.imageView.setImageResource(modelClass.getImageurl());

        myViewholder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {


        ImageView imageView ;
        TextView textView ;
        Button button;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            imageView =itemView.findViewById(R.id.imageview);

            textView = itemView.findViewById(R.id.textview);
            button = itemView.findViewById(R.id.clickbtn);
        }
    }
}
