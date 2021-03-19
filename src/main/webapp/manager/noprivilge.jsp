<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/user/generalHeader.jsp"%>
		<title>对不起，您没有权限</title>
		<style>
			.centerBlock{
				width:600px;
				height:300px;
				background-color:white;
				margin-top:100px;
				float:left;
				margin-left:212px;
			}
			.centerBlock img{
			margin-top:130px;
			margin-left:150px;
			float:left;
			display:block;
			}
			.container{
			height:500px;
			}
			.centerBlock p{
				display:block;
				float:left;
				margin-top:133px;
			}
			.centerBlock a{
				text-decoration:none;
				color:#0097de;
			}
		</style>
	</head>
<body>
<%@ include file="/WEB-INF/user/baseNavigation.jsp" %>
<div class="container">
	<div class="centerBlock">
		<img src="${pageContext.request.contextPath}/images/warning.png"/>
		<p>对不起，你没有权限，返回<a href="${pageContext.request.contextPath}/entrance.jsp">主页</a></p>
	</div>
	</div>
</body>
</html>