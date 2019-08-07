<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/6
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>商品类</title>
</head>
<body>

<table>
    <thead>
        <th>商品ID</th>
        <th>商品父类ID</th>
        <th>商品名</th>
        <th>商品状态</th>
        <th>排序编号</th>
        <th>创建时间</th>
        <th>最后一次更新时间</th>
        <th>操作</th>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="category">
        <tr>
            <th>${category.id}</th>
            <th>${category.parentId}</th>
            <th>${category.name}</th>
            <th>${category.status}</th>
            <th>${category.sortOrder}</th>
            <th>${category.createTime}</th>
            <th>${category.updateTime}</th>
            <th>
                <a href="update/${category.id}">编辑</a>
                <a href="delete/${category.id}">删除</a>
            </th>
        </tr>
    </c:forEach>
    </tbody>

    <thead>
    <a href="add">增加</a>
    </thead>

</table>



</body>
</html>
