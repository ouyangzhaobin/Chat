package com.chat.pojo;

public class FriendType {
    private int FT_ID;
    private String FT_Name;

    public FriendType() {

    }

    public FriendType(int FT_ID, String FT_Name) {
        this.FT_ID = FT_ID;
        this.FT_Name = FT_Name;
    }

    public int getFT_ID() {
        return FT_ID;
    }

    public void setFT_ID(int FT_ID) {
        this.FT_ID = FT_ID;
    }

    public String getFT_Name() {
        return FT_Name;
    }

    public void setFT_Name(String FT_Name) {
        this.FT_Name = FT_Name;
    }

    @Override
    public String toString() {
        return "FriendType{" +
                "FT_ID=" + FT_ID +
                ", FT_Name='" + FT_Name + '\'' +
                '}';
    }
}
