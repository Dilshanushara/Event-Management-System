package com.example.myevent.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myevent.Afterlogin;
import com.example.myevent.Common.Common;
import com.example.myevent.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustomerProfile extends AppCompatActivity {

    Button btndeactivate,btnfname,btnlname,btnemail,btnnumber,btnSave;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference tabel_customer=database.getReference("customer");
    DatabaseReference dbRef;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile);



        TextView ProfileName = (TextView)findViewById(R.id.txtfname);
        ProfileName.setText(Common.currcustomer.getFname());

        TextView Profileemail = (TextView)findViewById(R.id.txtfname);
        Profileemail.setText(Common.currcustomer.getEmail());

        TextView Profilenumber = (TextView)findViewById(R.id.txtnumber);
        Profilenumber.setText(Common.currcustomer.getNumber());

        TextView Profilname = (TextView)findViewById(R.id.txtlname);
        Profilname.setText(Common.currcustomer.getLname());


        //Delete Customer

        btndeactivate = (Button)findViewById(R.id.btndeactivate);
        btnfname= (Button)findViewById(R.id.btnfname);
        btnlname= (Button)findViewById(R.id.btnchsngeemail);
        btnemail= (Button)findViewById(R.id.btnemail);
        btnnumber= (Button)findViewById(R.id.btnnumber);
        btnSave = (Button)findViewById(R.id.btnSave);


        btndeactivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tabel_customer.child(Common.currcustomer.getNumber()).removeValue();
                Toast.makeText(CustomerProfile.this,"Deleteted!",Toast.LENGTH_SHORT).show();
                Intent delete = new Intent(CustomerProfile.this, Home.class);
                Common.currcustomer = null;
                startActivity(delete);
                finish();
            }
        });

        btnfname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent changename = new Intent(CustomerProfile.this, UpdateName.class);
                startActivity(changename);
                finish();
            }
        });
        btnlname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent changelname = new Intent(CustomerProfile.this,Updatelname.class);
                startActivity(changelname);
                finish();
            }
        });
        btnemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent changeemail = new Intent(CustomerProfile.this,UpdateEmail.class);
                startActivity(changeemail);
                finish();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent saveupdate = new Intent(CustomerProfile.this, Afterlogin.class);
                startActivity(saveupdate);
                finish();


            }
        });

    }

}
