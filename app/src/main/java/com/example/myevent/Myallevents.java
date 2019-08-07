package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Myallevents extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myallevents);

        ListView myeventlist = (ListView) findViewById(R.id.myeventlist);

         ArrayList <String> myarrayy=new ArrayList<>();

         myarrayy.add("SLIIT Walk");
         myarrayy.add("SLIIT Annual Get to Gether");
         myarrayy.add("Dinu and Kamal Wedding");


      //  ArrayAdapter a1=new ArrayAdapter(this,R.);

        //myeventlist.setAdapter(a1);

    }
}
