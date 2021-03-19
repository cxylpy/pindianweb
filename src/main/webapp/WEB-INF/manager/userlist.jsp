<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>会员管理</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/manager/css/global.css" />
	
<script
	src="${pageContext.request.contextPath}/manager/js/jquery-1.11.1.js"></script>
<%@ include file="/WEB-INF/manager/manager_top_navigation.jsp"%>
<ul class="side_navigation">
	会员管理
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/manageUsers?page=1" style="color:#da251c">会员列表</a></li>
</ul>
<div class="main_iframe">
	<table>
		<tr>
			<td>昵称</td>
			<td>手机</td>
			<td>单位</td>
			<td>生日</td>
			<td>性别</td>
			<td>总积分</td>
			<td>总消费</td>
			<td>礼包</td>
		</tr>
	 <c:forEach items="${users}" var="u">
		<tr>
			<td><a href="${pageContext.request.contextPath}/manager/getUserDetail?id=${u.id}">${u.nickname}</a></td>
			<td>${u.mobile}</td>
			<td>${u.school}</td>
			<td>${u.birthday}</td>
			<td>
			${u.sex}
			</td>
			<td>${u.totalBonus}<br/><a href="${pageContext.request.contextPath}/manager/getSomeUserBounsHistory?userid=${u.id}">明细</a></td>
			<td>${u.totalCost}<br/><a href="${pageContext.request.contextPath}/manager/getCostHistoryOrders?page=1&type=3">明细</a></td>
			<td>${u.briberyNum}<br/><a href="${pageContext.request.contextPath}/manager/manageUserBriberys?id=${u.id}">明细</a></td>
		</tr>
	 </c:forEach> 
	</table>
	<p>
共${maxPage}页
  <a href="${pageContext.request.contextPath}/manager/manageUsers?page=1">首页</a>
  <a href="${pageContext.request.contextPath}/manager/manageUsers?page=${page==1?1:page-1}">上一页</a>
		<!-- 分页逻辑开始 -->
		<c:if test="${maxPage<=5}">
			<c:set var="begin" value="1" scope="page"></c:set>
			<c:set var="end" value="${maxPage}" scope="page"></c:set>
		</c:if>
		<c:if test="${maxPage>5}">
			<c:choose>
				<c:when test="${page<=3}">
					<c:set var="begin" value="1" scope="page"></c:set>
					<c:set var="end" value="5" scope="page"></c:set>
				</c:when>
				<c:when test="${page>=(maxPage-2)}">
					<c:set var="begin" value="${maxPage-4}" scope="page"></c:set>
					<c:set var="end" value="${maxPage}" scope="page"></c:set>
				</c:when>
				<c:otherwise>
					<c:set var="begin" value="${page-2}" scope="page"></c:set>
					<c:set var="end" value="${page+2}" scope="page"></c:set>
				</c:otherwise>
			</c:choose>
		</c:if>
		<c:forEach begin="${begin}" end="${end}" step="1" var="i">
			<c:if test="${i==page}">
  		${i}
  	</c:if>
			<c:if test="${i!=page}">
				<a
					href="${pageContext.request.contextPath}/manager/manageUsers?page=${i}">${i}</a>
			</c:if>
		</c:forEach>
		<!-- 分页逻辑结束 -->
<a href="${pageContext.request.contextPath}/manager/manageUsers?page=${page==maxPage?page:page+1}">下一页</a>
  <a href="${pageContext.request.contextPath}/manager/manageUsers?page=${maxPage}">尾页</a>

	</p>
</div>
</body>