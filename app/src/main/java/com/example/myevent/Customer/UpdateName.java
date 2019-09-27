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

public class UpdateName extends AppCompatActivity {

    Button UpdateName;
    EditText txtfname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_name);

        UpdateName = (Button)findViewById(R.id.btnlname);
        txtfname = (EditText) findViewById(R.id.txtlastname);


        UpdateName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String name=txtfname.getText().toString();


                DatabaseReference updateData = FirebaseDatabase.getInstance().getReference("customer").child(Common.currcustomer.getNumber());

                updateData.child("name").setValue(name);

                Toast.makeText(UpdateName.this,"Change name",Toast.LENGTH_LONG).show();
                Intent updated = new Intent(UpdateName.this, CustomerProfile.class);
                Common.currcustomer.setFname(name);
                startActivity(updated);
                finish();
            }
        });




    }
}
