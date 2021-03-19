<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加商品</title>
<link rel="stylesheet" type="text/css" href="css/global.css" />
<link rel="stylesheet" type="text/css" href="css/addProduct.css" />
<script src="js/jquery-1.11.1.js"></script>
<script src="js/jquery.form.js"></script>
<script src="js/addProduct.js"></script>
<%@ include file="/WEB-INF/manager/manager_top_navigation.jsp"%>
<ul class="side_navigation">
	商品管理
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/addProduct.jsp" style="color:#da251c">发布商品</a></li>
	<li class="sub_title"><a href="${pageContext.request.contextPath}/manager/manageAllProduct?page=1&type=0">管理所有商品</a></li>
</ul>
<div class="main_iframe">
	<form action="${pageContext.request.contextPath}/manager/addProduct"
		method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>
					<p>商品标题</p>
				</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>
					<p>商品卖点</p>
				</td>
				<td><input type="text" name="description" /></td>

			</tr>
			<tr>
				<td>
					<p>基础价格</p>
				</td>
				<td><input type="text" name="price" /></td>
			</tr>
			<tr>
				<td>
					<p>促销价格</p>
				</td>
				<td><input type="text" name="onsalePrice" /></td>
			</tr>
			<tr>
				<td>
					<p>商品图片</p>
				</td>
				<td><input type="file" name="image" id="single_image_file" /></td>
			</tr>
			<tr>
				<td><img id="single_pic" src="" /></td>
				<input type="hidden" id="product_image" name="product_image"/>
			</tr>
			<tr>
				<td>在店铺中所属的分类：</td>
				<td><label> <input type="radio" name="largeType"
						value="1" checked="checked" /> 校园文化产品
				</label><label> <input type="radio" name="largeType" value="2" />
						A4云打印
				</label><label> <input type="radio" name="largeType" value="3" /> 海报
				</label><label> <input type="radio" name="largeType" value="4" />
						DM单
				</label><label> <input type="radio" name="largeType" value="5" />
						横幅/旗帜
				</label><label> <input type="radio" name="largeType" value="5" />
						名片
				</label><label> <input type="radio" name="largeType" value="5" />
						标志设计
				</label></td>
			</tr>
			<%--<tr>
				<td>
					<p>支付方式：</p>
				</td>
				<td><label> <input type="checkbox" name="payTypeString"
						value="0" checked="checked"/> 线上支付
				</label><label> <input type="checkbox" name="payTypeString" value="1" checked="checked"/>
						货到付款
				</label></td>
			</tr>
			 --%>
			<tr class="techs">
				<td>
					<p>
						工艺<span class="techPosition">1</span>： <input type="text"
							name="techName" />
					</p>
					<br/>
				</td>
				<td><label> <input type="radio" name="inputType1"
						value="1" checked="checked" class="addText"/> 单选
				</label><label> <input type="radio" name="inputType1" value="2" class="addText"/>
						输入
				</label><label>
							<input type="radio" name="inputType1" value="3" class="addPic"/>
							图片</label>
					<div class="techDescBlock">
						<br /> <label>描述:<input type="text"
							name="techDescription1" /></label><label>增加的价格:<input type="text"
							name="techPriceDelta1" /></label>
					</div> <input type="button" value="添加描述" class="addTechDesc"> </td>
			</tr>
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
						
					</div>
				</td>
			</tr>
			<tr>
				<td>活动：</td>
				<td><input type="text" name="action" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="确定" /></td>
			</tr>
		</table>
	</form>
	<!-- <iframe name="image_iframe"></iframe> -->
</div>
</body>
</html>

