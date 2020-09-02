package com.example.defenceline.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.defenceline.R;
import com.example.defenceline.model.Client;

import java.util.ArrayList;

public class ClientAdapter extends BaseAdapter {

    private Context context;
    private int resource;
    private ArrayList<Client> clients;

    public ClientAdapter(Context context, int resource, ArrayList<Client> clients){
        this.context = context;
        this.resource = resource;
        this.clients = clients;
    }

    public void addItem(Client client){
        this.clients.add(client);
    }

    @Override
    public int getCount() {
        return clients.size();
    }

    @Override
    public Client getItem(int position) {
        return clients.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null){
            view = LayoutInflater.from(context).inflate(resource, parent, false);
        }

//        ImageView back = view.findViewById(R.id.back);
//        ImageView search = view.findViewById(R.id.search);
        TextView name = view.findViewById(R.id.name);
        TextView phone = view.findViewById(R.id.phone);
        TextView location = view.findViewById(R.id.location);
        TextView time = view.findViewById(R.id.time);
        TextView date = view.findViewById(R.id.date);
        TextView price = view.findViewById(R.id.price);
//        Button more = view.findViewById(R.id.more_button);

        Client client = getItem(position);
        name.setText(client.getName());
        phone.setText(client.getPhoneNo());
        location.setText(client.getLocation());
//        time.setText(client.getTime() + "");
//        date.setText(client.getDate() + "");
        price.setText(client.getPrice() + "");

        return view;
    }
}
