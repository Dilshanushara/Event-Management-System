package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Myallevents extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myallevents);

        ListView myeventlist = (ListView) findViewById(R.id.myeventlist);
       // Log.d("onCreate ,Started");

         ArrayList <String> myarrayy=new ArrayList<>();

        myarrayy.add("SLIIT Walk");
        myarrayy.add("Dulana's b'day party");

         myarrayy.add("SLIIT Annual Get to Gether");
         myarrayy.add("Dinu and Kamal Wedding");




        ArrayAdapter a1=new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,myarrayy);

        myeventlist.setAdapter(a1);

        myeventlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent i1=new Intent(view.getContext(),EditDeleteEventpart1.class);
                startActivity(i1);
            }




        });








}
}