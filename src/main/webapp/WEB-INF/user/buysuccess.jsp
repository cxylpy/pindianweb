<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="generalHeader.jsp"%>
		<title>支付成功</title>
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
				margin-top:120px;
				font-size:1.3em;
			}
			.centerBlock p span{
				color:#da251c;
			}
			.centerBlock p+p{
				margin-top:30px;
				font-size:1em;
				text-align:center;				
			}
			.centerBlock p+p span{
				color:#054ba5;
				padding-right:5px;
				padding-left:5px;
			}
			.centerBlock a{
				text-decoration:none;
				color:#0097de;
			}
		</style>
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
	</head>
<body>
<%@ include file="baseNavigation.jsp" %>
<div class="container">
	<div class="centerBlock">
		<img src="${pageContext.request.contextPath}/images/tick_pay.png"/>
		<p>您已成功付款<span>￥${price}</span>元</p>
		<p><span id="second">5</span>秒后跳转到订单详情页面</p>
	</div>
	</div>
	<script>
		$(function () {
			var second = 5;
			counter = setInterval(function() {
				second--;
				$("#second").text(second);
				if(second==0) {
					clearInterval(counter);
					window.location.href="${pageContext.request.contextPath}/order/getOrderDetail?id=${orderid}";
				}
			},1000);
		});
	</script>
</body>
</html>