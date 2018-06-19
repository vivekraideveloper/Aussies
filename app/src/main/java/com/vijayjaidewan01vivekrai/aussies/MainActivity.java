package com.vijayjaidewan01vivekrai.aussies;

import android.app.ActionBar;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar mToolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private ViewPager mViewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private TabLayout mTabLayout;
    private String[] to = {"vivekraideveloper01@gmail.com"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = findViewById(android.R.id.content);
        Snackbar snackbar = Snackbar.make(view, "Please ensure stable internet connectivity!",7000).setAction("Action", null);
        snackbar.show();

        mToolbar = (Toolbar) findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("com.cricket.au");

        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mViewPager = (ViewPager) findViewById(R.id.main_tabPager);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mSectionsPagerAdapter);

        mTabLayout = (TabLayout) findViewById(R.id.main_tabs);
        mTabLayout.setupWithViewPager(mViewPager);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
//
        View headerView = navigationView.getHeaderView(0);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        if (item.getItemId() == R.id.share) {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Download Aussies, only app that provides action packed coverage of cricket worldwide!\n" + "https://play.google.com/store/apps/details?id=com.vijayjaidewan01vivekrai.androidfirebase");
            startActivity(Intent.createChooser(shareIntent, "Share Using"));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.home:
//                FragmentManager fm = getSupportFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.addToBackStack("");
//                ft.commit();
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.ca:
                WebFragment webFragment = new WebFragment();
                Bundle bundle = new Bundle();
                bundle.putString("url", "http://www.cricket.com.au");
                webFragment.setArguments(bundle);
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);

                FragmentManager fmCa = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction ftCa = fmCa.beginTransaction();
                ftCa.replace(R.id.drawer_layout, webFragment);
                ftCa.addToBackStack("");
                ftCa.commit();
                break;
            case R.id.aboutUs:
                Intent aboutIntent = new Intent(MainActivity.this, AboutUs.class);
                startActivity(aboutIntent);
                break;
            case R.id.help:
                final AlertDialog.Builder helpAlert = new AlertDialog.Builder(MainActivity.this);
                helpAlert.setIcon(R.drawable.australia);
                helpAlert.setTitle("Help");
                helpAlert.setMessage("Cricket Australia is your go to app for all the latest cricket news, blogs and videos trending worldwide. Navigate to the Videos, Blogs and Tweets section for an action packed journey. ");
                helpAlert.setPositiveButton("Go Ahead", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Intent intent1 = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent1);
                    }
                });
                helpAlert.setCancelable(false);
                helpAlert.show();
                break;
            case R.id.moreApps:
                Intent morIntent = new Intent(Intent.ACTION_VIEW);
                morIntent.setData(Uri.parse("https://play.google.com/store/search?q=pub:+Vivek+Rai&c=apps"));
                if (morIntent != null) {
                    startActivity(morIntent);
                }
                break;

            case R.id.contact:
                Intent conatctIntent = new Intent(Intent.ACTION_SEND);
                conatctIntent.setData(Uri.parse("mailto:"));
                conatctIntent.putExtra(Intent.EXTRA_EMAIL, to);
                conatctIntent.putExtra(Intent.EXTRA_SUBJECT, "com.cricket.au feedback");
                conatctIntent.putExtra(Intent.EXTRA_TEXT, "");
                conatctIntent.setType("message/UTF-8");
                startActivity(Intent.createChooser(conatctIntent, "Please Choose your Email"));
                break;
            case R.id.terms:
                Intent termsIntent = new Intent(MainActivity.this, Terms.class);
                startActivity(termsIntent);
                break;
        }
        return true;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();


//        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//        builder.setTitle("com.cricket.au");
//        builder.setMessage("Do you want to Exit?");
//        builder.setIcon(R.drawable.australia);
//        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.dismiss();
//            }
//        });
//        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.dismiss();
//
//                Intent intent = new Intent(Intent.ACTION_MAIN);
//                intent.addCategory(Intent.CATEGORY_HOME);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
//            }
//        });
//        builder.show();

    }
}
