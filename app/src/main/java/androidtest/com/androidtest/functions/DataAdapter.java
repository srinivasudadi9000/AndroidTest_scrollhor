package androidtest.com.androidtest.functions;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidtest.com.androidtest.MainActivity;
import androidtest.com.androidtest.R;

import static android.R.attr.data;
import static androidtest.com.androidtest.R.id.tv_commonname;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<CreateList> galleryList;
    private Context context;
    int tabname;
    private List<CreateList> data;

    public DataAdapter(Context context, ArrayList<CreateList> galleryList, int tabname) {//tabname=0;posts,//tabname=1;people
        this.galleryList = galleryList;
        this.context = context;
        this.tabname = tabname;
    }


    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_layout, viewGroup, false);
         return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.title.setText(galleryList.get(i).getImage_title());
        viewHolder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewHolder.img.setImageResource((galleryList.get(i).getImage_ID()));
    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView address;
        private ImageView img;

        public ViewHolder(View view) {
            super(view);
                title = (TextView) view.findViewById(R.id.title);
                title.setVisibility(View.GONE);

                img = (ImageView) view.findViewById(R.id.img);

        }
    }
}