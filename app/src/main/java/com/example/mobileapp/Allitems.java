package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Allitems extends AppCompatActivity {

ListView listView;

String[] itemNames = {"short sleeve t shirt", "long sleeve t shirt", " sports shoes","sports t shirt","Sports t shirt","t shirt"};
int[] itemImages = {R.drawable.shirt6,R.drawable.shirt2,R.drawable.shoe1,R.drawable.shirt3,R.drawable.shirt4,R.drawable.tshirt5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allitems);

        listView = findViewById(R.id.listView);

        CustomAdapter customadapter = new CustomAdapter();

        listView.setAdapter(customadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),ListdataActivity.class);
                intent.putExtra("name",itemNames[i]);
                intent.putExtra("image",itemImages[i]);
                startActivity(intent);
            }
        });

    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return itemImages.length;
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
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);

            TextView name = view1.findViewById(R.id.items);
            ImageView imageView = view1.findViewById(R.id.images);

            name.setText(itemNames[i]);
            imageView.setImageResource(itemImages[i]);

            return view1;
        }
    }
}