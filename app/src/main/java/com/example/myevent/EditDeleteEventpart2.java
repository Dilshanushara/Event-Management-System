package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditDeleteEventpart2 extends AppCompatActivity {

    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete_eventpart2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        b=(Button) findViewById(R.id.button6);

        b.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                openmyallevent();
            }


        });


        b=(Button) findViewById(R.id.button8);

        b.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                openmyallevent();
            }


        });





    }

    private void openmyallevent() {

        Intent i=new Intent(this, Myallevents.class);
        startActivity(i);
    }
}
