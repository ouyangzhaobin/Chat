<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    Object obj = request.getSession().getAttribute("user");
    if (obj == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
主页面

<h1>当前用户：${sessionScope.user.u_UserName}</h1>
</body>
</html>
