<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="generalHeader.jsp"%>
<title>请确认您的订单</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/fill_order.css" />
<script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>

<script src="${pageContext.request.contextPath}/js/fillorder.js"></script>
</head>
<body>
	<%@ include file="baseNavigation.jsp"%>
	<div class="container">
		<p class="title">填写并核对订单信息</p>
		<form method="post"
			action="${pageContext.request.contextPath}/order/newOrder">
			<div class="order">
				<div class="order_info">
					<div>
						<p class="subtitle">收货人信息</p>
						<a href="${pageContext.request.contextPath}/user/newAddressView"
							class="new_address">新增收货地址</a>
					</div>
					<div class="addresses">
						<c:forEach items="${addresses}" var="address" varStatus="vs">
							<label class="red_box"> <input name="addressindex"
								type="radio"
								<c:if test="${vs.count==1}">
								checked="checked"
							</c:if>
								value="${vs.index}" /> <span class="receiver_address">${address.receiver} ${address.mobile} ${address.address}</span></label>
						</c:forEach>
					</div>
					<div class="dotted_line"></div>
					<div>
						<p class="subtitle">支付方式</p>
					</div>
					<div class="pay_types">
						<label class="red_box"> <input name="payType" type="radio"
							value="0" checked="checked" /> <span>在线支付</span></label>
					</div>
					<div class="dotted_line"></div>
					<div class="list_left">
						<p class="subtitle">送货清单</p>
						<p class="product_desc">配送方式</p>
						<div class="transports">
							<label class="red_box"> <input name="transportType"
								type="radio" value="0" checked="checked" /> <span> 快递 </span></label> <label
								class="red_box"> <input name="transportType"
								type="radio" value="1" /> <span> 上门自取 </span></label>
						</div>
						<p class="product_desc">
							运费：<label class="normal_price transport_cost">￥${sessionScope.transportcost.price}</label>
						</p>
					</div>
					<div class="list_right">
						<a href="${pageContext.request.contextPath}/jsp_cart"
							class="new_address">返回修改购物车</a>
						<table class="buying_product">
							<c:forEach items="${sessionScope.carts}" var="cart">
								<tr>
									<td><img
										src="${pageContext.request.contextPath}/image/get?path=${cart.imgPath}&width=90&height=90" /></td>
									<td>
										<p>${cart.description}</p>
									</td>
									<td>
										<p class="normal_price formatprice" >￥${cart.perPrice}</p>
									</td>
									<td>
										<p>X${cart.number}</p>
									</td>
									<td>
									<p><a href="${pageContext.request.contextPath}/file/getByPath?path=${cart.filePath}">${fn:substringAfter(cart.filePath,"_")}</a></p>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				<p class="comment">给品点留言：</p>
				<textarea name="comment"></textarea>
				<table class="total_price_detail">
					<tr>
						<td>
							<p>
								<span class="red_color">${fn:length(carts)}</span>件商品，总商品金额：
							</p>
						</td>
						<td>
							<p class="normal_price java_gen_price formatprice">
								￥${sessionScope.totalPrice}</p>
						</td>
					</tr>
					<tr>
						<td>
							<p>运费</p>
						</td>
						<td>
							<p class="normal_price transport_cost">
								￥${sessionScope.transportcost.price}</p>
						</td>
					</tr>
					<tr>
						<td>
							<p>应支付总金额</p>
						</td>
						<td>
							<p class="normal_price with_trans_price">￥888.00</p>
						</td>
					</tr>

					<c:if test="${fn:length(sessionScope.briberys)>0}">
						<tr>
							<td><label><input type="checkbox" id="useBribery"
									name="useBribery" value="true" />使用品点优惠：</label><select name="bid">
									<c:forEach items="${sessionScope.briberys}" var="b">
										<option value="${b.id}">${b.name}减免 ${b.price} 元</option>
									</c:forEach>
							</select></td>
							<td>
								<p class="normal_price decrease_price">￥-888.0</p>
							</td>
						</tr>
					</c:if>
					<c:if test="${sessionScope.user.usableBonus>0}">
						<tr>
							<td><label><input type="checkbox" class="useBonus"
									name="useBonus" value="true" />使用品点积分：</label> <input type="text"
								class="number_input" name="bonus" />点 <input type="hidden"
								name="ratio" value="${sessionScope.bonusRatio1.price}" />  <span>可使用 ${sessionScope.user.usableBonus} 点</span></td>
							<td>
								<p class="normal_price">￥-0.54</p>
							</td>
						</tr>
					</c:if>
					<input
								type="hidden" name="getRatio"
								value="${sessionScope.bonusRatio2.price}" />
					<c:if test="${not empty sessionScope.userpackages}">
						<tr>
							<td><label><input type="checkbox" class="usePackage"
									name="usePackage" value="true" />使用A4礼包：</label> <input type="text"
								class="number_input" name="a4pages" />页  <span>可使用
									${sessionScope.userpackages.restPage} 页</span></td>
							<td>
								<p class="decreasePages">-2页</p>
									<input type="hidden" name="restPage" value="${sessionScope.userpackages.restPage}"/>
									<input type="hidden" name="packageid" value="${sessionScope.userpackages.id.a4package.id}"/>
							</td>
						</tr>
					</c:if>
				</table>
						<input type="hidden" name="a4price" value="${sessionScope.a4price}"/>
				<div class="dotted_line"></div>
				<p class="total_price">
					应付总额：<span class="large_price" id="lastTotal">￥898.00</span> <br />
					<span class="get_bonus">可获得品点积分：***</span>

				</p>
				<input type="hidden" value="${sessionScope.user.id}" name="uid" /> <input
					type="hidden" value="1" name="orderType" /> <input type="submit"
					value="提交订单" />
			</div>
		</form>
		<p class="receive_address">
			寄送至：重庆南岸区龙门浩街道金桂圆A栋3楼115室 <br /> 收货人：某某某 18983941392
		</p>
	</div>
	<div class="shadow"></div>
	<div class="dialog">
		<img class="close" src="${pageContext.request.contextPath}/images/close.png"/>
		<p class="counterblock">
			请于<span>29分59秒</span>内，在新开的页面完成支付
		</p>
		<div class="choice">
			<img src="${pageContext.request.contextPath}/images/ok.png" />
			<p>
				如已经成功支付，请点击： <a href="${pageContext.request.contextPath}/order/getLastestOrderDetail" class="complete">已完成付款</a>
			</p>
		</div>
		<div class="choice">
			<img src="${pageContext.request.contextPath}/images/warning.png" />
			<p>
				如付款遇到问题，你可以：<a href="${pageContext.request.contextPath}/order/repay" class="repay">重新支付</a>
			</p>
		</div>
	</div>
</body>
</html>