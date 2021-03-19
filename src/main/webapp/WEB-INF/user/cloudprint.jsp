<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="generalHeader.jsp"%>
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/product_detail.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/cloudprint.css" />
	<script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
	<script src="${pageContext.request.contextPath}/js/product_detail.js"></script>
	<script src="${pageContext.request.contextPath}/js/cloudprint.js"></script>
<title>${product.name}</title>
</head>
<body>
	<%@ include file="baseNavigation.jsp"%>
<div class="container">
			<!--上传按钮 -->
			<form action="${pageContext.request.contextPath}/upload/uploadFile" enctype="multipart/form-data" method="post" id="uploadfile">
			<div class="upload">
				<div>
					<img class="upload_button"  src="${pageContext.request.contextPath}/images/upload.png"/>
					<input type="file"  name="file" id="uploadfile" style="display:none;"/>
					<p>
						上传文档
					</p>
					<div id="progress_bar">
						<div id="progress"><p>0%</p></div>
					</div>
				</div>
				<%-- <p>
					<label id="preview"><a href="${pageContext.request.contextPath}/jsp_docpreview" target="_blank">文档预览</a></label>
				</p> --%>
			</div>
			</form>
			<!--上传按钮 -->

			<div class="detail">
			<input type="hidden" name="large_type" value="${product.largeType}"/>
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
			<form action="${pageContext.request.contextPath}/cart/buyNow">
			<input type="hidden" value="${product.id}" name="pid"/>
				<table>

					<c:forEach items="${product.techs}" var="tech" varStatus="vs">
						<tr>
							<td>${tech.name}</td>
							<c:if test="${tech.inputType==1}">
								<c:forEach items="${tech.teckdetails}" var="detail" varStatus="vss">
									<td><label class="red_box"> <input
											name="tech_detail${vs.count}" type="radio"
											<c:if test="${vss.count==1}">
											checked="checked"
											</c:if>
											value="${detail.description},${detail.priceDelta}" /> <span>${detail.description}</span></label></td>
											
								</c:forEach>
							</c:if>
							<c:if test="${tech.inputType==2}">
								<c:forEach items="${tech.teckdetails}" var="detail">
									<td><input class="number_input" type="text" value="${detail.priceDelta}"
										name="tech_detail${vs.count}" />${detail.description}</td>
								</c:forEach>
							</c:if>
							<c:if test="${tech.inputType==3}">
							<td colspan="10" class="imagesTd">
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
						共计：￥<label>0.00</label>元
					</p>
					<input type="submit" id="buyNow"value="立即打印"/>
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
	