package com.example.clock;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.os.Bundle;
import java.util.Locale;

import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StopwatchActivity extends AppCompatActivity {

    private int seconds = 0;
    private boolean running;

    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        Button bot_btn1 = findViewById(R.id.bot_btn_1);
        Button bot_btn2 = findViewById(R.id.bot_btn_2);
        Button bot_btn4 = findViewById(R.id.bot_btn_4);

        if(bot_btn1 != null) {
            bot_btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent timer = new Intent(StopwatchActivity.this, MainActivity.class);
                    startActivity(timer);
                }
            });
        }
        if(bot_btn2 != null) {
            bot_btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent stopwatch = new Intent(StopwatchActivity.this, Timer.class);
                    startActivity(stopwatch);
                }
            });
        }
        if(bot_btn4 != null) {
            bot_btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent alarm = new Intent(StopwatchActivity.this, Alarm.class);
                    startActivity(alarm);
                }
            });
        }
        if (savedInstanceState != null) {
            seconds
                    = savedInstanceState
                    .getInt("seconds");
            running
                    = savedInstanceState
                    .getBoolean("running");
            wasRunning
                    = savedInstanceState
                    .getBoolean("wasRunning");
        }
        runTimer();
    }

    @Override
    public void onSaveInstanceState(
            Bundle savedInstanceState)
    {
        savedInstanceState
                .putInt("seconds", seconds);
        savedInstanceState
                .putBoolean("running", running);
        savedInstanceState
                .putBoolean("wasRunning", wasRunning);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }

    public void onClickStart(View view)
    {
        running = true;
    }

    public void onClickStop(View view)
    {
        running = false;
    }

    public void onClickReset(View view)
    {
        running = false;
        seconds = 0;
    }

    private void runTimer()
    {

        final TextView timeView
                = (TextView)findViewById(
                R.id.time_view);

        final Handler handler
                = new Handler();

        handler.post(new Runnable() {
            @Override

            public void run()
            {
                int minutes = seconds / 3600;
                int sec = (seconds % 3600) / 60;
                int msecs = (seconds * 10 / 6) % 100;

                String time
                        = String
                        .format(Locale.getDefault(),
                                "%02d:%02d.%02d", minutes,
                                sec, msecs);

                timeView.setText(time);

                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 10);
            }
        });
    }
}