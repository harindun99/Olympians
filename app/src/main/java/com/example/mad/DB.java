package com.example.mad;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class DB {
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    public DB() {

    }

    public void saveCardDetails(String cardHolder, Card card, Context context){

        Map<String,Object> data = new HashMap<>();
        data.put(cardHolder,card);


        firestore.collection("Card Details").add(data).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {

            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(context,"Success",Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(context,"Fail",Toast.LENGTH_LONG).show();
            }
        });
    }
}
