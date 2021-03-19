<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改角色</title>
<style>
	label{
		display:block;
		float:left;
	}
	.firsttd{
		width:200px;
	}
</style>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager/css/global.css" />
<script src="${pageContext.request.contextPath}/manager/js/jquery-1.11.1.js"></script>
<%@ include file="/WEB-INF/manager/manager_top_navigation.jsp"%>
<ul class="side_navigation">
	修改角色
	<li class="sub_title"><a href="#" onclick="javascript:history.back(-1);">返回</a></li>
</ul>
<div class="main_iframe">
	<form action="${pageContext.request.contextPath}/manager/updateRole"
		method="post">
		<table>
			<tr>
				<td class="firsttd">
					<p>角色名称</p>
				</td>
				<td><input type="text" name="name" value="${r.name}"/></td>
			</tr>
			<tr>
				<td class="firsttd">
					<p>角色描述</p>
				</td>
				<td><input type="text" name="description" value="${r.description}"/></td>
			</tr>
			<tr>
				<td class="firsttd">
					<p>角色权限</p>
				</td>
				<td>
					<c:forEach items="${privileges}" var="p">
					<label><input type="checkbox" name="privileges" value="${p.id}"
						<c:forEach items="${r.privileges}" var="pp">
							<c:if test="${p.id==pp.id}">
								checked="checked"
							</c:if>
						</c:forEach>
					/>${p.name} 　</label>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="保存"/>
					<input type="hidden" name="id" value="${r.id}"/>
				</td> 
			</tr>
		</table>
	</form>
</div>
</body>
</html>
