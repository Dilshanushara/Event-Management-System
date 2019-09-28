package com.example.myevent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myevent.Model.Event;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Myallevents extends AppCompatActivity {

    DatabaseReference dbref;               //declare all variables

    ArrayAdapter<String>adapter;
    ArrayList<String>arrayList;
    Event evt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myallevents);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        evt=new Event();             //create a object using Event model class
        final ListView listView= (ListView) findViewById(R.id.myeventlist);      //create a list view

        final FirebaseDatabase[] databse = {FirebaseDatabase.getInstance()};     //get a database instance
        dbref = FirebaseDatabase.getInstance().getReference().child("Events");

         arrayList=new ArrayList<>();             //declare a array list

         adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,arrayList);    //set a array adapter

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for(DataSnapshot ds:dataSnapshot.getChildren()){      //for loop for get the all data from the databse

                    evt = ds.getValue(Event.class);                 //assign the values for evt object
                    arrayList.add(evt.getEname());                  //add the event name of each event to the arraylist
                }
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //implement listview onitemclick litnerner to get the id of the event that the user is clicking

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent i1=new Intent(Myallevents.this,EditDeleteEventpart1.class);    //create a intent for the next activity

                        //get the  clicked item id and assign it to clickid and pass it to the next activity
                        i1.putExtra("clickid",listView.getItemAtPosition(i).toString());
                        startActivity(i1);
                    }
                });

    }
}