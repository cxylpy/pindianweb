<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>订单管理</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/manager/css/global.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/navigation.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/manager/css/ordermanage.css" />
<script
	src="${pageContext.request.contextPath}/manager/js/jquery-1.11.1.js"></script>
	<style>
		#navigation_list{
			min-width:0;
		}
	</style>
<%@ include file="/WEB-INF/manager/manager_top_navigation.jsp"%>
<ul class="side_navigation">
	交易管理
	<li class="sub_title"><a
		href="${pageContext.request.contextPath}/manager/getManagerAllOrders?page=1&type=5"
		style="color:#da251c">订单管理</a></li>
</ul>

<div class="main_iframe">
	<ul id="navigation_list">
		<li>
					<a href="${pageContext.request.contextPath}/manager/getManagerAllOrders?page=1&type=5">所有订单</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/manager/getManagerAllOrders?page=1&type=0">未付款订单</a>
				</li >
				<li>
					<a href="${pageContext.request.contextPath}/manager/getManagerAllOrders?page=1&type=1">待发货订单</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/manager/getManagerAllOrders?page=1&type=2">已发货订单</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/manager/getManagerAllOrders?page=1&type=3">已完成订单</a>
				</li>
	</ul>

	<table>
		<tr>
			<td>商品</td>
			<td></td>
			<td>订单总额</td>
			<td>订单状态</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${orders}" var="order">
			<tr class="order_info">
				<td colspan="5"><img
					src="${pageContext.request.contextPath}/images/logo_small.png" />
					订单号：${order.id} 收货人：${order.receiver} 下单时间：${order.generatetime}</td>
			</tr>
			<tr>
				<td class="product_info"><img
					src="${pageContext.request.contextPath}/image/get?path=${order.imgPath}&width=120&height=120" />
				</td>
				<td class="order_desc">
					<p>${order.description}</p>

				</td>
				<td>
					<p class="large_price">￥${order.totalPrice}</p> <span
					class="gray_color">在线支付</span>
				</td>
				<td>
					<p class="normal_price">
						<c:if test="${order.payStatus==0}">
							未支付
						</c:if>
						<c:if test="${order.payStatus==1}">
							未发货
						</c:if>
						<c:if test="${order.payStatus==2}">
							已发货
						</c:if>
						<c:if test="${order.payStatus==3}">
							已完成
						</c:if>
					</p> <a href="${pageContext.request.contextPath}/manager/getOrderDetail?id=${order.id}" class="order_detail"><p class="blue_color">订单详情</p></a>
				</td>
				<td>
				<c:if test="${order.payStatus==1}">
				<a href="${pageContext.request.contextPath}/manager/confirmSendView?id=${order.id}"><p class="red_button">确认发货</p></a>
				</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
	<p>
		共${maxPage}页 <a
			href="${pageContext.request.contextPath}/manager/getManagerAllOrders?page=1&type=${type}">首页</a>
		<a
			href="${pageContext.request.contextPath}/manager/getManagerAllOrders?page=${page==1?1:page-1}&type=${type}">上一页</a>
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
					href="${pageContext.request.contextPath}/manager/getManagerAllOrders?page=${i}&type=${type}">${i}</a>
			</c:if>
		</c:forEach>
		<!-- 分页逻辑结束 -->
		<a
			href="${pageContext.request.contextPath}/manager/getManagerAllOrders?page=${page==maxPage?page:page+1}&type=${type}">下一页</a>
		<a
			href="${pageContext.request.contextPath}/manager/getManagerAllOrders?page=${maxPage}&type=${type}">尾页</a>
	</p>
</div>
</body>