package com.example.drivoapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.example.drivoapp.fragment.FavoriteFragment;
import com.example.drivoapp.fragment.HomeFragment;
import com.example.drivoapp.fragment.NotificationFragment;
import com.example.drivoapp.fragment.ProfileFragment;
import com.example.drivoappui.R;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private Toolbar toolbar;
    private AnimatedBottomBar animatedBottomBar;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar();
        initViews(savedInstanceState);
        initNavComponent();
    }

    private void initNavComponent() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_profile:
                        Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_notification:
                        Toast.makeText(MainActivity.this, "Notifications", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_setting:
                        Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @SuppressLint("NonConstantResourceId")
    private void initViews(Bundle savedInstanceState) {

        animatedBottomBar = findViewById(R.id.animatedBottomBar);

        if (savedInstanceState == null) {
            animatedBottomBar.selectTabById(R.id.home, true);
            fragmentManager = getSupportFragmentManager();

            HomeFragment homeFragment = new HomeFragment();
            fragmentManager.beginTransaction().replace(R.id.fragmentContainer, homeFragment).commit();
        }

        animatedBottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int lastIndex, @Nullable AnimatedBottomBar.Tab lastTab,
                                      int newIndex, @NonNull AnimatedBottomBar.Tab newTab) {

                Fragment fragment = null;
                switch (newTab.getId()){

                    case R.id.home:
                        fragment = new HomeFragment();
                        break;

                    case R.id.favorite:
                        fragment = new FavoriteFragment();
                        break;

                    case R.id.notification:
                        fragment = new NotificationFragment();
                        break;

                    case R.id.profile:
                        fragment = new ProfileFragment();
                        break;
                }

                if (fragment!=null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
                }

            }

            @Override
            public void onTabReselected(int i, @NonNull AnimatedBottomBar.Tab tab) {}

        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setToolbarNavigationClickListener(view -> drawer.openDrawer(GravityCompat.START));
        toggle.setHomeAsUpIndicator(R.drawable.ic_drawer);
        toggle.syncState();
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(0);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.END);
        }else
        super.onBackPressed();
    }
}