package com.example.myevent.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import com.example.myevent.EventPlanner.EventPlannerRegister1;
import com.example.myevent.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    EditText txt_fname,txt_lname,txt_email,txt_contact,txt_number;
    Button btn_signup;
    DatabaseReference dbR;
    customer customer;
   /*
    private ProgressDialog progressDialog;
    */




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



         /*
        progressDialog = new ProgressDialog(this);
         */

        txt_fname = findViewById(R.id.txtfname);
        txt_lname = findViewById(R.id.txtlname);
        txt_email = findViewById(R.id.txtfname);
        txt_contact = findViewById(R.id.txtpassword);
        txt_number = findViewById(R.id.txtnumber);

        btn_signup = findViewById(R.id.btnsignup);


        customer = new customer();

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbR = FirebaseDatabase.getInstance().getReference().child("customer");

                customer.setFname(txt_fname.getText().toString().trim());
                customer.setLname(txt_lname.getText().toString().trim());
                customer.setEmail(txt_email.getText().toString());
                customer.setPassowrd(txt_contact.getText().toString().trim());
                customer.setNumber(txt_number.getText().toString().trim());




                /*dbR.push().setValue("customer"); */
                dbR.child(txt_number.getText().toString()).setValue(customer);
                /*progressDialog.setMessage("Please Wait");
                progressDialog.show();

                 */

                Toast.makeText(getApplicationContext(),"Sign In Success", Toast.LENGTH_LONG).show();



                clearData();
            }


        });








    }
    public void register(View view){
        Intent intent=new Intent(this, Login.class);

        startActivity(intent);
    }


    private void clearData() {

        txt_fname.setText("");
        txt_lname.setText("");
        txt_email.setText("");
        txt_contact.setText("");
        txt_number.setText("");

    }
}
