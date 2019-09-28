//package com.example.myevent.EventPlanner;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.myevent.Common.Common;
//import com.example.myevent.Customer.UpdateName;
//import com.example.myevent.R;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//public class EventProfile extends AppCompatActivity {
//
//    Button btndeactivate,btneditname;
//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    final DatabaseReference tabel_eventplanner=database.getReference("Eventplanner");
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_evtprofile);
//
//
//                TextView ProfileName = (TextView)findViewById(R.id.txtfname);
//                ProfileName.setText(Common.currenteventplanner.getName());
//
//                TextView Profileemail = (TextView)findViewById(R.id.txtemail);
//                Profileemail.setText(Common.currenteventplanner.getEmail());
//
//                TextView Profilenumber = (TextView)findViewById(R.id.txtnumber);
//                Profilenumber.setText(Common.currenteventplanner.getPhone());
//
//                TextView ProfileAge = (TextView)findViewById(R.id.txtlname);
//                ProfileAge.setText(Common.currenteventplanner.getAge());
//
//                TextView Profiledescription = (TextView)findViewById(R.id.Profiledescription);
//                Profiledescription.setText(Common.currenteventplanner.getDescription());
//
//
//        btndeactivate = (Button)findViewById(R.id.btndeactivate);
//        btneditname= (Button)findViewById(R.id.btnfname);
//
//
//
//
//
//        btndeactivate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                tabel_eventplanner.child(Common.currenteventplanner.getPhone()).removeValue();
//                Toast.makeText(EventProfile.this,"Deleteted!",Toast.LENGTH_SHORT).show();
//                Intent delete = new Intent(EventProfile.this,EventPlannerRegister1.class);
//                Common.currenteventplanner = null;
//                startActivity(delete);
//                finish();
//
//            }
//        });
//
//        btneditname.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent changename = new Intent(EventProfile.this, UpdateName.class);
//                startActivity(changename);
//                finish();
//
//            }
//        });
//
//
//
//
//
//    }
//}
