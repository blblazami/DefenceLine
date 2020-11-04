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
import com.example.defenceline.model.Visit;
import com.example.defenceline.model.Voucher;

import java.util.ArrayList;

public class VoucherAdapter extends RecyclerView.Adapter<VoucherAdapter.voucherViewHolder> {

    private Context context;
    private int resource;
    private ArrayList<Voucher> vouchers;

    // voucher constructor
    public VoucherAdapter(ArrayList<Voucher> vouchers){
        this.vouchers = vouchers;
    }

    // holder class for recyclerview
    public class voucherViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView sumOf;
        TextView receiver;
        TextView date;
        TextView voucherNumber;
        ImageView stamp;

        public voucherViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.client_name);
            sumOf = itemView.findViewById(R.id.sum_of_view);
            receiver = itemView.findViewById(R.id.receiver_name);
            date = itemView.findViewById(R.id.voucher_date);
            voucherNumber = itemView.findViewById(R.id.voucher_number);
            stamp = itemView.findViewById(R.id.stamp);

        }
    }

    public VoucherAdapter(Context context, int resource, ArrayList<Voucher> vouchers){

        this.context = context;
        this.resource = resource;
        this.vouchers = vouchers;

    }

    @NonNull
    @Override
    public voucherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_voucher_view, null, false);
        voucherViewHolder viewHolder = new voucherViewHolder(v);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull VoucherAdapter.voucherViewHolder holder, int position) {

        Voucher v = vouchers.get(position);
        holder.name.setText(v.getName());
        holder.sumOf.setText(v.getSumOf());
        holder.receiver.setText(v.getReceiverName());
        holder.date.setText(v.getVoucherDate());
        holder.voucherNumber.setText(v.getVoucherNumber());

    }

    @Override
    public int getItemCount() {
        return vouchers.size();
    }
}
