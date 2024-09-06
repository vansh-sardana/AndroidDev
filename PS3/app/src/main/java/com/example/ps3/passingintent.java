package com.example.ps3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class passingintent extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passingintent);
        text= findViewById(R.id.textView2);
        Intent intent= getIntent();
        String temp= intent.getStringExtra(MainActivity.EXTRA_PASS);
        text.setText(temp);
    }
}