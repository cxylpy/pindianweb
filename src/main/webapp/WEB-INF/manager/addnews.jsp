<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发布文章</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/manager/css/global.css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script src="${pageContext.request.contextPath}/manager/js/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/manager/js/addNews.js"></script>
<style>
	form{
		text-align:left;
		margin-left:10px;
	}
	form p{
		font-size:1.3em;
	}
	input[type=text]{
		font-size:1.1em;
		width:600px;
	}
	input[type=submit]#add{
		float:left;
	}
	#imageblock p{
		font-size:0.9em;
		display:block;
		float:right;
		width:600px;
		margin-right:50px;
	}
</style>
<%@ include file="/WEB-INF/manager/manager_top_navigation.jsp"%>
<ul class="side_navigation">
	文章管理
	<li class="sub_title"><a
		href="${pageContext.request.contextPath}/manager/manageNews"
		>文章列表</a></li>
	<li class="sub_title"><a
		href="${pageContext.request.contextPath}/manager/jsp_addnews"
		style="color:#da251c">发布文章</a></li>
</ul>
<div class="main_iframe">
	<form action="${pageContext.request.contextPath}/manager/addNews" method="post" enctype="multipart/form-data">
		<p>标题</p>
		<br/>
		<input type="text" name="title" />
		<br/>
		<p>子标题</p>
		<br/>
		<input type="text" name="subtitle" />
		<br/>
		<p>图片　　　<input type="file" name="image" /></p>
		<br/>
		<div id="imageblock"></div>
		<br/>
		<p>文章内容</p>
		<br/>
		<textarea rows="10" cols="80" name="content" id="content"></textarea>
		<br/>
		<br/>
		<input id="add"type="submit" value="添加" />
		<br/>
		<br/>
		<br/>
	</form>
</div>
</body>