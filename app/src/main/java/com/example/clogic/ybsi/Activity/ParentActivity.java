package com.example.clogic.ybsi.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
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
import com.example.clogic.ybsi.Data.Answer;
import com.example.clogic.ybsi.Data.AnswerData;
import com.example.clogic.ybsi.Data.PDFMaker;
import com.example.clogic.ybsi.Data.Question;
import com.example.clogic.ybsi.Dialog.MessageDialog;
import com.example.clogic.ybsi.Fragment.ContentAddFragment;
import com.example.clogic.ybsi.Fragment.MainFragment;
import com.example.clogic.ybsi.Fragment.SignupFragment;
import com.example.clogic.ybsi.R;
import com.example.clogic.ybsi.Util.Birth;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.io.File;
import java.util.Date;

import at.markushi.ui.ActionView;
import at.markushi.ui.action.BackAction;
import at.markushi.ui.action.DrawerAction;


public class ParentActivity extends ActionBarActivity {

    private ActionView actionView;
    private Fragment nowFragment = null;

    private Button btn_addItem = null;

    private Drawer.Result drawer = null;

    private SharedPreferences pref;

    @Override
                protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_parent);

                    pref = this.getSharedPreferences("Stella", MODE_PRIVATE);

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
                                            .withName(pref.getString("name", "None"))
                                            .withEmail(pref.getString("email", "None"))
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
                                    new DividerDrawerItem(),
                                    new PrimaryDrawerItem().withName("보내기").withIcon(getResources().getDrawable(R.drawable.email)),
                                    new DividerDrawerItem(),
                                    new PrimaryDrawerItem().withName("테스트!").withIcon(getResources().getDrawable(R.drawable.family))
                            )
                            .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l, IDrawerItem iDrawerItem) {

                                    switch (position) {
                                        case 0:
                                            break;
                                        case 1:
                                            changeFragment(new MainFragment(null, true));
                                            break;
                                        case 2:
                                            changeFragment(new MainFragment(Question.Category.LeisureLife, false));
                                            break;
                                        case 3:
                                            changeFragment(new MainFragment(Question.Category.HolyDay, false));
                                            break;
                                        case 4:
                                            changeFragment(new MainFragment(Question.Category.Love, false));
                                            break;
                                        case 5:
                                            changeFragment(new MainFragment(Question.Category.Friends, false));
                                            break;
                                        case 6:
                                            changeFragment(new MainFragment(Question.Category.Family, false));
                                            break;
                                        case 7: // 구분선
                                            break;
                                        case 8:
                                            // 메일 보내기
                                            Intent i = new Intent(Intent.ACTION_SEND);
                                            i.setType("application/pdf");
                                            i.putExtra(Intent.EXTRA_EMAIL,new String[]{pref.getString("email", "None")});
                                            i.putExtra(Intent.EXTRA_SUBJECT, "제목이야");
                                            i.putExtra(Intent.EXTRA_TEXT, "내용이야");

                                            try
                                            {
                                                BaseFont objBaseFont = BaseFont.createFont("assets/NanumGothicBold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

                                                Font titleFont = new Font(objBaseFont, 20.0f);
                                                Font dateFont = new Font(objBaseFont, 15.0f);
                                                Font contentsFont = new Font(objBaseFont);

                                                PDFMaker.getInstance().exportAnswer("/mnt/sdcard/letter.pdf", AnswerData.getInstance().getAnswerList(), titleFont, dateFont, contentsFont);
                                            }
                                            catch (Exception e)
                                            {
                                                e.printStackTrace();
                                            }

                                            File file = new File("/mnt/sdcard/letter.pdf");
                                            Uri filePath = Uri.fromFile(file);

                                            i.putExtra(Intent.EXTRA_STREAM, filePath);

                                            startActivity(Intent.createChooser(i, "Send mail..."));
                                            break;
                                        case 9: // 구분선
                                            break;
                                        case 10:
                                            MessageDialog dialog = new MessageDialog(ParentActivity.this);
                                            dialog.show();
                                            break;
                                        default:
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

                            changeFragment(new MainFragment(null, true));
                        }
                    });

                    btn_addItem = (Button) findViewById(R.id.addItem);

                    if(getIntent().getBooleanExtra("signup", false)) {
                        changeFragment(new MainFragment(null, true));
                    } else {
                        changeFragment(new SignupFragment());
                    }
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

            if(!pref.getString("content", "").equals("")) {
                Answer answer = new Answer(new Date(System.currentTimeMillis()), "", "", pref.getString("content", ""));
                AnswerData.getInstance().saveAnswer(answer);
                pref.edit().putString("content", "").commit();
            }

            actionView.setAction(new DrawerAction(), ActionView.ROTATE_CLOCKWISE);
            btn_addItem.setBackgroundResource(R.drawable.btn_write);
            btn_addItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawer.closeDrawer();
                    changeFragment(new ContentAddFragment());
                }
            });
        } else if(!(nowFragment instanceof SignupFragment)) {
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
                    changeFragment(new MainFragment(null, true));
                }
            });
        }

        if(nowFragment instanceof SignupFragment) {
            btn_addItem.setBackgroundResource(R.drawable.btn_ok);
            btn_addItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pref.edit().putBoolean("signup", true).commit();
                    drawer.closeDrawer();
                    btn_addItem.setBackgroundResource(R.drawable.btn_write);
                    changeFragment(new MainFragment(null, true));
                    if(pref.getBoolean("signup", false)) {
                        AccountHeader.Result header = new AccountHeader()
                                .withActivity(ParentActivity.this)
                                .withHeaderBackground(R.mipmap.background)
                                .addProfiles(
                                        new ProfileDrawerItem()
                                                .withName(pref.getString("name", "None"))
                                                .withEmail(pref.getString("email", "None"))
                                                .withIcon(new Birth(ParentActivity.this).getDrawableAtDay())
                                )
                                .build();

                        drawer = new Drawer().withActivity(ParentActivity.this)
                                .addDrawerItems(
                                        new PrimaryDrawerItem().withName("시간순").withIcon(getResources().getDrawable(R.drawable.time)),
                                        new PrimaryDrawerItem().withName("여가생활").withIcon(getResources().getDrawable(R.drawable.rest)),
                                        new PrimaryDrawerItem().withName("기념일").withIcon(getResources().getDrawable(R.drawable.good)),
                                        new PrimaryDrawerItem().withName("사랑").withIcon(getResources().getDrawable(R.drawable.love)),
                                        new PrimaryDrawerItem().withName("친구와").withIcon(getResources().getDrawable(R.drawable.friends)),
                                        new PrimaryDrawerItem().withName("가족과").withIcon(getResources().getDrawable(R.drawable.family)),
                                        new DividerDrawerItem(),
                                        new PrimaryDrawerItem().withName("보내기").withIcon(getResources().getDrawable(R.drawable.family)),
                                        new DividerDrawerItem(),
                                        new PrimaryDrawerItem().withName("테스트!").withIcon(getResources().getDrawable(R.drawable.family))
                                )
                                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l, IDrawerItem iDrawerItem) {
                                        switch (position) {
                                            case 0:
                                                break;
                                            case 1:
                                                changeFragment(new MainFragment(null, true));
                                                break;
                                            case 2:
                                                changeFragment(new MainFragment(Question.Category.LeisureLife, false));
                                                break;
                                            case 3:
                                                changeFragment(new MainFragment(Question.Category.HolyDay, false));
                                                break;
                                            case 4:
                                                changeFragment(new MainFragment(Question.Category.Love, false));
                                                break;
                                            case 5:
                                                changeFragment(new MainFragment(Question.Category.Friends, false));
                                                break;
                                            case 6:
                                                changeFragment(new MainFragment(Question.Category.Family, false));
                                                break;
                                            case 7: // 구분선
                                                break;
                                            case 8:
                                                // 메일 보내기
                                                Intent i = new Intent(Intent.ACTION_SEND);
                                                i.setType("application/pdf");
                                                i.putExtra(Intent.EXTRA_EMAIL,new String[]{pref.getString("email", "None")});
                                                i.putExtra(Intent.EXTRA_SUBJECT, "제목이야");
                                                i.putExtra(Intent.EXTRA_TEXT, "내용이야");

                                                try
                                                {
                                                    BaseFont objBaseFont = BaseFont.createFont("assets/NanumGothicBold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

                                                    Font titleFont = new Font(objBaseFont, 20.0f);
                                                    Font dateFont = new Font(objBaseFont, 15.0f);
                                                    Font contentsFont = new Font(objBaseFont);

                                                    PDFMaker.getInstance().exportAnswer("/mnt/sdcard/letter.pdf", AnswerData.getInstance().getAnswerList(), titleFont, dateFont, contentsFont);
                                                }
                                                catch (Exception e)
                                                {
                                                    e.printStackTrace();
                                                }

                                                File file = new File("/mnt/sdcard/letter.pdf");
                                                Uri filePath = Uri.fromFile(file);

                                                i.putExtra(Intent.EXTRA_STREAM, filePath);

                                                startActivity(Intent.createChooser(i, "Send mail..."));
                                                break;
                                            case 9: // 구분선
                                                break;
                                            case 10:
                                                MessageDialog dialog = new MessageDialog(ParentActivity.this);
                                                dialog.show();
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                })
                                .withAccountHeader(header)
                                .withActionBarDrawerToggle(true)
                                .withTranslucentStatusBar(false)
                                .build();
                    }
                }
            });
        }

        transaction.replace(R.id.fl_container, nowFragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        actionView.setAction(new DrawerAction(), ActionView.ROTATE_CLOCKWISE);
        if(nowFragment instanceof MainFragment) {
            super.onBackPressed();
        } else {
            changeFragment(new MainFragment(null, true));
        }
    }
}
