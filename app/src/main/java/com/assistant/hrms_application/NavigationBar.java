//package com.assistant.hrms_application;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.ActionBarDrawerToggle;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import androidx.core.view.GravityCompat;
//import androidx.drawerlayout.widget.DrawerLayout;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentTransaction;
//
//import com.google.android.material.navigation.NavigationView;
//
//public class NavigationBar extends AppCompatActivity {
//
//    DrawerLayout drawerLayout;
//    NavigationView navigationView;
//    Toolbar toolbar;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        //setContentView(R.layout.navigation_bar);
//
//        drawerLayout=findViewById(R.id.drawerLayout);
//        //navigationView=findViewById(R.id.navigationView);
//        toolbar=findViewById(R.id.toolbar);
//
//        //setSupportActionBar(toolbar);
//       // ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.OpenDrawer,R.string.CloseDrawer);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//        loadFragment(new Fragment() );//load default fragment
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int id=item.getItemId();
//                if(id==R.id.DashBoard){
//                    loadFragment(new Fragment());
//
//                }
//                else if(id==R.id.Leaves){
//                    Toast.makeText(NavigationBar.this, "This page is for leaves", Toast.LENGTH_SHORT).show();
//
//                }
//                else if(id==R.id.Assets){
//                    Toast.makeText(NavigationBar.this, "this page is for asset", Toast.LENGTH_SHORT).show();
//
//                }
//                else if(id==R.id.Attendance){
//                    Toast.makeText(NavigationBar.this, "this is for attendance", Toast.LENGTH_SHORT).show();
//
//                }
//                drawerLayout.closeDrawer(GravityCompat.END);
//
//
//                return true;
//
//            }
//        });
//    }
//
//    private void loadFragment(Fragment Fragment) {
//
//        FragmentManager fm=getSupportFragmentManager();
//        FragmentTransaction ft=fm.beginTransaction();
//        Fragment fragment = null;
//        ft.add(R.id.card_view,fragment);
//        ft.commit();
//    }
//
//    @Override
//    public void onBackPressed(){
//        if(drawerLayout.isDrawerOpen(GravityCompat.END))
//        {
//            drawerLayout.closeDrawer(GravityCompat.END);
//
//        }
//        else{
//            super.onBackPressed();
//        }
//    }
//}
