<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/6
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加商品类别</title>
</head>
<body>


<form action="  "  method="post" >


    <span>商品ID</span>
    <input type="text" name="id"/>
    <br/>

    <span>商品父类ID</span>
    <input type="text" name="parentId"/>
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
