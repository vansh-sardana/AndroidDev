package com.example.lab13augagain;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editTextUsername, editTextAge, editTextPass, editTextAddress;
    TextView textView;
    Button submit;
    RadioGroup gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit= findViewById(R.id.button);
        editTextUsername= findViewById(R.id.username);
        editTextAge= findViewById(R.id.age);
        editTextPass= findViewById(R.id.password);
        editTextAddress= findViewById(R.id.address);
        textView= findViewById(R.id.textView3);
        gender= findViewById(R.id.radioGroup);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String age= editTextAge.getText().toString();
                String username= editTextUsername.getText().toString();
                String gen= ((RadioButton)findViewById(gender.getCheckedRadioButtonId())).getText().toString();
                String pass= editTextPass.getText().toString();
                String add= editTextAddress.getText().toString();
                String output= "Username: "+ username+"\nAge: "+ age+"\nPassword Entered: "+pass+ "\nAddress: "+add+"\nGender: "+gen;
                if (pass.equals("abcdef")) {
                    output += "\nLogin Successful";
                }else{
                    output+= "\nLogin Failed";
                }
                textView.setText(output);
            }
        });
    }
}