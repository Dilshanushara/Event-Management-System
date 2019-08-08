package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class evtwelcomepg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evtwelcomepg);
    }


    public void oncontinue(View view){
        Intent intent=new Intent(this,evtnavdraw.class);

        startActivity(intent);

    }
}
