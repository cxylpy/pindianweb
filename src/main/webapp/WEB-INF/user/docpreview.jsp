<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="generalHeader.jsp"%>
<link href="${pageContext.request.contextPath}/css/about.css" type="text/css" rel="stylesheet"/>
		<title>文件预览</title>
		<style>
		*{
			margin:0 auto;
			padding:0;
		}
			iframe{
			width:1024px;
			height:768px;
			margin-top:50px;
			margin-bottom:50px;
			}
		</style>
	</head>
<body>
<%@ include file="baseNavigation.jsp" %>
<div class="container">
<iframe src="${pageContext.request.contextPath}/file/get">
	
</iframe>
</div>
</body>
</html>