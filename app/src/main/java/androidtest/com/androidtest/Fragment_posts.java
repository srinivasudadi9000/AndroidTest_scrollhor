package androidtest.com.androidtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import androidtest.com.androidtest.functions.CreateList;
import androidtest.com.androidtest.functions.Custom_grid;
import androidtest.com.androidtest.functions.MyAdapter;
import androidtest.com.androidtest.functions.Validations;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static androidtest.com.androidtest.R.id.grid;
import static androidtest.com.androidtest.functions.Validations.grid_ids;
import static androidtest.com.androidtest.functions.Validations.validateDate;


public class Fragment_posts extends Fragment {
    int PICK_IMAGE=0;
    GridView grid;

    public Fragment_posts() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.explore_posts, container, false);
        Custom_grid adapter = new Custom_grid(Validations.ctx,Validations.grid_names ,Validations.grid_ids);
        grid=(GridView)v.findViewById(R.id.grid);
        grid.setAdapter(adapter);

        return v;
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
