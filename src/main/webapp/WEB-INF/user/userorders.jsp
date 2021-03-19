<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="generalHeader.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<title>我的订单</title>
<style>
	#pages{
		text-align:center;
	}
	#navigation_list{
		min-width:0;
	}
</style>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/user.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/user_orders.css"/>
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
						href="${pageContext.request.contextPath}/order/getUserOrders?page=1&type=5" style="color:#da251c">订单管理</a></li>
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
			<div class="notice">
				<img src="${pageContext.request.contextPath}/images/sound.png"/>
				<p>
					购物奖励品点积分，订单状态为“已完成”后，品点积分解冻，即可在下次购物时抵现。
					<br />
					<span>温馨提示：参加满减优惠活动的订单，满减优惠金额按比例（商品单价/订单金额）分摊到每个商品上；使用优惠券的订单如产生退货，
						优惠券均不退回；退货金额以小计为准。</span>
				</p>
			</div>
			<ul id="type_list">
				<li>
					<a href="${pageContext.request.contextPath}/order/getUserOrders?page=1&type=5">所有订单</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/order/getUserOrders?page=1&type=0">未付款订单</a>
				</li >
				<li>
					<a href="${pageContext.request.contextPath}/order/getUserOrders?page=1&type=1">待发货订单</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/order/getUserOrders?page=1&type=2">已发货订单</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/order/getUserOrders?page=1&type=3">已完成订单</a>
				</li>
			</ul>
			<table>
				<tr>
					<td>商品</td><td></td><td>订单总额</td><td>订单状态</td><td>　　　　操作</td>
				</tr>
				<c:forEach items="${orders}" var="order">
				<tr class="order_info">
					<td colspan="5"><img src="${pageContext.request.contextPath}/images/logo_small.png"/> 订单号：${order.id}　
					收货人：${order.receiver}　
					下单时间：${order.generatetime}　　　
					</td>
				</tr>
				<tr>
					<td class="product_info"><img  src="${pageContext.request.contextPath}/image/get?path=${order.imgPath}&width=150&height=150"/>
						<%-- <span class="gray_color">100个</span>--%>
					</td>
					<td class="order_desc">
						<p>${order.description}</p>
					
					</td>
					<td>
						<p class="large_price">￥${order.totalPrice}</p>
						<span class="gray_color">在线支付</span>
					</td>
					<td>
						<p class="normal_price">
						<c:if test="${order.payStatus==0}">未支付</c:if>
						<c:if test="${order.payStatus==1}">未发货</c:if>
						<c:if test="${order.payStatus==2}">已发货</c:if>
						<c:if test="${order.payStatus==3}">已完成</c:if>
						
						</p>
						<a href="${pageContext.request.contextPath}/order/getOrderDetail?id=${order.id}" class="order_detail"><p class="blue_color">订单详情</p></a>
					</td>
					<td>
					<c:if test="${order.payStatus==2}">
					<a href="https://www.alipay.com/" target="_blank"><p class="red_button">确认收货</p></a>
					</c:if>
					<c:if test="${order.payStatus==0}">
					<a href="${pageContext.request.contextPath}/order/payByOrderId?id=${order.id}"><p class="red_button">去支付</p></a>
					</c:if>
					</td>
				</tr>
				</c:forEach>
			</table>
			<p id="pages">
		共${maxPage}页 <a
			href="${pageContext.request.contextPath}/order/getUserOrders?page=1&type=${type}">首页</a>
		<a
			href="${pageContext.request.contextPath}/order/getUserOrders?page=${page==1?1:page-1}&type=${type}">上一页</a>
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
					href="${pageContext.request.contextPath}/order/getUserOrders?page=${i}&type=${type}">${i}</a>
			</c:if>
		</c:forEach>
		<!-- 分页逻辑结束 -->
		<a
			href="${pageContext.request.contextPath}/order/getUserOrders?page=${page==maxPage?page:page+1}&type=${type}">下一页</a>
		<a
			href="${pageContext.request.contextPath}/order/getUserOrders?page=${maxPage}&type=${type}">尾页</a>

	</p>
		</div>
