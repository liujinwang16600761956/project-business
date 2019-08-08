<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/6
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>管理员表</title>
</head>
<body>


<a href="/admin/category/all">商品类别</a>
<a href="/admin/category/product/all">所有商品</a>



<table>
    <thead>
    <th>管理员ID</th>
    <th>管理员名称</th>
    <th>管理员密码</th>
    <th>管理员Email</th>
    <th>管理员phone</th>
    <th>找回密码问题</th>
    <th>找回密码答案</th>
    <th>创建时间</th>
    <th>最后一次更新时间</th>
    <th>管理员ip</th>
    </thead>
    <tbody>
    <c:forEach items="${userInfos}" var="userInfo">
        <tr>
            <th>${userInfo.id}</th>
            <th>${userInfo.username}</th>
            <th>${userInfo.password}</th>
            <th>${userInfo.email}</th>
            <th>${userInfo.phone}</th>
            <th>${userInfo.question}</th>
            <th>${userInfo.answer}</th>
            <th>${userInfo.createTime}</th>
            <th>${userInfo.updateTime}</th>
            <th>${userInfo.ip}</th>
            <a href="update/${userInfo.id}">编辑</a>
            <a href="delete/${userInfo.id}">删除</a>
        </tr>
    </c:forEach>
    </tbody>
    <thead>
    <a href="add">增加</a>
    </thead>


</table>




</body>
</html>
