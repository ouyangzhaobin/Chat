package com.chat.pojo;

public class User_AddFriend {
    private int UAF_ID;
    private int UAF_UserID;
    private int UAF_FriendID;
    private int UAF_FriendsTableID;

    public User_AddFriend() {

    }

    public User_AddFriend(int UAF_ID, int UAF_UserID, int UAF_FriendID, int UAF_FriendsTableID) {
        this.UAF_ID = UAF_ID;
        this.UAF_UserID = UAF_UserID;
        this.UAF_FriendID = UAF_FriendID;
        this.UAF_FriendsTableID = UAF_FriendsTableID;
    }

    public int getUAF_ID() {
        return UAF_ID;
    }

    public void setUAF_ID(int UAF_ID) {
        this.UAF_ID = UAF_ID;
    }

    public int getUAF_UserID() {
        return UAF_UserID;
    }

    public void setUAF_UserID(int UAF_UserID) {
        this.UAF_UserID = UAF_UserID;
    }

    public int getUAF_FriendID() {
        return UAF_FriendID;
    }

    public void setUAF_FriendID(int UAF_FriendID) {
        this.UAF_FriendID = UAF_FriendID;
    }

    public int getUAF_FriendsTableID() {
        return UAF_FriendsTableID;
    }

    public void setUAF_FriendsTableID(int UAF_FriendsTableID) {
        this.UAF_FriendsTableID = UAF_FriendsTableID;
    }

    @Override
    public String toString() {
        return "User_AddFriend{" +
                "UAF_ID=" + UAF_ID +
                ", UAF_UserID=" + UAF_UserID +
                ", UAF_FriendID=" + UAF_FriendID +
                ", UAF_FriendsTableID=" + UAF_FriendsTableID +
                '}';
    }
}
