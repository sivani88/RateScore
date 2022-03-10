package com.example.ratescore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class FragmentActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
    Toolbar mToolbar;
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
       replaceFragment(new FriendsFragment());

    }
    //Bottom toolbar implementation
    public void getSetonClickListenerBottom() {
        BottomNavigationView bottomNav = findViewById(R.id.bottom);
        bottomNav.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.people:
                    replaceFragment(new FriendsFragment());
                    break;
                case R.id.list:
                    replaceFragment(new ChatFragment());
                    break;
                case R.id.workmates:
                    replaceFragment(new ScoreFragment());
                    break;
                case R.id.Profile:
                    break;
            }

            return true;
        });

    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.framelayout, fragment);
        mFragmentTransaction.commit();
    }
}