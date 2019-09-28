//package com.example.myevent.EventPlanner;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.example.myevent.Common.Common;
//import com.example.myevent.R;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//public class EventPlannerUpdateEmail extends AppCompatActivity {
//
//    Button UpdateEmail;
//    EditText UpadteedttxtEmail;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_event_planner_update_email);
//
//
//
//
//        UpdateEmail= (Button)findViewById(R.id.btnchangeemail);
//
//        UpadteedttxtEmail =(EditText)findViewById(R.id.edttxtemail);
//
//        UpdateEmail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String email=UpadteedttxtEmail.getText().toString();
//
//
//
//
//
//
//                DatabaseReference updateData = FirebaseDatabase.getInstance().getReference("Eventplanner").child(Common.currenteventplanner.getPhone());
//
//
//                updateData.child("email").setValue(email);
//
//
//                Toast.makeText(EventPlannerUpdateEmail.this,"Update", Toast.LENGTH_SHORT).show();
//                Intent updateemail = new Intent(EventPlannerUpdateEmail.this, EventPlannerProfile.class);
//                Common.currenteventplanner.setEmail(email);
//                startActivity(updateemail);
//                finish();
//            }
//        });
//    }
//}
