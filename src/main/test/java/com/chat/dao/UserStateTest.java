package com.chat.dao;

import com.chat.pojo.UserState;
import com.chat.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserStateTest {
    //查询用户id的状态
    @Test
    public void getAllUserState() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserStateMapper mapper = sqlSession.getMapper(UserStateMapper.class);
        HashMap<Object, Object> map = new HashMap<>();

        List<UserState> allUserState = mapper.getAllUserState(map);
        System.out.println("#################################################");
        for (UserState userState : allUserState) {
            System.out.println(userState);
        }
        System.out.println("#################################################");
        for (UserState userState : allUserState) {
           if(userState.getUS_ID()==1)
               System.out.println("状态ID:"+userState.getUS_ID()+"   状态名称："+userState.getUS_Name());
        }
        System.out.println("#################################################");

    }
}








