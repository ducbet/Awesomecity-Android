package com.framgia.awesomecity.screen;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by tmd on 19/07/2017.
 */

public class BaseActivity extends AppCompatActivity {
    public void removeTittleBar() {
        getSupportActionBar().hide();
    }
}
