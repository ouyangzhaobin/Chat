package com.chat.dao;


import com.chat.pojo.User;
import com.chat.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author WANGZIC
 * @description 数据库连接与操作类用于增删改查数据并返回给servlet使用
 */
public class UserDao {

    /**
     * 新增用户
     *
     * @param user 用户信息
     * @return 新增是否成功
     */
    public boolean insert(User user) {
       //注册
        Connection con = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        //String sql = "INSERT INTO user(U_UserName,U_PassWord,U_NickName,U_SignaTure,U_Sex,U_Birthday,U_Telephone,U_Email,U_HeadPortrait,U_UserState) VALUES(?,?,?,?,?,?,?,?,?,?)";
        String sql = "INSERT INTO user(U_UserName,U_PassWord,U_NickName,U_SignaTure,U_Sex,U_Birthday,U_Telephone,U_Email,U_HeadPortrait,U_UserState,U_ID) VALUES(?,?,?,?,?,?,?,?,?,?,0)";
        boolean res = false;
       // boolean res = true;
        try {
            pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getU_UserName());
            pstmt.setString(2, user.getU_PassWord());
            pstmt.setString(3, user.getU_NickName());
            pstmt.setString(4, user.getU_SignaTure());
            pstmt.setString(5, user.getU_Sex());
            pstmt.setString(6, user.getU_Birthday());
            pstmt.setString(7, user.getU_Telephone());
            pstmt.setString(8, user.getU_Email());
            pstmt.setString(9, user.getU_HeadPortrait());
            pstmt.setString(10, user.getU_UserState());
            //pstmt.setInt(11,u_id);
            //pstmt.setInt(11,user.getU_ID());
            //pstmt.setInt(11,12);
            res = (pstmt.executeUpdate() == 1);
        //    pstmt.execute();
     //       ResultSet rs = pstmt.getGeneratedKeys();
//            int id=0;
//            while(rs.next()) {
//                //获取id的值
//                int id = rs.getInt(11);
//            }
//            pstmt.setInt(11,id+1);



        } catch (SQLException e) {
            if (!e.getMessage().contains("PRIMARY")) {
                e.printStackTrace();
            } else {
                System.out.println("该用户名已存在");
                return false;
            }
        } finally {
            DBUtil.close(con, pstmt);
        }
        //return true;
       return res;

    }

    /**
     * 根据用户id删除用户信息
     *
     * @param U_ID 用户id
     * @return 删除是否成功
     */
    public boolean delete(Integer U_ID) {
        Connection con = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "delete from user where U_ID= ?";
        boolean res = false;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, U_ID);
            res = (pstmt.executeUpdate() == 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.close(con, pstmt);
        }
        return res;
    }

    /**
     * 更新用户信息
     *
     * @param user 修改后的用户信息
     * @return 更新是否成功
     */
    public boolean update(User user) {
        Connection con = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "update user set U_UserName=?,U_PassWord=?,U_NickName=?,U_SignaTure=?,U_Sex=?,U_Birthday=?,U_Telephone=?,U_Email=?,U_HeadPortrait=?,U_UserState=? where U_ID=?";
//        String sql = "update user set username=?,nickname=?,password=?,gender=?,phone=?,email=?,address=? where userid= ?";
        boolean res = false;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getU_UserName());
            pstmt.setString(2, user.getU_PassWord());
            pstmt.setString(3, user.getU_NickName());
            pstmt.setString(4, user.getU_SignaTure());
            pstmt.setString(5, user.getU_Sex());
            pstmt.setString(6, user.getU_Birthday());
            pstmt.setString(7, user.getU_Telephone());
            pstmt.setString(8, user.getU_Email());
            pstmt.setString(9, user.getU_HeadPortrait());
            pstmt.setString(10, user.getU_UserState());
            pstmt.setInt(11, user.getU_ID());
            // pstmt.setInt(10,user.getU_ID());
            res = (pstmt.executeUpdate() == 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.close(con, pstmt);
        }
        return res;

    }

    /**
     * 根据用户名查找用户密码
     *
     * @param U_UserName 用户名
     * @return 用户信息
     */
    public User selectByU_UserName(String U_UserName) {
        Connection con = DBUtil.getConnection();
        List<User> list = new ArrayList<>();
        String sql = "select * from user where U_UserName=?";
        PreparedStatement pstmt = null;
        ResultSet rs;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, U_UserName);
            rs = pstmt.executeQuery();
            list = resultSetToBean(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con, pstmt);
        }
        return list.isEmpty() ? null : list.get(0);
    }

    /**
     * 根据用户id查询userid用户信息
     *
     * @param U_ID 用户id
     * @return 用户信息
     */
    public User selectByU_ID(Integer U_ID) {
        Connection con = DBUtil.getConnection();
        List<User> list = new ArrayList<>();
        String sql = "select * from user where userid= ?";
        PreparedStatement pstmt = null;
        ResultSet rs;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, U_ID);
            rs = pstmt.executeQuery();
            list = resultSetToBean(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con, pstmt);
        }
        return list.isEmpty() ? null : list.get(0);
    }

    /**
     * 根据传入的参数查询用户
     *
     * @param paramMap 参数Map
     * @return 用户列表
     */
    public List<User> selectByMap(Map<String, Object> paramMap) {
        Connection con = DBUtil.getConnection();
        List<User> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from user where 1=1");
        List<Object> paramList = new ArrayList<>();
        for (String key : paramMap.keySet()) {
            sql.append(" and ").append(key).append(" = ?");
            paramList.add(paramMap.get(key));
        }
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(sql.toString());
            for (int i = 0; i < paramList.size(); i++) {
                pstmt.setObject(i, paramList.get(i));
            }
            list = resultSetToBean(pstmt.executeQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con, pstmt);
        }
        return list;
    }

    /**
     * 将查询结果转换位对象
     *
     * @param rs 查询结果
     * @return 用户列表
     * @throws SQLException
     */
    private static List<User> resultSetToBean(ResultSet rs) throws SQLException {
        List<User> list = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setU_ID(rs.getInt("U_ID"));
            user.setU_UserName(rs.getString("U_UserName"));
            user.setU_PassWord(rs.getString("U_PassWord"));
            user.setU_NickName(rs.getString("U_NickName"));
            user.setU_SignaTure(rs.getString("U_SignaTure"));
            user.setU_Sex(rs.getString("U_Sex"));
            user.setU_Birthday(rs.getString("U_Birthday"));
            user.setU_Telephone(rs.getString("U_Telephone"));
            user.setU_Email(rs.getString("U_Email"));
            user.setU_HeadPortrait(rs.getString("U_HeadPortrait"));
            user.setU_UserState(rs.getString("U_UserState"));
            list.add(user);
        }
        return list;
    }


    /**
     * 测试数据库连接是否正常
     * @param args
     */
//    public static void main(String[] args) {
//        System.out.println(new UserDao().selectByU_UserName("123"));
//        System.out.println(new UserDao().selectByMap(new HashMap<>(0)));
//    }

}
