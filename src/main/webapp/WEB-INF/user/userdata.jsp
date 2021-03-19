<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="generalHeader.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<title>我的品点</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/user.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/user_info.css" />
	<script src="${pageContext.request.contextPath}/js/userdata.js"></script>
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
						href="${pageContext.request.contextPath}/order/getUserOrders?page=1&type=5">订单管理</a></li>
					<li class="sub_title"><a 
						href="${pageContext.request.contextPath}/jsp_userrefund">申请退款</a></li>
					<li class="sub_title"><a href="${pageContext.request.contextPath}/address/getAll">收货地址</a></li>
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
						href="${pageContext.request.contextPath}/jsp_userdata" style="color:#da251c">我的资料</a></li>
						
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
				<img src="${pageContext.request.contextPath}/images/default_head_icon.png" />
				<div class="summary_info">
					<p class="user_account">${sessionScope.user.mobile}</p>
					<p>资料完整度:</p>
					<div class="full_progess">
						<div class="main_progress"><p>15%</p></div>
					</div>
				</div>
			</div>
			<form action="${pageContext.request.contextPath}/user/saveUserInfo">
				<table>
					<tr>
						<td><span class="red_color">*</span>昵称：</td>
						<td><input type="text" value="${sessionScope.user.nickname}" name="nickname"/></td>
					</tr>
					<tr>
						<td><span class="red_color">*</span>性别：</td>
						<td><label class="red_box"> 
						<input name="sex"
								type="radio" value="男" 
								<c:if test="${sessionScope.user.sex=='男'}">
									checked="checked"
								</c:if>
								/> <span>男</span><label class="red_box">
									
						<input name="sex" type="radio" value="女" 
														<c:if test="${sessionScope.user.sex=='女'}">
									checked="checked"
								</c:if>
						
						/> <span>女</span></td>
					</tr>
					<tr>
						<td><span class="red_color">*</span>生日：</td>
						<td><select name="year" 
						>
						<c:forEach begin="1949" end="2016" step="1" var="year">
								<option value="${year}"
								<c:if test="${sessionScope.user.year==year}">
									selected="selected"
								</c:if>
								>${year}</option>
								</c:forEach>
						</select>年 <select name="month">
						<c:forEach begin="1" end="12" step="1" var="month">
								<option value="${month}" 
								<c:if test="${sessionScope.user.month==month}">
									selected="selected"
								</c:if>
								>${month}</option>
								</c:forEach>
						</select>月 <select name="day">
						<c:forEach begin="1" end="31" step="1" var="day">
								<option value="${day}"
								<c:if test="${sessionScope.user.day==day}">
									selected="selected"
								</c:if>
								>${day}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>固定电话：</td>
						<td><input type="text" name="districtNum" value="${sessionScope.user.districtNum}" />－<input
							type="text" name="telephone" value="${sessionScope.user.telephone}"/></td>
					</tr>
					<tr>
						<td><span class="red_color">*</span>邮箱：</td>
						<td><input type="text" name="email" value="${sessionScope.user.email}"/></td>
					</tr>
					<tr>
						<td><span class="red_color">*</span>所属单位/学校：</td>
						<td><input type="text" name="school" value="${sessionScope.user.school}"/></td>
					</tr>
				</table>
				<input type="reset" value="重置" /> <input type="submit" value="提交" />
			</form>
			<!-- 用户信息  -->
		</div>
	</div>
</body>
</html>