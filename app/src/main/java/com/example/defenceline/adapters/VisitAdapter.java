package com.example.defenceline.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.defenceline.R;
import com.example.defenceline.model.Client;
import com.example.defenceline.model.Visit;

import java.util.ArrayList;

public class VisitAdapter extends RecyclerView.Adapter<VisitAdapter.visitViewHolder> {

    private Context context;
    private int resource;
    private ArrayList<Visit> visits;

    // visit constructor
    public VisitAdapter(ArrayList<Visit> visits){
        this.visits = visits;
    }

    // holder class for recyclerview
    public class visitViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView visitNumber;
        TextView date;
        TextView serviceProvider;
        TextView signature;
        ImageView stamp;

        public visitViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_field);
            visitNumber = itemView.findViewById(R.id.visit_number_field);
            date = itemView.findViewById(R.id.date_field);
            serviceProvider = itemView.findViewById(R.id.service_provider_field);
            signature = itemView.findViewById(R.id.signature);
            stamp = itemView.findViewById(R.id.stamp);

        }
    }

    public VisitAdapter(Context context, int resource, ArrayList<Visit> visits){

        this.context = context;
        this.resource = resource;
        this.visits = visits;

    }

    @NonNull
    @Override
    public visitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_visit_show, null, false);
        visitViewHolder viewHolder = new visitViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull visitViewHolder holder, int position) {
        Visit v = visits.get(position);
        holder.name.setText(v.getName());
        holder.visitNumber.setText(v.getVisitNumber());
        holder.date.setText(v.getDate());
        holder.serviceProvider.setText(v.getServiceProvider());
        holder.signature.setText(v.getSignature());

    }

    @Override
    public int getItemCount() {
        return visits.size();
    }
}
