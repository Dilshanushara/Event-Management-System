package com.example.myevent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myevent.Model.edit_ad1;
import com.example.myevent.Model.event_details1;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class event_details extends AppCompatActivity {

    TextView txtName, txtVenue, txtDate, txtTime, txtEtype;
    DatabaseReference dbRef;
    com.example.myevent.Model.event_details1 Std1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        txtName = (TextView)findViewById(R.id.evname);
        txtVenue = (TextView)findViewById(R.id.evvenue);
        txtDate = (TextView)findViewById(R.id.evdate);
        txtTime = (TextView)findViewById(R.id.evtime);
        txtEtype = (TextView)findViewById(R.id.evtype);

        Std1 = new event_details1();

        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference("PostAdd1").child("event_details1").child("Std1");
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()){
                    txtName.setText(dataSnapshot.child("name").getValue().toString());
                    txtVenue.setText(dataSnapshot.child("venue").getValue().toString());
                    txtDate.setText(dataSnapshot.child("date").getValue().toString());
                    txtTime.setText(dataSnapshot.child("time").getValue().toString());
                    txtEtype.setText(dataSnapshot.child("eType").getValue().toString());
                }
                else
                    Toast.makeText(getApplicationContext(),"No Source to Display", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
