package com.example.myevent;
import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class post_ad extends AppCompatActivity {

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
        setContentView(R.layout.activity_post_ad);


        txtName = findViewById(R.id.EtName);
        txtDes = findViewById(R.id.EtDes);
        txtEmail = findViewById(R.id.EtEmail);
        txtConNo = findViewById(R.id.EtConNo);

        btnSave = findViewById(R.id.btnPost);
        btnCancel = findViewById(R.id.cancel);

        std = new edit_ad1();


        Button buttonOne = (Button) findViewById(R.id.btnPost);
        buttonOne.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbRef = FirebaseDatabase.getInstance().getReference().child("edit_ad1");

                try {
                    if (TextUtils.isEmpty(txtName.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter Name", Toast.LENGTH_SHORT).show();

                    else if (TextUtils.isEmpty(txtDes.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter Description", Toast.LENGTH_LONG).show();

                    else if (TextUtils.isEmpty(txtEmail.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter Email", Toast.LENGTH_SHORT).show();

                    else {
                        std.setName(txtName.getText().toString().trim());
                        std.setDescription(txtDes.getText().toString().trim());
                        std.setEmail(txtEmail.getText().toString().trim());
                        std.setConNo(Integer.parseInt(txtConNo.getText().toString().trim()));

                        dbRef.push().setValue(std);

                        Toast.makeText(getApplicationContext(), "Posted", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_SHORT).show();
                }
            }


        });
    }

    private void openafterpostad() {           //create a method to open a the next activity
        Intent i = new Intent(this, select_ad.class);
        startActivity(i);
    }

}