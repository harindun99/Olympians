package com.example.mad;

public class Card {
    private int cardNo;
    private String type;
    private String cHoldersName;
    private String date;

    @Override
    public String toString() {
        return "Card{" +
                "cardNo=" + cardNo +
                ", type='" + type + '\'' +
                ", cHoldersName='" + cHoldersName + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public Card(int cardNo, String type, String cHoldersName, String date) {
        this.cardNo = cardNo;
        this.type = type;
        this.cHoldersName = cHoldersName;
        this.date = date;
    }

    public Card() {

    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setcHoldersName(String cHoldersName) {
        this.cHoldersName = cHoldersName;
    }

    public void setDate(String date) {
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
