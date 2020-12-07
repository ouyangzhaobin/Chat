package com.chat.pojo;

public class UserState {
    private int US_ID;
    private String US_Name;

    public UserState() {
    }

    public UserState(int US_ID, String US_Name) {
        this.US_ID = US_ID;
        this.US_Name = US_Name;
    }

    public int getUS_ID() {
        return US_ID;
    }

    public void setUS_ID(int US_ID) {
        this.US_ID = US_ID;
    }

    public String getUS_Name() {
        return US_Name;
    }

    public void setUS_Name(String US_Name) {
        this.US_Name = US_Name;
    }

    @Override
    public String toString() {
        return "UserState{" +
                "US_ID=" + US_ID +
                ", US_Name='" + US_Name + '\'' +
                '}';
    }
}
