package com.example.drivoapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drivoappui.R;
import com.example.drivoapp.model.Brand;

import java.util.List;

public class TopBrandAdapter extends RecyclerView.Adapter<TopBrandAdapter.ViewHolder> {

    private Context context;
    private List<Brand> topBrandList;

    public TopBrandAdapter(Context context, List<Brand> topBrandList) {
        this.context = context;
        this.topBrandList = topBrandList;

    }

    @NonNull
    @Override
    public TopBrandAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.top_brands_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopBrandAdapter.ViewHolder holder, int position) {

        holder.brandLogo.setImageResource(topBrandList.get(position).getBrandImage());

    }

    @Override
    public int getItemCount() {
        return topBrandList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView brandLogo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            brandLogo = itemView.findViewById(R.id.brand_item_logo);

        }
    }
}
