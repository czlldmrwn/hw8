package com.mirea.kt.hw6;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {

    private ArrayList<Store> stores;

    public StoreAdapter(ArrayList<Store> stores){
        this.stores = stores;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView nameView;
        private final TextView addressView;
        private final TextView workTimeView;

        public ViewHolder(View view) {
            super(view);
            nameView = view.findViewById(R.id.tvName);
            addressView = view.findViewById(R.id.tvAddress);
            workTimeView = view.findViewById(R.id.tvWorkTime);
        }
    }

    @NonNull
    @Override
    public StoreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull StoreAdapter.ViewHolder holder, int position) {
        Store store = stores.get(position);
        holder.nameView.setText(String.format("%s", store.getName()));
        holder.addressView.setText(String.format("%s", store.getAddress()));
        holder.workTimeView.setText(String.format("%d - %d", store.getHoursOpen(), store.getHoursClose()));
    }

    @Override
    public int getItemCount() {
        return stores.size();
    }
}
