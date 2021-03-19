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
	<li class="sub_title"><a href="#" onclick="javascript:history.back(-1);">返回</a></li>
</ul>
<div class="main_iframe">
	<form action="${pageContext.request.contextPath}/manager/modifyBribery"
		method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>
					<p>红包主题</p>
				</td>
				<td><input type="text" name="name" value="${bribery.name}"/></td>
			</tr>
			<tr>
				<td>红包图片<input type="file" name="image"/></td>
				<td><img src="${pageContext.request.contextPath}/image/get?path=${bribery.imgPath}&width=60&height=60"/></td>
			</tr>
			<tr>
				<td>
					<p>红包描述</p>
				</td>
				<td><input type="text" name="description" value="${bribery.description}"/></td>
			</tr>
			<tr>
				<td>
					<p>红包面额</p>
				</td>
				<td><input type="text" name="price" value="${bribery.price}"/>元</td>
			</tr>
			<tr>
				<td>
					<p>红包数量</p>
				</td>
				<td><input type="text" name="num" value="${bribery.num}"/></td>
			</tr>
			<tr>
				<td>
					<p>使用红包最小订单总金额</p>
				</td>
				<td><input type="text" name="minPrice" value="${bribery.minPrice}"/></td>
			</tr>
			<tr>
				<td>
					<p>有效期至</p>
				</td>
				<td><input type="text" name="validDate"value="${bribery.validDate}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});"/></td>
			</tr>
			<tr>
				<td>
					<p>剩余数量</p>
				</td>
				<td><input type="text" name="restNum" value="${bribery.restNum}"/></td>
			</tr>
			<tr>
				<td>
					<p>红包状态</p>
				</td>
				<td><p>${bribery.isShow==0?"未上架":"已上架"}</p></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="保存修改" /></td>
			</tr>
		</table>
		<input type="hidden" name="createTime" value="${bribery.createTime}"/>
		<input type="hidden" name="isShow" value="${bribery.isShow}"/>
		<input type="hidden" name="id" value="${bribery.id}"/>
	</form>
</div>
</body>
</html>
