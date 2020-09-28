package com.example.defenceline;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseManager {

    private static ValueEventListener mValueEventListener;
    private static DatabaseReference mDatabaseReference;

    public interface OnCounterReceived {
        void onReceived(int invoiceCounter);
    }

    public static void stopInvoiceCounterListener() {
        if (mDatabaseReference != null) {
            mDatabaseReference.removeEventListener(mValueEventListener);
            mDatabaseReference = null;
        }
    }

    public static void getInvoiceCounter(final OnCounterReceived onCounterReceived) {
        if (mDatabaseReference != null)
            return;
        mValueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int invoiceCounter = snapshot.getValue(Integer.class);
                onCounterReceived.onReceived(invoiceCounter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        mDatabaseReference = FirebaseDatabase.getInstance().getReference(FirebaseKeys.INVOICE_COUNTER);
        mDatabaseReference.addValueEventListener(mValueEventListener);
    }

    public static void updateInvoiceCounter(int invoiceCounter) {
        FirebaseDatabase.getInstance().getReference(FirebaseKeys.INVOICE_COUNTER).setValue(invoiceCounter);
    }
}
