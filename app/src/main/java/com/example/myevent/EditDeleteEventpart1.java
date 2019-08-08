package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditDeleteEventpart1 extends AppCompatActivity {

    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete_eventpart1);


        b=(Button) findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                openeditdeletepart2();
            }


        });



    }

    private void openeditdeletepart2() {
        Intent i=new Intent(this, EditDeleteEvent.class);
        startActivity(i);


    }


}
