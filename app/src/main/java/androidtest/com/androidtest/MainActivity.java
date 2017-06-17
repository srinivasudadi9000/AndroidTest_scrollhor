package androidtest.com.androidtest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;


import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidtest.com.androidtest.functions.NavDrawerItem;
import androidtest.com.androidtest.functions.NavDrawerListAdapter;

import androidtest.com.androidtest.R;
import androidtest.com.androidtest.functions.NavigationMethod;
import androidtest.com.androidtest.functions.RoundImage;
import androidtest.com.androidtest.functions.Validations;

import android.widget.AdapterView.OnItemClickListener;

import static androidtest.com.androidtest.R.id.iv_slide_profilepic;
import static androidtest.com.androidtest.R.id.iv_slidemenu;
import static androidtest.com.androidtest.R.id.ll_slide_display;
import static androidtest.com.androidtest.functions.Validations.navMenuIcons;
import static androidtest.com.androidtest.functions.Validations.navMenuTitles;


public class MainActivity extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Validations.ctx = MainActivity.this;

        NavigationMethod nv=new NavigationMethod(this);
    }


}
