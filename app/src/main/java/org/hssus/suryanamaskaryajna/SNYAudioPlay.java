package org.hssus.suryanamaskaryajna;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SNYAudioPlay extends BaseActivity {


    MediaPlayer player;
    ImageView imageView,backBtn,media_btn_stop;
    TextView setTxt,mantraTxt,selectedAudio;
    int audioFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snyaudio_play);
        assignUIComponent();
        addPlayer();
        addEvents();
    }

    public void assignUIComponent() {
        imageView = (ImageView) findViewById(R.id.media_btn);
        backBtn = (ImageView) findViewById(R.id.userSettings);
        media_btn_stop = (ImageView) findViewById(R.id.media_btn_stop);
        media_btn_stop.setImageDrawable(getResources().getDrawable(R.drawable.stop, getTheme()));
        backBtn.setImageDrawable(getResources().getDrawable(R.drawable.back, getTheme()));
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.play, getTheme()));

        setTxt = (TextView) findViewById(R.id.setTxt);
        mantraTxt = (TextView) findViewById(R.id.mantraTxt);
        selectedAudio = (TextView) findViewById(R.id.selectedAudio);

        audioFile=R.raw.snyaudiofull;
        selectedAudio.setText(setTxt.getText());

    }

    public void addEvents(){

        setTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAudio.setText(setTxt.getText());
                audioFile=R.raw.snyaudiofull;
            }
        });

        mantraTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAudio.setText(mantraTxt.getText());
                audioFile=R.raw.snyaudiofull;
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAfterTransition();
            }
        });

        media_btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player.isPlaying()){
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.play,getTheme()));
                    player.stop();
                    addPlayer();
                }
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player.isPlaying()){
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.play,getTheme()));
                    player.pause();
                } else {
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.pause,getTheme()));
                    player.start();
                }
            }
        });
    }

    public void addPlayer(){
        player=MediaPlayer.create(this, R.raw.snyaudiofull);
    }
}
