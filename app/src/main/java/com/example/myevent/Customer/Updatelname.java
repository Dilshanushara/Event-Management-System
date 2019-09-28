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

public class Updatelname extends AppCompatActivity {

    Button btnlname;
    EditText txtlastname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatelname);

        btnlname = (Button)findViewById(R.id.btnchsngeemail);
        txtlastname =(EditText)findViewById(R.id.txtemail);



        btnlname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lname=txtlastname.getText().toString();

                DatabaseReference updatedata = FirebaseDatabase.getInstance().getReference("customer").child(Common.currcustomer.getNumber());
                updatedata.child("lname").setValue("lname");

                Toast.makeText(Updatelname.this,"Change Last Name",Toast.LENGTH_LONG).show();
                Intent update = new Intent(Updatelname.this,CustomerProfile.class);
                Common.currcustomer.setLname(lname);
                startActivity(update);
                finish();
            }
        });

    }
}
