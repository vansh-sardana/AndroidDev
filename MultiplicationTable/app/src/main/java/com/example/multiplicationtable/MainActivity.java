package com.example.multiplicationtable;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView table;
    private Button button;
    private EditText num1;
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
        table= findViewById(R.id.table);
        button= findViewById(R.id.button);
        num1= findViewById(R.id.num1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder temp= new StringBuilder();
                String val= num1.getText().toString();
                if(val.isEmpty()) return;
                Integer num= Integer.parseInt(val);
                for(int i=1; i<=10; i++){
                    temp.append(num).append(" X ").append(i).append(" = ").append(num*i).append("\n");
                }
                table.setText(temp);
            }
        });
    }
}