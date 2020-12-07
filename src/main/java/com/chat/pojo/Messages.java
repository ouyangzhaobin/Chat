package com.chat.pojo;

import java.util.Date;

public class Messages implements Comparable<Messages> {
    private int M_ID;
    private String M_PostMessages;
    private int M_status;
    private Date M_Time;
    private int M_MessagesTypeID;
    private int M_FromUserID;
    private int M_ToUserID;

    public Messages() {

    }

    public Messages(int m_ID, String m_PostMessages, int m_status, Date m_Time, int m_MessagesTypeID, int m_FromUserID, int m_ToUserID) {
        M_ID = m_ID;
        M_PostMessages = m_PostMessages;
        M_status = m_status;
        M_Time = m_Time;
        M_MessagesTypeID = m_MessagesTypeID;
        M_FromUserID = m_FromUserID;
        M_ToUserID = m_ToUserID;
    }

    public int getM_ID() {
        return M_ID;
    }

    public void setM_ID(int m_ID) {
        M_ID = m_ID;
    }

    public String getM_PostMessages() {
        return M_PostMessages;
    }

    public void setM_PostMessages(String m_PostMessages) {
        M_PostMessages = m_PostMessages;
    }

    public int getM_status() {
        return M_status;
    }

    public void setM_status(int m_status) {
        M_status = m_status;
    }

    public Date getM_Time() {
        return M_Time;
    }

    public void setM_Time(Date m_Time) {
        M_Time = m_Time;
    }

    public int getM_MessagesTypeID() {
        return M_MessagesTypeID;
    }

    public void setM_MessagesTypeID(int m_MessagesTypeID) {
        M_MessagesTypeID = m_MessagesTypeID;
    }

    public int getM_FromUserID() {
        return M_FromUserID;
    }

    public void setM_FromUserID(int m_FromUserID) {
        M_FromUserID = m_FromUserID;
    }

    public int getM_ToUserID() {
        return M_ToUserID;
    }

    public void setM_ToUserID(int m_ToUserID) {
        M_ToUserID = m_ToUserID;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "M_ID=" + M_ID +
                ", M_PostMessages='" + M_PostMessages + '\'' +
                ", M_status=" + M_status +
                ", M_Time=" + M_Time +
                ", M_MessagesTypeID=" + M_MessagesTypeID +
                ", M_FromUserID=" + M_FromUserID +
                ", M_ToUserID=" + M_ToUserID +
                '}';
    }

    @Override
    public int compareTo(Messages messages) {
        if (this.getM_ID()%10000 > messages.getM_ID()%10000) {
            return 1;

        } else if (this.getM_ID()%10000 < messages.getM_ID()%10000) {
            return -1;

        } else {
            return 0;

        }
    }
}
