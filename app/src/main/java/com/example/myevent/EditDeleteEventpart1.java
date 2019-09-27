package com.example.myevent;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.Toolbar;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class EditDeleteEventpart1 extends AppCompatActivity {

    Toolbar mtoolbar;
    private Button b,button;
    DatabaseReference dbref;


    String ename, eplace;
    EditText txt_place, txt_name,txt_type;


    RadioGroup radio_type;



    RadioButton Etypeoption;


    String streventtype;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete_eventpart1);


       // mtoolbar = findViewById(R.id.toolbar);
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

        //   mtoolbar.setTitle(bundle.getString("ename"));


            final String tempholder= getIntent().getStringExtra("clickid").toString();

            button=findViewById(R.id.button);



                dbref =FirebaseDatabase.getInstance().getReference().child("Events").child(tempholder);

                dbref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        if (dataSnapshot.hasChildren()){
                            txt_name.setText(dataSnapshot.child("ename").getValue().toString());


                            txt_place.setText(dataSnapshot.child("place").getValue().toString());
                        //    txt_type.setText(dataSnapshot.child("type").getValue());
                            //txt_num.setText(dataSnapshot.child("num").getValue().toString());


                        }



                        else{
                            Toast.makeText(getApplicationContext(),"No values to retrieve",Toast.LENGTH_LONG).show();
                        }



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {






                    }
                });


        b = (Button) findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                boolean validation =validation();

                if (validation==true) {

                    openeditdeletepart2();

                }


            }


        });
    }

    private void openeditdeletepart2() {


        final String id= getIntent().getStringExtra("clickid").toString();
        Intent i = new Intent(this, EditDeleteEventpart2.class);
        i.putExtra("clickid",id);
        i.putExtra("ename",txt_name.getText().toString());
        i.putExtra("eplace",txt_place.getText().toString());
        i.putExtra("radiotype", streventtype);
        startActivity(i);
    }


    public boolean validation(){
        final    String name=txt_name.getText().toString();

        String eventplace= txt_place.getEditableText().toString().trim();
        String eventname=txt_name.getEditableText().toString().trim();

        if(eventplace.isEmpty()) {
            txt_place.setError("Field can't be empty");
            return false;
        }

//
//        if (eventname != name){
//            txt_name.setError("can't change the event name");
//            return  false;
//        }



        else
            return true;

    }




}

