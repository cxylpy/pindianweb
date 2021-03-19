<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发布红包</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager/css/global.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager/css/addProduct.css" />
<script src="${pageContext.request.contextPath}/manager/js/jquery-1.11.1.js"></script>
<script src="${pageContext.request.contextPath}/manager/js/datepicker/WdatePicker.js"></script>
<%@ include file="/WEB-INF/manager/manager_top_navigation.jsp"%>
<ul class="side_navigation">
	财务管理
	<li class="sub_title"><a href="#">财务收入</a></li>
	<li class="sub_title"><a style="color:#da251c" href="${pageContext.request.contextPath}/manager/jsp_newbribery">红包发布</a></li>
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/showAllBribery">红包管理</a></li>
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/jsp_newa4package">礼包发布</a></li>
	<li class="sub_title"><a  href="${pageContext.request.contextPath}/manager/showAllA4package">礼包管理</a></li>
</ul>
<div class="main_iframe">
	<form action="${pageContext.request.contextPath}/manager/addBribery"
		method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>
					<p>红包主题</p>
				</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>
					<p>红包描述</p>
				</td>
				<td><input type="text" name="description" /></td>
			</tr>
			<tr>
				<td>
					<p>红包面额</p>
				</td>
				<td><input type="text" name="price" />元</td>
			</tr>
			<tr>
				<td>
					<p>红包数量</p>
				</td>
				<td><input type="text" name="num" /></td>
			</tr>
			<tr>
				<td>
					<p>使用红包最小订单总金额</p>
				</td>
				<td><input type="text" name="minPrice" /></td>
			</tr>
			<tr>
				<td>
					<p>有效期至</p>
				</td>
				<td><input type="text" name="validDate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});"/></td>
			</tr>
			<tr>
				<td>
					<p>红包图片</p>
				</td>
				<td><input type="file" name="image"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="发布" /></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>
