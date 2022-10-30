package com.example.mad;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CardsViewAdapter extends ArrayAdapter<Card> {


    public CardsViewAdapter(@NonNull Context context, int resource, @NonNull List<Card> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View currentItemView = convertView;


        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.card, parent, false);
        }

        Card card = CardStore.getInstance().find(position);
        Log.d("Card Number",card.toString());


        TextView cardNumberTextView  = currentItemView.findViewById(R.id.TextViewNo);
        cardNumberTextView.setText(String.valueOf(card.getCardNo()));




        TextView cardTypeTextView = currentItemView.findViewById(R.id.textViewType);
        cardTypeTextView.setText(card.getType());

        Button deleteButton = currentItemView.findViewById(R.id.deletebtn);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CardStore.getInstance().delete(position);
                refreshPage();
            }
        });
        Button editButton = currentItemView.findViewById(R.id.editbtn);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoEditIntent = new Intent(view.getContext(),MainActivity2.class);
                gotoEditIntent.putExtra("CardIndex",position);
                gotoEditIntent.putExtra("CardNumber",card.getCardNo());
                gotoEditIntent.putExtra("CardHolderName",card.getcHoldersName());
                gotoEditIntent.putExtra("currentType",card.getType());
                gotoEditIntent.putExtra("currentDate",card.getDate());
                view.getContext().startActivity(gotoEditIntent);
                refreshPage();
            }
        });

        return currentItemView;
    }

    public void refreshPage(){
//        this.clear();
        Log.d("Updated",CardStore.getInstance().findAll().toString());
//        this.addAll(CardStore.getInstance().findAll());
        this.notifyDataSetChanged();

    }


}
