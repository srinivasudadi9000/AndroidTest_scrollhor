package androidtest.com.androidtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidtest.com.androidtest.functions.CreateList;
import androidtest.com.androidtest.functions.MyAdapter;
import androidtest.com.androidtest.functions.Validations;

import static androidtest.com.androidtest.functions.Validations.personno_ids;
import static androidtest.com.androidtest.functions.Validations.profile_address;
import static androidtest.com.androidtest.functions.Validations.profile_names;

/**
 * Created by Sridhar on 28-05-2017.
 */

public class Fragment_people_listview extends Fragment {
    public Fragment_people_listview() {
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
        initializing_recyclerview(v,R.id.imagegallery);
        return v;
    }

    public void initializing_recyclerview(View v,int galleryid){
        RecyclerView recyclerView = (RecyclerView)v.findViewById(galleryid);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(Validations.ctx
                , LinearLayoutManager.VERTICAL, false));
        DividerItemDecoration divider = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(Validations.ctx, R.drawable.my_custom_divider));
        recyclerView.addItemDecoration(divider);

        //  addView(RecyclerView);

     //   RecyclerView.LayoutManager layoutManager = new GridLayoutManager(Validations.ctx,2);
       // recyclerView.setLayoutManager(layoutManager);
     /*   ArrayList<CreateList> createLists = prepareData();
        MyAdapter adapter = new MyAdapter(Validations.ctx,1, createLists);
        recyclerView.setAdapter(adapter);*/

    }
    private ArrayList<CreateList> prepareData(){

        ArrayList<CreateList> theimage = new ArrayList<>();
        for(int i = 0; i< profile_names.length; i++){
            CreateList createList = new CreateList();
            createList.setImage_title(profile_names[i]);
            createList.setImage_title2(profile_address[i]);
            createList.setImage_ID(personno_ids[i]);
            theimage.add(createList);
        }
        return theimage;
    }




}
