package androidtest.com.androidtest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidtest.com.androidtest.functions.NavigationMethod;
import androidtest.com.androidtest.functions.Validations;

import static androidtest.com.androidtest.R.id.tv_blackcolortxt;
import static androidtest.com.androidtest.R.id.tv_bluecolortxt;
import static androidtest.com.androidtest.R.id.tv_bluecolortxt2;
import static androidtest.com.androidtest.functions.Validations.ctx;
import static androidtest.com.androidtest.functions.Validations.feed_labels;

import android.widget.ImageView;
import android.widget.TextView;
/**
 * Created by Sridhar on 29-05-2017.
 */

public class FeedActivity  extends AppCompatActivity {
    int likecount =0;

    ImageView  iv_feed_pic,iv_feed_like;
    TextView tv_feedname,tv_feedtime,tv_bluecolortxt,tv_blackcolortxt,tv_bluecolortxt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed);
        ctx = FeedActivity.this;

        NavigationMethod nv=new NavigationMethod(this);


        iv_feed_pic= (ImageView)findViewById(R.id.iv_common_pic);
        Bitmap icon = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.ic_slide_profilepic);
        Bitmap b = Validations.getRoundedCroppedBitmap(icon, 200);
        iv_feed_pic.setImageBitmap(b);

        tv_feedname=(TextView)findViewById(R.id.tv_commonname);
        tv_feedname.setText(Validations.feed_labels[0]);
         tv_feedtime=(TextView)findViewById(R.id.tv_commontime);
        tv_feedtime.setText("Today    "+ Validations.getTodayDate1("HH:mm a"));


         tv_bluecolortxt=(TextView)findViewById(R.id.tv_bluecolortxt);
        tv_bluecolortxt.setText(Validations.feed_labels[1]);
         tv_blackcolortxt=(TextView)findViewById(R.id.tv_blackcolortxt);
        tv_blackcolortxt.setText(Validations.feed_labels[2]);
         tv_bluecolortxt2=(TextView)findViewById(R.id.tv_bluecolortxt2);
        tv_bluecolortxt2.setText(Validations.feed_labels[3]);


        final TextView tv_feedlikecnt=(TextView)findViewById(R.id.tv_feedlikecnt) ;
        ImageView iv_feed_like=(ImageView)findViewById(R.id.iv_feed_like);


        iv_feed_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                likecount++;
                tv_feedlikecnt.setText(""+likecount);


            }
        });

    }
}
