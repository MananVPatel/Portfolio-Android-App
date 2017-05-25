package com.example.patel.mananvpatel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class bullseye extends AppCompatActivity {
    BullsEyeView bullsEyeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bullseye);

        //create a new bullseyeview and then display it in the activity.
        bullsEyeView = new BullsEyeView(this);
        setContentView(bullsEyeView);

    }
}
