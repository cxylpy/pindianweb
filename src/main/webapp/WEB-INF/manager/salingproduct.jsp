<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理所有商品</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/manager/css/global.css" />
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/navigation.css" />
<script
	src="${pageContext.request.contextPath}/manager/js/jquery-1.11.1.js"></script>
<script
	src="${pageContext.request.contextPath}/manager/js/datepicker/WdatePicker.js"></script>
<style>
	#navigation_list{
		margin:0;
		min-width:0;
	}
	#navigation_list li{
		width:12.5%;
		font-size:0.9em;
	}
</style>
<%@ include file="/WEB-INF/manager/manager_top_navigation.jsp"%>
<ul class="side_navigation">
	商品管理
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/jsp_addProduct" >发布商品</a></li>
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/manageAllProduct?page=1&type=0"style="color:#da251c">管理所有商品</a></li>
</ul>
<div class="main_iframe">
<ul id="navigation_list">
		<li>
					<a href="${pageContext.request.contextPath}/manager/manageAllProduct?page=1&type=0">所有商品</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/manager/manageAllProduct?page=1&type=1">校园文化产品</a>
				</li >
				<li>
					<a href="${pageContext.request.contextPath}/manager/manageAllProduct?page=1&type=2">A4云打印</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/manager/manageAllProduct?page=1&type=3">海报</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/manager/manageAllProduct?page=1&type=4">DM单</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/manager/manageAllProduct?page=1&type=5">横幅/旗帜</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/manager/manageAllProduct?page=1&type=6">名片</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/manager/manageAllProduct?page=1&type=7">标志设计</a>
				</li>
	</ul>
	<table>
		<tr>
			<td>商品图片</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>总销售量</td>
			<td>发布时间</td>
			<td>商品状态</td>
			<td>商品权重</td>
			<td>状态操作</td>
			<td>权重设置</td>
			<td>商品操作</td>
		</tr>
		<c:forEach items="${products}" var="p">
		<tr>
			<td><img class="product_img" src="${pageContext.request.contextPath}/image/get?path=${p.imgPath}&width=50&height=50" /></td>
			<td>${p.name}</td>
			<td>${p.price}</td>
			<td>${p.totalsale}</td>
			<td>${p.salingtime}</td>
			<td>
				<c:if test="${p.saling==0}">
					未上架
				</c:if>
				<c:if test="${p.saling==1}">
					已上架
				</c:if>
			</td>
			<td>${p.weight}</td>
			<td><a href="${pageContext.request.contextPath}/manager/putOn?id=${p.id}">上架</a>/<a href="${pageContext.request.contextPath}/manager/pullOff?id=${p.id}">下架</a></td>
			<td><form action="${pageContext.request.contextPath}/manager/saveWeight">
					<input type="text" name="weight" value="${p.weight}" />
					<input type="hidden" name="id" value="${p.id}"/>
					<input type="button"
						value="保存权重" onclick="submit();"/>
				</form></td>
			<td><a href="${pageContext.request.contextPath}/manager/modifyProductView?id=${p.id}">修改</a>/<a href="${pageContext.request.contextPath}/manager/deleteProductById?id=${p.id}">删除</a></td>
		</tr>
		</c:forEach>
	</table>
	<p>
		共${maxPage}页 <a
			href="${pageContext.request.contextPath}/manager/manageAllProduct?page=1&type=${type}">首页</a>
		<a
			href="${pageContext.request.contextPath}/manager/manageAllProduct?page=${page==1?1:page-1}&type=${type}">上一页</a>
		<!-- 分页逻辑开始 -->
		<c:if test="${maxPage<=5}">
			<c:set var="begin" value="1" scope="page"></c:set>
			<c:set var="end" value="${maxPage}" scope="page"></c:set>
		</c:if>
		<c:if test="${maxPage>5}">
			<c:choose>
				<c:when test="${page<=3}">
					<c:set var="begin" value="1" scope="page"></c:set>
					<c:set var="end" value="5" scope="page"></c:set>
				</c:when>
				<c:when test="${page>=(maxPage-2)}">
					<c:set var="begin" value="${maxPage-4}" scope="page"></c:set>
					<c:set var="end" value="${maxPage}" scope="page"></c:set>
				</c:when>
				<c:otherwise>
					<c:set var="begin" value="${page-2}" scope="page"></c:set>
					<c:set var="end" value="${page+2}" scope="page"></c:set>
				</c:otherwise>
			</c:choose>
		</c:if>
		<c:forEach begin="${begin}" end="${end}" step="1" var="i">
			<c:if test="${i==page}">
  		${i}
  	</c:if>
			<c:if test="${i!=page}">
				<a
					href="${pageContext.request.contextPath}/manager/manageAllProduct?page=${i}&type=${type}">${i}</a>
			</c:if>
		</c:forEach>
		<!-- 分页逻辑结束 -->
		<a
			href="${pageContext.request.contextPath}/manager/manageAllProduct?page=${page==maxPage?page:page+1}&type=${type}">下一页</a>
		<a
			href="${pageContext.request.contextPath}/manager/manageAllProduct?page=${maxPage}&type=${type}">尾页</a>
	</p>
</div>
</body>