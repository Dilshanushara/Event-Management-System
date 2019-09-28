package com.example.myevent.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myevent.Common.Common;
import com.example.myevent.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class UpdateEmail extends AppCompatActivity {


    Button btnchsngeemail;
    EditText txtemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_email);

        btnchsngeemail = (Button) findViewById(R.id.btnchsngeemail);
        txtemail = (EditText) findViewById(R.id.txtemail);

        btnchsngeemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email=txtemail.getText().toString();

                DatabaseReference updateData = FirebaseDatabase.getInstance().getReference("customer").child(Common.currcustomer.getNumber());
                updateData.child("email").setValue("email");

                Toast.makeText(UpdateEmail.this,"Change Email",Toast.LENGTH_LONG).show();
                Intent update1 = new Intent(UpdateEmail.this,CustomerProfile.class);
                Common.currcustomer.setEmail(email);
                startActivity(update1);
                finish();


            }
        });




    }
}