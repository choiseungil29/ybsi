package com.example.clogic.ybsi.Activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cengalabs.flatui.FlatUI;
import com.example.clogic.ybsi.R;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import at.markushi.ui.ActionView;
import at.markushi.ui.action.BackAction;
import at.markushi.ui.action.DrawerAction;


public class MainActivity extends ActionBarActivity {

    ListView lv_contents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_contents = (ListView) findViewById(R.id.lv_contents);

        LayoutInflater li = LayoutInflater.from(this);
        View customView = li.inflate(R.layout.actionbar, null);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        ab.setDisplayShowHomeEnabled(true);
        ab.setCustomView(customView);

        final ActionView actionView = (ActionView) findViewById(R.id.action);
        AccountHeader.Result header = new AccountHeader()
                .withActivity(this)
                .withHeaderBackground(R.mipmap.ic_launcher)
                .addProfiles(
                        new ProfileDrawerItem().withName("SeungIl Choi").withEmail("choiseungil29@gmail.com").setEnabled(false)
                ).withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public void onProfileChanged(View view, IProfile iProfile) {

                    }
                })
                .build();

        final Drawer.Result drawer = new Drawer().withActivity(this)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Hello!"),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem().withName("World!"),
                        new PrimaryDrawerItem().withName("Hello!"),
                        new SecondaryDrawerItem().withName("World!")
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {

                    }
                })
                .withAccountHeader(header)
                .withActionBarDrawerToggle(true)
                .withTranslucentStatusBar(false)
                .build();

        drawer.addItem(new SecondaryDrawerItem().withName("전체 보기"));

        FlatUI.initDefaultValues(this);
        FlatUI.setDefaultTheme(FlatUI.DEEP);
        FlatUI.setDefaultTheme(R.array.blood);

        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drawer.isDrawerOpen()) {
                    drawer.closeDrawer();
                    actionView.setAction(new DrawerAction(), ActionView.ROTATE_CLOCKWISE);
                } else {
                    drawer.openDrawer();
                    actionView.setAction(new BackAction(), ActionView.ROTATE_COUNTER_CLOCKWISE);
                }
            }
        });
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
}
