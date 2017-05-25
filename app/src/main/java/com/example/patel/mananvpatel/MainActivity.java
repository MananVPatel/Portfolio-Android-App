package com.example.patel.mananvpatel;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;

import java.io.File;

//used the audio example from the book to create the sound capability

public class MainActivity extends AppCompatActivity {

    private SoundPool soundPool;
    private SparseIntArray soundMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureSounds();
    }


    //create a new soundPool object and place different sounds into the pool using the soundmap
    public void configureSounds()
    {
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        soundMap = new SparseIntArray(4);
        soundMap.put(1, soundPool.load(this, R.raw.mario, 1));
        soundMap.put(2, soundPool.load(this, R.raw.waterdrop, 1));
        soundMap.put(3, soundPool.load(this, R.raw.mario, 1));
        soundMap.put(4, soundPool.load(this, R.raw.waterdrop, 1));

    }

    public void GoToAboutMe(View v)
    {
        //open the aboutMe activity
        Intent intent = new Intent(this, aboutMe.class);
        startActivity(intent);
        //play the mario tune
        soundPool.play(1, 1, 1, 1, 0, 1.0f);

    }
    public void GoToPortfolio(View v)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mvpportfolio-160521.appspot.com/"));
        startActivity(intent);
        soundPool.play(2, 1, 1, 1, 0, 1.0f);

    }
    public void GoToLinkedIn(View v)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/manan-patel-40a7b960/"));
        startActivity(intent);
        soundPool.play(3, 1, 1, 1, 0, 1.0f);

    }
    public void GoToGitHub(View v)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/MananVPatel"));
        startActivity(intent);
        soundPool.play(4, 1, 1, 1, 0, 1.0f);
    }

    //inflate the menu in this activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //when the action menu button is clicked. handle the event
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.action_settings1:
                Toast.makeText(this,"Background Color changed to Yellow",Toast.LENGTH_SHORT).show();
                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#ffd700"));
                return true;
            case R.id.action_settings2:
                Toast.makeText(this,"Background Color changed to Salmon",Toast.LENGTH_SHORT).show();
                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#ff7373"));
                return true;
            case R.id.action_settings3:
                Toast.makeText(this,"Background Color changed to Teal",Toast.LENGTH_SHORT).show();
                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#7fffd4"));
                return true;
            case R.id.draw:
                Toast.makeText(this,"Checkout the Bullseye",Toast.LENGTH_SHORT).show();
                //open bullseye activity
                Intent newActivity0 = new Intent(this, bullseye.class);
                startActivity(newActivity0);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
