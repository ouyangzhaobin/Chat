package com.chat.pojo;

public class MessagesType {
    private int MT_ID;
    private String MT_Name;

    public MessagesType() {

    }

    public MessagesType(int MT_ID, String MT_Name) {
        this.MT_ID = MT_ID;
        this.MT_Name = MT_Name;
    }

    public int getMT_ID() {
        return MT_ID;
    }

    public void setMT_ID(int MT_ID) {
        this.MT_ID = MT_ID;
    }

    public String getMT_Name() {
        return MT_Name;
    }

    public void setMT_Name(String MT_Name) {
        this.MT_Name = MT_Name;
    }

    @Override
    public String toString() {
        return "MessagesType{" +
                "MT_ID=" + MT_ID +
                ", MT_Name='" + MT_Name + '\'' +
                '}';
    }
}
