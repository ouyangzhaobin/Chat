package com.chat.dao;

import com.chat.pojo.FriendsTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FriendsTableMapper {

    //增加用户id和好友id的好友关系
    int addFriendsTable(FriendsTable friendsTable);

    //删除用户id和好友id的关系
    int deleteFriendsTable(int F_ID);

    //更新用户id与好友id的关系
    int updateFriendsTable(FriendsTable friendsTable);

    //获取用户id与好友id的好友关系
    List<FriendsTable> getUserIDFriend(Map map);

}
