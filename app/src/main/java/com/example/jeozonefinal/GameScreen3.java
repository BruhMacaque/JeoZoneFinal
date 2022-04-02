package com.example.jeozonefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameScreen3 extends AppCompatActivity {
    private Button easyButton;
    private Button hardButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen3);

        easyButton = (Button) findViewById(R.id.easyBtn);
        hardButton = (Button) findViewById(R.id.hardBtn);

        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                easyModeOpen();
            }
        });
        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hardModeOpen();
            }
        });
    }
    public void easyModeOpen(){
        Intent intent = new Intent(this, GameScreen2.class);
        startActivity(intent);
    }
    public void hardModeOpen(){
        Intent intent = new Intent(this, GameScreen4Hard.class);
        startActivity(intent);
    }
}