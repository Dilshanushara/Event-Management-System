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


public class EditDeleteEventpart2 extends AppCompatActivity {

    private Button b;

    EditText txt_date, txt_people;          //declare all variables
    DatabaseReference dbref;

    RadioGroup radio_Sponsors;
    RadioButton Sponsorsoption;
    String strsponsor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete_eventpart2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txt_date=findViewById(R.id.txtdate);                 //asign  xml file textfileds id to edit text variables
        txt_people=findViewById(R.id.txtpeople);

        //get the passed variables from the previous activity and assign them to string variables

        final String eventidname= getIntent().getStringExtra("clickid").toString();
        final String eplace= getIntent().getStringExtra("eplace").toString();
        final String ename= getIntent().getStringExtra("ename").toString();
        final String etype= getIntent().getStringExtra("radiotype");

        radio_Sponsors = findViewById(R.id.radioGroup2);


        //Check the sponsor type that the user selecting radio button from switch case

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

        dbref = FirebaseDatabase.getInstance().getReference().child("Events").child(eventidname); //get a databse instance

        dbref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                if (dataSnapshot.hasChildren()){
                    //set the values to textfileds which are getting from the database

                    txt_people.setText(dataSnapshot.child("people").getValue().toString());
                    txt_date.setText(dataSnapshot.child("date").getValue().toString());

                }

                else{
                    //display a toast message if there is no values to retrieve

                    Toast.makeText(getApplicationContext(),"No values to retrieve",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        b=(Button) findViewById(R.id.buttondelete);

        //if the user ebter the delete event button delete the event

        b.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                dbref=FirebaseDatabase.getInstance().getReference().child("Events");
                dbref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if(dataSnapshot.hasChild(eventidname)){
                            dbref=dbref.child(eventidname);
                            dbref.removeValue();

                            //make a toast if the event has been deleted
                            Toast.makeText(getApplicationContext(),"Event has been deleted",Toast.LENGTH_LONG).show();
                            openmyallevent();
                        }

                        else{
                            //make a toast if the event hasn't deleted

                            Toast.makeText(getApplicationContext(),"No Event to delete",Toast.LENGTH_LONG).show();
                        }

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

        });

        b=(Button) findViewById(R.id.buttonupdate);

        b.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {


                boolean validate = validation();

                if (validate == true) {                            //check if the validation is true


                    final Event evt = new Event();
                    dbref = FirebaseDatabase.getInstance().getReference().child("Events");
                    try {

                        dbref.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                if (dataSnapshot.hasChild(eventidname)) {

                                    evt.setEname(ename.toString().trim());               //set the values to Event object using set methods
                                    evt.setPlace(eplace.toString().trim());
                                    evt.setType(etype);
                                    evt.setDate(txt_date.getText().toString().trim());
                                    evt.setPeople(txt_people.getText().toString().trim());
                                    evt.setSponsors(strsponsor);

                                    dbref.child(evt.getEname().toString()).setValue(evt);    //pass the event object to the database

                                    //make a toast  if the data updated successfully
                                    Toast.makeText(getApplicationContext(), "Update success", Toast.LENGTH_LONG).show();

                                    openmyallevent();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });

                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(), "Update Error", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private void openmyallevent() {

        Intent i=new Intent(this, Myallevents.class);
        startActivity(i);
    }


    public boolean validation(){                                              //implement the validation method
        String eventdate= txt_date.getEditableText().toString().trim();        //assign edit text values to String variables
        String eventpeople=txt_people.getEditableText().toString().trim();

        if(eventdate.isEmpty()) {                                               //check the assigned String variables are empty
            txt_date.setError("Field can't be empty");                         //set a error message
            return false;                                                      //if the variable is empty return false
        }

        else if (eventpeople.isEmpty()){                                       //check the assigned String variables are empty
            txt_people.setError("Field can't be empty");                         //set a error message
            return  false;                                                    //if the variable is empty return false
        }

        else
            return true;

    }


}
