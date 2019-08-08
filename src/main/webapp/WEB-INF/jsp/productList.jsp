<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/7
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>商品表</title>
</head>
<body>


<table>
    <thead>
    <th>商品ID</th>
    <th>商品类别</th>
    <th>商品名称</th>
    <th>商品副标题</th>
    <th>产品主图</th>
    <th>商品价格</th>
    <th>商品库存</th>
    <th>商品状态</th>
    <th>创建时间</th>
    <th>最后一次更新时间</th>
    <th>商品详情</th>
    <th>商品图片</th>
    <th>操作</th>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="product">
        <tr>
            <th>${product.id}</th>
            <th>${product.categoryId}</th>
            <th>${product.name}</th>
            <th>${product.subtitle}</th>
            <th>${product.mainImage}</th>
            <th>${product.price}</th>
            <th>${product.stock}</th>
            <th>${product.status}</th>
            <th>${product.createTime}</th>
            <th>${product.updateTime}</th>
            <th>${product.detail}</th>
            <th>${product.subImages}</th>
            <th>
                <a href="update/${product.id}">编辑</a>
                <a href="delete/${product.id}">删除</a>
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
