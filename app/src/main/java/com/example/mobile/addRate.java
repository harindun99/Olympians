package com.example.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class addRate extends AppCompatActivity {

    EditText name,review,email,rurl;
    Button btnSubmit,btnCancle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_rate);

        name = (EditText) findViewById(R.id.txtName);
        email = (EditText) findViewById(R.id.txtEmail);
        rurl = (EditText) findViewById(R.id.txtImageUrl);
        review = (EditText) findViewById(R.id.txtReview);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnCancle = (Button) findViewById(R.id.btnCancle);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(name.getText().toString())) {
                    name.setError("Please Fill the Field");
                    return;
                }
                if (TextUtils.isEmpty(email.getText().toString())) {
                    email.setError("Please Fill the Field");
                    return;
                }
                if (TextUtils.isEmpty(rurl.getText().toString())) {
                    rurl.setError("Please Fill the Field");
                    return;
                }
                if (TextUtils.isEmpty(review.getText().toString())) {
                    review.setError("Please Fill the Field");
                    return;
                } else
                insertData();
                clearAll();
            }
        });

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

        private void insertData()
        {
            Map<String,Object> map =new HashMap<>();
            map.put("name",name.getText().toString());
            map.put("email",email.getText().toString());
            map.put("rurl",rurl.getText().toString());
            map.put("review",review.getText().toString());

            FirebaseDatabase.getInstance().getReference().child("Raters").push()
                    .setValue(map)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(addRate.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(Exception e) {
                            Toast.makeText(addRate.this, "Error While Insertion", Toast.LENGTH_SHORT).show();
                        }
                    });
    }

    private void clearAll()
    {
        name.setText("");
        email.setText("");
        rurl.setText("");
        review.setText("");
    }

}