
package com.example.jeozonefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class GameScreen4Hard extends AppCompatActivity {
    private int a;
    private TextView question;
    private TextView questionNumber;
    private Button option1Btn, option2Btn, option3Btn, option4Btn;
    private ArrayList<QuizStuff> quizArray;
    Random random;
    int currentScore = 0;
    int questionCounter = 0;
    int currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen2);
        question = findViewById(R.id.idTVQuestion);
        questionNumber = findViewById(R.id.idTVQuestionAttempt);

        option1Btn = findViewById(R.id.BtnOption1);
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

    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(GameScreen4Hard.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_sheet, (LinearLayout)findViewById(R.id.LLScore));
        TextView score = bottomSheetView.findViewById(R.id.Score);
        Button restartButton = bottomSheetView.findViewById(R.id.RestartBtn);
        score.setText("Your score is \n" + currentScore + "/5");
        restartButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                currentPos = random.nextInt(quizArray.size());
                setDataToView(currentPos);
                questionCounter = 0;
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void setDataToView(int currentPos){
        questionNumber.setText("Questions Attempted: " + questionCounter + "/5");

        if(questionCounter == 5){
            showBottomSheet();
        }else{
            question.setText(quizArray.get(currentPos).getQuestion());
            option1Btn.setText(quizArray.get(currentPos).getOption1());
            option2Btn.setText(quizArray.get(currentPos).getOption2());
            option3Btn.setText(quizArray.get(currentPos).getOption3());
            option4Btn.setText(quizArray.get(currentPos).getOption4());
        }

    }
    private void getQuizQuestions(ArrayList<QuizStuff> quizStuffPassed) {
        //Easy questions

       //Hard questions
        quizStuffPassed.add(new QuizStuff("Where is Cat Island located?", "Vietnam", "Thailand", "Korea", "Japan", "France"));
        quizStuffPassed.add(new QuizStuff("Where is Mount Kilimanjaro located?", "Kenya", "Mozambique", "Tanzania", "Ethiopia", "Tanzania"));
        quizStuffPassed.add(new QuizStuff("What is the capital of Kazakhstan?", "Almaty", "Taraz", "Nur-Sultan", "Turkistan", "Nur-Sultan"));
        quizStuffPassed.add(new QuizStuff("What is the capital of Poland?", "Warszawa", "Kraków", "Gdańsk", "Łódź", "Warszawa"));
        quizStuffPassed.add(new QuizStuff("What is the capital of Vietnam?", "Haiphong", "Hanoi", "Ho Chi Minh", "Pleiku", "Hanoi"));
        quizStuffPassed.add(new QuizStuff("What is the capital of Wales?", "Edinburg", "Dublin", "London", "Cardiff", "Cardiff"));
        quizStuffPassed.add(new QuizStuff("What is the capital of Uganda?", "Kasese", "Lira", "Mbarara", "Kampala", "Kampala"));
        quizStuffPassed.add(new QuizStuff("Where is Albania located?", "Europe", "Asia", "South America", "Asia", "Europe"));
        quizStuffPassed.add(new QuizStuff("What is the World's longest river?", "Amazon River", "Nile River", "Mississippi River", "Congo River", "Nile"));
        quizStuffPassed.add(new QuizStuff("What is the shape of river delta?", "Triangular", "Square", "Circular", "Straight", "Triangular"));
        quizStuffPassed.add(new QuizStuff("What is the previous name of Beijing?", "Chongqing", "Shenzhen", "Peking", "Shanghai", "Peking"));
        quizStuffPassed.add(new QuizStuff("What is the previous name of Beijing?", "Chongqing", "Shenzhen", "Peking", "Shanghai", "Peking"));
        quizStuffPassed.add(new QuizStuff("World's least population dense country?", "Lebanon", "Panama", "Jamaica", "Mongolia", "Mongolia"));
        quizStuffPassed.add(new QuizStuff("What is the capital of Bulgaria?", "Katherine", "Budapest", "Anna", "Sofia", "Sofia"));
        quizStuffPassed.add(new QuizStuff("What is the capital of Romania?", "Sofia", "Budapest", "Bucharest", "Oradea", "Bucharest"));
        quizStuffPassed.add(new QuizStuff("What is the capital of Hungary?", "Vienna", "Budapest", "Bucharest", "Debrecen", "Budapest"));
        quizStuffPassed.add(new QuizStuff("What is the capital of Hungary?", "Vienna", "Budapest", "Bucharest", "Debrecen", "Budapest"));




    }
}