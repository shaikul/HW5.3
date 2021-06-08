package com.example.myapplication23;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HomeFragment homeFragment = new  HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).addToBackStack("Home").commit();
        bottomNavigationView = findViewById(R.id.bottom_nav_view);
        NotificationFragment notificationFragment = new  NotificationFragment();
        SettingsFragment settingsFragment = new  SettingsFragment();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                getSupportActionBar().setTitle(item.getTitle());
                switch (item.getItemId()){
                    case R.id.notification :
                        openFragment(notificationFragment);
                        break;
                    case R.id.home :
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).addToBackStack("Home").commit();
                        break;
                    case R.id.settings :
                        openFragment(settingsFragment);
                        break;
                }
                return true;
            }
        });

    }

    private void openFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }

}