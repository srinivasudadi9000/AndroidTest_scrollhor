package androidtest.com.androidtest.functions;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidtest.com.androidtest.R;

public class NavDrawerListAdapter extends BaseAdapter {
     
    private Context context;
    private ArrayList<NavDrawerItem> navDrawerItems;
     
    public NavDrawerListAdapter(Context context, ArrayList<NavDrawerItem> navDrawerItems){
        this.context = context;
        this.navDrawerItems = navDrawerItems;
    }
 
    @Override
    public int getCount() {
        return navDrawerItems.size();
    }
 
    @Override
    public Object getItem(int position) {       
        return navDrawerItems.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_row, null);
        }
          
        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.list_row_icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.list_row_title);
       TextView txtCount = (TextView) convertView.findViewById(R.id.list_row_counter);

        imgIcon.setImageResource(navDrawerItems.get(position).getIcon());        
        txtTitle.setText(navDrawerItems.get(position).getTitle());
         
        // displaying count
        // check whether it set visible or not
        if(position ==1){
            txtCount.setBackgroundResource(R.drawable.count);
            txtCount.setVisibility(View.VISIBLE);

        }else{
            // hide the counter view
            txtCount.setVisibility(View.GONE);
        }
         
        return convertView;
    }
 
}