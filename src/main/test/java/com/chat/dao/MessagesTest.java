package com.chat.dao;

import com.chat.pojo.Messages;
import com.chat.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MessagesTest {
    //查询记录
    @Test
    public void  getAllMessagesByFromUserID(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        MessagesMapper mapper = sqlSession.getMapper(MessagesMapper.class);
        HashMap<Object, Object> map = new HashMap<>();
        List<Messages> allMessagesByUserID = mapper.getAllMessagesByUserID(map);
        System.out.println("######################################################");
        System.out.println(allMessagesByUserID);
        System.out.println("######################################################");
        for (Messages messages : allMessagesByUserID) {
            if(messages.getM_FromUserID()==1 )
                System.out.println("发送方"+messages.getM_FromUserID()+"   发送内容："+messages.getM_PostMessages());
        }
        System.out.println("######################################################");
        for (Messages messages : allMessagesByUserID) {
            if(messages.getM_ToUserID()==1)
                System.out.println("接收方"+messages.getM_ToUserID()+"   接收内容："+messages.getM_PostMessages());
        }
        System.out.println("######################################################");
        //排序
        Collections.sort(allMessagesByUserID);
        System.out.println(allMessagesByUserID);
        System.out.println("######################################################");
        for (Messages messages : allMessagesByUserID) {
            if(messages.getM_FromUserID()==1 )
                System.out.println("发送方"+messages.getM_FromUserID()+"   发送内容："+messages.getM_PostMessages());
            if(messages.getM_ToUserID()==1)
                System.out.println("接收方"+messages.getM_ToUserID()+"   接收内容："+messages.getM_PostMessages());
        }
        System.out.println("######################################################");
    }
    //增加用户id和好友id的聊天记录
    @Test
    public void addMessages(){
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        MessagesMapper mapper1 = sqlSession1.getMapper(MessagesMapper.class);
        HashMap<Object, Object> map = new HashMap<>();
        List<Messages> allMessagesByUserID = mapper1.getAllMessagesByUserID(map);
        Integer FromUserID = 2;
        Integer ToUserID = 3;
        Integer count=0;
        for (Messages messages : allMessagesByUserID) {
            if (messages.getM_FromUserID() == ToUserID || messages.getM_ToUserID() == ToUserID)
                count++;
        }


        sqlSession1.close();
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        MessagesMapper mapper = sqlSession.getMapper(MessagesMapper.class);
        Messages messages = new Messages();
        messages.setM_ID(FromUserID*100000000+ToUserID*10000+count+1);
        messages.setM_PostMessages("这个是"+FromUserID+"新加给"+ToUserID+"内容"+count);
        messages.setM_status(1);
        messages.setM_Time(new Date());
        messages.setM_MessagesTypeID(1);
        messages.setM_FromUserID(FromUserID);
        messages.setM_ToUserID(ToUserID);
        mapper.addMessages(messages);
        sqlSession.commit();
        sqlSession.close();
    }
}






















