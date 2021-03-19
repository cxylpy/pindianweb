<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>订单详情</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/fill_order.css" />
<style>
.dotted_line {
	width: 600px;
}

.order {
	background-color: #CCCCCC;
	margin-top: 10px;
}

.title {
	margin-top: 0;
}
.list_left{
	clear:left;
}
</style>
<script
	src="${pageContext.request.contextPath}/manager/js/jquery-1.11.1.js"></script>
<%@ include file="/WEB-INF/manager/manager_top_navigation.jsp"%>
<ul class="side_navigation">
	交易管理
	<li class="sub_title"><a href="#"
		onclick="javascript:history.back(-1);">返回</a></li>
</ul>
<div class="main_iframe">
	<div class="order">
		<p class="title">
			<c:if test="${order.payStatus==0}">
				<span>未支付</span>
			</c:if>
			<c:if test="${order.payStatus==1}">
				<span>未发货</span>
			</c:if>
			<c:if test="${order.payStatus==2}">
				<span>已发货</span>
			</c:if>
			<c:if test="${order.payStatus==3}">
				<span>已完成</span>
			</c:if>
		</p>
		<div class="order_info">
			<div class="addresses">
			<p class="subtitle">收货人信息</p>
			<br/>
				<p class="itemdesc">${order.address}${order.receiver}
					${order.mobile}</p>

			</div>
			<div class="dotted_line"></div>
			<div class="pay_types">
				<p class="subtitle">支付方式</p>
				<p class="itemdesc">在线支付</p>
			</div>
			<div class="dotted_line"></div>
			<div class="list_left">
				<p class="subtitle">送货清单</p>
				<br />
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
							<td><a
								href="${pageContext.request.contextPath}/file/getByPath?path=${suborder.filePath}">${fn:substringAfter(suborder.filePath,"_")}</a>
							</td>
						</tr>
					</c:forEach>
				</table>
				<p class="itemdesc">配送方式：${order.transportType==0?"快递":"上门自取"} 运费：<span
						style="color:#da251c;">￥${order.transportCost}</span>
				</p>
			</div>
		</div>
		<p class="comment">给品点留言：${order.comment==""?"无":order.comment}</p>
		<p class="total_price">
			实付总额：<span class="large_price" id="lastTotal">￥${order.totalPrice}</span>
			<br />
		</p>
	</div>
</div>
</body>
</html>