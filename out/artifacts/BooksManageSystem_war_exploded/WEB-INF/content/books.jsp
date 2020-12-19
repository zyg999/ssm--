<%--
网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
author yeeku.H.lee kongyeeku@163.com 公众号: fkbooks
version 1.0
Copyright (C), 2001-2020, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=utf-8" language="java" errorPage=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-4.3.1/css/bootstrap.min.css">
	<script src="${pageContext.request.contextPath}/resources/jquery-3.4.1.min.js">
	</script>
	<script src="${pageContext.request.contextPath}/resources/bootstrap-4.3.1/js/bootstrap.bundle.min.js">
	</script>
	<title> 图书列表 </title>
</head>
<body>
<br class="container">
<c:if test="${not empty tip}">
<div class="toast" role="alert" aria-live="assertive" 
	aria-atomic="true" data-delay="12000">
	<div class="toast-header">
		<strong class="mr-auto">提示</strong>
		<button type="button" class="ml-2 mb-1 close"
			data-dismiss="toast" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
	<div class="toast-body">
		${tip}
	</div>
</div>
</c:if>
    <img src="${pageContext.request.contextPath}/images/book.jpg"  class="rounded mx-auto d-block"></br>
	<form class="form-inline offset-md-3 d-block" action="${pageContext.request.contextPath}/queryBook" method="post">
		<div class="row">
			<span style="color: red" class="col-sm-2">${error}</span>
			<label for="bookName"></label>
			<input type="text" id="bookName" name="bookName" class="form-control col-sm-4"  placeholder="请输入图书名字">
			<input type="submit" class="btn btn-primary " value="查询">
		</div>
	</form><br>
<a href="${pageContext.request.contextPath}/books" class="offset-5 btn btn-primary col-2">书城</a>
<div class="row">
<div class="col-sm"><h3 class="text-info">图书列表</h3></div>
<div class="col-sm text-right">
<a href="${pageContext.request.contextPath}/bookForm"
	class="btn btn-primary">添加图书</a></div>
</div>
<table class="table table-hover">
	<thead>
	<tr>
		<th scope="col">书名</th>
		<th scope="col">作者</th>
		<th scope="col">价格</th>
		<th scope="col">操作</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="item" items="${books}">
	<tr>
		<td>${item.title}</td>
		<td>${item.author}</td>
		<td>${item.price}</td>
		<td><a href="${pageContext.request.contextPath}/updateForm?id=${item.id}"
			class="badge badge-warning">修改</a>
		<a href="${pageContext.request.contextPath}/deleteBook?id=${item.id}"
			onclick="return confirm('请您确认是否真的删除');" 
			class="badge badge-danger">删除</a></td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</div>
<script type="text/javascript">
$('.toast').toast("show");
</script>
</body>
</html>