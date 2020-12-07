package com.chat.pojo;

public class FriendsEvaluation {
    private int FE_ID;
    private int FE_ToUserID;
    private int FE_FromUserID;
    private String FE_EvaluationContent;

    public FriendsEvaluation() {
    }

    public FriendsEvaluation(int FE_ID, int FE_ToUserID, int FE_FromUserID, String FE_EvaluationContent) {
        this.FE_ID = FE_ID;
        this.FE_ToUserID = FE_ToUserID;
        this.FE_FromUserID = FE_FromUserID;
        this.FE_EvaluationContent = FE_EvaluationContent;
    }

    public int getFE_ID() {
        return FE_ID;
    }

    public void setFE_ID(int FE_ID) {
        this.FE_ID = FE_ID;
    }

    public int getFE_ToUserID() {
        return FE_ToUserID;
    }

    public void setFE_ToUserID(int FE_ToUserID) {
        this.FE_ToUserID = FE_ToUserID;
    }

    public int getFE_FromUserID() {
        return FE_FromUserID;
    }

    public void setFE_FromUserID(int FE_FromUserID) {
        this.FE_FromUserID = FE_FromUserID;
    }

    public String getFE_EvaluationContent() {
        return FE_EvaluationContent;
    }

    public void setFE_EvaluationContent(String FE_EvaluationContent) {
        this.FE_EvaluationContent = FE_EvaluationContent;
    }

    @Override
    public String toString() {
        return "FriendsEvaluation{" +
                "FE_ID=" + FE_ID +
                ", FE_ToUserID=" + FE_ToUserID +
                ", FE_FromUserID=" + FE_FromUserID +
                ", FE_EvaluationContent='" + FE_EvaluationContent + '\'' +
                '}';
    }
}
