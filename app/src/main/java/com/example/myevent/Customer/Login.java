package com.example.myevent.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myevent.Afterlogin;
import com.example.myevent.Common.Common;
//import com.example.myevent.EventPlanner.EventPlannerSignIn;
import com.example.myevent.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {


    EditText txt_Email,txt_Contact,txt_fname;
    Button btn_login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        txt_Email =(EditText)findViewById(R.id.txtEmail);
        txt_Contact =(EditText)findViewById(R.id.txtPassowrd);
        btn_login =(Button)findViewById(R.id.btnlogin);



        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_customer= database.getReference("customer");


    btn_login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            table_customer.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if(dataSnapshot.child(txt_Email.getText().toString()).exists()){
                        customer customer=dataSnapshot.child(txt_Email.getText().toString()).getValue(customer.class);

                        customer.setEmail(txt_Email.getText().toString());

                        if(customer.getPassowrd().equals(txt_Contact.getText().toString())){
                            Toast.makeText(Login.this,"Sign In Success",Toast.LENGTH_LONG).show();
                            Intent login = new Intent(Login.this,CustomerHome.class);
                            Common.currcustomer = customer;
                            startActivity(login);
                            finish();

                        }else{
                            Toast.makeText(Login.this,"Wrong Passowrd",Toast.LENGTH_LONG).show();
                        }



                    }
                    else{
                        Toast.makeText(Login.this,"User not exist Database",Toast.LENGTH_SHORT).show();
                    }





                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    });







    }

    public void forgotpw(View view){
        Intent intent=new Intent(this,Forgotpassword.class);

        startActivity(intent);

    }










}
