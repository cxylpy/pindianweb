<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<meta http-equiv="X-UA-Compatible" content="IE=8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager/css/global.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager/css/main.css"/>
		
	</head>
	<body>
		<div class="container">
			<div class="red_line"></div>
			<ul class="manager_navigation">
				<li><img src="${pageContext.request.contextPath}/manager/images/manager_logo.png"/></li>
				<a href="${pageContext.request.contextPath}/manager/getManagerAllOrders?page=1&type=5"><li><img src="${pageContext.request.contextPath}/manager/images/trade.png"/><p>交易管理</p></li></a>
				<a href="${pageContext.request.contextPath}/manager/manageAllProduct?page=1&type=0"><li><img src="${pageContext.request.contextPath}/manager/images/products.png"/><p>商品管理</p></li></a>
				<a href="${pageContext.request.contextPath}/manager/manageUsers?page=1"><li><img src="${pageContext.request.contextPath}/manager/images/vips.png"/><p>会员管理</p></li></a>
				<a href="${pageContext.request.contextPath}/manager/manageNews"><li><img src="${pageContext.request.contextPath}/manager/images/articles.png"/><p>文章管理</p></li></a>
				<a href="${pageContext.request.contextPath}/manager/showGlobalSettings"><li><img src="${pageContext.request.contextPath}/manager/images/settings.png"/><p>系统设置</p></li></a>
				<a href="${pageContext.request.contextPath}/manager/showAllBribery"><li><img src="${pageContext.request.contextPath}/manager/images/finance.png"/><p>财务管理</p></li></a>
			</ul>
				<div class="red_line"></div>