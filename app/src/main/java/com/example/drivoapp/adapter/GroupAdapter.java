package com.example.drivoapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drivoapp.model.Brand;
import com.example.drivoapp.model.Car;
import com.example.drivoapp.model.Group;
import com.example.drivoappui.R;

import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> {

    private Context context;
    private List<Group> groupList;
    private List<Brand> topBrandList;
    private List<Car> availableNearList;

    public GroupAdapter(Context context, List<Group> groupList, List<Brand> topBrandList, List<Car> availableNearList) {
        this.context = context;
        this.groupList = groupList;
        this.topBrandList = topBrandList;
        this.availableNearList = availableNearList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.group_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.groupTitle.setText(groupList.get(position).getGroupTitle());
        holder.groupShowAll.setText(groupList.get(position).getGroupButtonTitle());
        holder.setList(holder.recyclerView, position);

    }

    @Override
    public int getItemCount() {
        return groupList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView groupTitle;
        private TextView groupShowAll;
        private RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            groupTitle = itemView.findViewById(R.id.group_title);
            groupShowAll = itemView.findViewById(R.id.show_all);
            recyclerView = itemView.findViewById(R.id.group_recyclerview);

        }

        public void setList(RecyclerView recyclerView, int position) {

            switch (position){

                case 0:

                    setTopBrandList(recyclerView);

                    break;

                case 1:

                    setAvailableNearList(recyclerView);

                    break;

            }

        }

    }

    private void setTopBrandList(RecyclerView recyclerView) {

        TopBrandAdapter adapter = new TopBrandAdapter(context, topBrandList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(true);

    }

    private void setAvailableNearList(RecyclerView recyclerView) {

        AvailableNearAdapter adapter = new AvailableNearAdapter(context, availableNearList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(true);

    }
}
