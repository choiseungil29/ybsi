package com.example.clogic.ybsi.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.cengalabs.flatui.FlatUI;
import com.example.clogic.ybsi.Fragment.ContentAddFragment;
import com.example.clogic.ybsi.Fragment.MainFragment;
import com.example.clogic.ybsi.R;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import at.markushi.ui.ActionView;
import at.markushi.ui.action.BackAction;
import at.markushi.ui.action.DrawerAction;


public class ParentActivity extends ActionBarActivity {

    private ActionView actionView;
    private Fragment nowFragment = null;

    private Button btn_addItem = null;

    private Drawer.Result drawer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);

        LayoutInflater li = LayoutInflater.from(this);
        View customView = li.inflate(R.layout.actionbar, null);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        ab.setDisplayShowHomeEnabled(true);
        ab.setCustomView(customView);
        ab.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar));
        Toolbar parent = (Toolbar)customView.getParent();
        parent.setContentInsetsAbsolute(0, 0);

        actionView = (ActionView) findViewById(R.id.action);
        AccountHeader.Result header = new AccountHeader()
                .withActivity(this)
                .withHeaderBackground(R.mipmap.background)
                .addProfiles(
                        new ProfileDrawerItem()
                                .withName("SeungIl Choi")
                                .withEmail("choiseungil29@gmail.com")
                                .withIcon(getResources().getDrawable(R.drawable.stellars7))
                )
                .build();

        drawer = new Drawer().withActivity(this)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("시간순").withIcon(getResources().getDrawable(R.drawable.time)),
                        new PrimaryDrawerItem().withName("여가생활").withIcon(getResources().getDrawable(R.drawable.rest)),
                        new PrimaryDrawerItem().withName("기념일").withIcon(getResources().getDrawable(R.drawable.good)),
                        new PrimaryDrawerItem().withName("사랑").withIcon(getResources().getDrawable(R.drawable.love)),
                        new PrimaryDrawerItem().withName("친구와").withIcon(getResources().getDrawable(R.drawable.friends)),
                        new PrimaryDrawerItem().withName("가족과").withIcon(getResources().getDrawable(R.drawable.family)),
                        new PrimaryDrawerItem().withName("테스트!").withIcon(getResources().getDrawable(R.drawable.family))
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l, IDrawerItem iDrawerItem) {
                        switch (position) {
                            case 0:
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                        }
                    }
                })
                .withAccountHeader(header)
                .withActionBarDrawerToggle(true)
                .withTranslucentStatusBar(false)
                .build();

        FlatUI.initDefaultValues(this);
        FlatUI.setDefaultTheme(FlatUI.DEEP);
        FlatUI.setDefaultTheme(R.array.blood);

        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nowFragment instanceof MainFragment) {
                    if(drawer.isDrawerOpen()) {
                        drawer.closeDrawer();
                    } else {
                        drawer.openDrawer();
                    }
                    return;
                }

                changeFragment(new MainFragment());
            }
        });

        btn_addItem = (Button) findViewById(R.id.addItem);

        changeFragment(new MainFragment());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        nowFragment = fragment;

        if(nowFragment instanceof MainFragment) {
            actionView.setAction(new DrawerAction(), ActionView.ROTATE_CLOCKWISE);
            btn_addItem.setBackgroundResource(R.drawable.btn_write);
            btn_addItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawer.closeDrawer();
                    changeFragment(new ContentAddFragment());
                }
            });
        } else {
            actionView.setAction(new BackAction(), ActionView.ROTATE_COUNTER_CLOCKWISE);
        }

        if(nowFragment instanceof ContentAddFragment) {
            //btn_addItem.setText("확정");
            btn_addItem.setBackgroundResource(R.drawable.btn_ok);
            //btn_addItem.setBackgroundResource(R.dra);
            btn_addItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 여기에 DB에 집어넣는다
                    drawer.closeDrawer();
                    changeFragment(new MainFragment());
                }
            });
        }

        transaction.replace(R.id.fl_container, nowFragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        actionView.setAction(new DrawerAction(), ActionView.ROTATE_CLOCKWISE);
    }
}
