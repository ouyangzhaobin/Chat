package com.chat.dao;

import com.chat.pojo.Messages;

import java.util.List;
import java.util.Map;

public interface MessagesMapper {
    //获取用户id的所有消息
    List<Messages> getAllMessagesByUserID(Map map);
    //增加用户id的消息
    int addMessages(Messages messages);


}
