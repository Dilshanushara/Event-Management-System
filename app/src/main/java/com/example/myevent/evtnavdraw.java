package com.example.myevent;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

public class evtnavdraw extends AppCompatActivity
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





                messagev = (CardView) findViewById(R.id.message1234);

                postadd = (CardView) findViewById(R.id.Post);

                cutomerpost= (CardView) findViewById(R.id.custom);

                notificationv1 = (CardView) findViewById(R.id.notification34);


                messagev.setOnClickListener(this);
                notificationv1.setOnClickListener(this);
                postadd.setOnClickListener(this);
                cutomerpost.setOnClickListener(this);




    }




    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){


            case R.id.Post : i =new Intent(this,evtpost.class);startActivity(i);break;


            case R.id.custom : i =new Intent(this,evtcust.class);startActivity(i);break;




           case R.id.message1234 : i =new Intent(this,evtmessage123.class);startActivity(i);break;


            case R.id.notification34 : i =new Intent(this,evtnotification456.class);startActivity(i);break;




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


        } else if (id == R.id.nav_profile) {

            Intent intent=new Intent(this,evtprofile.class);

            startActivity(intent);



        }else if (id == R.id.nav_share) {


        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
















}
