package com.example.patel.mananvpatel;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class aboutMe extends Activity {
    private String[] navArray = {"Contact Me", "Projects", "Work Experience"};
    private ListView navListView;
    private ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        //set an array adapter for the listView and populate it with navArray
        navListView = (ListView) findViewById(R.id.navLV);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, navArray);
        navListView.setAdapter(arrayAdapter);

        //when an item in the listview is clicked open the correct activity
        navListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent newActivity0 = new Intent(view.getContext(), contactMe.class);
                        startActivity(newActivity0);
                        break;
                    case 1:
                        Intent newActivity1 = new Intent(view.getContext(), myProjects.class);
                        startActivity(newActivity1);
                        break;
                    case 2:
                        Intent newActivity2 = new Intent(view.getContext(), workExperience.class);
                        startActivity(newActivity2);
                        break;
                    default:
                }
            }
        });

        //when the user long clicks the list view items, it pops up with an item long clicked toast
        navListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Toast.makeText(aboutMe.this, "Long Clicked Item: "+navListView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }
}
