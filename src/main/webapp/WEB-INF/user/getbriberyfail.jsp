<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="generalHeader.jsp"%>
		<title>关于品点</title>
		<style>
		#bg{
			background-image:url("${pageContext.request.contextPath}/images/getbriberybg.png");
			height:70%;
			text-align:center;
		}
		.out{
			padding-top:5%;
		}
		.centerblock{
			width:700px;
			padding-left:70px;
			height:400px;
		}
		.centerblock img, .centerblock p{
		float:left;
		display:block;
		color:#d9d9d9;
		}
		.centerblock a{
			text-decoration:none;
			float:left;
			display:block;
		}
		.left_logo{
			width:150px;
			height:150px;
			margin-top:100px;
			margin-left:100px;
		}
		.line{
			margin-top:80px;
			margin-left:20px;
		}
		table {
		display:block;
		margin-top:100px;
		margin-left:20px;
		float:left;
		}
		span{
			color:#ffff00;
		}
		.title {
			font-size:1.5em;
			padding-bottom:10px;
		}
		.enterhome {
			color:#d9bebe;
			background-color:#da251c;
			padding:5px 10px 5px 10px;
			font-size:1.2em;
			margin-top:30px;
		}
		.seebribery {
			margin-top:30px;
			font-size:1.2em;
			padding:5px 10px 5px 10px;
			color:#282f35;
			background-color:white;
		}
		</style>
	</head>
<body>
<%@ include file="baseNavigation.jsp" %>
	<div class="out">
	<div id="bg">
		<div class="centerblock">
			<img class="left_logo"src="${pageContext.request.contextPath}/images/logo_noborder.png"/>
			<img class="line" src="${pageContext.request.contextPath}/images/verticalline.png"/>
			<table>
				<tr><td colspan="2"><p class="title">${msg}</p></td></tr>
				<tr><td colspan="2"><a href="${pageContext.request.contextPath}/index/showIndex" class="enterhome">进入主页</a><a href="${pageContext.request.contextPath}/user/getBriberys" class="seebribery">查看红包</a></td></tr>
			</table>
		</div>
	</div>
	</div>
</body>
</html>