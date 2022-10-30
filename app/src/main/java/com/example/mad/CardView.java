package com.example.mad;

public class CardView {
    private int cardNo;
    private String type;
    private String cHoldersName;
    private String date;


    public CardView(int cardNo, String type, String cHoldersName, String date) {
        this.cardNo = cardNo;
        this.type = type;
        this.cHoldersName = cHoldersName;
        this.date = date;
    }

    public int getCardNo() {
        return cardNo;
    }

    public String getType() {
        return type;
    }

    public String getcHoldersName() {
        return cHoldersName;
    }

    public String getDate() {
        return date;
    }


}
