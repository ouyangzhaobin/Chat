package com.chat.dao;


import com.chat.pojo.FriendGroups;
import com.chat.pojo.FriendsTable;
import com.chat.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class FriendGroupsTest {
    @Test
    public void getUserGroups(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FriendGroupsMapper mapper = sqlSession.getMapper(FriendGroupsMapper.class);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        //好友分组id和好友ids
        map.put("FG_ID",10001);
        map.put("FG_UserID",1);
        List<FriendGroups> friendGroupsList = mapper.getUserGroups(map);
        System.out.println("###################################################");
        System.out.println(friendGroupsList);
        System.out.println("###################################################");
        for (FriendGroups friendGroups : friendGroupsList) {
            System.out.println(friendGroups.getFG_Name());
        }
        System.out.println("###################################################");

        sqlSession.commit();
        sqlSession.close();
    }


}
