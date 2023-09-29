package com.assistant.hrms_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class ProfilePage extends AppCompatActivity {

    Button asset_apply,leave_apply;
    androidx.appcompat.widget.Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        asset_apply = findViewById(R.id.asset_apply);
        leave_apply = findViewById(R.id.leave_apply);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationview);
        drawerLayout = findViewById(R.id.drawerLayout);

        //Asset apply button
        asset_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilePage.this, AssetPopUp.class);
                startActivity(intent);

            }
        });
        //leave apply button
        leave_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilePage.this, PopUpLeave.class);
                startActivity(intent);
            }
        });

        //setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Dashboard");
        }


//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_open, R.string.navigation_close);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.navigation_bar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId=item.getItemId();
        if(itemId ==  R.id.home1)
        {
            Toast.makeText(this,"Home CLicked",Toast.LENGTH_SHORT);
        } else if (itemId == R.id.setting) {
            Toast.makeText(this,"Settings open", Toast.LENGTH_SHORT);
        }else if(itemId == android.R.id.home)
        {
            super.onBackPressed();
        }
        else
        {
            Toast.makeText(this,"Logout clicked",Toast.LENGTH_SHORT);
        }

        return super.onOptionsItemSelected(item);
    }
}



//// 1.That cirle of chart not showing
////2. HRMS application name on navigation bar
////3.three lines in right upper corner not opening
//// 4. Rename profile heading to Dashboard