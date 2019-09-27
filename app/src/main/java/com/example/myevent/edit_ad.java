package com.example.myevent;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myevent.Model.edit_ad1;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class edit_ad extends AppCompatActivity {

    EditText txtName, txtDes, txtEmail, txtConNo;
    Button btnSave, btnCancel;
    DatabaseReference dbRef;
    com.example.myevent.Model.edit_ad1 edit_ad1;

/*Update*/

    Button buttonOne = (Button) findViewById(R.id.btnUpSave);
        buttonOne.setOnClickListener(new Button.OnClickListener() {
        public void onClick(final View v) {


            DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("edit_ad1");
            updRef.addListenerForSingleValueEvent (new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if (dataSnapshot.hasChild("Std1")) {

                        try {
                            edit_ad1.setName(txtName.getText().toString().trim());
                            edit_ad1.setDescription(txtDes.getText().toString().trim());
                            edit_ad1.setEmail(txtEmail.getText().toString().trim());
                            edit_ad1.setConNo(Integer.parseInt(txtConNo.getText().toString().trim()));

                            dbRef = FirebaseDatabase.getInstance().getReference().child("std");
                            dbRef.setValue(edit_ad1);
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

/* Delete */

DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("edit_ad1");
delRef.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot){
        if(dataSnapshot.hasChild("edit_ad1")){
        dbRef=FirebaseDatabase.getInstance().getReference().child("edit_ad1").child("edit_ad1");
        dbRef.removeValue();
        clearControls();
        Toast.makeText(getApplicationContext()."Data deleted Successfully",Toast.LENGTH_SHORT).show();
        }

        else
        Toast.makeText(getApplicationContext(),"No Source to Delete",Toast.LENGTH_SHORT).show();
        }

        @Override
public void onCancelled(@NonNull DatabaseError databaseError){

        }

        });

        }

        }