package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= findViewById(R.id.textView3);
        button= findViewById(R.id.button2);
        editText= findViewById(R.id.editText1);
        SharedPreferences sp= getSharedPreferences("fileName", MODE_PRIVATE);
        textView.setText(sp.getString("MyValInSP", "Value not found"));
        button.setOnClickListener(view -> {
            String val= textView.getText().toString();
            if(val.isEmpty()) return;
            SharedPreferences sharedPreferences= getSharedPreferences("fileName", MODE_PRIVATE);
            SharedPreferences.Editor ed= sharedPreferences.edit();
            ed.putString("MyValInSP", editText.getText().toString());
            ed.apply();
            textView.setText(sp.getString("MyValInSP", "Value not found"));
        });
    }
}