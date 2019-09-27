package com.example.myevent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {


    private Button b,button;
    DatabaseReference dbref;
    String ename, eplace;
    EditText txt_place, txt_name,txt_type;
    RadioGroup radio_type;
    RadioButton Etypeoption;
    String streventtype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_name=findViewById(R.id.txtname);
        txt_place=findViewById(R.id.txtplace);

        radio_type =findViewById(R.id.radiotype);

        radio_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {


        Etypeoption= radio_type.findViewById(i);

        switch(i) {
            case R.id.radioButton:
                streventtype =  Etypeoption.getText().toString();
                break;


            case R.id.radioButton2:
                streventtype =  Etypeoption.getText().toString();
                break;

            case R.id.radioButton3:
                streventtype =  Etypeoption.getText().toString();
                break;

            case R.id.radioButton4:
                streventtype =  Etypeoption.getText().toString();
                break;
            default:


        }
    }
});

        b=(Button) findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {


                boolean validation = validation();

                if (validation == true) {

                    openaddevent2();
                }
            }
        });


    }

    public void openaddevent2() {

        Intent i=new Intent(this, Addevent2.class);

        i.putExtra("ename",txt_name.getText().toString());
        i.putExtra("eplace",txt_place.getText().toString());
        i.putExtra("radiotype", streventtype);
        startActivity(i);
    }

    public boolean validation(){
        final    String name=txt_name.getText().toString();

        String eventplace= txt_place.getEditableText().toString().trim();
        String eventname=txt_name.getEditableText().toString().trim();

        if(eventname.isEmpty()) {
            txt_name.setError("Field can't be empty");
            return false;
        }
        else if(eventplace.isEmpty()){
            txt_place.setError("Field can't be empty");
            return  false;
        }
        else
            return true;

    }

}






