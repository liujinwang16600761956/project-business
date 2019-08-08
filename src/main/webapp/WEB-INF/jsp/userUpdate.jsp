<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/7
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page isELIgnored="false" %>

<html>
<head>
    <title>用户修改页面</title>
</head>
<body>

<form action="  "  method="post" >

    <span>管理员ID</span>
    <input type="id" name="id" value="${userInfo.id}" readonly="true"/>
    <br/>

    <span>以下部分可修改</span>
    <br/>


    <span>管理员名称</span>
    <input type="text" name="username" value="${userInfo.username}"/>
    <br/>

    <span>管理员密码</span>
    <input type="text" name="password" value="${userInfo.password}"/>
    <br/>

    <span>管理员Email</span>
    <input type="text" name="email" value="${userInfo.email}"/>
    <br/>

    <span>管理员phone</span>
    <input type="text" name="phone" value="${userInfo.phone}"/>
    <br/>

    <span>找回密码问题</span>
    <input type="text" name="question" value="${userInfo.question}"/>
    <br/>

    <span>找回密码答案</span>
    <input type="text" name="answer" value="${userInfo.answer}"/>
    <br/>

    <span>管理员ip</span>
    <input type="text" name="ip" value="${userInfo.ip}"/>
    <br/>
    <input type="submit" value="确认修改"/>
</form>



</body>
</html>
