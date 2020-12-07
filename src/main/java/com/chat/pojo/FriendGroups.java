package com.chat.pojo;

public class FriendGroups {
    private int FG_ID;
    private String FG_Name;
    private int FG_UserID;

    public FriendGroups() {

    }

    public FriendGroups(int FG_ID, String FG_Name, int FG_UserID) {
        this.FG_ID = FG_ID;
        this.FG_Name = FG_Name;
        this.FG_UserID = FG_UserID;
    }

    public int getFG_ID() {
        return FG_ID;
    }

    public void setFG_ID(int FG_ID) {
        this.FG_ID = FG_ID;
    }

    public String getFG_Name() {
        return FG_Name;
    }

    public void setFG_Name(String FG_Name) {
        this.FG_Name = FG_Name;
    }

    public int getFG_UserID() {
        return FG_UserID;
    }

    public void setFG_UserID(int FG_UserID) {
        this.FG_UserID = FG_UserID;
    }

    @Override
    public String toString() {
        return "FriendGroups{" +
                "FG_ID=" + FG_ID +
                ", FG_Name='" + FG_Name + '\'' +
                ", FG_UserID=" + FG_UserID +
                '}';
    }
}
