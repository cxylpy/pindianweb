<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发布红包</title>
<style>

.firsttd {
	width: 200px;
}
</style>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/manager/css/global.css" />
<script
	src="${pageContext.request.contextPath}/manager/js/jquery-1.11.1.js"></script>
<%@ include file="/WEB-INF/manager/manager_top_navigation.jsp"%>
<ul class="side_navigation">
	系统设置
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/manageManager">管理管理员</a></li>
	<li class="sub_title"><a style="color:#da251c" href="${pageContext.request.contextPath}/manager/addManagerView">添加管理员</a></li>
	
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/getManagerRoles">管理角色</a></li>
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/addRoleView">添加角色</a></li>
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/showGlobalSettings">积分比例</a></li>
</ul>
<div class="main_iframe">
	<form action="${pageContext.request.contextPath}/manager/addManager" method="post">
		<table>
			<tr>
				<td class="firsttd">
					<p>管理员账号</p>
				</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td class="firsttd">
					<p>管理员密码</p>
				</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td class="firsttd">
					<p>角色</p>
				</td>
				<td><c:forEach items="${roles}" var="r" varStatus="vs">
						<label><input type="radio" name="rid" value="${r.id}"
							<c:if test="${vs.count==1}">
								checked="checked"
							</c:if> />
							${r.name}
							</label>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="添加" /></td>
			</tr>
		</table>
		<s:fielderror></s:fielderror>
	</form>
</div>
</body>
</head>
</html>
