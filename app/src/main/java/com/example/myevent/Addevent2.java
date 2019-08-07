package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Addevent2 extends AppCompatActivity {

    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addevent2);


        b=(Button) findViewById(R.id.button2);

        b.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                openafteraddevent();
            }


        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void openafteraddevent() {
        Intent i=new Intent(this, Aftereventadded.class);
        startActivity(i);


    }
}
