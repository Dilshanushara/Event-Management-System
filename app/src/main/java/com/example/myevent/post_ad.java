package com.example.myevent;


import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myevent.Model.edit_ad1;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class post_ad extends AppCompatActivity {

    EditText txtName, txtDes, txtEmail, txtConNo;
    Button btnSave, btnCancel;
    DatabaseReference dbRef;
    com.example.myevent.Model.edit_ad1 edit_ad1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_ad);

        txtName = findViewById(R.id.EtName);
        txtDes = findViewById(R.id.EtDes);
        txtEmail = findViewById(R.id.EtEmail);
        txtConNo = findViewById(R.id.EtConNo);


        btnSave = findViewById(R.id.btnPost);
        btnCancel = findViewById(R.id.cancel);

        edit_ad1 = new edit_ad1();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



        dbRef = FirebaseDatabase.getInstance().getReference().child("edit_ad1");

        edit_ad1.setName(txtName.getText().toString().trim());
        edit_ad1.setDescription(txtDes.getText().toString().trim());
        edit_ad1.setEmail(txtEmail.getText().toString().trim());
        edit_ad1.setConNo(Integer.parseInt(txtConNo.getText().toString().trim()));


        dbRef.child(edit_ad1.getName()).setValue("edit_ad1");
        Toast.makeText(getApplicationContext(),"Adding success",Toast.LENGTH_SHORT).show();
        clearData();


            }
        });
}
    private void clearData() {

        txtName.setText("");
        txtDes.setText("");
        txtEmail.setText("");
        txtConNo.setText("");
    }
        }