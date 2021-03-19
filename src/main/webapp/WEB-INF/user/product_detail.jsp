<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="generalHeader.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/product_detail.css" />
	<script src="${pageContext.request.contextPath}/js/product_detail.js"></script>
<title>${product.name}</title>
</head>
<body>
	<%@ include file="baseNavigation.jsp"%>
	<div class="container">
		<!--上传按钮 -->
		<div class="product_image_box">
				<img class="product_image"
					src="${pageContext.request.contextPath}/image/get?path=${product.imgPath}&width=300&height=330" />
		</div>

		<!--上传按钮 -->

		<!-- 商品描述 -->
		<div class="detail">
			<p class="product_name">${product.name}</p>
			<p class="product_desc">${product.description}</p>
			
			<div class="price_div">
				<p>
					价格：<label class="normal_price">￥${product.price}</label>
				</p>
				<c:if test="${product.onsalePrice!=0}">
				<p>
					促销价：<label class="onsale_price">￥${product.onsalePrice}</label>
				</p>
				</c:if>
				<p>
					本店活动：<label class="action">${product.action}</label>
				</p>
			</div>
			<%-- <p class="transport">
					运费：快递 9.00
				</p>--%>
			<div class="dotted_line"></div>
			<p class="statistic">
				年销售量：<label class="sale_amount">${product.totalsale}</label> 月销售量：<label
					class="sale_amount">${product.monthsale}</label>
			</p>
			<div class="dotted_line"></div>
			<form action="${pageContext.request.contextPath}/cart/add" autocomplete="off" method="post">
				<table>

					<c:forEach items="${product.techs}" var="tech" varStatus="vs">
						<tr>
							<td class="techname">${tech.name}</td>
							<c:if test="${tech.inputType==1}">
							<td colspan="100">
								<c:forEach items="${tech.teckdetails}" var="detail" varStatus="vss">
									<label class="red_box"> <input
											name="tech_detail${vs.count}" type="radio"
											<c:if test="${vss.count==1}">
											checked="checked"
											</c:if>
											value="${detail.description},${detail.priceDelta}" /> <span>${detail.description}</span></label>
											
								</c:forEach>
								</td>
							</c:if>
							<c:if test="${tech.inputType==2}">
								<c:forEach items="${tech.teckdetails}" var="detail">
									<td><input class="number_input" type="text" value="${detail.priceDelta}"
										name="tech_detail${vs.count}" />${detail.description}</td>
								</c:forEach>
							</c:if>
							<c:if test="${tech.inputType==3}">
							<td colspan="100" class="imagesTd">
								<c:forEach items="${tech.teckdetails}" var="detail" varStatus="vss">
								<label class="red_box">
								<input name="tech_detail${vs.count}" type="radio"<c:if test="${vss.count==1}">
											checked="checked"
											</c:if> value="${detail.description},${detail.priceDelta}"/>
								<img class="littleImg"src="${pageContext.request.contextPath}/image/get?path=${detail.description}"/></label>
								</c:forEach>
								</td>
							</c:if>
						</tr>
					</c:forEach>
					<tr>
					<td>数量</td>
					<td><input class="number_input" type="text" value="1"
										name="number" /></td>
					</tr>
				</table>
				<div>
					<p class="total_price">
						共计：￥<label>68.00</label>元
					</p>
					<input type="hidden" name="pid" value="${product.id}"/>
					<input type="button" id="buyNow"value="立即购买"/>
					<input type="button" id="addCart"value="加入购物车" />
				</div>
			</form>
		</div>
		<!-- 商品描述 -->

		<!-- 商品详情 -->
		<div class="product_detail">
			<p class="company_name">品点品牌设计</p>
			<p class="customer_service">
				客服A <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=239253219&site=qq&menu=yes"><img
					src="${pageContext.request.contextPath}/images/qq_online.png"
					align="middle" /></a>
			</p>
			<p class="customer_service">
				客服B <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=239253219&site=qq&menu=yes"><img
					src="${pageContext.request.contextPath}/images/qq_online.png"
					align="middle" /></a>
			</p>
			<div class="details_title">
				<p>产品详情</p>
			</div>
			<div class="detail_images">
				<c:forEach items="${product.images}" var="image">
					<img src="${pageContext.request.contextPath}/image/get?path=${image.urlpath}"/>
				</c:forEach>
			</div>
		</div>
		<!-- 商品详情 -->
	</div>
</body>
</html>
