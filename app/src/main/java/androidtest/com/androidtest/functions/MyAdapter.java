package androidtest.com.androidtest.functions;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import android.view.ViewGroup.LayoutParams;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidtest.com.androidtest.R;

public class MyAdapter extends ArrayAdapter<CreateList> {

    Context context;

    public MyAdapter(Context context, int resourceId, List<CreateList> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    private class ViewHolder {

        ImageView imageView;
        TextView txtTitle;
        TextView txtDesc;
        LinearLayout ll_grid;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        CreateList rowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
  //      if (convertView == null) {
            convertView = mInflater.inflate(R.layout.custom_people, null);
            holder = new ViewHolder();
            holder.txtDesc = (TextView) convertView.findViewById(R.id.tv_commontime);
            holder.txtTitle = (TextView) convertView.findViewById(R.id.tv_commonname);
            holder.imageView = (ImageView) convertView.findViewById(R.id.iv_common_pic);

        holder.ll_grid = (LinearLayout)convertView.findViewById(R.id.ll_grid);

        for(int i=0;i<Validations.grid_peopleids.length;i++){
            for(int j=0;j<Validations.grid_peopleids[i].length;j++){
                holder.ll_grid.addView(insertPhoto(Validations.grid_peopleids[i][j]));
            }
        }


            convertView.setTag(holder);
    //    } else {
            holder = (ViewHolder) convertView.getTag();

            holder.txtDesc.setText(rowItem.getImage_title2());
            holder.txtTitle.setText(rowItem.getImage_title());
            holder.imageView.setImageResource(rowItem.getImage_ID());

    //    }
        return convertView;
    }
    View insertPhoto(int imgid){
      //  Bitmap bm = decodeSampledBitmapFromUri(path, 220, 220);

        LinearLayout layout = new LinearLayout(Validations.ctx);
        layout.setLayoutParams(new LayoutParams(250, 250));
        layout.setGravity(Gravity.CENTER);

        ImageView imageView = new ImageView(Validations.ctx);
        imageView.setLayoutParams(new LayoutParams(220, 220));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(imgid);

        layout.addView(imageView);
        return layout;
    }

    public Bitmap decodeSampledBitmapFromUri(String path, int reqWidth, int reqHeight) {
        Bitmap bm = null;

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        bm = BitmapFactory.decodeFile(path, options);

        return bm;
    }

    public int calculateInSampleSize(

            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            if (width > height) {
                inSampleSize = Math.round((float)height / (float)reqHeight);
            } else {
                inSampleSize = Math.round((float)width / (float)reqWidth);
            }
        }

        return inSampleSize;
    }


}