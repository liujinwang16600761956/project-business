<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/7
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加管理员</title>
</head>
<body>

<form action="  "  method="post" >


    <span>管理员名称</span>
    <input type="text" name="username" />
    <br/>

    <span>管理员密码</span>
    <input type="text" name="password"/>
    <br/>

    <span>管理员Email</span>
    <input type="text" name="email"/>
    <br/>

    <span>管理员phone</span>
    <input type="text" name="phone" />
    <br/>

    <span>找回密码问题</span>
    <input type="text" name="question"/>
    <br/>

    <span>找回密码答案</span>
    <input type="text" name="answer"/>
    <br/>

    <span>管理员ip</span>
    <input type="text" name="ip"/>
    <br/>

    <input type="submit" value="确认修改"/>
</form>

</body>
</html>
