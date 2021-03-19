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
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/showAllBribery" >红包管理</a></li>
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/jsp_newa4package">礼包发布</a></li>
	<li class="sub_title"><a style="color:#da251c" href="${pageContext.request.contextPath}/manager/showAllA4package">礼包管理</a></li>
</ul>
<div class="main_iframe">
		<table>
			<tr>
				<td>
					<p>礼包图片</p>
				</td>
				<td>
					<p>礼包主题</p>
				</td>
				<td>
					<p>A4页数</p>
				</td>
				<td>
					<p>礼包数量</p>
				</td>
				<td>
					<p>剩余数量</p>
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
			
			<c:forEach items="${a4packages}" var="a4package">
			<tr>
				<td>
					<img src="${pageContext.request.contextPath}/image/get?path=${a4package.imgPath}&width=60&height=60"/>
				</td>
				<td>
					<p>${a4package.name}</p>
				</td>
				<td>
					<p>${a4package.pages}页</p>
				</td>
				<td>
					<p>${a4package.num}</p>
				</td>
				<td>
					<p>${a4package.restNum}</p>
				</td>
				<td>
					<p>${a4package.validDate}</p>
				</td>
				<td>
					<p>${a4package.isShow==0?"未上架":"已上架"}</p>
					<p><a href="${pageContext.request.contextPath}/manager/showThisPackage?id=${a4package.id}">上架</a></p>
					<p><a href="${pageContext.request.contextPath}/manager/hideThisPackage?id=${a4package.id}">下架</a></p>
				</td>
				<td>
					<p><a href="${pageContext.request.contextPath}/manager/modifyA4packageView?id=${a4package.id}">修改</a></p>
				</td>
			</tr>
			</c:forEach>
		</table>
</div>
</body>
</html>
