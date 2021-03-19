<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理红包</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager/css/global.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager/css/addProduct.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager/css/manageBribery.css"/>
<script src="${pageContext.request.contextPath}/manager/js/jquery-1.11.1.js"></script>
<script src="${pageContext.request.contextPath}/manager/js/datepicker/WdatePicker.js"></script>
<%@ include file="/WEB-INF/manager/manager_top_navigation.jsp"%>
<ul class="side_navigation">
	财务管理
	<li class="sub_title"><a href="#">财务收入</a></li>
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/jsp_newbribery">红包发布</a></li>
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/showAllBribery" style="color:#da251c">红包管理</a></li>
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/jsp_newa4package">礼包发布</a></li>
	<li class="sub_title"><a  href="${pageContext.request.contextPath}/manager/showAllA4package">礼包管理</a></li>
</ul>
<div class="main_iframe">
		<table>
			<tr>
				<td>
					<p>红包图片</p>
				</td>
				<td>
					<p>红包主题</p>
				</td>
				<td>
					<p>红包面额</p>
				</td>
				<td>
					<p>红包数量</p>
				</td>
				<td>
					<p>剩余数量</p>
				</td>
				<td>
					<p>使用条件</p>
				</td>
				<td>
					<p>使用有效期至</p>
				</td>
				<td>
					<p>状态</p>
				</td>
				<td>
					<p>操作</p>
				</td>
			</tr>
			
			<c:forEach items="${briberys}" var="bribery">
			<tr>
				<td>
					<img src="${pageContext.request.contextPath}/image/get?path=${bribery.imgPath}&width=60&height=60"/>
				</td>
				<td>
					<p>${bribery.name}</p>
				</td>
				<td>
					<p>${bribery.price}</p>
				</td>
				<td>
					<p>${bribery.num}</p>
				</td>
				<td>
					<p>${bribery.restNum}</p>
				</td>
				<td>
					<p>满${bribery.minPrice}元使用</p>
				</td>
				<td>
					<p>${bribery.validDate}</p>
				</td>
				<td>
					${bribery.isShow==0?"未上架":"已上架"}
					<p>
						<p><a href="${pageContext.request.contextPath}/manager/showThisBribery?id=${bribery.id}">上架</a></p>
					<p><a href="${pageContext.request.contextPath}/manager/hideThisBribery?id=${bribery.id}">下架</a></p>
					</p>
				</td>
				<td>
					<p><a href="${pageContext.request.contextPath}/manager/modifyBriberyView?id=${bribery.id}">修改</a></p>
					
				</td>
			</tr>
			</c:forEach>
		</table>
</div>
</body>
</html>
