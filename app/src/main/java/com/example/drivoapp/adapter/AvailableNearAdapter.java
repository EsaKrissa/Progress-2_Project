package com.example.drivoapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drivoapp.model.Car;
import com.example.drivoappui.R;

import java.util.List;

public class AvailableNearAdapter extends RecyclerView.Adapter<AvailableNearAdapter.ViewHolder> {

    private Context context;
    private List<Car> availableNearList;

    public AvailableNearAdapter(Context context, List<Car> availableNearList) {
        this.context = context;
        this.availableNearList = availableNearList;
    }

    @NonNull
    @Override
    public AvailableNearAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.available_cars_near, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AvailableNearAdapter.ViewHolder holder, int position) {

        holder.carImage.setImageResource(availableNearList.get(position).getCarImage());
        holder.carName.setText(availableNearList.get(position).getCarName());
        holder.carRating.setText(availableNearList.get(position).getCarRating());
        holder.carPrice.setText(availableNearList.get(position).getCarPrice());

    }

    @Override
    public int getItemCount() {
        return availableNearList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView carImage;
        private TextView carName, carRating, carPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            carImage = itemView.findViewById(R.id.car_item_preview);
            carName = itemView.findViewById(R.id.car_item_name);
            carRating = itemView.findViewById(R.id.car_item_rating);
            carPrice = itemView.findViewById(R.id.car_item_price);

        }
    }
}
