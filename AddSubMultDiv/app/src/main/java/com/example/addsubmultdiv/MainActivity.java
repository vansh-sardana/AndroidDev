package com.example.addsubmultdiv;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText num1,num2;
    private Button add1, sub1, mult1, div1;
    private TextView output;
    private String getAns(int op){
        String a= num1.getText().toString();
        String b= num2.getText().toString();
        if(a.isEmpty() || b.isEmpty()) return "";
        Integer ans=0;
        switch (op){
            case 1:
                Toast.makeText(MainActivity.this, "Add pressed", Toast.LENGTH_SHORT).show();
                ans= Integer.parseInt(a)+Integer.parseInt(b);
                break;
            case 2:
                Toast.makeText(MainActivity.this, "Multiply", Toast.LENGTH_SHORT).show();
                ans= Integer.parseInt(a)*Integer.parseInt(b);
                break;
            case 3:
                Toast.makeText(MainActivity.this, "Division", Toast.LENGTH_SHORT).show();
                ans= Integer.parseInt(a)/Integer.parseInt(b);
                break;
            case 4:
                Toast.makeText(MainActivity.this, "Subtraction", Toast.LENGTH_SHORT).show();
                ans=Integer.parseInt(a)-Integer.parseInt(b);
        }
        return ans.toString();
    }
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
        num1= findViewById(R.id.number1);
        num2= findViewById(R.id.number2);
        add1= findViewById(R.id.add);
        sub1= findViewById(R.id.sub);
        mult1= findViewById(R.id.mult);
        div1= findViewById(R.id.div);
        output= findViewById(R.id.output);
        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                output.setText(getAns(1));
            }
        });
        mult1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                output.setText(getAns(2));
            }
        });
        div1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                output.setText(getAns(3));
            }
        });
        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                output.setText(getAns(4));
            }
        });
    }
}