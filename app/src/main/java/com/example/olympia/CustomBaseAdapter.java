package com.example.olympia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBaseAdapter extends BaseAdapter {

    Context context;
    String listProduct[];
    int listImages[];
    LayoutInflater inflater;


    public CustomBaseAdapter(Context ctx, String [] productList, int [] images) {
        this.context = ctx;
        this.listProduct = productList;
        this.listImages = images;
        inflater = LayoutInflater.from(ctx);

    }

    @Override
    public int getCount() {
        return listProduct.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_custom_list_view, null);
        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        ImageView productImg = (ImageView) convertView.findViewById(R.id.imageIcon);
        textView.setText(listProduct[position]);
        productImg.setImageResource(listImages[position]);

        return convertView;
    }
}
