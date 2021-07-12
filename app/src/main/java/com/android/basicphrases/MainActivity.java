package com.android.basicphrases;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//TODO -- Hide Action Bar
public class MainActivity extends AppCompatActivity {

    private MediaPlayer converter;
    private GridLayout backGround;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        converter = MediaPlayer.create(this,R.raw.hello);
        backGround = findViewById(R.id.backGround);
        for(int i=0;i<backGround.getChildCount();i++){
            Button btn;
            btn = (Button)backGround.getChildAt(i);
            btn.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {

                    onClick(view);
                    return true;
                }
            });
        }
    }
    private void stopCurrent(){
        if(converter.isPlaying())
            converter.stop();
    }
    private void animateButton(Button animation){
        animation.setScaleX(0.95f);
        animation.setScaleY(0.95f);
        animation.setAlpha(0.8f);
        animation.animate().scaleY(1).scaleX(1).alpha(1).setDuration(200);
    }
    public void onClick(View v){
        Button clicked = (Button) v;
        stopCurrent();
        animateButton(clicked);
        switch (clicked.getText().toString()){
            case "Do you \nspeak english?":
                converter = MediaPlayer.create(this,R.raw.doyouspeakenglish);
                converter.start();
                break;
            case "Good Evening":
                converter = MediaPlayer.create(this,R.raw.goodevening);
                converter.start();
                break;
            case "hello":
                converter = MediaPlayer.create(this,R.raw.hello);
                converter.start();
                break;
            case "How are you?":
                converter = MediaPlayer.create(this,R.raw.howareyou);
                converter.start();
                break;
            case "I Live in":
                converter = MediaPlayer.create(this,R.raw.ilivein);
                converter.start();
                break;
            case "My name is":
                converter = MediaPlayer.create(this,R.raw.mynameis);
                converter.start();
                break;
            case "Please":
                converter = MediaPlayer.create(this,R.raw.please);
                converter.start();
                break;
            case "Welcome":
                converter = MediaPlayer.create(this, R.raw.welcome);
                converter.start();
                break;
            default:
                break;

        }
    }
}