package com.example.viva;



import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class RadioButtonActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    Button button;
    RadioButton btn;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        radioGroup= findViewById(R.id.radioGroup);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sel= radioGroup.getCheckedRadioButtonId();
                btn= findViewById(sel);
                if (sel ==-1){
                    Toast.makeText(RadioButtonActivity.this, "Please Select One Item", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(RadioButtonActivity.this,btn.getText() , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}