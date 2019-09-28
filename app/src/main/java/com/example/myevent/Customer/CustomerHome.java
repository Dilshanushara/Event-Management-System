package com.example.myevent.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myevent.Common.Common;
import com.example.myevent.R;

public class CustomerHome extends AppCompatActivity {

    Button viewprofile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);


        viewprofile = (Button)findViewById(R.id.viewprofile);


        viewprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent login = new Intent(CustomerHome.this,CustomerProfile.class);
                startActivity(login);
                finish();
            }
        });
    }


}
