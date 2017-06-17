package androidtest.com.androidtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

import androidtest.com.androidtest.functions.CreateList;
import androidtest.com.androidtest.functions.Custom_grid;
import androidtest.com.androidtest.functions.DataAdapter;
import androidtest.com.androidtest.functions.MyAdapter;
import androidtest.com.androidtest.functions.Validations;

import static androidtest.com.androidtest.R.id.grid;
import static androidtest.com.androidtest.functions.Validations.grid_ids;

/**
 * Created by Sridhar on 30-05-2017.
 */

public class Fragment_Profile extends Fragment {
    public Fragment_Profile(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.profile_fragment, container, false);

        initializing_recyclerview(v);
        return v;
    }
    public void initializing_recyclerview(View v){
        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(Validations.ctx,2);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<CreateList> createLists = prepareData();
        DataAdapter adapter = new DataAdapter(Validations.ctx, createLists,0);
        recyclerView.setAdapter(adapter);

    }
    private ArrayList<CreateList> prepareData(){

        ArrayList<CreateList> theimage = new ArrayList<>();
        for(int i = 0; i< grid_ids.length; i++){
            CreateList createList = new CreateList();
            // createList.setImage_title(image_titles[i]);
            createList.setImage_ID(grid_ids[i]);
            theimage.add(createList);
        }
        return theimage;
    }


}
