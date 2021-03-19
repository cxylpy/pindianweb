<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/user/generalHeader.jsp" %>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css"/>
<script src="${pageContext.request.contextPath}/js/login.js"></script>
		<title>登陆品点</title>
	</head>
	<body>
		<div class="container">
		<form action="${pageContext.request.contextPath}/user/login" autocomplete="off" method="post">
			<div>
				<img src="${pageContext.request.contextPath}/images/login_logo.png"/>
			</div>
			<table>
				<tr>
					<td class="message"><p>${login_message}</p></td>
				</tr>
				<tr>
					<td class="box">
					<label>手机号</label>
					<input type="text" name="mobile"/>
					<img src="${pageContext.request.contextPath}/images/user_account.png"/></td>
				</tr>
				<tr>
					<td class="box">
					<label>密码</label>
					<input type="password" name="password"/>
					<img src="${pageContext.request.contextPath}/images/password.png"/></td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="submit" value="登录"/>
					</td>
				</tr>
				<tr>
					<td>
						<a href="${pageContext.request.contextPath}/register.jsp">立即免费注册</a>
					</td>
				</tr>
			</table>
		</form>
		</div>
		<hr/>
		<p>品点品牌设计有限公司</p>
	</body>
</html>
