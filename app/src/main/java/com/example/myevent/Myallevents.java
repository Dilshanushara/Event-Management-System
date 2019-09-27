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



    DatabaseReference dbref;

    ArrayAdapter<String>adapter;
    ArrayList<String>arrayList;
    Event evt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myallevents);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        evt=new Event();
        final ListView listView= (ListView) findViewById(R.id.myeventlist);
       // Log.d("onCreate ,Started");

        final FirebaseDatabase[] databse = {FirebaseDatabase.getInstance()};
        dbref = FirebaseDatabase.getInstance().getReference().child("Events");

         arrayList=new ArrayList<>();





        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,arrayList);

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for(DataSnapshot ds:dataSnapshot.getChildren()){

                    evt = ds.getValue(Event.class);
                    arrayList.add(evt.getEname());
                }
                listView.setAdapter(adapter);





            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent i1=new Intent(Myallevents.this,EditDeleteEventpart1.class);
                        i1.putExtra("clickid",listView.getItemAtPosition(i).toString());
                        startActivity(i1);
                    }
                });











}
}