package com.example.drivoapp.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.drivoappui.R;
import com.example.drivoapp.adapter.GroupAdapter;
import com.example.drivoapp.model.Brand;
import com.example.drivoapp.model.Car;
import com.example.drivoapp.model.Group;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private Context mContext;
    private GroupAdapter adapter;
    private RecyclerView recyclerView;
    private List<Group> groupList;
    private List<Brand> topBrandList;
    private List<Car> availableNearList;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setAdapterType(view);
        setAdapter();

    }

    private void setAdapter() {

        initGroupData();
        initCarData();

        adapter = new GroupAdapter(mContext, groupList, topBrandList, availableNearList);
        recyclerView.setAdapter(adapter);

    }

    private void initCarData() {

        topBrandList = new ArrayList<>();
        availableNearList = new ArrayList<>();

        topBrandList.add(new Brand(R.drawable.brand_logo_1));
        topBrandList.add(new Brand(R.drawable.brand_logo_2));
        topBrandList.add(new Brand(R.drawable.brand_logo_3));
        topBrandList.add(new Brand(R.drawable.brand_logo_4));
        topBrandList.add(new Brand(R.drawable.brand_logo_5));


        availableNearList.add(new Car("Land Rover", "4.4", "1.4jt/hari", R.drawable.car_1));
        availableNearList.add(new Car("Ford", "4.1", "1jt/hari", R.drawable.car_2));
        availableNearList.add(new Car("Acura", "3.9", "900rb/hari", R.drawable.car_3));
        availableNearList.add(new Car("Alfa Romeo", "4.6", "1.6jt/hari", R.drawable.car_4));
        availableNearList.add(new Car("Nissan", "4.3", "1.3jt/hari", R.drawable.car_5));
        availableNearList.add(new Car("Camaro", "4.2", "1.2jt/hari", R.drawable.car_6));
    }

    private void initGroupData() {

        groupList = new ArrayList<>();
        groupList.add(new Group("Brand Terbaik", "Lihat Semua"));
        groupList.add(new Group("Tersedia di Sekitar Anda", "Lihat Semua"));

    }

    private void setAdapterType(View view) {

        recyclerView = view.findViewById(R.id.home_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
}