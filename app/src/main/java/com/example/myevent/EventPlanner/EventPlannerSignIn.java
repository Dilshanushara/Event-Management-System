package com.example.myevent.EventPlanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myevent.Common.Common;
import com.example.myevent.Model.EventPlanner;
import com.example.myevent.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EventPlannerSignIn extends AppCompatActivity {


    EditText edtPhone,edtPassword;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_planner_sign_in);

        edtPassword =(EditText)findViewById(R.id.edtPassword);
        edtPhone=(EditText)findViewById(R.id.edtPhone);
        btnSignIn =(Button)findViewById(R.id.btnSignIn);

        //firebase


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_Eventplanner= database.getReference("Eventplanner");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                table_Eventplanner.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(edtPhone.getText().toString()).exists()) {


                             EventPlanner eventPlanner = dataSnapshot.child(edtPhone.getText().toString()).getValue(EventPlanner.class);

                            //set phone
                            eventPlanner.setPhone(edtPhone.getText().toString());

                            if (eventPlanner.getPassword().equals(edtPassword.getText().toString())) {
                                Toast.makeText(EventPlannerSignIn.this, "Sign in Successfull", Toast.LENGTH_SHORT).show();
                                Intent signIn = new Intent(EventPlannerSignIn.this, EventPlannerWelcomePage.class);
                                Common.currenteventplanner =eventPlanner;
                                startActivity(signIn);
                                finish();

                            } else {
                                Toast.makeText(EventPlannerSignIn.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                            }

                        }


                        else{

                            Toast.makeText(EventPlannerSignIn.this,"User not exist Database",Toast.LENGTH_SHORT).show();

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
