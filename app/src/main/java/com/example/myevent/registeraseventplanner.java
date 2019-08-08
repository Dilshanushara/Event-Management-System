package com.example.myevent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class registeraseventplanner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeraseventplanner);
    }


    public void sendNext(View view){
        Intent intent=new Intent(this,registeraseventplanner2.class);

        startActivity(intent);

    }

}
