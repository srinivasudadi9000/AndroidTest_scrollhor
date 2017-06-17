package androidtest.com.androidtest;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidtest.com.androidtest.functions.Validations;


import static androidtest.com.androidtest.R.id.iv_feed_like;
import static androidtest.com.androidtest.R.id.tv_bluecolortxt;
import static androidtest.com.androidtest.R.id.tv_feedlikecnt;
import static androidtest.com.androidtest.functions.Validations.ctx;

public class Fragment_feed extends Fragment {

    int likecount =0;
    public Fragment_feed() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle inState) {
        View v = inflater.inflate(R.layout.feed, container, false);
      ImageView  iv_feed_pic = (ImageView)v.findViewById(R.id.iv_common_pic);
        Bitmap icon = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.ic_slide_profilepic);
        Bitmap b = Validations.getRoundedCroppedBitmap(icon, 200);
        iv_feed_pic.setImageBitmap(b);
        TextView tv_feedname=(TextView)v.findViewById(R.id.tv_commonname);
        tv_feedname.setText("Antonzuenco");
        TextView tv_feedtime=(TextView)v.findViewById(R.id.tv_commontime);
        tv_feedtime.setText("Today    "+ Validations.getTodayDate1("HH:mm a"));


        TextView tv_bluecolortxt=(TextView)v.findViewById(R.id.tv_bluecolortxt);
        tv_bluecolortxt.setText("@cher.mania");
        TextView tv_blackcolortxt=(TextView)v.findViewById(R.id.tv_blackcolortxt);
        tv_blackcolortxt.setText("nice eve studio photography");
        TextView tv_bluecolortxt2=(TextView)v.findViewById(R.id.tv_bluecolortxt2);
        tv_bluecolortxt2.setText("#ua #model #new #face #girls #2015 #st");


       final TextView tv_feedlikecnt=(TextView)v.findViewById(R.id.tv_feedlikecnt) ;
       ImageView iv_feed_like=(ImageView)v.findViewById(R.id.iv_feed_like);


        iv_feed_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
               likecount++;
                tv_feedlikecnt.setText(""+likecount);


            }
        });
        return v;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);



        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception

    }}

