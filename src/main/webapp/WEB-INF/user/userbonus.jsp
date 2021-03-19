<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="generalHeader.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<title>我的品点</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/user.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/user_bonus.css" />
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
						href="${pageContext.request.contextPath}/user/getBounsHistory?page=1" style="color:#da251c">品点积分</a></li>
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
		<!--侧面导航栏-->
		<div class="right_container">
			<div class="total_bonus">
				<table>
					<tr>
						<td>
							<p class="total_bonus_desc">总积分</p>
						</td>
						<td>
							<p class="total_bonus_desc">可用积分</p>
						</td>
					</tr>
					<tr>
						<td>
							<p class="large_price">${sessionScope.user.totalBonus}</p>
						</td>
						<td>
							<p class="large_price">${sessionScope.user.usableBonus}</p>
						</td>
					</tr>
				</table>
			</div>
			<table>
				<tr class="titles">
					<td>
						<p>积分来源</p>
					</td>
					<td>
						<p>积分变化</p>
					</td>
					<td>
						<p>日期</p>
					</td>
				<!-- 	<td>
						<p>备注</p>
					</td> -->
				</tr>
				<tr>
					<td colspan="4"><div class="red_line"></div></td>
				</tr>
				<tr>
					<td colspan="4"><div class="background_gray_line"></div></td>
				</tr>
				<c:forEach items="${bonuses}" var="bonus" varStatus="vs">
					<tr class="bonus_detail">
						<td><img src="${pageContext.request.contextPath}/image/get?path=${ordergroups[vs.index].imgPath}&width=100&height=100" />
							<p>
								<br /> ${ordergroups[vs.index].description}
							</p></td>
						<td>
						<c:if test="${bonus.delta>0}">
						<p class="get_bonus">
							+${bonus.delta}
							</p>
						</c:if>
						<c:if test="${bonus.delta<0}">
						<p class="lose_bonus">
							${bonus.delta}
							</p>
						</c:if>
						</td>
						<td><p>${bonus.createTime}</p></td>
					</tr>
				</c:forEach>
			</table>
			
			<p>
共${maxPage}页
  <a href="${pageContext.request.contextPath}/user/getBounsHistory?page=1">首页</a>
  <a href="${pageContext.request.contextPath}/user/getBounsHistory?page=${page==1?1:page-1}">上一页</a>
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
					href="${pageContext.request.contextPath}/user/getBounsHistory?page=${i}">${i}</a>
			</c:if>
		</c:forEach>
		<!-- 分页逻辑结束 -->
<a href="${pageContext.request.contextPath}/user/getBounsHistory?page=${page==maxPage?page:page+1}">下一页</a>
  <a href="${pageContext.request.contextPath}/user/getBounsHistory?page=${maxPage}">尾页</a>

	</p>
			
		</div>
</body>
</html>