package com.example.chatting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.chatting.chatting.chatting_Fragment;
import com.example.chatting.friends.friends_Fragment;
import com.example.chatting.search.search_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navigationView;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private friends_Fragment friends_fragment = new friends_Fragment();
    private chatting_Fragment chatting_fragment = new chatting_Fragment();
    private search_Fragment search_fragment = new search_Fragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction1 = fragmentManager.beginTransaction();
        transaction1.replace(R.id.frameLayout, friends_fragment).commitAllowingStateLoss();

        navigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                switch(menuItem.getItemId())
                {
                    case R.id.friends_menu:
                        transaction.replace(R.id.frameLayout, friends_fragment).commitAllowingStateLoss();
                        break;
                    case R.id.chatting_menu:
                        transaction.replace(R.id.frameLayout, chatting_fragment).commitAllowingStateLoss();
                        break;
                    case R.id.search_menu:
                        transaction.replace(R.id.frameLayout, search_fragment).commitAllowingStateLoss();
                        break;
                }
                return true;
            }
        });
    }
}