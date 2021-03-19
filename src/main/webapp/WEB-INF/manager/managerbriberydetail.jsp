<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户红包明细</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/manager/css/global.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/userbribery.css" />
<script
	src="${pageContext.request.contextPath}/manager/js/jquery-1.11.1.js"></script>
<%@ include file="/WEB-INF/manager/manager_top_navigation.jsp"%>
<ul class="side_navigation">
	会员管理
	<li class="sub_title"><a
		href="#"
		onclick="javascript:history.back(-1);">返回</a></li>
</ul>
<div class="main_iframe">
	<div class="right_container">
		<table>
			<tr>
				<td>主题</td>
				<td>描述</td>
				<td>面额</td>
				<td>剩余金额</td>
				<td>领取时间</td>
				<td>使用条件</td>
				<td>有效期至</td>
			</tr>
			<c:forEach items="${briberys}" var="b">
				<tr>
					<td>
						<p>${b.id.briberymoney.name}</p>
					</td>
					<td>
						<p>${b.id.briberymoney.description}</p>
					</td>
					<td><p>${b.id.briberymoney.price}</p></td>
					<td><p>${b.id.briberymoney.price}</p></td>
					<td><p>${b.gettime}</p></td>
					<td><p>消费满${b.id.briberymoney.minPrice}可使用</p></td>
					<td><p>${b.id.briberymoney.validDate}</p></td>
				</tr>
			</c:forEach>
		<c:forEach items="${packages}" var="p">
		<tr>
					<td>
						<p>${p.id.a4package.name}</p>
					</td>
					<td>
						<p>${p.id.a4package.description}</p>
					</td>
					<td><p>${p.id.a4package.pages}张</p></td>
					<td><p>${p.restPage}张</p></td>
					<td><p>${p.gettime}</p></td>
					<td><p>只限A4打印</p></td>
					<td><p>${p.id.a4package.validDate}</p></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>