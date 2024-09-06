package com.example.lab30aug;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.MissingResourceException;

public class MainActivity extends AppCompatActivity {
    int ch=1, fsize=25;
//    @SuppressLint();
    TextView t;
    private Button b1;
    private Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        t= findViewById(R.id.ymca);
        b2= findViewById(R.id.color1);
        b1= findViewById(R.id.size1);
     b1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             t.setTextSize(fsize);
             Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
             fsize+=5;
             if(fsize==50){
                 fsize=25;
             }
         }
     });
     b2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
             switch (ch){
                 case 1:
                     t.setTextColor(Color.GREEN);
                     ch++;
                     break;
                 case 2:
                     t.setTextColor(Color.RED);
                     ch++;
                     break;
                 case 3:
                     t.setTextColor(Color.BLUE);
                     ch++;
                     break;
                 case 4:
                     t.setTextColor(Color.YELLOW);
                     ch=1;
             }
         }
     });
    }
}