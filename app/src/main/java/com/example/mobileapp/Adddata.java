package com.example.mobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobileapp.User.MyRatings;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Adddata extends AppCompatActivity {

    EditText name,review, email, purl;
    Button submit, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddata);

        name = (EditText) findViewById(R.id.add_name);
        email = (EditText) findViewById(R.id.add_email);
        review = (EditText) findViewById(R.id.add_course);
        purl = (EditText) findViewById(R.id.add_purl);

        back = (Button) findViewById(R.id.add_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), MyRatings.class));
                finish();
            }
        });

        submit = (Button) findViewById(R.id.add_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(name.getText().toString())){
                    name.setError("Please fill this field");
                    return;
                }
                if(TextUtils.isEmpty(email.getText().toString())){
                    email.setError("Please fill this field");
                    return;
                }
                if(TextUtils.isEmpty(review.getText().toString())){
                    review.setError("Please fill this field");
                    return;
                }
                if(TextUtils.isEmpty(purl.getText().toString())){
                    purl.setError("Please fill this field");
                    return;
                }else
                processinsert();
            }


        });

    }

    private void processinsert() {
        Map<String,Object> map = new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("review",review.getText().toString());
        map.put("email",email.getText().toString());
        map.put("iurl",purl.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("items").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        name.setText("");
                        review.setText("");
                        email.setText("");
                        purl.setText("");
                        Toast.makeText(getApplicationContext(), "Inserted successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(getApplicationContext(), "Could not insert", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}