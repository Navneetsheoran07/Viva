package com.example.viva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView  textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    editText = findViewById(R.id.edttxt);
    button = findViewById(R.id.btn);
    textView = findViewById(R.id.textView);



    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String data= editText.getText().toString();
            textView.setText(data);
            Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);

            intent.putExtra("name",data);
            startActivity(intent);
            finish();
        }
    });



    }
}