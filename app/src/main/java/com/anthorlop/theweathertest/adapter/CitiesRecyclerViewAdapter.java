package com.anthorlop.theweathertest.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anthorlop.theweathertest.R;
import com.anthorlop.theweathertest.dataview.CityView;
import com.anthorlop.theweathertest.interfaces.OnCityListener;

import java.util.List;


public class CitiesRecyclerViewAdapter extends RecyclerView.Adapter<CitiesRecyclerViewAdapter.ViewHolder> {

    private List<CityView> mValues;

    private OnCityListener mOnCityListener;

    public CitiesRecyclerViewAdapter(List<CityView> items, OnCityListener listener) {
        mValues = items;
        mOnCityListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.city_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.mNombre.setText(mValues.get(position).getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnCityListener != null) {
                    mOnCityListener.onCityClicked(holder.mItem);
                }
            }
        });
    }

    public void setValues(List<CityView> values) {
        mValues = values;
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mNombre;
        CityView mItem;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mNombre  = view.findViewById(R.id.nameCity);
        }

        @NonNull
        @Override
        public String toString() {
            return super.toString() + " '" + mNombre.getText() + "'";
        }
    }
}
