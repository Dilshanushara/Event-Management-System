package com.example.myevent.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myevent.R;

public class forgotpassword1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword1);
    }

    public void done(View view){
        Intent intent=new Intent(this,Login.class);

        startActivity(intent);

    }
}
