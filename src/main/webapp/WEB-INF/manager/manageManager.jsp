<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员管理</title>
<style>
	.privileges {
		width:400px;
	}
</style>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/manager/css/global.css" />
	
<script
	src="${pageContext.request.contextPath}/manager/js/jquery-1.11.1.js"></script>
<%@ include file="/WEB-INF/manager/manager_top_navigation.jsp"%>
<ul class="side_navigation">
	系统设置
	<li class="sub_title"><a style="color:#da251c" href="${pageContext.request.contextPath}/manager/manageManager">管理管理员</a></li>
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/addManagerView">添加管理员</a></li>
	
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/getManagerRoles">管理角色</a></li>
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/addRoleView">添加角色</a></li>
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/showGlobalSettings">积分比例</a></li>
</ul>
<div class="main_iframe">
	<table>
		<tr>
			<td>管理员账号</td>
			<td>管理员角色</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${managers}" var="m">
		<tr>
			<td>${m.username}</td>
			<td>${m.role.name}</td>
			<td>
				<a href="${pageContext.request.contextPath}/manager/modifyManagerView?id=${m.id}">修改</a>
				<a href="${pageContext.request.contextPath}/manager/deleteManager?id=${m.id}">删除</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>