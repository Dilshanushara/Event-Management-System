package com.example.myevent.EventPlanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myevent.R;

public class EventPlannerRegister2 extends AppCompatActivity {

    EditText EdtEventPlannerDescription,EdtEventPlannerPassword;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeraseventplanner2);


        String EventPlannerName= getIntent().getStringExtra("EventPlannerName");
        String EventPlannerEmail=getIntent().getStringExtra("EventPlannerEmail");
        String EventPlannerPhone=getIntent().getStringExtra("EventPlannerPhone");
        String EventPlannerAge=getIntent().getStringExtra("EventPlannerAge");

        EdtEventPlannerDescription = (EditText)findViewById(R.id.EdtEventPlannerDescription);
        EdtEventPlannerPassword = (EditText)findViewById(R.id.EdtEventPlannerPassword);

        String EdtEventPlannerDesc=EdtEventPlannerDescription.getText().toString();
        String EdtEventPlannerPass=EdtEventPlannerPassword.getText().toString();



    }



}
