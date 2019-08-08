<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/7
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>增加商品</title>
</head>
<body>


<form action="  "  method="post" >


    <span>商品类别</span>
    <select id="category_id" name="categoryId">
        <c:forEach items="${categories}" var="category">
            <option value="${category.id }">${category.name}</option>
        </c:forEach>
    </select>
    <br/>

    <span>商品名称</span>
    <input type="text" name="name"/>
    <br/>

    <span>商品副标题</span>
    <input type="text" name="subtitle"/>
    <br/>

    <a href="uploadPic">上传产品主图</a>
    <input type="text" name="mainImage" value="${url}"/>
    <br/>

    <span>商品价格</span>
    <input type="text" name="price"/>
    <br/>

    <span>商品库存</span>
    <input type="text" name="stock"/>
    <br/>


    <span>商品状态</span>
    <input type="text" name="status"/>
    <br/>


    <span>商品详情</span>
    <input type="text" name="detail"/>
    <br/>

    <a href="uploadPic2">上传商品图片</a>
    <span>商品图片</span>
    <input type="text" name="subImages" value="${url2}"/>
    <br/>

    <input type="submit" value="确定增加"/>
</form>







</body>
</html>
