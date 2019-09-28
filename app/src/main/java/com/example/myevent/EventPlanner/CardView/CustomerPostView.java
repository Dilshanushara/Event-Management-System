package com.example.myevent.EventPlanner.CardView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myevent.Common.Common;
import com.example.myevent.EventPlanner.ConfirmForm;
import com.example.myevent.EventPlanner.EventPlannerWelcomePage;
import com.example.myevent.Interface.ItemClickListener;
import com.example.myevent.Model.CustomerPost;
import com.example.myevent.Model.EventPlanner;
import com.example.myevent.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustomerPostView extends AppCompatActivity {


    RecyclerView mBlogList;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mDatabase;
    FirebaseRecyclerAdapter<CustomerPost,CustomerPostHolder> firebaseRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_post_view);




        mBlogList=(findViewById(R.id.myrecycleview));
        mBlogList.setHasFixedSize(true);

        mBlogList.setLayoutManager(new LinearLayoutManager(this));


        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabase =mFirebaseDatabase.getReference("Customerpost");
        mDatabase.keepSynced(true);
    }


    @Override
    protected void onStart() {
        super.onStart();

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<CustomerPost, CustomerPostHolder>(CustomerPost.class,R.layout.blogrow,CustomerPostHolder.class,mDatabase) {
            @Override
            protected void populateViewHolder(CustomerPostHolder customerPostHolder, final CustomerPost customerPost, int i) {
                customerPostHolder.setTitle(customerPost.getName());
                customerPostHolder.setDesc(customerPost.getDescription());
                customerPostHolder.setImage(getApplicationContext(),customerPost.getImage());


                customerPostHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Intent myIntent = new Intent(CustomerPostView.this, ConfirmForm.class);
                        myIntent.putExtra("position",firebaseRecyclerAdapter.getRef(position).getKey());
                        startActivity(myIntent);

                    }
                });


            }
        };

        mBlogList.setAdapter(firebaseRecyclerAdapter);
    }
}
