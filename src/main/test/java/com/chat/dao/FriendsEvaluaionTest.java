package com.chat.dao;

import com.chat.pojo.FriendsEvaluation;
import com.chat.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import java.util.HashMap;
import java.util.List;

public class FriendsEvaluaionTest {
    //获取用户id收到的所有好友评价
    @Test
    public void getUserIDFriend() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FriendsEvaluationMapper mapper = sqlSession.getMapper(FriendsEvaluationMapper.class);
        HashMap<String, Integer> map = new HashMap<>();
        //用户id
        map.put("FE_ToUserID", 1);
        //
        List<FriendsEvaluation> allEvaluationByUserID = mapper.getAllEvaluationByUserID(map);
        System.out.println("#####################################");
        System.out.println(allEvaluationByUserID);
        System.out.println("#####################################");
        for (FriendsEvaluation friendsEvaluation : allEvaluationByUserID) {
            System.out.println(friendsEvaluation);
        }
        System.out.println("#####################################");

        //打印用户收到指定用户的评价
        for (FriendsEvaluation friendsEvaluation : allEvaluationByUserID) {
            if (friendsEvaluation.getFE_FromUserID() == 2)
                System.out.println(friendsEvaluation);
        }
        System.out.println("#####################################");

        sqlSession.commit();
        sqlSession.close();
    }

    //增加用户id收到好友id的评价
    @Test
    public void addFriendsEvaluation() {
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        FriendsEvaluationMapper mapper1 = sqlSession1.getMapper(FriendsEvaluationMapper.class);
        HashMap<String, Integer> map = new HashMap<>();
        List<FriendsEvaluation> allEvaluationByUserID = mapper1.getAllEvaluationByUserID(map);

        Integer count = 0;
        Integer UserID = 1;
        Integer FriendID = 2;

        for (FriendsEvaluation friendsEvaluation : allEvaluationByUserID) {
            if((friendsEvaluation.getFE_FromUserID()==FriendID )&& (friendsEvaluation.getFE_ToUserID()==UserID))
                count++;
        }
        sqlSession1.close();


        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        FriendsEvaluationMapper mapper2 = sqlSession2.getMapper(FriendsEvaluationMapper.class);
        Integer FriendsEvaluaionID = UserID*100000000+FriendID*10000+count+1;
        String FE_EvaluationContent = new String("这个是insert的评价内容");
        FriendsEvaluation friendsEvaluaion2 = new FriendsEvaluation(FriendsEvaluaionID, UserID, FriendID, FE_EvaluationContent);
        mapper2.addFriendsEvaluation(friendsEvaluaion2);

        sqlSession2.commit();
        sqlSession2.close();
    }
}
