package com.example.jeozonefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView question;
    private TextView questionNumber;
    private Button option1Btn, option2Btn, option3Btn, option4Btn;
    private ArrayList<QuizStuff> quizArray;
    Random random;
    int currentScore = 0;
    int questionCounter = 1;
    int currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question = findViewById(R.id.idTVQuestion);
        questionNumber = findViewById(R.id.idTVQuestionAttempt);

        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);

        quizArray = new ArrayList<>();
        random = new Random();

        getQuizQuestions(quizArray);
        currentPos = random.nextInt(quizArray.size());
        setDataToView(currentPos);

        option1Btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(quizArray.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionCounter++;
                currentPos = random.nextInt(quizArray.size());
                setDataToView(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(quizArray.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionCounter++;
                currentPos = random.nextInt(quizArray.size());
                setDataToView(currentPos);
            }
        });
        option3Btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(quizArray.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionCounter++;
                currentPos = random.nextInt(quizArray.size());
                setDataToView(currentPos);
            }
        });
        option4Btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(quizArray.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionCounter++;
                currentPos = random.nextInt(quizArray.size());
                setDataToView(currentPos);
            }
        });

    }
    private void setDataToView(int currentPos){
        questionNumber.setText("Questions Attempted: " + questionCounter + "/10");

        question.setText(quizArray.get(currentPos).getQuestion());
        option1Btn.setText(quizArray.get(currentPos).getOption1());
        option2Btn.setText(quizArray.get(currentPos).getOption2());
        option3Btn.setText(quizArray.get(currentPos).getOption3());
        option4Btn.setText(quizArray.get(currentPos).getOption4());



    }
    private void getQuizQuestions(ArrayList<QuizStuff> quizStuffPassed) {
        quizStuffPassed.add(new QuizStuff("What is the capital of Canada?", "Ottawa", "London", "Ontario", "Vancouver", "Ottawa"));
        quizStuffPassed.add(new QuizStuff("What is the capital of Ireland?", "Edinburg", "Dublin", "London", "Cardiff", "Dublin"));
        quizStuffPassed.add(new QuizStuff("Where is the Colosseum located?", "Spain", "Austria", "France", "Italy", "Italy"));
        quizStuffPassed.add(new QuizStuff("What is the capital of great Britain?", "Edinburg", "Dublin", "London", "Cardiff", "London"));

    }
}