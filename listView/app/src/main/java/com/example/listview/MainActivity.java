package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        String[] arr= {"this", "that", "what", "why", "kyu", "nhi", "ok", "chalo", "fir", "so", "jao", "this", "that", "what", "why", "kyu", "nhi", "ok", "chalo", "fir", "so", "jao"};
        ArrayAdapter<String> ad= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);
        listView.setAdapter(ad);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "You clicked on: "+i, Toast.LENGTH_SHORT).show();
            }
        });
    }
}