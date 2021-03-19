<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户详情</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/manager/css/global.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/navigation.css" />
<script
	src="${pageContext.request.contextPath}/manager/js/jquery-1.11.1.js"></script>
<style>
	.main_iframe p{
	text-align:left;
	display:block;
	float:left;
	margin-left:10px;
	width:380px;
	line-height:40px;
	height:40px;
	}
</style>
<%@ include file="/WEB-INF/manager/manager_top_navigation.jsp"%>
<ul class="side_navigation">
	用户详情
	<li class="sub_title"><a href="#" onclick="javascript:history.back(-1);">返回</a></li>
</ul>
<div class="main_iframe">
	<p>昵称:${manageuser.nickname}</p>
	<p>手机号码：${manageuser.mobile}</p>
	<p>性别：${manageuser.sex}</p>
	<p>生日：${fn:split(manageuser.birthday," ")[0]}</p>
	<p>电话：${manageuser.districtNum}-${manageuser.telephone}</p>
	<p>email：${manageuser.email}</p>
	<p>单位：${manageuser.school}</p>
	<p>总积分：${manageuser.totalBonus}</p>
	<p>可用积分：${manageuser.usableBonus}</p>
	<p>总花费：${manageuser.totalCost}</p>
	<p>地址信息：</p>
	<table>
		<tr>
			<td>收货人</td>
			<td>手机</td>
			<td>地址</td>
		</tr>
		<c:forEach items="${manageuser.addresses}" var="a">
		<tr>
			<td>${a.receiver}</td>
			<td>${a.mobile}</td>
			<td>${a.address}</td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>