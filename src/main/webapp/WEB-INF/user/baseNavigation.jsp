<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<script src="${pageContext.request.contextPath}/js/global.js"></script>
<!--导航栏-->
<div class="navigation_user">
	<!-- 登陆显示  -->
	<c:if test="${sessionScope.user!=null}">
		<p id="nickname">${sessionScope.user.nickname}</p>
		<p id="login_user">
			<a href="${pageContext.request.contextPath}/index/showIndex" id="index_link">品点首页</a><label>/</label><a
				href="${pageContext.request.contextPath}/jsp_userdata">我是品点人</a><label>/</label><a
				href="${pageContext.request.contextPath}/jsp_cart">购物车<span>${fn:length(sessionScope.carts)}</span></a><label>/</label><a
				href="${pageContext.request.contextPath}/user/logout">退出</a>
		</p>
	</c:if>
	<!-- 登陆显示  -->
	<!-- 未登录显示 -->
	<c:if test="${sessionScope.user==null}">
		<p id="unlogin_user">
			<a target="_blank" href="${pageContext.request.contextPath}/login.jsp">登陆</a><label>/</label><a target="_blank" href="${pageContext.request.contextPath}/register.jsp">免费注册</a>
		</p>
	</c:if>
	<!-- 未登录显示 -->
	
</div>
<ul id="navigation_list">
	<li class="navigation_left"><a href="${pageContext.request.contextPath}/index/showIndex"">品点首页</a></li>
	<li class="navigation_left"><a href="${pageContext.request.contextPath}/about.jsp">品点介绍</a></li>
	<li class="navigation_right"><a href="${pageContext.request.contextPath}/news/getSumNews">品点资讯</a></li>
	<li class="navigation_right"><a href="${pageContext.request.contextPath}/contactus.jsp">联系品点</a></li>
	<a href="${pageContext.request.contextPath}/index/showIndex"><img src="${pageContext.request.contextPath}/images/logo.png"
		id="navigation_logo" /></a>
</ul>
<!--导航栏-->