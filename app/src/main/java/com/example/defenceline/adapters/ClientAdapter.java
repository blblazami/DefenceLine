package com.example.defenceline.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.defenceline.R;
import com.example.defenceline.model.Client;

import java.util.ArrayList;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.clientViewHolder> {

    private Context context;
    private int resource;
    private ArrayList<Client> clients;

    // client constructor
    public ClientAdapter(ArrayList<Client> clients) {
        this.clients = clients;
    }

    // holder class for recyclerview
    public class clientViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView phone;
        TextView location;
        TextView time;
        TextView date;
        TextView serviceType;
        TextView price;


        public clientViewHolder(@NonNull View itemView) {
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

    public ClientAdapter(Context context, int resource, ArrayList<Client> clients){
        this.context = context;
        this.resource = resource;
        this.clients = clients;
    }

    public void addItem(Client client){
        this.clients.add(client);
        notifyDataSetChanged();
    }

    public int getCount() {
        return clients.size();
    }

    
    public Client getItem(int position) {
        return clients.get(position);
    }

    @NonNull
    @Override
    public clientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_client_data_show, null, false);
        clientViewHolder viewHolder = new clientViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull clientViewHolder holder, int position) {
        Client c = clients.get(position);
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
        return clients.size();
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        View view = convertView;
//        if (view == null){
//            view = LayoutInflater.from(context).inflate(resource, parent, false);
//        }
//
//        ImageView back = view.findViewById(R.id.back);
//        ImageView search = view.findViewById(R.id.search);
//        TextView name = view.findViewById(R.id.name);
//        TextView phone = view.findViewById(R.id.phone);
//        TextView location = view.findViewById(R.id.location);
//        TextView time = view.findViewById(R.id.time);
//        TextView date = view.findViewById(R.id.date);
//        TextView price = view.findViewById(R.id.price);
//        Button more = view.findViewById(R.id.more_button);
//
//        Client client = getItem(position);
//        name.setText(client.getName());
//        phone.setText(client.getPhoneNo());
//        location.setText(client.getLocation());
//        time.setText(client.getTime() + "");
//        date.setText(client.getDate() + "");
//        price.setText(client.getPrice() + "");
//
//        return view;
//    }
}
