package com.example.patel.mananvpatel;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.Arrays;

public class myProjects extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_projects);

        //create a spinner for selecting different projects
        Spinner spinner = (Spinner) findViewById(R.id.projects_spinner);

        //set and adapter using an ArrayAdapter for the projects_array
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.projects_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //store information in the projects_file about the different project topics.
        String fileName = "Projects_file";
        Resources r = getResources();
        String[] projects = r.getStringArray(R.array.projects_array);

        //create an output stream to store information
        FileOutputStream output;

        //write the array to a file.
        try {
            output = openFileOutput(fileName, Context.MODE_PRIVATE);
            for (String p : projects) {
                output.write(p.getBytes());
            }
            //close the output stream
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //when an item from the list view is selected do the following
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //get the name of the selected item
        String name = adapterView.getSelectedItem().toString();
        Toast.makeText(adapterView.getContext(), "Selected: " + name, Toast.LENGTH_LONG).show();

        //get the view id's for displaying purposes
        TextView projTV = (TextView) findViewById(R.id.projectsTV);
        ImageView projIV = (ImageView) findViewById(R.id.projIV);
        TextView descTV = (TextView) findViewById(R.id.projDesc);

        //for the atm app - display image and description
        if(name.equals("ATM.go")) {
            projTV.setText("ATM.go");
            projIV.setImageResource(R.mipmap.atm);
            descTV.setText(R.string.atmDesc);
        }
        if(name.equals("Classic Sanskrit App")) {
            projTV.setText("Classic Sanskrit App");
            projIV.setImageResource(R.mipmap.sanskrit);
            descTV.setText(R.string.sansDesc);
        }
        if(name.equals("Court Counter App")) {
            projTV.setText("Court Counter App");
            projIV.setImageResource(R.mipmap.courtcounter);
            descTV.setText(R.string.courtCounterDesc);
        }
        if(name.equals("SPYTeam (Senior Project)")) {
            projTV.setText("SPYTeam (Senior Project)");
            projIV.setImageResource(R.mipmap.seniorproject);
            descTV.setText(R.string.spDesc);
        }
        if(name.equals("Pebble Watch App")) {
            projTV.setText("Pebble Watch App");
            projIV.setImageResource(R.mipmap.pebble);
            descTV.setText(R.string.pwDesc);
        }
        if(name.equals("Portfolio Website")) {
            projTV.setText("Portfolio Website");
            projIV.setImageResource(R.mipmap.portfolio);
            descTV.setText(R.string.portfolioDesc);
        }
        if(name.equals("Trivia App")) {
            projTV.setText("Trivia App");
            projIV.setImageResource(R.mipmap.trivia);
            descTV.setText(R.string.triviaDesc);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //there is always something selected
    }
}
