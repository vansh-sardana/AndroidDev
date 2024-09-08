package com.example.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAdapter extends ArrayAdapter<String> {
    Context context;
    String[] arr;
    public MyAdapter(@NonNull Context context, int resource, @NonNull String[] arr) {
        super(context, resource, arr);
        this.context= context;
        this.arr= arr;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return arr[position];
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.myadapter, parent, false);
        TextView text= convertView.findViewById(R.id.textView);
        text.setText(arr[position]);
        Button btn= convertView.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "You pressed: "+ position, Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
