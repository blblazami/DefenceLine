package com.example.defenceline.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.defenceline.R;
import com.example.defenceline.model.Company;

import java.util.ArrayList;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.companyViewHolder> {

    private Context mContext;
    private int resource;
    private ArrayList<Company> companies;

    // company constructor
    public CompanyAdapter(ArrayList<Company> companies) {
        this.companies = companies;
    }

    // holder class for recyclerview
    public class companyViewHolder extends RecyclerView.ViewHolder{
            TextView name;
            TextView phone;
            TextView location;
            TextView time;
            TextView date;
            TextView serviceType;
            TextView price;

        public companyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_field);
            phone = itemView.findViewById(R.id.phone_field);
            location = itemView.findViewById(R.id.location_field);
            time = itemView.findViewById(R.id.time_field);
            date = itemView.findViewById(R.id.date_field);
            serviceType = itemView.findViewById(R.id.service_type_field);
            price = itemView.findViewById(R.id.price_field);
        }
    }

    public CompanyAdapter(Context context, int resource, ArrayList<Company> mCompanies){
        this.mContext = context;
        this.resource = resource;
        this.companies = mCompanies;
    }

    @NonNull
    @Override
    public companyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_company_data_show, null, false);
        companyViewHolder viewHolder = new companyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull companyViewHolder holder, int position) {
        Company c = companies.get(position);
        holder.name.setText(c.getName());
        holder.phone.setText(c.getPhoneNo());
        holder.location.setText(c.getLocation());
        holder.date.setText(c.getDate());
        holder.time.setText(c.getTime());
        holder.price.setText(c.getPrice());
        holder.serviceType.setText(c.getServiceType());
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return companies.size();
    }
}
