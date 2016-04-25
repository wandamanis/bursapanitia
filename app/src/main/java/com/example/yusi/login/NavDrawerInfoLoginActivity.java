package com.example.yusi.login;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by wanda on 20/04/16.
 */
public class NavDrawerInfoLoginActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener{

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    private TextView lblName;
    private ImageView imgProfilePict;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer_activity_layout);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        lblName = (TextView)findViewById(R.id.lblName);
        imgProfilePict = (ImageView)findViewById(R.id.imgProfilePict);
        lblName.setText(""+intent.getStringExtra("name"));
        lblName.setVisibility(View.GONE);
        imgProfilePict.setImageURI(Uri.parse(""+intent.getStringExtra("profileUrl")));
        //Picasso.with(getApplicationContext()).load(""+intent.getStringExtra("profileUrl")).into(imgProfilePict);



    }


    @Override
    public void onDrawerItemSelected(View view, int position) {

    }
}
