<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/7
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>商品修改</title>
</head>
<body>


<form action="  "  method="post" >

    <span>商品ID</span>
    <input type="id" name="id" value="${product.id}" readonly="true"/>
    <br/>

    <span>以下部分可修改</span>
    <br/>


    <span>商品类别</span>
    <input type="text" name="categoryId" value="${product.categoryId}"/>
    <br/>

    <span>商品名称</span>
    <input type="text" name="name" value="${product.name}"/>
    <br/>

    <span>商品副标题</span>
    <input type="text" name="subtitle" value="${product.subtitle}"/>
    <br/>

    <span>产品主图</span>
    <input type="text" name="mainImage" value="${product.mainImage}"/>
    <br/>

    <span>商品价格</span>
    <input type="text" name="price" value="${product.price}"/>
    <br/>

    <span>商品库存</span>
    <input type="text" name="stock" value="${product.stock}"/>
    <br/>


    <span>商品状态</span>
    <input type="text" name="status" value="${product.status}"/>
    <br/>


    <span>商品详情</span>
    <input type="text" name="detail" value="${product.detail}"/>
    <br/>

    <span>商品图片</span>
    <input type="text" name="subImages" value="${product.subImages}"/>
    <br/>

    <input type="submit" value="确认修改"/>
</form>




</body>
</html>
