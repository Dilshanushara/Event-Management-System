package com.example.myevent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class edit_ad extends AppCompatActivity {

    EditText txtName, txtDes, txtEmail, txtConNo;
    Button btnSave, btnCancel;
    DatabaseReference dbRef;
    edit_ad1 std;

    private void clearControls() {

        txtName.setText("");
        txtDes.setText("");
        txtEmail.setText("");
        txtConNo.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ad);

        txtName = findViewById(R.id.txtUpName);
        txtDes = findViewById(R.id.txtUpDes);
        txtEmail = findViewById(R.id.txtUpEmail);
        txtConNo = findViewById(R.id.txtUpConNo);

        btnSave = findViewById(R.id.btnUpSave);
        btnCancel = findViewById(R.id.btnUpCancel);

        std = new edit_ad1();


    Button buttonOne = (Button) findViewById(R.id.btnUpSave);
        buttonOne.setOnClickListener(new Button.OnClickListener() {
        public void onClick(final View v) {


            DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("edit_ad1");
            updRef.addListenerForSingleValueEvent (new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if (dataSnapshot.hasChild("Std1")) {

                        try {
                            std.setName(txtName.getText().toString().trim());
                            std.setDescription(txtDes.getText().toString().trim());
                            std.setEmail(txtEmail.getText().toString().trim());
                            std.setConNo(Integer.parseInt(txtConNo.getText().toString().trim()));

                            dbRef = FirebaseDatabase.getInstance().getReference().child("std");
                            dbRef.setValue(std);
                            clearControls();

                            Toast.makeText(getApplicationContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();

                        } catch (NumberFormatException e) {
                            Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_SHORT).show();

                        }
                    } else
                        Toast.makeText(getApplicationContext(), "No Source to Update", Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            }}
            });
        }
            private void openaftereditad() {           //create a method to open a the next activity
                Intent i = new Intent(this, select_ad.class);
                startActivity(i);
        }

    }

