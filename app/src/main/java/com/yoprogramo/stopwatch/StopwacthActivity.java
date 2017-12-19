package com.yoprogramo.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class StopwacthActivity extends AppCompatActivity {

    int seconds = 0;
    boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        runTimer();

    }

    private void runTimer() {
        final TextView timeView = findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600)/60;
                int secs = seconds % 60;
                String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);

                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });

    }


    public void onClickStart(View view) {
        running = true;
        Toast.makeText(this, "Start Button", Toast.LENGTH_SHORT).show();
    }

    public void onClickStop(View view) {
        running = false;
        Toast.makeText(this, "Stop Button", Toast.LENGTH_SHORT).show();
    }

    public void onClickReset(View view) {
        running = false;
        seconds = 0;
        Toast.makeText(this, "Reset Button", Toast.LENGTH_SHORT).show();
    }
}

