package com.github.jasonwangdev.signaturepad.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        MainFragment mainFragment = (MainFragment) fm.findFragmentByTag("MainFragment");
        if (null == mainFragment)
            mainFragment = new MainFragment();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.layout, mainFragment, "MainFragment");
        ft.commit();
    }

}
