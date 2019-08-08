<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/7
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>图片上传2</title>
</head>
<body>


<form action="  "  method="post"  enctype="multipart/form-data">
    图片上传1<input type="file" name="picfile1"/>
    <br/>
    图片上传2<input type="file" name="picfile2"/>
    <br/>
    图片上传3<input type="file" name="picfile3"/>
    <br/>



    <input type="submit" value="提交">

</form>


</body>
</html>
