package com.example.myevent;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.Toolbar;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class EditDeleteEventpart1 extends AppCompatActivity {


    private Button b,button;                      //declare all variables
    DatabaseReference dbref;

    String ename, eplace;
    EditText txt_place, txt_name,txt_type;

    RadioGroup radio_type;
    RadioButton Etypeoption;
    String streventtype;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete_eventpart1);

        txt_name=findViewById(R.id.txtname);                   //asign  xml file textfileds id to edit text variables
        txt_place=findViewById(R.id.txtplace);
        radio_type =findViewById(R.id.radiotype);

        radio_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                Etypeoption= radio_type.findViewById(i);

                switch(i) {                    //Check the event type that the user selecting radio button from switch case
                    case R.id.radioButton:
                        streventtype =  Etypeoption.getText().toString();
                        break;


                    case R.id.radioButton2:
                        streventtype =  Etypeoption.getText().toString();
                        break;

                    case R.id.radioButton3:
                        streventtype =  Etypeoption.getText().toString();
                        break;

                    case R.id.radioButton4:
                        streventtype =  Etypeoption.getText().toString();
                        break;
                    default:


                }
            }
        });

        //get the user selected id from the list view of the previous activity and assign it to tempholder
        final String tempholder= getIntent().getStringExtra("clickid").toString();
        button=findViewById(R.id.button);


        dbref =FirebaseDatabase.getInstance().getReference().child("Events").child(tempholder);  //get the instance of the firbase databse

        dbref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.hasChildren()){
                            //set the values to textfileds which are getting from the database

                            txt_name.setText(dataSnapshot.child("ename").getValue().toString());
                            txt_place.setText(dataSnapshot.child("place").getValue().toString());

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


        b = (Button) findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                boolean validation =validation();

                if (validation==true) {               //check if the validation is true

                    openeditdeletepart2();             //if the validation is true execute the openeditpart2 function

                }


            }


        });
    }

    private void openeditdeletepart2() {


        final String id= getIntent().getStringExtra("clickid").toString();   //get the clicked it and anssign it to a variable
        Intent i = new Intent(this, EditDeleteEventpart2.class);      //create an intent to go to next activity
        i.putExtra("clickid",id);                                            //send the values to the next activity using putextra
        i.putExtra("ename",txt_name.getText().toString());
        i.putExtra("eplace",txt_place.getText().toString());
        i.putExtra("radiotype", streventtype);
        startActivity(i);
    }


    public boolean validation(){                           //implement the validation method
        final    String name=txt_name.getText().toString();

        String eventplace= txt_place.getEditableText().toString().trim();  //assign edit text values to String variables
        String eventname=txt_name.getEditableText().toString().trim();

        if(eventplace.isEmpty()) {                                     //check the assigned String variables are empty
            txt_place.setError("Field can't be empty");                //set a error message
            return false;                                              //if the variable is empty return false
        }

        else
            return true;

    }
}

