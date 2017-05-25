package com.example.patel.mananvpatel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class workExperience extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_experience);

        //get the radiogroup by id and set and on checked change listener
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.workRG);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            //when you choose another radio button, set a description and image
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                TextView worktv = (TextView) findViewById(R.id.workTV);
                ImageView workimg = (ImageView) findViewById(R.id.workIV);
                switch(checkedId) {
                    case R.id.RArb:
                        worktv.setText(R.string.RADesc);
                        workimg.setImageResource(R.mipmap.sportpsu);
                        break;
                    case R.id.TArb:
                        worktv.setText(R.string.TADesc);
                        workimg.setImageResource(R.mipmap.psu);
                        break;
                }
            }
        });
    }
    public void onRadioButtonClicked(View view) {

    }
}
