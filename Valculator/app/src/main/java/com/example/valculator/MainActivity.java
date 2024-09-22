package com.example.valculator;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnAC, btnEqual, btnDel;
    TextView prob, soln;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prob= findViewById(R.id.problem_tv);
        soln= findViewById(R.id.soln_tv);
        Button[] btns= new Button[]{findViewById(R.id.button0), findViewById(R.id.button1), findViewById(R.id.button2), findViewById(R.id.button3), findViewById(R.id.button4), findViewById(R.id.button5), findViewById(R.id.button6), findViewById(R.id.button7), findViewById(R.id.button8), findViewById(R.id.button9), findViewById(R.id.buttonDec), findViewById(R.id.buttonOB), findViewById(R.id.buttonCB), findViewById(R.id.buttonDiv), findViewById(R.id.buttonMul), findViewById(R.id.buttonMin),findViewById(R.id.buttonPls)};
        btnDel= findViewById(R.id.buttonDel);
        btnAC= findViewById(R.id.buttonAC);
        btnEqual= findViewById(R.id.buttonEqual);
        for(Button b: btns){
            b.setOnClickListener(view -> {
                String curr= prob.getText().toString();
                int n= curr.length();
                char lastChar= n>0? curr.charAt(curr.length()-1) : ' ';
                String currBtn= b.getText().toString();
                if((currBtn.equals("+") || currBtn.equals("/") || currBtn.equals("*") || currBtn.equals(".") || currBtn.equals("-")) && (lastChar=='+' || lastChar=='-' || lastChar=='*' || lastChar=='.' || lastChar=='/' ) ){
                        prob.setText(curr.substring(0,curr.length()-1)+currBtn);
                }else{
                    prob.setText(curr+currBtn);
                }
                evaluateRes();
            });
        }
        btnAC.setOnClickListener(view -> {
            prob.setText("");
            soln.setText("0");
        });
        btnDel.setOnClickListener(view -> {
            String curr= prob.getText().toString();
            if(curr.isEmpty()) return;
            prob.setText(curr.substring(0, curr.length()-1));
            evaluateRes();
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evaluateRes();
                prob.setText(soln.getText().toString());
            }
        });
    }
    String getResult(String data){
        try{
            Context context= Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable= context.initStandardObjects();
            String finalResult= context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            return finalResult;
        }catch (Exception e){
            return "";
        }
    }
    void evaluateRes(){
        soln.setText(getResult(prob.getText().toString()));
    }
}