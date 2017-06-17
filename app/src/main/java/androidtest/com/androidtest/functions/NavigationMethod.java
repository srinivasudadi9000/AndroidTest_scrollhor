package androidtest.com.androidtest.functions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidtest.com.androidtest.ExploreActivity;
import androidtest.com.androidtest.FeedActivity;
import androidtest.com.androidtest.ProfileActivity;
import androidtest.com.androidtest.R;

import static androidtest.com.androidtest.R.id.iv_slidemenu;

/**
 * Created by Sridhar on 29-05-2017.
 */

public class NavigationMethod  implements AdapterView.OnItemClickListener {

    //declaring elements needed to navigation drawer
    String[] navMenuTitles;
    private int[] navMenuIcons;

    int[] iconarray;
    private RelativeLayout mDrawerLayout;

    ImageView iv_slide_profilepic;
    private ListView mDrawerList;
    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;
    private LinearLayout ll_slide_display;


    private ActionBarDrawerToggle mDrawerToggle;
    // nav drawer title
    private CharSequence mDrawerTitle;
    private ImageView iv_dashboard_sidemenu;
    Context ctx;
    Activity act;
    TextView tv_header_title;
    public NavigationMethod(Activity act){
        this.act=act;
        this.ctx=Validations.ctx;
        navMenuTitles=Validations.navMenuTitles;
        navMenuIcons=Validations.navMenuIcons;
        tv_header_title = (TextView)act.findViewById(R.id.tv_header_title);
        slide();
    }
    private class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // display view for selected nav drawer item
            displayView(position);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View arg1, int pos, long arg3) {
        // TODO Auto-generated method st

        String selected = (String) parent.getItemAtPosition(pos);

        System.out.println("selected: " + selected);

    }

    private void displayView(int position) {
        // update the main content by replacing fragments
        switch (position) {
            case 0:
                tv_header_title.setText(navMenuTitles[0]);

                Intent in = new Intent(ctx, FeedActivity.class);
                in.putExtra("title", navMenuTitles[0]);
                ctx.startActivity(in);


                break;
            case 1:
                tv_header_title.setText(navMenuTitles[1]);

                break;
            case 2:
                tv_header_title.setText(navMenuTitles[2]);
                // fragment = new TableFragment();
                Intent in1 = new Intent(ctx, ExploreActivity.class);
                in1.putExtra("title", navMenuTitles[2]);
                ctx.startActivity(in1);

                break;
            case 3:
                tv_header_title.setText(navMenuTitles[3]);
                // fragment = new TableFragment();
                Intent in2 = new Intent(ctx, ProfileActivity.class);
                in2.putExtra("title", navMenuTitles[3]);
                ctx.startActivity(in2);

                // fragment = new TableFragment();
                break;
        }

    }

    public void slide() {

        mDrawerLayout = (RelativeLayout)act.findViewById(R.id.drawer_layout);
        iv_slide_profilepic = (ImageView)act.findViewById(R.id.iv_slide_profilepic);
        Bitmap icon = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.ic_slide_profilepic);
        Bitmap b = Validations.getRoundedCroppedBitmap(icon, 200);

        iv_slide_profilepic.setImageBitmap(b);
        ll_slide_display = (LinearLayout)act. findViewById(R.id.ll_slide_display);

        mDrawerList = (ListView)act. findViewById(R.id.list_slidermenu);

        navDrawerItems = new ArrayList<NavDrawerItem>();

        // adding nav drawer items to array
        // Home
        for (int i = 0; i <navMenuTitles.length; i++) {

            navDrawerItems.add(new NavDrawerItem(navMenuTitles[i], navMenuIcons[i]));
        }

        // Recycle the typed array
        // navMenuIcons.recycle();

        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

        // setting the nav drawer list adapter
        System.out.println("navDrawerItems:::" + navDrawerItems);
        adapter = new NavDrawerListAdapter(ctx,
                navDrawerItems);
        mDrawerList.setAdapter(adapter);

        iv_dashboard_sidemenu = (ImageView)act. findViewById(iv_slidemenu);

        iv_dashboard_sidemenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // invalidateOptionsMenu();
                if (ll_slide_display.getVisibility() == View.VISIBLE) {
                    ll_slide_display.setVisibility(View.GONE);
                } else if (ll_slide_display.getVisibility() == View.GONE) {
                    ll_slide_display.setVisibility(View.VISIBLE);
                }
            }
        });


    }

}
