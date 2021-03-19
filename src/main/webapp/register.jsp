<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/user/generalHeader.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register.css" />
<script src="${pageContext.request.contextPath}/js/register.js"></script>
<title>注册</title>
</head>
<body>
	<div class="container">
		<form action="${pageContext.request.contextPath }/user/register" autocomplete="off" method="post">
			<table>
				<tr>
					<td>
						<p>昵称：</p>
					</td>
				</tr>
				<tr>
					<td class="box"><input type="text" name="nickname" value="${nickname}"/> <img
						src="${pageContext.request.contextPath}/images/user_account.png" /></td>
					<td>&nbsp;&nbsp;&nbsp;<img name="nicknameValid"
						src="${pageContext.request.contextPath}/images/black_bg.png" /></td>
				</tr>
				<tr>
					<td colspan="2" class="message">
						<p></p>
					</td>
				</tr>
				<tr>
					<td>
						<p>请设置密码：</p>
					</td>
				</tr>

				<tr>
					<td class="box"><input type="password" name="password" value="${password}"/> <img
						src="${pageContext.request.contextPath}/images/password.png" /></td>
					<td>&nbsp;&nbsp;&nbsp;<img name="passwordValid1"
						src="${pageContext.request.contextPath}/images/black_bg.png" /></td>
				</tr>
				<tr>
					<td colspan="2" class="message">
						<p> </p>
					</td>
				</tr>
				<tr>
					<td>
						<p>请确认密码：</p>
					</td>
				</tr>
				<tr>
					<td class="box"><input type="password" name="password2" /> <img
						src="${pageContext.request.contextPath}/images/password.png" /></td>
					<td>&nbsp;&nbsp;&nbsp;<img name="passwordValid2"
						src="${pageContext.request.contextPath}/images/black_bg.png" /></td>
				</tr>
				<tr>
					<td colspan="2" class="message">
						<p> </p>
					</td>
				</tr>
				<tr>
					<td>
						<p>验证手机：</p>
					</td>
				</tr>
				<tr>
					<td class="box"><input type="text" name="phone" value="${phone}"/> <img
						src="${pageContext.request.contextPath}/images/phone_number.png" /></td>
					<td>&nbsp;&nbsp;&nbsp;<img name="phoneValid"
						src="${pageContext.request.contextPath}/images/black_bg.png" /></td>
				</tr>
				<tr>
					<td colspan="2" class="message">
						<p>${register_message}</p>
					</td>
				</tr>
				<tr>
					<td>
						<p>短信验证码：</p>
					</td>
				</tr>
				<tr>
					<td><input type="text" id="validator" name="validator" /> <a
						href="#" class="getSms">获取短信验证码</a></td>
				</tr>
				<tr>
					<td colspan="2" class="message">
						<p></p>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="立即注册" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
