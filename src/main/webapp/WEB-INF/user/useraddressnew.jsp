<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="generalHeader.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<title>我的品点</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/user.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/user_address.css"/>
</head>
<body>
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
	<!--导航栏-->
	<div id="navigation_list">
		<a class="navigation_left"
			href="${pageContext.request.contextPath}/jsp_userdata">我是品点人</a> <a
			class="navigation_right"
			href="${pageContext.request.contextPath}/index/showIndex">品点品牌首页>></a>
	</div>
	<!--导航栏-->
	<div class="container">

		<!--侧面导航栏-->
		<ul class="side_navigation">
			<li class="main_title">我的交易
				<ul>
					<li class="sub_title"><a 
						href="${pageContext.request.contextPath}/order/getUserOrders?page=1&type=5" >订单管理</a></li>
					<li class="sub_title"><a
						href="${pageContext.request.contextPath}/jsp_userrefund">申请退款</a></li>
					<li class="sub_title"><a href="${pageContext.request.contextPath}/address/getAll" style="color:#da251c">收货地址</a></li>
				</ul>
			</li>
			<li class="main_title">我的资产
				<ul>
					<li class="sub_title"><a 
						href="${pageContext.request.contextPath}/user/getBounsHistory?page=1">品点积分</a></li>
						<li class="sub_title"><a
						href="${pageContext.request.contextPath}/user/getBriberys"
						>我的礼包</a></li>
				</ul>
			</li>
			<li class="main_title">我的账户
				<ul>
					<li class="sub_title"><a 
						href="${pageContext.request.contextPath}/jsp_userdata" >我的资料</a></li>
				</ul>
			</li>
			<li class="main_title">用户须知
				<ul>
					<li class="sub_title"><a 
						href="${pageContext.request.contextPath}/jsp_paystandard">收费标准</a></li>
				</ul>
			</li>
		</ul>
		<!--侧面导航栏-->
		<div class="right_container">
			<!-- 用户信息  -->
			<div class="user_info">
		<form action="${pageContext.request.contextPath}/address/add">
			<table>
				<tr>
					<td><span class="red_color">*</span>收货人：</td>
					<td><input type="text" name="receiver"/></td>
				</tr>
				<tr>
					<td><span class="red_color">*</span>联系电话：</td>
					<td><input type="text" name="mobile"/></td>
				</tr>
				<tr>
					<td><span class="red_color">*</span>地址：</td>
					<td><input type="text" name="address"/></td>
				</tr>
			</table>
			<input type="hidden" value="${sessionScope.user.id}" name="uid"/>
			<input type="submit" value="确认" class="red_button"/>
			
		</form>
		</div>
	</div>
</body>
</html>