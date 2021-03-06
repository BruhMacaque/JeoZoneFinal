
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

public class GameScreen2 extends AppCompatActivity {
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

        //gets input from a button press

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
// shows the final pop-up window

    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(GameScreen2.this);
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
// sets button text to correspond with pre-written questions
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

    //stores questions for the quiz

    private void getQuizQuestions(ArrayList<QuizStuff> quizStuffPassed) {
        //Easy questions
        quizStuffPassed.add(new QuizStuff("What is the capital of Canada?", "Ottawa", "London", "Ontario", "Vancouver", "Ottawa"));
        quizStuffPassed.add(new QuizStuff("What is the capital of Ireland?", "Edinburg", "Dublin", "London", "Cardiff", "Dublin"));
        quizStuffPassed.add(new QuizStuff("Where is Colosseum located?", "Spain", "Austria", "France", "Italy", "Italy"));
        quizStuffPassed.add(new QuizStuff("What is the capital of Russia?", "Saint-Petersburg", "Novgorod", "Kiev", "Moscow", "Moscow"));
        quizStuffPassed.add(new QuizStuff("What is the capital of India?", "Delhi", "Chennai", "Kolkata", "Bengaluru", "Delhi"));
        quizStuffPassed.add(new QuizStuff("What is the capital of Argentina?", "Buenos Aires", "Mendoza", "C??rdoba", "Rosario", "Buenos Aires"));
        quizStuffPassed.add(new QuizStuff("What is the capital of Denmark?", "Randers", "Copenhagen", "Herning", "Kolding", "Copenhagen"));
        quizStuffPassed.add(new QuizStuff("What is the capital of Belgium?", "Brussels", "Antwerp", "Leuven", "Charleroi", "Brussels"));
        quizStuffPassed.add(new QuizStuff("Where is Mount Everest located?", "Asia", "Europe", "Africa", "North America", "Asia"));
        quizStuffPassed.add(new QuizStuff("Where is Taj Mahal located?", "Afghanistan", "Pakistan", "India", "Nepal", "India"));
        quizStuffPassed.add(new QuizStuff("Where is Grand Canyon located?", "Arizona", "Kansas", "Texas", "Nevada", "Arizona"));
        quizStuffPassed.add(new QuizStuff("Where is Easter Island located?", "Argentina", "Chile", "Bolivia", "Colombia", "Chile"));
        quizStuffPassed.add(new QuizStuff("Where is Mount Olympus located", "Italy", "Albania", "Greece", "Bulgaria", "Greece"));
        quizStuffPassed.add(new QuizStuff("What is the capital of Greece?", "Rome", "Athens", "Thessaloniki", "Heraklion", "Athens"));
        quizStuffPassed.add(new QuizStuff("What is Earth's most northern place?", "Greenland", "Yukon", "The South Pole", "The North Pole", "The North Pole"));
        quizStuffPassed.add(new QuizStuff("What is the capital of Austria?", "Bucharest", "Berlin", "Budapest", "Vienna", "Vienna"));
        //Hard questions
    }
}