package com.example.mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class allReviews extends AppCompatActivity {

    RecyclerView recyclerView;
    allReviewsAdapter allreviewsAdapter;

    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_reviews);

        recyclerView = (RecyclerView)findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<allReviewsModel> options =
                new FirebaseRecyclerOptions.Builder<allReviewsModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Raters"), allReviewsModel.class)
                        .build();

        allreviewsAdapter = new allReviewsAdapter(options);
        recyclerView.setAdapter(allreviewsAdapter);

        btnBack = (Button) findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        allreviewsAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        allreviewsAdapter.startListening();
    }
}