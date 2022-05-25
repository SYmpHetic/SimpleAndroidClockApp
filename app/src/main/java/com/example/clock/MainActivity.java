package com.example.clock;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.clock.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bot_btn2 = findViewById(R.id.bot_btn_2);
        Button bot_btn3 = findViewById(R.id.bot_btn_3);
        Button bot_btn4 = findViewById(R.id.bot_btn_4);

        if(bot_btn2 != null) {
            bot_btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent timer = new Intent(MainActivity.this, Timer.class);
                    startActivity(timer);
                }
            });
        }
        if(bot_btn3 != null) {
            bot_btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent stopwatch = new Intent(MainActivity.this, StopwatchActivity.class);
                    startActivity(stopwatch);
                }
            });
        }
        if(bot_btn4 != null) {
            bot_btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent alarm = new Intent(MainActivity.this, Alarm.class);
                    startActivity(alarm);
                }
            });
        }

    }
}