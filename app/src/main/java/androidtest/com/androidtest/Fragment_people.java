package androidtest.com.androidtest;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import androidtest.com.androidtest.functions.CreateList;
import androidtest.com.androidtest.functions.MyAdapter;
import androidtest.com.androidtest.functions.Validations;

import static androidtest.com.androidtest.functions.Validations.grid_ids;
import static androidtest.com.androidtest.functions.Validations.personno_ids;
import static androidtest.com.androidtest.functions.Validations.profile_address;
import static androidtest.com.androidtest.functions.Validations.profile_names;
import static androidtest.com.androidtest.functions.Validations.validateDate;

/**
 * Created by Sridhar on 28-05-2017.
 */

public class Fragment_people extends Fragment {
    ListView listView;

    public Fragment_people() {
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
        View v = inflater.inflate(R.layout.explore_people, container, false);
        //initializing_recyclerview(v,R.id.imagegallery);

        prepareData();
        System.out.println("preparedata:   "+prepareData());
        listView = (ListView) v.findViewById(R.id.list_explore);
        MyAdapter adapter = new MyAdapter(Validations.ctx, 1, prepareData());
        listView.setAdapter(adapter);

        return v;
    }


    private ArrayList<CreateList> prepareData() {

        ArrayList<CreateList> theimage = new ArrayList<>();
        for (int i = 0; i < profile_names.length; i++) {
            CreateList createList = new CreateList();
            createList.setImage_title(profile_names[i]);
            createList.setImage_title2(profile_address[i]);
            createList.setImage_ID(personno_ids[i]);
            System.out.println("createList::"+createList);
            theimage.add(createList);
        }
        return theimage;
    }


}
