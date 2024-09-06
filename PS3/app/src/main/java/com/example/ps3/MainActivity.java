package com.example.ps3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText text;
    public static final String EXTRA_PASS= "com.example.ps3.EXTRA.text";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("SUCCESS", "APP RUN");
        text= findViewById(R.id.pass);
    }
    public void activateGaneshVandana(View view){
        Toast.makeText(this, "Ganesh Vandana", Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    public void activatePassLeak(View view){
        Intent intent= new Intent(this, passingintent.class);
        intent.putExtra(EXTRA_PASS, text.getText().toString());
        startActivity(intent);
    }
}