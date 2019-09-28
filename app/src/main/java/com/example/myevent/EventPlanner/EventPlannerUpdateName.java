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
//public class EventPlannerUpdateName extends AppCompatActivity {
//
//    Button UpdateName;
//    EditText edttxtname;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_update_name);
//
//
//        UpdateName= (Button)findViewById(R.id.btnchangename);
//
//        edttxtname =(EditText)findViewById(R.id.edttxtname);
//
//
//        UpdateName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String name=edttxtname.getText().toString();
//
//
//
//
//
//
//                DatabaseReference updateData = FirebaseDatabase.getInstance().getReference("Eventplanner").child(Common.currenteventplanner.getPhone());
//
//
//                updateData.child("name").setValue(name);
//
//
//                Toast.makeText(EventPlannerUpdateName.this,"Update", Toast.LENGTH_SHORT).show();
//
//                Intent updatename = new Intent(EventPlannerUpdateName.this, EventPlannerProfile.class);
//                Common.currenteventplanner.setName(name);
//                startActivity(updatename);
//                finish();
//
//
//
//            }
//        });
//
//
//
//    }
//}
