package com.example.customlistview;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= findViewById(R.id.listView);
        String arr[]= {"this", "that", "what","this", "that", "what", "this", "that", "what","this", "that", "what"};
        MyAdapter ad= new MyAdapter(this, R.layout.myadapter,arr);
        listView.setAdapter(ad);

    }
}