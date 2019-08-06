package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b=(Button) findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                openaddevent2();
            }


        });


        }

    private void openaddevent2() {

        Intent i=new Intent(this, Addevent2.class);
        startActivity(i);
    }

}





