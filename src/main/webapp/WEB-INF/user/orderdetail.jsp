<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="generalHeader.jsp"%>
<title>请确认您的订单</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/fill_order.css" />
<script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
</head>
<body>
	<%@ include file="baseNavigation.jsp"%>
	<div class="container">
		<p class="title">
		<c:if test="${order.payStatus==0}"><span>买家未支付，</span>立即去<a href="${pageContext.request.contextPath}/order/payByOrderId?id=${order.id}"><span>支付</span></a></c:if>
		<c:if test="${order.payStatus==1}"><span>卖家未发货，</span>提醒卖家<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=239253219&site=qq&menu=yes"><img src="${pageContext.request.contextPath}/images/qq_online.png"/></a></c:if>
		<c:if test="${order.payStatus==2}"><span>卖家已发货，</span>等待买家确认</c:if>
		<c:if test="${order.payStatus==3}"><span>买家已收货，</span><a href="#"><span>确认收货</span></a></c:if>
		<c:if test="${order.payStatus==4}"><span>交易已完成</span></c:if>
		</p>
			<div class="order">
				<div class="order_info">
				<div>
				<p class="subtitle">收货人信息</p>
				</div>
					<div class="addresses">
						<p class="itemdesc">${order.address}　　${order.receiver}　　${order.mobile}</p>
						
					</div>
					<div class="dotted_line"></div>
					<div>
						<p class="subtitle">支付方式</p>
					</div>
					<div class="pay_types">
							<p class="itemdesc">在线支付</p>
					</div>
					<div class="dotted_line"></div>
					<div class="list_left">
					<p class="subtitle">送货清单</p>
						<br/>
						<table class="buying_product">
							<c:forEach items="${order.suborders}" var="suborder">
								<tr>
									<td><img
										src="${pageContext.request.contextPath}/image/get?path=${suborder.imgPath}&width=100&height=100" /></td>
									<td>
										<p>${suborder.description}</p>
									</td>
									<td>
										<p class="normal_price">￥${suborder.price}</p>
									</td>
									<td>
										<p>X${suborder.number}</p>
									</td>
									<td><a href="${pageContext.request.contextPath}/file/getByPath?path=${suborder.filePath}">${fn:substringAfter(suborder.filePath,"_")}</a></td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="5"><p class="itemdesc">配送方式：${order.transportType==0?"快递":"上门自取"}　　　　　　　　运费：<span style="color:#da251c;">￥${order.transportCost}</span></p></td>
							</tr>
						</table>
					
					</div>
				</div>
				<p class="comment">给品点留言：${order.comment==""?"无":order.comment}</p>
				<p class="total_price">
					实付总额：<span class="large_price" id="lastTotal">￥${order.totalPrice}</span> <br />
				</p>
			</div>
	</div>
</body>
</html>