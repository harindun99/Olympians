package com.example.mad;

import java.util.ArrayList;

public class CardStore {

    private static CardStore cardStore;

    public static CardStore getInstance(){
        if(cardStore == null){
             cardStore = new CardStore();

        }

        return cardStore;

    }

    private ArrayList<Card> cards = new ArrayList<>();

    public void update(Card card,int index){

        cards.set(index,card);
    }

    public Card find(int index){
        return cards.get(index);
    }

    public void add(Card card){
        cards.add(card);
    }

    public void delete(int index){
        cards.remove(index);
    }

    public ArrayList<Card> findAll(){
        return cards;
    }

}


