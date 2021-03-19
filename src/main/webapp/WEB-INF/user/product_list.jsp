<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="generalHeader.jsp"%>


<title>校园文化产品</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/global.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/navigation.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/product_list.css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
<script src="${pageContext.request.contextPath}/js/product_list.js"></script>
</head>
<body>
	<%@ include file="baseNavigation.jsp"%>
	<div class="container">
		<div class="title_bar">
			<p>
				<c:if test="${type==1}">
					校园文化创意产品 >
					</c:if>
				<c:if test="${type==2}">
					A4云打印 >
					</c:if>
				<c:if test="${type==3}">
					海报 >
					</c:if>
				<c:if test="${type==4}">
					DM单 >
					</c:if>
				<c:if test="${type==5}">
					横幅/旗帜 >
					</c:if>
				<c:if test="${type==6}">
					名片 >
					</c:if>
				<c:if test="${type==7}">
					标志设计 >
					</c:if>
			</p>
		</div>
		<img class="shadow"
			src="${pageContext.request.contextPath}/images/product_list_shadow.png" />
		<div class="products">



			<c:forEach items="${products}" var="product">


				<div class="product_container">
					<img
						src="${pageContext.request.contextPath}/image/get?path=${product.imgPath}&width=280&height=330" />
					<a 
						<c:if test="${product.largeType!=2}">
						href="${pageContext.request.contextPath}/product/detail?id=${product.id}"
						</c:if>
						<c:if test="${product.largeType==2}">
						href="${pageContext.request.contextPath}/product/a4print?id=${product.id}"
						</c:if>
						class="red_block">
						<div>
							<p class="product_title">
								<c:if test="${type==1}">
									校园文化创意产品 <br /> >>
								</c:if>
								<c:if test="${type==2}">
					A4云打印 <br /> >>
					</c:if>
								<c:if test="${type==3}">
					海报 <br /> >>
					</c:if>
								<c:if test="${type==4}">
					DM单 <br /> >>
					</c:if>
								<c:if test="${type==5}">
									横幅/旗帜 <br /> >>
								</c:if>
								<c:if test="${type==6}">
					名片<br /> >>
					</c:if>
				<c:if test="${type==7}">
					标志设计<br /> >>
					</c:if>
							</p>
							<p class="product_desc">${product.name}</p>

						</div>
					</a>
				</div>

			</c:forEach>

			<p class="no_more">--更多商品，敬请期待--</p>



		</div>
	</div>
</body>
</html>
