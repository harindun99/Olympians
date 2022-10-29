package com.example.mobileapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<user> {

    public ListAdapter(Context context, ArrayList<user> userArrayList){
        super(context,R.layout.list_item,userArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        user user = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);


        }

        ImageView imageView = convertView.findViewById(R.id.item_pic);
        TextView itemName = convertView.findViewById(R.id.itemName);
        TextView lastMsg = convertView.findViewById(R.id.lastMessage);

        imageView.setImageResource(user.imageId);
        itemName.setText(user.name);
        lastMsg.setText(user.lastMessage);



        return super.getView(position, convertView, parent);
    }
}
