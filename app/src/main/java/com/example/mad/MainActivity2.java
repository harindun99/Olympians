package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText t;
    EditText t1;
    EditText t2;
    Spinner s;
    String type;
    int currentCardNumber;
    int currentCardIndex = -1;
    String currentType;
    String currentCardHolderName;
    String currentDate;
    DB database;

    public void onSave(View a){

        int CardNumber = Integer.parseInt(t.getText().toString());
        String cHoldersName = t2.getText().toString();
        String date = t1.getText().toString();
        Card card = new Card(CardNumber,type,cHoldersName,date);
        card.setCardNo(CardNumber);
        card.setcHoldersName(cHoldersName);
        card.setDate(date);
        Log.d("CardIndex",String.valueOf(currentCardIndex));

        if(currentCardIndex != -1){

            CardStore.getInstance().update(card,currentCardIndex);

        }
        else{
            CardStore.getInstance().add(card);
            database.saveCardDetails(cHoldersName, card,this);
            Toast.makeText(this, "Card Saved", Toast.LENGTH_SHORT).show();
        }


        startActivity(new Intent(this, MainActivity5.class));





    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = new DB();
        setContentView(R.layout.activity_main2);
        t= (EditText)findViewById(R.id.editTextNumber);
        t1= (EditText)findViewById(R.id.editTextNumberDecimal);
        t2= (EditText)findViewById(R.id.editTextTextPersonName2);
        s = (Spinner)findViewById((R.id.CardTypeS));
        s.setOnItemSelectedListener(this);
        try {
            currentCardIndex = getIntent().getExtras().getInt("CardIndex",-1);
            currentCardNumber = getIntent().getExtras().getInt("CardNumber",0);
            currentCardHolderName = getIntent().getExtras().getString("CardHolderName");
            currentType = getIntent().getExtras().getString("currentType");
            currentDate = getIntent().getExtras().getString("currentDate");

            if(currentCardNumber != 0){
                t.setText(String.valueOf(currentCardNumber));

            }
            if(currentCardHolderName != null){
                t2.setText(currentCardHolderName);
            }
            if(currentType != null){

            }

            if(currentDate != null){
                t1.setText(currentDate);
            }

        }catch (Exception e){

        }







    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
         type = adapterView.getItemAtPosition(i).toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        type = "";
    }
}