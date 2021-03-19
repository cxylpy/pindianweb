<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户积分明细</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/manager/css/global.css" />
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/user_bonus.css" />
<script
	src="${pageContext.request.contextPath}/manager/js/jquery-1.11.1.js"></script>
	<style>
		.total_bonus{
			margin-left:300px;	
			background-color:#CCCCCC;
		}
		.total_bonus * {
			background-color:#CCCCCC;
		}
	</style>
<%@ include file="/WEB-INF/manager/manager_top_navigation.jsp"%>
<ul class="side_navigation">
	会员管理
	<li class="sub_title"><a href="#" onclick="javascript:history.back(-1);">返回</a></li>
</ul>
<div class="main_iframe">
	<div class="total_bonus">
				<table>
					<tr>
						<td>
							<p class="total_bonus_desc">总积分</p>
						</td>
						<td>
							<p class="total_bonus_desc">可用积分</p>
						</td>
					</tr>
					<tr>
						<td>
							<p class="large_price">${sessionScope.user.totalBonus}</p>
						</td>
						<td>
							<p class="large_price">${sessionScope.user.usableBonus}</p>
						</td>
					</tr>
				</table>
			</div>
			<table>
				<tr class="titles">
					<td>
						<p>积分来源</p>
					</td>
					<td>
						<p>积分变化</p>
					</td>
					<td>
						<p>日期</p>
					</td>
				<tr>
					<td colspan="4"><div class="background_gray_line"></div></td>
				</tr>
				<c:forEach items="${bonuses}" var="bonus" varStatus="vs">
					<tr class="bonus_detail">
						<td><img src="${pageContext.request.contextPath}/image/get?path=${ordergroups[vs.index].imgPath}&width=100&height=100" />
							<p>
								<br /> ${ordergroups[vs.index].description}
							</p></td>
						<td>
						<c:if test="${bonus.delta>0}">
						<p class="get_bonus">
							+${bonus.delta}
							</p>
						</c:if>
						<c:if test="${bonus.delta<0}">
						<p class="lose_bonus">
							${bonus.delta}
							</p>
						</c:if>
						</td>
						<td><p>${bonus.createTime}</p></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="100">
					<p>
共${maxPage}页
  <a href="${pageContext.request.contextPath}/order/getManagerAllOrders?page=1">首页</a>
  <a href="${pageContext.request.contextPath}/order/getManagerAllOrders?page=${page==1?1:page-1}">上一页</a>
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
					href="${pageContext.request.contextPath}/order/getManagerAllOrders?page=${i}">${i}</a>
			</c:if>
		</c:forEach>
		<!-- 分页逻辑结束 -->
<a href="${pageContext.request.contextPath}/order/getManagerAllOrders?page=${page==maxPage?page:page+1}">下一页</a>
  <a href="${pageContext.request.contextPath}/order/getManagerAllOrders?page=${maxPage}">尾页</a>

	</p>
					</td>
				</tr>
			</table>
	
	
	
</div>
</body>