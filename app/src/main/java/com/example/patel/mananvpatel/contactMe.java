package com.example.patel.mananvpatel;

import android.animation.AnimatorSet;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.OvalShape;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class contactMe extends AppCompatActivity implements View.OnClickListener {

    private ImageView githubIV;
    private ImageView linkedInIV;
    private ImageView fbIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_me);

        //get the views and set a on click listener for them
        githubIV = (ImageView) findViewById(R.id.GitHub);
        linkedInIV = (ImageView) findViewById(R.id.linkedIN);
        fbIV = (ImageView) findViewById(R.id.FaceBook);

        githubIV.setOnClickListener(this);
        linkedInIV.setOnClickListener(this);
        fbIV.setOnClickListener(this);
    }


    //when the image is clicked get the image id and send it to the webview activity to load a webpage
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.GitHub:
                Intent intentGH = new Intent(this, webVIew.class);
                String s1 = "gh";
                intentGH.putExtra("website", s1);
                startActivity(intentGH);
                break;
            case R.id.linkedIN:
                Intent intentLI = new Intent(this, webVIew.class);
                String s2 = "li";
                intentLI.putExtra("website", s2);
                startActivity(intentLI);
                break;
            case R.id.FaceBook:
                Intent intentFB = new Intent(this, webVIew.class);
                String s3 = "fb";
                intentFB.putExtra("website", s3);
                startActivity(intentFB);
                break;
        }
    }
}
