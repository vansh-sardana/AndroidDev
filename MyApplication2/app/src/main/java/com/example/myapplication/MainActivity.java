package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final String []questions= {"Python is a statically typed language.",
            "Python supports multiple inheritance.",
            "The `__init__` method in Python is called when an object is created.",
            "In Python, `==` checks for identity, while `is` checks for equality.",
            "Python uses indentation to define blocks of code.",
            "The `list` data structure in Python is immutable.",
            "You can use the `len()` function to find the length of a string in Python.",
            "Python's `range()` function generates a list of numbers.",
            "Python supports both procedural and object-oriented programming paradigms.",
            "In Python, a `tuple` is a mutable data structure."};
    private final Boolean[] answers={
            false,
            true,
            true,
            false,
            true,
            false,
            true,
            false,
            true,
            false
        };
    private final String[] hints={
            "Python is dynamically typed.",
            "Python does support multiple inheritance.",
            "The `__init__` method is called when an object is created.",
            "`==` checks for equality, while `is` checks for identity.",
            "Python uses indentation to define blocks of code.",
            "The `list` data structure in Python is mutable.",
            "`len()` can be used to find the length of a string.",
            "`range()` generates an iterator, not a list.",
            "Python supports both procedural and object-oriented programming.",
            "A `tuple` is immutable."
    };
    Button yes, no, restart, next;
    TextView ques, heading, hint;
    int index, score;
    int len= questions.length;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes= findViewById(R.id.yes);
        no= findViewById(R.id.no);
        ques= findViewById(R.id.ques);
        restart= findViewById(R.id.restart);
        heading= findViewById(R.id.heading);
        next= findViewById(R.id.next);
        hint= findViewById(R.id.hint);
        restartQuiz();
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isCorrect(true);
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isCorrect(false);
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initialiseQuiz();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next.setVisibility(View.GONE);
                yes.setVisibility(View.VISIBLE);
                no.setVisibility(View.VISIBLE);
                hint.setVisibility(View.GONE);
                if(index>=len-1){
                    setScore();
                    return;
                }
                else{
                    index++;
                    setQuestion();
                }
            }
        });
    }
    private void initialiseQuiz(){
        index=0;
        score=0;
        heading.setVisibility(View.VISIBLE);
        yes.setVisibility(View.VISIBLE);
        no.setVisibility(View.VISIBLE);
        restart.setVisibility(View.GONE);
        setQuestion();
    }
    private void setQuestion(){
        ques.setText(questions[index]);
    }
    private void isCorrect(Boolean ans){
        hint.setText(hints[index]);
        if (index<len && answers[index]==ans){
            score++;
            hint.setTextColor(Color.GREEN);
        }else{
            hint.setTextColor(Color.RED);
        }
        hint.setVisibility(View.VISIBLE);
        next.setVisibility(View.VISIBLE);
        yes.setVisibility(View.GONE);
        no.setVisibility(View.GONE);
    }
    private void setScore(){
        String msg= "Your Score is :"+score+"/"+len;
        ques.setText(msg);
        restartQuiz();
    }
    private void restartQuiz(){
        hint.setVisibility(View.GONE);
        heading.setVisibility(View.GONE);
        yes.setVisibility(View.GONE);
        no.setVisibility(View.GONE);
        next.setVisibility(View.GONE);
        restart.setVisibility(View.VISIBLE);
    }

}