<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/6
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>增加商品类别</title>
</head>
<body>


<form action="  "  method="post" >


    <span>商品所属父类</span>
    <select id="parent_id" name="parentId">
        <c:forEach items="${categories}" var="category">
            <option value="${category.id }">${category.name}</option>
        </c:forEach>
    </select>
    <br/>


    <span>商品名</span>
    <input type="text" name="name" />
    <br/>

    <span>商品状态</span>
    <input type="text" name="status"/>
    <br/>

    <span>排序编号</span>
    <input type="text" name="sortOrder"/>
    <br/>
    <input type="submit" value="确认添加"/>
</form>


</body>
</html>
