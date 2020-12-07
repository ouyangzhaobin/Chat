package com.chat.pojo;

/**
 * @author WANGZIC
 */
public class User {
    private Integer U_ID;

    private String U_UserName;

    private String U_PassWord;

    private String U_NickName;

    private String U_SignaTure;

    private String U_Sex;

    private String U_Birthday;

    private String U_Telephone;

    private String U_Email;

    private String U_HeadPortrait;

    private String U_UserState;

    public Integer getU_ID() {
        return U_ID;
    }

    public void setU_ID(Integer u_ID) {
        U_ID = u_ID;
    }

    public String getU_UserName() {
        return U_UserName;
    }

    public void setU_UserName(String u_UserName) {
        U_UserName = u_UserName;
    }

    public String getU_PassWord() {
        return U_PassWord;
    }

    public void setU_PassWord(String u_PassWord) {
        U_PassWord = u_PassWord;
    }

    public String getU_NickName() {
        return U_NickName;
    }

    public void setU_NickName(String u_NickName) {
        U_NickName = u_NickName;
    }

    public String getU_SignaTure() {
        return U_SignaTure;
    }

    public void setU_SignaTure(String u_SignaTure) {
        U_SignaTure = u_SignaTure;
    }

    public String getU_Sex() {
        return U_Sex;
    }

    public void setU_Sex(String u_Sex) {
        U_Sex = u_Sex;
    }

    public String getU_Birthday() {
        return U_Birthday;
    }

    public void setU_Birthday(String u_Birthday) {
        U_Birthday = u_Birthday;
    }

    public String getU_Telephone() {
        return U_Telephone;
    }

    public void setU_Telephone(String u_Telephone) {
        U_Telephone = u_Telephone;
    }

    public String getU_Email() {
        return U_Email;
    }

    public void setU_Email(String u_Email) {
        U_Email = u_Email;
    }

    public String getU_HeadPortrait() {
        return U_HeadPortrait;
    }

    public void setU_HeadPortrait(String u_HeadPortrait) {
        U_HeadPortrait = u_HeadPortrait;
    }

    public String getU_UserState() {
        return U_UserState;
    }

    public void setU_UserState(String u_UserState) {
        U_UserState = u_UserState;
    }

    @Override
    public String toString() {
        return "查询结果：User{" +
                "U_ID=" + U_ID +
                ", U_UserName='" + U_UserName + '\'' +
                ", U_PassWord='" + U_PassWord + '\'' +
                ", U_NickName='" + U_NickName + '\'' +
                ", U_SignaTure='" + U_SignaTure + '\'' +
                ", U_Sex='" + U_Sex + '\'' +
                ", U_Birthday='" + U_Birthday + '\'' +
                ", U_Telephone='" + U_Telephone + '\'' +
                ", U_Email='" + U_Email + '\'' +
                ", U_HeadPortrait='" + U_HeadPortrait + '\'' +
                ", U_UserState='" + U_UserState + '\'' +
                '}';
    }
}
