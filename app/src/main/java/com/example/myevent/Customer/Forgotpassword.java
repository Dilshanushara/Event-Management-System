package com.example.myevent.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myevent.R;

public class Forgotpassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
    }
    public void submit(View view){
        Intent intent=new Intent(this,forgotpassword1.class);

        startActivity(intent);

    }
}
