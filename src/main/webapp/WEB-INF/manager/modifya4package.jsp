<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改礼包</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager/css/global.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager/css/addProduct.css" />
<script src="${pageContext.request.contextPath}/manager/js/jquery-1.11.1.js"></script>
<script src="${pageContext.request.contextPath}/manager/js/datepicker/WdatePicker.js"></script>
<%@ include file="/WEB-INF/manager/manager_top_navigation.jsp"%>
<ul class="side_navigation">
	修改礼包
	<li class="sub_title"><a href="#" onclick="javascript:history.back(-1);">返回</a></li>
</ul>
<div class="main_iframe">
	<form action="${pageContext.request.contextPath}/manager/modifyA4package"
		method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>
					<p>礼包主题</p>
				</td>
				<td><input type="text" name="name" value="${a4package.name}"/></td>
			</tr>
			<tr>
				<td>
					<p>礼包图片<input type="file" name="image"/></p>
				</td>
				<td><img src="${pageContext.request.contextPath}/image/get?path=${a4package.imgPath}&width=60&height=60"/></td>
			</tr>
			<tr>
				<td>
					<p>礼包描述</p>
				</td>
				<td><input type="text" name="description" value="${a4package.description}"/></td>
			</tr>
			<tr>
				<td>
					<p>A4页数</p>
				</td>
				<td><input type="text" name="pages" value="${a4package.pages}"/>页</td>
			</tr>
			<tr>
				<td>
					<p>礼包数量</p>
				</td>
				<td><input type="text" name="num" value="${a4package.num}"/></td>
			</tr>
			<tr>
				<td>
					<p>礼包剩余数量</p>
				</td>
				<td><input type="text" name="restNum" value="${a4package.restNum}"/></td>
			</tr>
			<tr>
				<td>
					<p>状态</p>
				</td>
				<td>${a4package.isShow==0?"未上架":"已上架"}</td>
			</tr>
			<tr>
				<td>
					<p>有效期至</p>
				</td>
				<td><input type="text" name="validDate" value="${a4package.validDate}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="保存修改" /></td>
			</tr>
		</table>
		<input type="hidden" value="${a4package.id}" name="id"/>
		<input type="hidden" value="${a4package.isShow}" name="isShow"/>
		<input type="hidden" value="${a4package.createTime}" name="createTime"/>
	</form>
</div>
</body>
</html>
