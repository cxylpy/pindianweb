<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>品点品牌后台管理登陆</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager/css/global.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager/css/login.css" />
</head>
<body>
	<img src="${pageContext.request.contextPath}/manager/images/login_bg.png" class="bg" />
	<div class="container">
		<div class="login_box">
			<p class="title">品点品牌网站后台管理系统</p>
			<div class="light_gray_line"></div>
			<table>
				<form action="${pageContext.request.contextPath}/manager/login" method="post">
					<tr>
							<td colspan="2"><p class="message">${login_message}</p></td>
						</tr>
					<tr>
						<td>用户名：</td>
						<td><input type="text" name="username" /></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" name="password" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="" /></td>
					</tr>
				</form>
			</table>
		</div>
	</div>
</body>
</html>


