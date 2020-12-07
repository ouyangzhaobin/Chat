package com.chat.dao;

import com.chat.pojo.UserState;

import java.util.List;
import java.util.Map;

public interface UserStateMapper {
    //查询用户id的状态
    List<UserState> getAllUserState(Map map);

}
