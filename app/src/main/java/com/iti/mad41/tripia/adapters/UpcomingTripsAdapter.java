package com.iti.mad41.tripia.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.iti.mad41.tripia.R;
import com.iti.mad41.tripia.databinding.UpcomingTripCardBinding;
import com.iti.mad41.tripia.model.Trip;

import java.util.List;

public class UpcomingTripsAdapter extends RecyclerView.Adapter<UpcomingTripHolder> {
    private List<Trip> tripsList;
    private Context context;

    public UpcomingTripsAdapter(Context _context, List<Trip> tripsList) {
        this.context = _context;
        this.tripsList = tripsList;
    }

    @NonNull
    @Override
    public UpcomingTripHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        UpcomingTripCardBinding upcomingTripCardBinding  = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.upcoming_trip_card, parent, false);
        return new UpcomingTripHolder(upcomingTripCardBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingTripHolder holder, int position) {
        Trip trip = tripsList.get(position);
        holder.bind(trip);
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull UpcomingTripHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    @Override
    public int getItemCount() {
        return tripsList.size();
    }
}

class UpcomingTripHolder extends RecyclerView.ViewHolder {
    UpcomingTripCardBinding upcomingTripCardBinding;

    public UpcomingTripHolder(@NonNull UpcomingTripCardBinding upcomingTripCardBinding) {
        super(upcomingTripCardBinding.getRoot());
        this.upcomingTripCardBinding = upcomingTripCardBinding;
    }

    public void bind(Trip trip){
        upcomingTripCardBinding.setUpcomingTrips(trip);
        upcomingTripCardBinding.executePendingBindings();
    }

    public void unbind(){
        if(upcomingTripCardBinding !=  null){
            upcomingTripCardBinding.unbind();
        }
    }
}
