package com.chat.dao;

import com.chat.pojo.FriendGroups;

import java.util.List;
import java.util.Map;

public interface FriendGroupsMapper {
    //获取用户id的分组
    List<FriendGroups> getUserGroups(Map map);
}


