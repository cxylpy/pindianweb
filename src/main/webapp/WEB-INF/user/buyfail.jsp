<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="generalHeader.jsp"%>
		<title>支付失败</title>
		<style>
			.centerBlock{
				width:600px;
				height:300px;
				background-color:white;
				margin-top:100px;
				float:left;
				margin-left:212px;
			}
			.centerBlock>img{
			margin-top:110px;
			margin-left:150px;
			float:left;
			display:block;
			margin-right:20px;
			}
			.container{
			height:500px;
			}
			.centerBlock p{
				margin-top:110px;
				font-size:1.3em;
			}
			.centerBlock p+p{
				margin-top:30px;
				font-size:1em;
				text-align:center;				
			}
			.centerBlock p+p span{
				padding-right:5px;
				padding-left:5px;
				font-weight:600;
				
			}
			#qq{
				text-decoration:none;
				display:block;
				float:right;
				margin-right:120px;
				margin-top:-30px;
			}
		</style>
	</head>
<body>
<%@ include file="baseNavigation.jsp" %>
<div class="container">
	<div class="centerBlock">
		<img src="${pageContext.request.contextPath}/images/warning.png"/>
		<p>对不起，支付失败了!</p>
		<p><span>联系卖家：</span>品点品牌设计有限公司</p><a target="_blank" id="qq" href="http://wpa.qq.com/msgrd?v=3&uin=239253219&site=qq&menu=yes"><img src="${pageContext.request.contextPath}/images/qq_online.png"/></a>
		

	</div>
	</div>
</body>
</html>