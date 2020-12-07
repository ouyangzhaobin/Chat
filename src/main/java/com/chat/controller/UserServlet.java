package com.chat.controller;

import com.chat.dao.UserDao;
import com.chat.pojo.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Servlet implementation class UserServlet
 * @author WANGZIC
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserDao dao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String act =request.getParameter("act");
        if(act!=null){
            //根据传输的act调用不同的方法进行处理
            switch (act) {
                case "toUpdatePage":
                    toUpdatePage(request,response);
                    break;
                case "select":
                    selectAllUsers(request,response);
                    break;
                case "insert":
                    insertUser(request,response);
                    break;
                case "update":
                    updateUser(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                default:selectAllUsers(request,response);
                    break;
            }
        }else {
            response.getWriter().print("act参数不能位空，请检查是否传输了该参数！");
        }

    }

    private void toUpdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        Integer U_ID =Integer.valueOf(request.getParameter("U_ID"));
        User user = dao.selectByU_ID(U_ID);
        request.setAttribute("updateUser", user);
        request.getRequestDispatcher("pages/usermgr/update.jsp").forward(request, response);
    }

    private void selectAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> list = dao.selectByMap(new HashMap<String,Object>(0));
        request.setAttribute("userList", list);
        request.getRequestDispatcher("pages/usermgr/index.jsp").forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String U_UserName= request.getParameter("U_UserName");
        String U_PassWord = request.getParameter("U_PassWord");
        String U_NickName = request.getParameter("U_NickName");
        String U_SignaTure = request.getParameter("U_SignaTure");
        String U_Sex = request.getParameter("U_Sex");
        String U_Birthday = request.getParameter("U_Birthday");
        String U_Telephone = request.getParameter("U_Telephone");
        String U_Email = request.getParameter("U_Email");
        String U_HeadPortrait = request.getParameter("U_HeadPortrait");
        //String U_UserStateID =request.getParameter("U_UserStateID");
        User user = new User();
        if(U_UserName!=null){
            user.setU_UserName(U_UserName);
        }
        if(U_PassWord!=null){
            user.setU_PassWord(U_PassWord);
        }
        if(U_NickName!=null){
            user.setU_NickName(U_NickName);
        }
        if(U_SignaTure!=null){
            user.setU_SignaTure(U_SignaTure);
        }if(U_Sex!=null){
            user.setU_Sex(U_Sex);
        }
        if(U_Birthday!=null){
            user.setU_Birthday(U_Birthday);
        }
        if(U_Telephone!=null){
            user.setU_Telephone(U_Telephone);
        }
        if(U_Email!=null){
            user.setU_Email(U_Email);
        }
        if(U_HeadPortrait!=null){
            user.setU_HeadPortrait(U_HeadPortrait);
        }

//        if(U_UserStateID!=null){
//            user.setU_UserStateID(Integer.valueOf(U_UserStateID));
//        }

        if(dao.insert(user)){
            request.getSession().setAttribute("resultMSG", "新增成功");
            response.sendRedirect("UserServlet?act=select");
        }else {
            request.getSession().setAttribute("resultMSG", "新增失败");
            request.getRequestDispatcher("pages/usermgr/insert.jsp").forward(request, response);
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        Integer U_ID =Integer.valueOf(request.getParameter("U_ID"));
        if(dao.delete(U_ID)){
            request.getSession().setAttribute("resultMSG", "删除成功");
        }else {
            request.getSession().setAttribute("resultMSG", "删除失败");
        }
        response.sendRedirect("UserServlet?act=select");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String U_ID =request.getParameter("U_ID");
        String U_UserName= request.getParameter("U_UserName");
        String U_PassWord = request.getParameter("U_PassWord");
        String U_NickName = request.getParameter("U_NickName");
        String U_SignaTure = request.getParameter("U_SignaTure");
        String U_Sex = request.getParameter("U_Sex");
        String U_Birthday = request.getParameter("U_Birthday");
        String U_Telephone = request.getParameter("U_Telephone");
        String U_Email = request.getParameter("U_Email");
        String U_HeadPortrait = request.getParameter("U_HeadPortrait");
       String U_UserState =request.getParameter("U_UserState");
        User user = new User();
        if(U_ID!=null){
            user.setU_ID(Integer.valueOf(U_ID));
        }
        if(U_UserName!=null){
            user.setU_UserName(U_UserName);
        }
        if(U_PassWord!=null){
            user.setU_PassWord(U_PassWord);
        }
        if(U_NickName!=null){
            user.setU_NickName(U_NickName);
        }
        if(U_SignaTure!=null){
            user.setU_SignaTure(U_SignaTure);
        }if(U_Sex!=null){
            user.setU_Sex(U_Sex);
        }
        if(U_Birthday!=null){
            user.setU_Birthday(U_Birthday);
        }
        if(U_Telephone!=null){
            user.setU_Telephone(U_Telephone);
        }
        if(U_Email!=null){
            user.setU_Email(U_Email);
        }
        if(U_HeadPortrait!=null){
            user.setU_HeadPortrait(U_HeadPortrait);
        }

        if(U_UserState!=null){
            user.setU_UserState(U_UserState);
        }
        if(dao.update(user)){
            request.getSession().setAttribute("resultMSG", "修改成功");
            response.sendRedirect("UserServlet?act=select");
        }else {
            request.setAttribute("updateUser", user);
            request.getSession().setAttribute("resultMSG","修改失败");
            request.getRequestDispatcher("pages/usermgr/update.jsp").forward(request, response);
        }
    }
}
