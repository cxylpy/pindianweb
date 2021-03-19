<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改商品</title>
<link rel="stylesheet" type="text/css" href="css/global.css" />
<link rel="stylesheet" type="text/css" href="css/addProduct.css" />
<script src="js/jquery-1.11.1.js"></script>
<script src="js/jquery.form.js"></script>
<script src="js/addProduct.js"></script>
<%@ include file="/WEB-INF/manager/manager_top_navigation.jsp"%>
<ul class="side_navigation">
	商品管理
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/jsp_addProduct" >发布商品</a></li>
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/manageAllProduct" style="color:#da251c">管理所有商品</a></li>
</ul>
<div class="main_iframe">
	<form action="${pageContext.request.contextPath}/manager/updateProduct"
		method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>
					<p>商品标题</p>
				</td>
				<td><input type="text" name="name" value="${product.name}" /></td>
			</tr>
			<tr>
				<td>
					<p>商品卖点</p>
				</td>
				<td><input type="text" name="description"
					value="${product.description}" /></td>

			</tr>
			<tr>
				<td>
					<p>基础价格</p>
				</td>
				<td><input type="text" name="price" value="${product.price}" /></td>
			</tr>
			<tr>
				<td>
					<p>促销价格</p>
				</td>
				<td><input type="text" name="onsalePrice"
					value="${product.onsalePrice}" /></td>
			</tr>
			<tr>
				<td>
					<p>商品图片</p>
				</td>
				<td><input type="file" name="image" id="single_image_file" /></td>
			</tr>
			<tr>
				<td><img id="single_pic"
					src="${pageContext.request.contextPath}/image/get?path=${product.imgPath}&width=80&height=80" /></td>
				<input type="hidden" id="product_image" name="product_image" value="${product.imgPath }"/>
			</tr>
			<tr>
				<td>在店铺中所属的分类：</td>
				<td><label> <input type="radio" name="largeType"
						value="1"
						<c:if test="${product.largeType==1}">
						checked="checked"
						</c:if> />
						校园文化产品
				</label><label> <input type="radio" name="largeType" value="2"
						<c:if test="${product.largeType==2}">
						checked="checked"
						</c:if> />
						A4云打印
				</label><label> <input type="radio" name="largeType" value="3"
						<c:if test="${product.largeType==3}">
						checked="checked"
						</c:if> />
						海报
				</label><label> <input type="radio" name="largeType" value="4"
						<c:if test="${product.largeType==4}">
						checked="checked"
						</c:if> />
						DM单
				</label><label> <input type="radio" name="largeType" value="5"
						<c:if test="${product.largeType==5}">
						checked="checked"
						</c:if> />
						横幅/旗帜
				</label><label> <input type="radio" name="largeType" value="6"
						<c:if test="${product.largeType==6}">
						checked="checked"
						</c:if> />
						名片
				</label><label> <input type="radio" name="largeType" value="7"
						<c:if test="${product.largeType==7}">
						checked="checked"
						</c:if> />
						标志设计
				</label></td>
			</tr>
			<%-- 
			<tr>
				<td>
					<p>支付方式：</p>
				</td>
				<td><label> <input type="checkbox" name="payTypeString"
						value="0"
						<c:if test="${product.paytype.type==2 or product.payType.type==0}">
						checked="checked"
						</c:if> />
						线上支付
				</label><label> <input type="checkbox" name="payTypeString"
						value="1"
						<c:if test="${product.paytype.type==2 or product.payType.type==1}">
						checked="checked"
						</c:if> />
						货到付款
				</label></td>
			</tr>
			--%>
			<c:forEach items="${product.techs}" var="tech" varStatus="vs">
				<tr class="techs">
					<td>
						<p>
							工艺<span class="techPosition">${vs.count}</span>： <input
								type="text" name="techName" value="${tech.name}" />
						</p>
					</td>
					<td><label> <input type="radio"
							name="inputType${vs.count}"
							<c:if test="${tech.inputType==1}">
					checked="checked"
					</c:if>
							value="1" class="addText" /> 单选
					</label><label> <input type="radio" name="inputType${vs.count}"
							value="2"
							<c:if test="${tech.inputType==2}">
					checked="checked"
					</c:if>
							class="addText" /> 输入
					</label> <c:if test="${vs.count==1}">
							<label> <input type="radio" name="inputType${vs.count}"
								value="3"
								<c:if test="${tech.inputType==3}">
					checked="checked"
					</c:if>
								class="addPic" /> 图片
							</label>
						</c:if>
						<div class="techDescBlock"
							<c:if test="${tech.inputType==3}">
						id="product_images"
						</c:if>>
							<c:forEach items="${tech.teckdetails}" var="detail"
								varStatus="vss">
								<c:if test="${tech.inputType==1 or tech.inputType==2}">
									<br />
									<label>描述:<input type="text"
										name="techDescription${vs.count}"
										value="${detail.description}" /></label>
									<label>增加的价格:<input type="text"
										name="techPriceDelta${vs.count}" value="${detail.priceDelta}" /></label>
								</c:if>
								<c:if test="${tech.inputType==3}">
									<img align="middle"
										src="${pageContext.request.contextPath}/image/get?path=${detail.description}&width=80&height=80">
									<input type="hidden" value="${detail.description}"
										name="techDescription${vs.count}">
									<input type="text" name="techPriceDelta${vs.count}"
										value="${detail.priceDelta}">
								</c:if>
							</c:forEach>
						</div> <c:if test="${tech.inputType==3}">
							<input type="file" value="添加图片" class="addTechDesc" name="image">
						</c:if> <c:if test="${tech.inputType==1 or tech.inputType==2}">
							<input type="button" value="添加描述" class="addTechDesc">
						</c:if></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="2"><input type="button" id="addTech" value="添加工艺">
				</td>
			</tr>
			<tr>
				<td>商品描述图片：</td>
				<td><input type="file" id="images_file" name="image" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="images">
					<c:forEach items="${product.images}" var="image">
						<img
							src="${pageContext.request.contextPath}/image/get?path=${image.urlpath}&width=80&height=80">
						<input type="hidden"
							value="${image.urlpath}"
							name="details_image">
</c:forEach>
					</div>
				</td>
			</tr>
			<tr>
				<td>活动：</td>
				<td><input type="text" name="action" value="${product.action}"/></td>
			</tr>
			<tr>
			<input type="hidden" name="id" value="${product.id}"/>
				<td colspan="2"><input type="submit" value="确定" /></td>
			</tr>
		</table>
	</form>
	<!-- <iframe name="image_iframe"></iframe> -->
</div>
</body>
</html>

