<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="/WEB-INF/user/generalHeader.jsp"%>
<title>公司动态</title>
<script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
<link rel="stylesheet" tpye="text/css"
	href="${pageContext.request.contextPath}/css/news.css" />
<style>
.detailblock {
	background-color: white;
	width: 962px;
	margin-top: 40px;
	margin-left: 31px;
	float: left;
	display: block;
	padding:30px;
	line-height:40px;
}

.title {
	font-size: 1.6em;
	text-align:center;
}

.subtitle {
	text-align:center;	
	margin-left:400px;
	font-size: 1.4em;
	
}

.pubtime {
	text-align:right;	
	font-size: 1.1em;
	color:#6e6e6e;
}


.content{
	width:700px;
}
</style>
<script src="${pageContext.request.contextPath}/js/newstop.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/user/baseNavigation.jsp"%>
	<div class="container">
		<label class="toptitle"><input type="radio" name="toptitle"
			checked="checked" /><span>公司动态</span></label> <label class="toptitle"><input
			type="radio" name="toptitle" /><span>会员俱乐部</span></label>
		<div class="detailblock">
			<p class="title">${news.title}</p>
			<p class="subtitle">${news.subtitle}</p>
			<p class="pubtime">${news.pubTime}</p>
			<div class="content">${news.content}</div>
		</div>
	</div>
</body>

</html>