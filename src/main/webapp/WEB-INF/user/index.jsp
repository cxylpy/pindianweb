<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="generalHeader.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/index.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/product_list.css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
<script src="${pageContext.request.contextPath}/js/product_list.js"></script>
<script src="${pageContext.request.contextPath}/js/index.js"></script>
<title>品点品牌</title>
</head>
<body>
	<%@ include file="baseNavigation.jsp"%>
	<div class="left_ad">
		<c:forEach items="${briberys}" var="b">
		<a href="${pageContext.request.contextPath}/user/getBriberyView?id=${b.id}">
			<img src="${pageContext.request.contextPath}/image/get?path=${b.imgPath}"/>
		</a>
		</c:forEach>
	</div>
	<div class="right_ad">
		<c:forEach items="${a4packages}" var="a">
		<a href="${pageContext.request.contextPath}/user/getA4View?id=${a.id}">
			<img src="${pageContext.request.contextPath}/image/get?path=${a.imgPath}"/>
		</a>
		</c:forEach>
	</div>
	<div class="container">
		<div class="blocks_container">
			<a
				href="${pageContext.request.contextPath}/product/showByLargeType?type=1">
				<div class="campus_product">
					<p>校园文化产品</p>
					<p>&gt;</p>
				</div>
			</a>

			<div class="light_gray_block"></div>
			<a
				href="${pageContext.request.contextPath}/product/showByLargeType?type=4">
				<div class="DMPaper">
					<p>DM单</p>
					<p>&lt;</p>
				</div>
			</a>
			<div class="dark_gray_block"></div>
			<a>
				<div class="center_logo">
					<img
						src="${pageContext.request.contextPath}/images/center_logo.png" />
				</div>
			</a> <a
				href="${pageContext.request.contextPath}/product/showByLargeType?type=2"
				class="right">
				<div class="cloud_print">
					<p>A4 云打印</p>
					<p>&gt;</p>
				</div>
			</a> <a
				href="${pageContext.request.contextPath}/product/showByLargeType?type=3">
				<div class="post">
					<p>海报</p>
					<p>&gt;</p>
				</div>
			</a> <a
				href="${pageContext.request.contextPath}/product/showByLargeType?type=5">
				<div class="banner_flag">
					<p>横幅/旗帜</p>
					<p>&lt;</p>
				</div>
			</a>
		</div>

		<div class="largeType">
			<div class="title_bar">
				<p>
					校园文化创意产品 > <span><a
						href="${pageContext.request.contextPath}/product/showByLargeType?type=1">更多产品</a></span>
				</p>

			</div>
			<img class="shadow"
				src="${pageContext.request.contextPath}/images/product_list_shadow.png" />
			<div class="products">

				<c:forEach items="${cultures}" var="culture">
					<div class="product_container">
						<img
							src="${pageContext.request.contextPath}/image/get?path=${culture.imgPath}&width=280&height=330" />
						<a target="_blank"
							href="${pageContext.request.contextPath}/product/detail?id=${culture.id}"
							class="red_block">
							<div>
								<p class="product_title">
									校园文化创意产品<br /> >>

								</p>
								<p class="product_desc">${culture.name}</p>

							</div>
						</a>
					</div>
				</c:forEach>

				<p class="no_more"></p>
			</div>
		</div>
		<div class="largeType">
			<div class="title_bar">
				<p>
					海报 > <span><a 
						href="${pageContext.request.contextPath}/product/showByLargeType?type=3">更多产品</a></span>
				</p>
			</div>
			<img class="shadow"
				src="${pageContext.request.contextPath}/images/product_list_shadow.png" />
			<div class="products">
				<c:forEach items="${posts}" var="post">
					<div class="product_container">
						<img
							src="${pageContext.request.contextPath}/image/get?path=${post.imgPath}&width=280&height=330" />
						<a target="_blank"
							href="${pageContext.request.contextPath}/product/detail?id=${post.id}"
							class="red_block">
							<div>
								<p class="product_title">
									海报<br /> >>

								</p>
								<p class="product_desc">${post.name}</p>

							</div>
						</a>
					</div>

				</c:forEach>
				<p class="no_more"></p>
			</div>

		</div>
		<div class="largeType">
			<div class="title_bar">
				<p>
					DM单 > <span><a
						href="${pageContext.request.contextPath}/product/showByLargeType?type=4">更多产品</a></span>
				</p>
			</div>
			<img class="shadow"
				src="${pageContext.request.contextPath}/images/product_list_shadow.png" />
			<div class="products">
				<c:forEach items="${dms}" var="dm">
					<div class="product_container">
						<img
							src="${pageContext.request.contextPath}/image/get?path=${dm.imgPath}&width=280&height=330" />
						<a target="_blank"
							href="${pageContext.request.contextPath}/product/detail?id=${dm.id}"
							class="red_block">
							<div>
								<p class="product_title">
									DM单<br /> >>

								</p>
								<p class="product_desc">${dm.name}</p>

							</div>
						</a>
					</div>

				</c:forEach>
				<p class="no_more"></p>
			</div>
		</div>
		<div class="largeType">
			<div class="title_bar">
				<p>
					名片 > <span><a
						href="${pageContext.request.contextPath}/product/showByLargeType?type=6">更多产品</a></span>
				</p>
			</div>
			<img class="shadow"
				src="${pageContext.request.contextPath}/images/product_list_shadow.png" />
			<div class="products">
				<c:forEach items="${cards}" var="card">
					<div class="product_container">
						<img
							src="${pageContext.request.contextPath}/image/get?path=${card.imgPath}&width=280&height=330" />
						<a target="_blank"
							href="${pageContext.request.contextPath}/product/detail?id=${card.id}"
							class="red_block">
							<div>
								<p class="product_title">
									DM单<br /> >>

								</p>
								<p class="product_desc">${card.name}</p>

							</div>
						</a>
					</div>

				</c:forEach>
				<p class="no_more"></p>
			</div>

		</div>
		
		
		<div class="largeType">
			<div class="title_bar">
				<p>
					横幅/旗帜 > <span><a
						href="${pageContext.request.contextPath}/product/showByLargeType?type=5">更多产品</a></span>
				</p>
			</div>
			<img class="shadow"
				src="${pageContext.request.contextPath}/images/product_list_shadow.png" />
			<div class="products">
				<c:forEach items="${flags}" var="flag">
					<div class="product_container">
						<img
							src="${pageContext.request.contextPath}/image/get?path=${flag.imgPath}&width=280&height=330" />
						<a target="_blank"
							href="${pageContext.request.contextPath}/product/detail?id=${flag.id}"
							class="red_block">
							<div>
								<p class="product_title">
									横幅/旗帜<br /> >>

								</p>
								<p class="product_desc">${flag.name}</p>

							</div>
						</a>
					</div>

				</c:forEach>
				<p class="no_more"></p>
			</div>

		</div>
	</div>
	<div id="side_navi">
		<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=239253219&site=qq&menu=yes" id="side_navi_first">在线咨询</a>
		<a href="${pageContext.request.contextPath}/product/showByLargeType?type=1">校园文化创意产品</a>
		<a href="${pageContext.request.contextPath}/product/showByLargeType?type=2">A4云打印</a>
		<a href="${pageContext.request.contextPath}/product/showByLargeType?type=5">横幅旗帜</a>
		<a href="${pageContext.request.contextPath}/product/showByLargeType?type=4">DM单</a>
		<a href="${pageContext.request.contextPath}/product/showByLargeType?type=3">海报</a>
		<a href="${pageContext.request.contextPath}/product/showByLargeType?type=6">名片</a>
		<a href="${pageContext.request.contextPath}/product/showByLargeType?type=7">标志设计</a>
	</div>
</body>
</html>