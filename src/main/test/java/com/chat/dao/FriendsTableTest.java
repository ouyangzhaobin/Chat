package com.chat.dao;

import com.chat.pojo.FriendsTable;
import com.chat.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.List;

public class FriendsTableTest {


    //增加用户id与好友id的好友关系
    @Test
    public void addFriendsTable() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FriendsTableMapper mapper = sqlSession.getMapper(FriendsTableMapper.class);


        Integer UserID = 1;
        Integer FriendID = 6;

        Integer FriendsTableID1 = UserID * 10000 + FriendID;
        Integer FriendTypeID1 = 1;
        Integer GroupsID1 = UserID * 10000 + 1;
        String FriendName1 = new String("新加好友的备注");
        FriendsTable friendsTable1 = new FriendsTable();
        friendsTable1.setF_ID(FriendsTableID1);
        friendsTable1.setF_UserID(UserID);
        friendsTable1.setF_FriendID(FriendID);
        friendsTable1.setF_FriendTypeID(FriendTypeID1);
        friendsTable1.setF_FriendGroupsID(GroupsID1);
        friendsTable1.setF_Name(FriendName1);
        mapper.addFriendsTable(friendsTable1);


        Integer FriendsTableID2 = FriendID * 10000 + UserID;
        Integer FriendTypeID2 = 1;
        Integer GroupsID2 = FriendID * 10000 + 1;
        String FriendName2 = new String("新被加好友的备注");
        FriendsTable friendsTable2 = new FriendsTable();
        friendsTable2.setF_ID(FriendsTableID2);
        friendsTable2.setF_UserID(FriendID);
        friendsTable2.setF_FriendID(UserID);
        friendsTable2.setF_FriendTypeID(FriendTypeID2);
        friendsTable2.setF_FriendGroupsID(GroupsID2);
        friendsTable2.setF_Name(FriendName2);
        mapper.addFriendsTable(friendsTable2);
        sqlSession.commit();
        sqlSession.close();

    }

    //删除用户id与好友id的所有关系
    @Test
    public void deleteFriendsTable() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FriendsTableMapper mapper = sqlSession.getMapper(FriendsTableMapper.class);
        Integer UserID = 1;
        Integer FriendID = 6;
        Integer F_ID1 = UserID * 10000 + FriendID;
        Integer F_ID2 = FriendID * 10000 + UserID;

        mapper.deleteFriendsTable(F_ID1);
        mapper.deleteFriendsTable(F_ID2);
        sqlSession.commit();
        sqlSession.close();
    }

    //更新用户id与好友id的关系
    @Test
    public void updateFriendsTable() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FriendsTableMapper mapper = sqlSession.getMapper(FriendsTableMapper.class);

        Integer UserID = 1;
        Integer FriendID = 6;
        Integer FriendsTableID = UserID * 10000 + FriendID;
        String Name = new String("更改后的备注");
        Integer FriendTypeID = 1;
        Integer GroupsID = UserID * 10000 + 2;
        FriendsTable friendsTable = new FriendsTable(FriendsTableID, UserID, FriendID, Name, FriendTypeID, GroupsID);
        mapper.updateFriendsTable(friendsTable);

        sqlSession.commit();
        sqlSession.close();
    }

    //查询用户id的好友id的好友
    @Test
    public void getUserIDFriend() {
        SqlSession session = MybatisUtils.getSqlSession();
        FriendsTableMapper mapper = session.getMapper(FriendsTableMapper.class);
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        Integer F_UserID = 1;
        Integer F_FriendID = 2;
        //用户id和好友id
        map.put("F_UserID", F_UserID);
        map.put("F_FriendID", F_FriendID);

        List<FriendsTable> friendsTableList = mapper.getUserIDFriend(map);
        System.out.println("###################################################");
        System.out.println(friendsTableList);
        System.out.println("###################################################");
        for (FriendsTable friendsTable : friendsTableList) {
            System.out.println(friendsTable.getF_Name());
        }
        System.out.println("###################################################");
        session.commit();
        session.close();
    }

}
