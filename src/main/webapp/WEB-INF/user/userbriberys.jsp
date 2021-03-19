<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="generalHeader.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<title>我的品点</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/user.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/userbribery.css" />
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
					<li class="sub_title"><a
						href="${pageContext.request.contextPath}/address/getAll">收货地址</a></li>
				</ul>
			</li>
			<li class="main_title">我的资产
				<ul>
					<li class="sub_title"><a
						href="${pageContext.request.contextPath}/user/getBounsHistory?page=1">品点积分</a></li>
					<li class="sub_title"><a
						href="${pageContext.request.contextPath}/user/getBriberys"
						style="color:#da251c">我的礼包</a></li>
				</ul>
			</li>
			<li class="main_title">我的账户
				<ul>
					<li class="sub_title"><a
						href="${pageContext.request.contextPath}/jsp_userdata">我的资料</a></li>
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
			<c:forEach items="${briberys}" var="b">
			 <div class="briberyblock">
				<div class="bagblock">
					<p class="briberyname">${b.id.briberymoney.name}</p>
					<img src="${pageContext.request.contextPath}/images/li.png" />
					<p class="briberysum">
						代金券<span>${b.id.briberymoney.price}</span>元
					</p>
				</div>
				<table>
					<tr>
						<td class="briberydesc">${b.id.briberymoney.description}</td>
					</tr>
					<tr>
						<td>消费满<span class="normal_price">${b.id.briberymoney.minPrice}</span>可使用
						</td>
					</tr>
					<tr>
						<td>注：此代金券是一次性的</td>
					</tr>
					<tr>
						<td>有效期至${b.id.briberymoney.validDate}</td>
					</tr>
				</table>
			</div> 
			
			</c:forEach>
			
			<c:forEach items="${packages}" var="p">
			
			 <div class="briberyblock">
				<div class="bagblock">
					<p class="briberyname">${p.id.a4package.name}</p>
					<img src="${pageContext.request.contextPath}/images/li.png" />
					<p class="briberysum">
						免费A4云打印<span>${p.id.a4package.pages}</span>页
					</p>
				</div>
				<table>
					<tr>
						<td class="briberydesc">${p.id.a4package.description}</td>
					</tr>
					<tr>
						<td>已用<span class="normal_price">${p.id.a4package.pages-p.restPage}</span>张
						</td>
					</tr>
					<tr>
						<td>剩余<span class="normal_price">${p.restPage}</span>页
						</td>
					</tr>
					<tr>
						<td>注：此礼包仅限A4云打印。</td>
					</tr>
					<tr>
						<td>有效期至${p.id.a4package.validDate}</td>
					</tr>
				</table>
			</div> 
			</c:forEach>
		</div>
	</div>
</body>
</html>