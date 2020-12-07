package com.chat.controller;



import com.chat.dao.UserDao;
import com.chat.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @description 注册请求处理类
 * @author WANGZIC
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String U_UserName = request.getParameter("U_UserName");
        String U_PassWord = request.getParameter("U_PassWord");
        String rpsw = request.getParameter("rpsw");
        if(U_UserName==null||U_UserName.trim().isEmpty()){
            request.setAttribute("registError", "用户名不能为空");
            request.getRequestDispatcher("regist.jsp").forward(request, response);
            return;
        }
        if(U_PassWord==null||U_PassWord.trim().isEmpty()){
            request.setAttribute("registError", "密码不能为空");
            request.getRequestDispatcher("regist.jsp").forward(request, response);
            return;
        }
        if(!U_PassWord.equals(rpsw)){
            request.setAttribute("registError", "密码不一致");
            request.getRequestDispatcher("regist.jsp").forward(request, response);
            return;
        }
        UserDao dao = new UserDao();
        User user =new User();
        user.setU_UserName(U_UserName);
        user.setU_PassWord(U_PassWord);
        if(dao.selectByU_UserName(U_UserName)!=null){
            request.setAttribute("registError", "注册失败，该用户名已存在");
            request.getRequestDispatcher("regist.jsp").forward(request, response);
        }else {
            if(dao.insert(user)){
                response.sendRedirect("index.jsp");
            }else {
                request.setAttribute("registError", "注册失败，发生未知错误");
                request.getRequestDispatcher("regist.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
