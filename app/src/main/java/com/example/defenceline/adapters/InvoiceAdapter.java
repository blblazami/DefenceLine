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
import com.example.defenceline.model.Invoice;

import java.util.ArrayList;

public class InvoiceAdapter extends RecyclerView.Adapter<InvoiceAdapter.invoiceViewHolder> {

    private Context context;
    private int resource;
    private ArrayList<Invoice> invoices;

    //invoice constructor
    public InvoiceAdapter(ArrayList<Invoice> invoices){
        this.invoices = invoices;
    }

    // holder class for recyclerView
    public class invoiceViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView invoiceNumber;
        TextView invoiceDate;
        TextView accountantName;
        TextView phoneNumber;
        TextView price;
        TextView total;
        ImageView stamp;

        public invoiceViewHolder(@NonNull View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.client_name);
            invoiceNumber = itemView.findViewById(R.id.invoice_number);
            invoiceDate = itemView.findViewById(R.id.invoice_date);
            accountantName = itemView.findViewById(R.id.accountant_name);
            phoneNumber = itemView.findViewById(R.id.phone_num);
            price = itemView.findViewById(R.id.price_view);
            total = itemView.findViewById(R.id.total_view);
            stamp = itemView.findViewById(R.id.stamp);
        }

    }

    // adapter constructor
    public InvoiceAdapter(Context context, int resource, ArrayList<Invoice> invoices) {
        this.context = context;
        this.resource = resource;
        this.invoices = invoices;
    }

    public void addItem(Invoice invoice){
        this.invoices.add(invoice);
        notifyDataSetChanged();
    }

    public int getCount() {
        return invoices.size();
    }

    @NonNull
    @Override
    public invoiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_invoice_show, null, false);
        invoiceViewHolder viewHolder = new invoiceViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull invoiceViewHolder holder, int position) {

        Invoice i = invoices.get(position);
        holder.name.setText(i.getName());
        holder.invoiceNumber.setText(i.getInvoiceNumber());
        holder.invoiceDate.setText(i.getInvoiceDate());
        holder.phoneNumber.setText(i.getPhoneNumber());
        holder.accountantName.setText(i.getAccountant());
        holder.price.setText(i.getPrice());
        holder.total.setText(i.getTotal());

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

        @Override
    public int getItemCount() {
        return invoices.size();
    }
}
