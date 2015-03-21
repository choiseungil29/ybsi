package com.example.clogic.ybsi.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.example.clogic.ybsi.R;

public class SplashActivity extends ActionBarActivity {

    private final int SPLASH_TIMEOUT = 3500;

    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        pref = this.getSharedPreferences("Stella", MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, ParentActivity.class);
                if(pref.getBoolean("signup", false)) {
                    i.putExtra("signup", true);
                } else {
                    i.putExtra("signup", false);
                }
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        }, SPLASH_TIMEOUT);

        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(1000);
        ImageView iv_first = (ImageView) findViewById(R.id.iv_first);
        iv_first.setAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation animation = new AlphaAnimation(0.0f, 1.0f);
                animation.setDuration(1000);
                ImageView iv_second = (ImageView) findViewById(R.id.iv_second);
                iv_second.setVisibility(View.VISIBLE);
                iv_second.setAnimation(animation);
            }
        }, 1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation animation = new AlphaAnimation(0.0f, 1.0f);
                animation.setDuration(1000);
                ImageView iv_second = (ImageView) findViewById(R.id.logo);
                iv_second.setVisibility(View.VISIBLE);
                iv_second.setAnimation(animation);
            }
        }, 500);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
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
}
