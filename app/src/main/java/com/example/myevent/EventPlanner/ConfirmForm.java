package com.example.myevent.EventPlanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myevent.Model.Confirm;
import com.example.myevent.Model.EventPlanner;
import com.example.myevent.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfirmForm extends AppCompatActivity {

    Button btnEventPlannerNext;
    EditText evtDescription,evtPrice,evtContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(
                R.layout.activity_confirm_form);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference tabel_confirm=database.getReference("ConfirmOrder");

        btnEventPlannerNext = (Button)findViewById(R.id.BtnConfirm);


        btnEventPlannerNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                evtDescription=(EditText)findViewById(R.id.evtDescription);
                evtPrice=(EditText)findViewById(R.id.evtPrice);
                evtContact=(EditText)findViewById(R.id.evtNumber);




                Confirm confirm = new Confirm(evtDescription.getText().toString(),evtPrice.getText().toString(),evtContact.getText().toString() );
                tabel_confirm.child(evtContact.getText().toString()).setValue(confirm);

                Intent signIn = new Intent(ConfirmForm.this, EventNavigationBar.class);
                Toast.makeText(ConfirmForm.this, "Order is Confirmed", Toast.LENGTH_SHORT).show();
                startActivity(signIn);
                finish();


            }
        });
    }


}
