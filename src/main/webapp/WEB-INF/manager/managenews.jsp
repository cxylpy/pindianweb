<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>文章管理</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/manager/css/global.css" />
<script
	src="${pageContext.request.contextPath}/manager/js/jquery-1.11.1.js"></script>
<%@ include file="/WEB-INF/manager/manager_top_navigation.jsp"%>
<ul class="side_navigation">
	文章管理
	<li class="sub_title"><a
		href="${pageContext.request.contextPath}/manager/manageNews" style="color:#da251c"
		>文章列表</a></li>
	<li class="sub_title"><a
		href="${pageContext.request.contextPath}/manager/jsp_addnews"
		>发布文章</a></li>
</ul>
<div class="main_iframe">
	<table>
		<tr>
			<td>标题</td>
			<td>发布时间</td>
			<td>操作</td>
		</tr>
	 <c:forEach items="${news}" var="n">
		<tr>
			<td>${n.title}</td>
			<td>${n.pubTime}</td>
			<td><a href="${pageContext.request.contextPath}/manager/modifyNewsView?id=${n.id}">修改</a>/<a href="${pageContext.request.contextPath}/manager/deleteNews?id=${n.id}">删除</a></td>
		</tr>
	 </c:forEach> 
	</table>
</div>
</body>