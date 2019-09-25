package com.example.myevent.EventPlanner;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.example.myevent.R;
import com.example.myevent.event_details;
import com.example.myevent.post_ad;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class EventNavigationBar extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener
{
    private CardView messagev,notificationv1,postadd,cutomerpost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evtnavdraw);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);





                messagev = (CardView) findViewById(R.id.message12345);

                postadd = (CardView) findViewById(R.id.Post1);

                cutomerpost= (CardView) findViewById(R.id.custom1);

                notificationv1 = (CardView) findViewById(R.id.notification345);


                messagev.setOnClickListener(this);
                notificationv1.setOnClickListener(this);
                postadd.setOnClickListener(this);
                cutomerpost.setOnClickListener(this);




    }




    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){


            case R.id.Post1 : i =new Intent(this, post_ad.class);startActivity(i);break;


            case R.id.custom1 : i =new Intent(this, EventPlannerCustomerPost.class);startActivity(i);break;




           case R.id.message12345 : i =new Intent(this, EventPlannerMessage.class);startActivity(i);break;


            case R.id.notification345 : i =new Intent(this, evtnotification4567.class);startActivity(i);break;




            default:break;


        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.evtnavdraw, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_adds) {

                Intent intent = new Intent(this, event_details.class);

                startActivity(intent);





        } else if (id == R.id.nav_profile) {

            Intent intent = new Intent(this, EventProfile.class);

            startActivity(intent);



        }else if (id == R.id.nav_share) {


        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public static class evtnotification4567 extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_evtnotification4567);
        }
    }
}
