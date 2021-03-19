<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="generalHeader.jsp"%>
		<title>我的购物车</title>
		
		<link href="${pageContext.request.contextPath}/css/global.css" type="text/css" rel="stylesheet"/>
		<link href="${pageContext.request.contextPath}/css/user.css" type="text/css" rel="stylesheet"/>
		<link href="${pageContext.request.contextPath}/css/cart.css" type="text/css" rel="stylesheet"/>
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
		<script src="${pageContext.request.contextPath}/js/cart.js"></script>
	</head>
<body>
<!--导航栏-->

		<div id="navigation_list">
			<a class="navigation_left"href="${pageContext.request.contextPath}/user/jsp_cart">购物车 </a>
			<a class="navigation_right" href="${pageContext.request.contextPath}/index/showIndex">品点品牌首页>></a>
		</div>
		<!--导航栏-->
		<form action="${pageContext.request.contextPath}/cart/generateOrder" method="post">
		<div class="container">
			<p class="title">
				所有商品　${fn:length(sessionScope.carts)}
			</p>
			<table>
				<tr class="titles">
					<td>
					<p>
						<label>
							<input type="checkbox" id="selectAll"/>
							&nbsp;全选</label>
					</p></td>
					<td>
					<p>
						商品信息
					</p></td>
					<td>
					<p>
						单价（元）
					</p></td>
					<td>
					<p>
						数量
					</p></td>
					<td>
					<p>
						金额（元）
					</p></td>
					<td>
					<p>
						操作
					</p></td>
				</tr>
				<tr>
					<td colspan="6"><div class="background_gray_line"></div></td>
				</tr>
				<tr>
					<td colspan="6"><div class="red_line"></div></td>
				</tr>
				<c:forEach items="${sessionScope.carts}" var="cart" varStatus="vs">
				<tr class="buying_product">
					<td><input type="checkbox" class="item" name="checkedItems"checked="checked" value="${vs.index}"/><img src="${pageContext.request.contextPath}/image/get?path=${cart.imgPath}&width=100&height=100"/></td>
					<td><p class="desc">${cart.description}</p></td>
					<td><p class="black_price">${cart.perPrice}</p></td>
					<td><input type="text" class="number_input" value="${cart.number}" name="nums"/></td>
					<td><p class="red_price">￥</p></td>
					<td><a href="${pageContext.request.contextPath}/cart/delete?pos=${vs.count}">删除</a></td>
					<input type="hidden" name="imgPaths" value="${cart.imgPath}"/>
					<input type="hidden" name="descriptions" value="${cart.description}"/>
					<input type="hidden" name="perPrices" value="${cart.perPrice}"/>
				</tr>
				</c:forEach>
			</table>
			<div>
				<input type="submit" value="结算"/>
				<p>已选商品<span id="num">1</span>件　　合计（不含运费）：<span id="total">￥30.00</span></p>
			</div>
		</div>
		</form>
	</body>
</html>