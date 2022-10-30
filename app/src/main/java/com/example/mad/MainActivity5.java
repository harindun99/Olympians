package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        List<Card> cards = CardStore.getInstance().findAll();
        Log.d("Cards",cards.toString());
        ListView cardsListView = (ListView) findViewById(R.id.CardListView);

        CardsViewAdapter adapter = new CardsViewAdapter(this,0 ,cards);



        cardsListView.setAdapter(adapter);
    }
}