<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>全局设置</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/manager/css/global.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/manager/css/addProduct.css" />
<script
	src="${pageContext.request.contextPath}/manager/js/jquery-1.11.1.js"></script>
<%@ include file="/WEB-INF/manager/manager_top_navigation.jsp"%>
<ul class="side_navigation">
	系统设置
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/manageManager">管理管理员</a></li>
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/addManagerView">添加管理员</a></li>
	
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/getManagerRoles">管理角色</a></li>
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/addRoleView">添加角色</a></li>
	<li class="sub_title"><a style="color:#da251c" href="${pageContext.request.contextPath}/manager/showGlobalSettings">积分比例</a></li>
</ul>
<div class="main_iframe">
	<form action="${pageContext.request.contextPath}/manager/saveGlobalSettings" method="post">
		<br/>
		<br/>
		每 <input type="text" name="ratio1" value="${ratio1.price}"/> 个积分可以减免1元
		<br/>
		<br/>
		<br/>
		每消费1元可以获得 <input type="text" name="ratio2" value="${ratio2.price}"/> 个积分
		<br/>
		<br/>
		<br/>
		描述: <input type="text" name="description" value="${cost.description}"/>
		<br/>
		<br/>
		<br/>
		<input type="hidden" value="${ratio1.id}" name="ratioid1"/>
		<input type="hidden" value="${ratio2.id}" name="ratioid2"/>
		全部商品统一运费： <input type="text" name="price" value="${cost.price}"/> 元
		<br/>
		<br/>
		<br/>
		<input type="hidden" value="${cost.id}" name="id"/>
		<input type="submit" value="保存"/>
		<br/>		
		<br/>		
		<br/>		
	</form>
</div>
</body>
</html>
