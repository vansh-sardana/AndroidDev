package com.example.phonecontactsusingrv;

import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactActivity extends RecyclerView.Adapter<ContactActivity.ViewHolder> {

    private Contact[] contacts;
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView sno;
        private TextView phoneNo;
        private TextView name;
        private Button button;
        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            sno = (TextView) view.findViewById(R.id.sno);
            phoneNo = (TextView) view.findViewById(R.id.contactNo);
            name = (TextView) view.findViewById(R.id.name);
            button = (Button)view.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String phoneNumber = getPhoneNo().getText().toString();
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + phoneNumber));
//                    if (intent.resolveActivity(view.getContext().getPackageManager()) != null) {
                        startActivity(view.getContext(), intent, null);
//                    }
                }
            });
        }

        public TextView getSno() {
            return sno;
        }
        public TextView getPhoneNo(){
            return phoneNo;
        }
        public TextView getName(){
            return name;
        }
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public ContactActivity(Contact[] dataSet) {
        contacts = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.contactlayout, viewGroup, false);

        return new ViewHolder(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("working", contacts[position].phone);
        Integer sn= contacts[position].sno;
        holder.getSno().setText(String.format("%d", sn));
        Log.d("working1", contacts[position].phone);
        holder.getPhoneNo().setText(contacts[position].phone);
        Log.d("working2", contacts[position].phone);
        holder.getName().setText(contacts[position].name);

    }

    // Replace the contents of a view (invoked by the layout manager)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return contacts.length;
    }
}
