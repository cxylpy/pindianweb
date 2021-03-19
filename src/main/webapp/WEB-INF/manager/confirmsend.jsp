<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户积分明细</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/manager/css/global.css" />
<script
	src="${pageContext.request.contextPath}/manager/js/jquery-1.11.1.js"></script>
<%@ include file="/WEB-INF/manager/manager_top_navigation.jsp"%>
<ul class="side_navigation">
	确认发货
	<li class="sub_title"><a href="#" onclick="javascript:history.back(-1);">返回</a></li>
</ul>
<div class="main_iframe">
<form action="${pageContext.request.contextPath}/manager/confirmSend" method="post">
				<table>
					<tr>
					<td>
					<p>支付宝交易号：${order.tbid}</p>
					<input type="hidden" value="${order.id}" name="id"/>
					<input type="hidden" value="${order.tbid}" name="tbid"/>
					</td>
					</tr>
					<tr>
						<td>
						物流公司：<input type="text" name="comName"/>
						</td>
					</tr>
					<tr>
						<td>
						物流发货单号：<input type="text" name="number"/>
						</td>
					</tr>
					<tr>
						<td>
							物流运输类型
							<label><input type="radio" name="type" value="POST"/>平邮</label>
							<label><input type="radio" name="type" value="EXPRESS" checked="checked"/>快递</label>
							<label><input type="radio" name="type" value="EMS"/>EMS</label>
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="发货"/>
						</td>
					</tr>
				</table>
				</form>
</div>
</body>