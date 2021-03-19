<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改管理员</title>
<style>
	.firsttd{
		width:200px;
	}
</style>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager/css/global.css" />
<script src="${pageContext.request.contextPath}/manager/js/jquery-1.11.1.js"></script>
<%@ include file="/WEB-INF/manager/manager_top_navigation.jsp"%>
<ul class="side_navigation">
	修改管理员
	<li class="sub_title"><a href="#" onclick="javascript:history.back(-1);">返回</a></li>
</ul>
<div class="main_iframe">
	<form action="${pageContext.request.contextPath}/manager/modifyManager"
		method="post">
		<table>
			<tr>
				<td class="firsttd">
					<p>管理员账号</p>
				</td>
				<td><input type="text" name="username" value="${m.username}"/></td>
			</tr>
			<tr>
				<td class="firsttd">
					<p>角色</p>
				</td>
				<td>
					<c:forEach items="${roles}" var="r" varStatus="vs">
						<label><input type="radio" name="rid" value="${r.id}"
							<c:if test="${vs.count==1}">
								checked="checked"
							</c:if>
						/>${r.name}</label>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="保存"/></td>
			</tr>
			<input type="hidden" value="${m.id}" name="id"/>
		</table>
	</form>
</div>
</body>
</html>
