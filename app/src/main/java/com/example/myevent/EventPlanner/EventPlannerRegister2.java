package com.example.myevent.EventPlanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myevent.Model.EventPlanner;
import com.example.myevent.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EventPlannerRegister2 extends AppCompatActivity {

    EditText EdtEventPlannerDescription,EdtEventPlannerPassword;
    Button BtnEventPlannersub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeraseventplanner2);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference tabel_eventplanner=database.getReference("Eventplanner");


        final String EventPlannerName= getIntent().getStringExtra("EventPlannerName");
        final String EventPlannerEmail=getIntent().getStringExtra("EventPlannerEmail");
        final String EventPlannerPhone=getIntent().getStringExtra("EventPlannerPhone");
        final String EventPlannerAge=getIntent().getStringExtra("EventPlannerAge");

        EdtEventPlannerDescription = (EditText)findViewById(R.id.EdtEventPlannerDescription);
        EdtEventPlannerPassword = (EditText)findViewById(R.id.EdtEventPlannerPassword);
        BtnEventPlannersub=(Button)findViewById(R.id.BtnEventPlannersubmit);



        BtnEventPlannersub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tabel_eventplanner.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {




                        if(dataSnapshot.child(EventPlannerPhone).exists()){
                            Toast.makeText(EventPlannerRegister2.this,"Phone number already register",Toast.LENGTH_SHORT).show();
                        }else{


                            EventPlanner eventPlanner = new EventPlanner(EventPlannerName,EventPlannerEmail, EventPlannerPhone,EventPlannerAge,EdtEventPlannerDescription.getText().toString(),EdtEventPlannerPassword.getText().toString() );
                            tabel_eventplanner.child(EventPlannerPhone).setValue(eventPlanner);
                            Toast.makeText(EventPlannerRegister2.this,"Sign up is done!",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(EventPlannerRegister2.this,EventPlannerWelcomePage.class);
                            startActivity(intent);
                            finish();

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });


    }



}
