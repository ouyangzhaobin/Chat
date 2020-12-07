package com.chat.dao;

import com.chat.pojo.FriendsEvaluation;

import java.util.List;
import java.util.Map;

public interface FriendsEvaluationMapper {
    //获取用户id收到的所有好友评价
    List<FriendsEvaluation> getAllEvaluationByUserID(Map map);
    //增加用户id收到好友id的评价
    int addFriendsEvaluation(FriendsEvaluation friendsEvaluation);

}
