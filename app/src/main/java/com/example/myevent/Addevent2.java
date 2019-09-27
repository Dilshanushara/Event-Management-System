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

    private Button b;



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



        txt_date=findViewById(R.id.txtdate);
        txt_people=findViewById(R.id.txtpeople);




        b=(Button) findViewById(R.id.addevent);

        final String eplace= getIntent().getStringExtra("eplace").toString();
        final String ename= getIntent().getStringExtra("ename").toString();
        final String etype= getIntent().getStringExtra("radiotype");







        radio_Sponsors = findViewById(R.id.radioGroup2);

        radio_Sponsors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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

                boolean validate = validation();

                if (validate == true) {


                    dbref = FirebaseDatabase.getInstance().getReference().child("Events");

                    evt = new Event();
                    evt.setEname(ename);
                    evt.setPlace(eplace);
                    evt.setType(etype);
                    evt.setDate(txt_date.getText().toString().trim());
                    evt.setPeople(txt_people.getText().toString().trim());
                    evt.setSponsors(strsponsor);


                    //dbref.push().setValue(std);
                    //  dbref.child("IT002").setValue(std);
                    dbref.child(evt.getEname().toString()).setValue(evt);


                    Toast.makeText(getApplicationContext(), "Data saved succesfully", Toast.LENGTH_LONG).show();
                    openafteraddevent();
                    cleancontrol();

                }


            }



        });








    }







    private void openafteraddevent() {
        Intent i = new Intent(this, Aftereventadded.class);
        startActivity(i);


    }






    private void cleancontrol() {

        txt_people.setText("");
        txt_date.setText("");


    }


    public boolean validation(){
        String eventdate= txt_date.getEditableText().toString().trim();
        String eventpeople=txt_people.getEditableText().toString().trim();

        if(eventdate.isEmpty()) {
            txt_date.setError("Field can't be empty");
            return false;
        }

        else if (eventpeople.isEmpty()){
            txt_people.setError("Field can't be empty");
            return  false;
        }

        else
            return true;

    }












}









