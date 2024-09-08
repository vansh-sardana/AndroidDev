package com.example.phonecontactsusingrv;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private final Contact[] contacts = {
            new Contact("Alice", "1234567890", 1),
            new Contact("Bob", "9876543210", 2),
            new Contact("Charlie", "5556667777", 3),
            new Contact("David", "4445556666", 4),
            new Contact("Eva", "3334445555", 5),
            new Contact("Frank", "2223334444", 6),
            new Contact("Grace", "1112223333", 7),
            new Contact("Hank", "9998887777", 8),
            new Contact("Ivy", "8889996666", 9),
            new Contact("Jack", "7778889999", 10),
            new Contact("Kate", "6667778888", 11),
            new Contact("Liam", "5556669999", 12),
            new Contact("Mia", "4443332222", 13),
            new Contact("Nina", "3332221111", 14),
            new Contact("Owen", "2221119999", 15),
            new Contact("Paul", "1119998888", 16),
            new Contact("Quinn", "9996665555", 17),
            new Contact("Rose", "8885554444", 18),
            new Contact("Sam", "7774443333", 19),
            new Contact("Tina", "6663332222", 20)
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView= findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ContactActivity ad= new ContactActivity(contacts);
        recyclerView.setAdapter(ad);
    }
}