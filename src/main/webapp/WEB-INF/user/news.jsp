<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="generalHeader.jsp"%>
<title>品点资讯</title>
<script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
<link rel="stylesheet" tpye="text/css"
	href="${pageContext.request.contextPath}/css/news.css" />
	<script src="${pageContext.request.contextPath}/js/newstop.js"></script>
</head>
<body>
	<%@ include file="baseNavigation.jsp"%>
	<div class="container">
		<label class="toptitle"><input type="radio" name="toptitle"
			checked="checked" /><span>公司动态</span></label> <label class="toptitle"><input
			type="radio" name="toptitle" /><span>会员俱乐部</span></label> 
		<c:forEach items="${news}" var="n">
		<a href="${pageContext.request.contextPath}/news/getDetail?id=${n.id}">
			<div class="sumblock">
				<p class="title">${n.title}</p>
				<c:forEach items="${n.images}" begin="0" end="0" var="image">
				<img src="${pageContext.request.contextPath}/image/get?path=${image.urlpath}&width=400&height=400" />
				</c:forEach>
			</div>
		</a> 
		</c:forEach>
	</div>

</body>
</html>