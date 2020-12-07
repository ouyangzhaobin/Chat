package com.chat.pojo;

public class FriendsTable {
    private int F_ID;
    private int F_UserID;
    private int F_FriendID;
    private String F_Name;
    private int F_FriendTypeID;
    private int F_FriendGroupsID;

    public FriendsTable() {
    }

    public FriendsTable(int f_ID, int f_UserID, int f_FriendID, String f_Name, int f_FriendTypeID, int f_FriendGroupsID) {
        F_ID = f_ID;
        F_UserID = f_UserID;
        F_FriendID = f_FriendID;
        F_Name = f_Name;
        F_FriendTypeID = f_FriendTypeID;
        F_FriendGroupsID = f_FriendGroupsID;
    }

    public int getF_ID() {
        return F_ID;
    }

    public void setF_ID(int f_ID) {
        F_ID = f_ID;
    }

    public int getF_UserID() {
        return F_UserID;
    }

    public void setF_UserID(int f_UserID) {
        F_UserID = f_UserID;
    }

    public int getF_FriendID() {
        return F_FriendID;
    }

    public void setF_FriendID(int f_FriendID) {
        F_FriendID = f_FriendID;
    }

    public String getF_Name() {
        return F_Name;
    }

    public void setF_Name(String f_Name) {
        F_Name = f_Name;
    }

    public int getF_FriendTypeID() {
        return F_FriendTypeID;
    }

    public void setF_FriendTypeID(int f_FriendTypeID) {
        F_FriendTypeID = f_FriendTypeID;
    }

    public int getF_FriendGroupsID() {
        return F_FriendGroupsID;
    }

    public void setF_FriendGroupsID(int f_FriendGroupsID) {
        F_FriendGroupsID = f_FriendGroupsID;
    }

    @Override
    public String toString() {
        return "FriendsTable{" +
                "F_ID=" + F_ID +
                ", F_UserID=" + F_UserID +
                ", F_FriendID=" + F_FriendID +
                ", F_Name='" + F_Name + '\'' +
                ", F_FriendTypeID=" + F_FriendTypeID +
                ", F_FriendGroupsID=" + F_FriendGroupsID +
                '}';
    }
}
