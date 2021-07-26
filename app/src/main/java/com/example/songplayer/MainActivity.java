package com.example.songplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button play,stop,pause;
    MediaPlayer mediaPlayer;
    int pausecurrentposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        play=(Button) findViewById(R.id.btn_play);
        pause=(Button) findViewById(R.id.btn_pause);
        stop=(Button) findViewById(R.id.btn_stop);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch(view.getId())
        {
            case R.id.btn_play:
                if(mediaPlayer==null)
                {
            mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.ganeshaarti);
            mediaPlayer.start();
                }
                else if(!mediaPlayer.isPlaying())
                {
                    mediaPlayer.seekTo(pausecurrentposition);
                    mediaPlayer.start();
                }
            break;

            case R.id.btn_pause:
                if(mediaPlayer!=null)
                {
                    mediaPlayer.pause();
                    pausecurrentposition=mediaPlayer.getCurrentPosition();
                }
                break;

            case R.id.btn_stop:
                if(mediaPlayer!=null)
                {
                mediaPlayer.stop();
                mediaPlayer=null;
                }
                break;
        }

    }
}