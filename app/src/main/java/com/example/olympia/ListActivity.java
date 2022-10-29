package com.example.olympia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {
    String productList[] = {"Backpack", "Bayernkit", "Hoodie", "Eurokit", "Jumper", "Jumper2", "Sneakers", "Shirt"};
    int productImages [] = {R.drawable.backpack, R.drawable.bayernkit, R.drawable.hoodie, R.drawable.eurokit, R.drawable.jumper, R.drawable.jumper2, R.drawable.sneakers, R.drawable.shirt};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = (ListView) findViewById(R.id.customListView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(),productList, productImages);
        listView.setAdapter(customBaseAdapter);

    }
}