package com.example.myevent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.myevent.Model.Event;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Addevent2 extends AppCompatActivity {

    private Button b;                   //declare all variables
    EditText txt_date, txt_people;
    DatabaseReference dbref;

    RadioGroup radio_Sponsors;
    RadioButton Sponsorsoption;

    String strsponsor;
    Event evt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addevent2);


        txt_date=findViewById(R.id.txtdate);                    //asign  xml file textfileds to edit text variables
        txt_people=findViewById(R.id.txtpeople);

        b=(Button) findViewById(R.id.addevent);

        //get the passed variables from the previous activity and assign them to string variables

        final String eplace= getIntent().getStringExtra("eplace").toString();
        final String ename= getIntent().getStringExtra("ename").toString();
        final String etype= getIntent().getStringExtra("radiotype");

        radio_Sponsors = findViewById(R.id.radioGroup2);

        radio_Sponsors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {     //Check the sponsorship options  selected by the user
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                Sponsorsoption=radio_Sponsors.findViewById(i);

                switch(i) {
                    case R.id.radioButton6:
                        strsponsor = Sponsorsoption.getText().toString();
                        break;


                    case R.id.radioButton5:
                        strsponsor = Sponsorsoption.getText().toString();
                        break;

                    default:


                }
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean validate = validation();    //assign validation return value to validate variable

                if (validate == true) {        //check if the validation is true


                    dbref = FirebaseDatabase.getInstance().getReference().child("Events");//declare the firebase reference

                    try {


                        evt = new Event();            //create a object from Event model class
                        evt.setEname(ename);          //set the values to the object
                        evt.setPlace(eplace);
                        evt.setType(etype);
                        evt.setDate(txt_date.getText().toString().trim());
                        evt.setPeople(txt_people.getText().toString().trim());
                        evt.setSponsors(strsponsor);


                        dbref.child(evt.getEname().toString()).setValue(evt);   //pass the Event object to the databse

                        //display toast message if the data saved successfully
                        Toast.makeText(getApplicationContext(), "Data saved succesfully", Toast.LENGTH_LONG).show();
                        openafteraddevent();
                        cleancontrol();

                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(), "Invalid entry", Toast.LENGTH_LONG).show();
                    }
                }


            }



        });

    }

    private void openafteraddevent() {           //create a method to open a the next activity
        Intent i = new Intent(this, Aftereventadded.class);
        startActivity(i);


    }

    private void cleancontrol() {

        txt_people.setText("");
        txt_date.setText("");
    }


    public boolean validation(){
        //assign edit text values to String variables
        String eventdate= txt_date.getEditableText().toString().trim();
        String eventpeople=txt_people.getEditableText().toString().trim();

        if(eventdate.isEmpty()) {                    //check the assigned String variables are empty
            txt_date.setError("Field can't be empty");    //set a error message
            return false;                                //if the variable is empty return false
        }

        else if (eventpeople.isEmpty()){               //check the assigned String variables are empty
            txt_people.setError("Field can't be empty");     //set a error message
            return  false;                                  //if the variable is empty return false
        }

        else
            return true;

    }
}









