package com.example.intentweb;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= findViewById(R.id.button);
        url= findViewById(R.id.editTextText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlText= url.getText().toString();
                Toast.makeText(MainActivity.this, urlText, Toast.LENGTH_SHORT).show();
                //for url in chrome
                Uri webpage = Uri.parse(urlText);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
                //for sending the email
//                Intent intent = new Intent(Intent.ACTION_SEND);
//                intent.setType("*/*");
//                String []arr= {"xyz@gmail.com"};
//                intent.putExtra(Intent.EXTRA_EMAIL, arr);
//                intent.putExtra(Intent.EXTRA_SUBJECT, "This will be the subject of the email");
//                intent.putExtra(Intent.EXTRA_TEXT, urlText);
//                if (intent.resolveActivity(getPackageManager()) != null) {
//                    startActivity(intent);
//                }

            }
        });
    }
}