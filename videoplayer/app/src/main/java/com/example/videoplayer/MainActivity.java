package com.example.videoplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    Button button;
    SurfaceView surfaceView;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= findViewById(R.id.button);
        surfaceView= findViewById(R.id.surfaceView);
        surfaceView.setKeepScreenOn(true);
        mediaPlayer= new MediaPlayer();
        seekBar= findViewById(R.id.seekBar);
        SurfaceHolder surfaceHolder= surfaceView.getHolder();
        try {
            mediaPlayer.setDataSource("https://scontent.cdninstagram.com/o1/v/t16/f2/m69/An8lTmvUqSIYo_SkYl1F4yNLw4DrvuCNz5J-22eQ4J9mDGi6q9IOmdjnnu_kbEMxc1fQB9QmqMd2f_fVjyQh_OnN.mp4?efg=eyJ2ZW5jb2RlX3RhZyI6Inhwdl9wcm9ncmVzc2l2ZS5JTlNUQUdSQU0uQ0FST1VTRUxfSVRFTS5DMy42NDAuZGFzaF9iYXNlbGluZV8zX3YxIn0&_nc_ht=scontent.cdninstagram.com&_nc_cat=110&strext=1&vs=a99e772329f8d484&_nc_vs=HBksFQIYOnBhc3N0aHJvdWdoX2V2ZXJzdG9yZS9HR08tR2h1RlhsU0J1dzhJQUlydFJLLVNpZTRMYmtZTEFBQUYVAALIAQAVAhg6cGFzc3Rocm91Z2hfZXZlcnN0b3JlL0dQd3hOZ2U4OS1ILTlIa0pBTUxYOEwyUzZ2Z09icFIxQUFBRhUCAsgBACgAGAAbAogHdXNlX29pbAExEnByb2dyZXNzaXZlX3JlY2lwZQExFQAAJvrsvvCvwMgBFQIoAkMzLBdARvWhysCDEhgSZGFzaF9iYXNlbGluZV8zX3YxEQB17gcA&ccb=9-4&oh=00_AYD7vrYzPww2av1gSsEqwVEOnOp2Q3fQUYytvAF6V457Fg&oe=66E0F717&_nc_sid=1d576d");
        } catch (IOException e) {
            Toast.makeText(this, "An error occured", Toast.LENGTH_SHORT).show();
            throw new RuntimeException(e);
        }
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
                mediaPlayer.setDisplay(surfaceHolder);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

            }
        });
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                Toast.makeText(MainActivity.this, "Video Ready to be played", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
                seekBar.setMax(mediaPlayer.getDuration());
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                        seekBar.setProgress(i);
                        mediaPlayer.seekTo(i);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(mediaPlayer.isPlaying()){
                            mediaPlayer.pause();
                            button.setText("Play");
                        }
                        else{
                            mediaPlayer.start();
                            button.setText("Pause");
                        }
                    }
                });
            }
        });

        mediaPlayer.prepareAsync();

    }
}

//public class MainActivity extends AppCompatActivity {
//    MediaPlayer mediaPlayer;
//    Button button;
//    SurfaceView surfaceView;
//    SeekBar seekBar;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        button= findViewById(R.id.button);
//        surfaceView= findViewById(R.id.surfaceView);
//        surfaceView.setKeepScreenOn(true);
//        SurfaceHolder surfaceHolder= surfaceView.getHolder();
//        mediaPlayer= MediaPlayer.create(this, R.raw.vdo);
//        Toast.makeText(MainActivity.this, "Video Ready to be played", Toast.LENGTH_SHORT).show();
//        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
//            @Override
//            public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
//                mediaPlayer.setDisplay(surfaceHolder);
//                mediaPlayer.start();
//            }
//
//            @Override
//            public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
//
//            }
//        });
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(mediaPlayer.isPlaying()){
//                    mediaPlayer.pause();
//                    button.setText("Play");
//                }
//                else{
//                    mediaPlayer.start();
//                    button.setText("Pause");
//                }
//            }
//        });
//    }
//}