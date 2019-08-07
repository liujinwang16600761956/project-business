<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/6
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>修改商品类别</title>
</head>
<body>

<form action="  "  method="post" >

    <span>商品ID</span>
    <input type="id" name="id" value="${category.id}" readonly="true"/>
    <br/>

    <span>以下部分可修改</span>
    <br/>

    <span>商品父类ID</span>
    <input type="text" name="parent_id" value="${category.parentId}"/>
    <br/>

    <span>商品名</span>
    <input type="text" name="name" value="${category.name}"/>
    <br/>

    <span>商品状态</span>
    <input type="text" name="status" value="${category.status}"/>
    <br/>

    <span>排序编号</span>
    <input type="text" name="sort_order" value="${category.sortOrder}"/>
    <br/>

    <input type="submit" value="确认修改"/>
</form>



</body>
</html>
