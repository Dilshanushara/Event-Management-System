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

    EditText txt_date, txt_people;
    DatabaseReference dbref;

    RadioGroup radio_Sponsors;
    RadioButton Sponsorsoption;


    String strsponsor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete_eventpart2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        txt_date=findViewById(R.id.txtdate);
        txt_people=findViewById(R.id.txtpeople);


        final String eventidname= getIntent().getStringExtra("clickid").toString();
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


        //txt_people.setText(eplace);

        dbref = FirebaseDatabase.getInstance().getReference().child("Events").child(eventidname);

        dbref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                if (dataSnapshot.hasChildren()){
                    txt_people.setText(dataSnapshot.child("people").getValue().toString());
                    txt_date.setText(dataSnapshot.child("date").getValue().toString());
                    //    txt_type.setText(dataSnapshot.child("type").getValue());
                    //txt_num.setText(dataSnapshot.child("num").getValue().toString());
                }



                else{
                    Toast.makeText(getApplicationContext(),"No values to retrieve",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        b=(Button) findViewById(R.id.buttondelete);

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

                            Toast.makeText(getApplicationContext(),"Event has been deleted",Toast.LENGTH_LONG).show();
                            openmyallevent();
                        }

                        else{
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

                if (validate == true) {


                    final Event evt = new Event();
                    dbref = FirebaseDatabase.getInstance().getReference().child("Events");

                    dbref.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            if (dataSnapshot.hasChild(eventidname)) {

                                evt.setEname(ename.toString().trim());
                                evt.setPlace(eplace.toString().trim());
                                evt.setType(etype);
                                evt.setDate(txt_date.getText().toString().trim());
                                evt.setPeople(txt_people.getText().toString().trim());
                                evt.setSponsors(strsponsor);

                                dbref.child(evt.getEname().toString()).setValue(evt);

                                Toast.makeText(getApplicationContext(), "Update success", Toast.LENGTH_LONG).show();

                                openmyallevent();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        });
    }

    private void openmyallevent() {

        Intent i=new Intent(this, Myallevents.class);
        startActivity(i);
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
