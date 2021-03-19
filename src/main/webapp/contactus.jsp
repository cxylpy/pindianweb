<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/user/generalHeader.jsp"%>
<link href="${pageContext.request.contextPath}/css/contactus.css"
	type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=qeWyCwXMzdG3lfgh67UTyCw2"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js"></script>
	<link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css" />
<title>关于品点</title>
</head>
<body>
	<%@ include file="WEB-INF/user/baseNavigation.jsp"%>
	<div class="container">
		<div id="map"></div>
		<div id="left">
			<h2>很高兴您对我们感兴趣</h2>
			<h3>Get in touch</h3>
			<p>重庆市南岸区龙门浩街道金桂园A栋楼115室</p>
			<p>T:13883693014 18983941392</p>
			<p>F:62622565</p>
			<p>E: 471142202@qq.com</p>
			<p>
				<a
					href="https://shop115138677.taobao.com/?spm=a230r.7195193.1997079397.189.AuDRLO">品点淘宝店</a>
			</p>
			<h3>Join us</h3>
			<p>如果你的创意无处安放，那么来吧！</p>
			<p>请将简历发送至</p>
			<p>Email:471142202@qq.com</p>
		</div>
		<div id="right">
			<form action="#">
			<p>感谢你对我们的关注，</p>
			<p>请填写表格留下联系方式及你的需求，</p>
			<p>我们将尽快的与您联系。</p>
			<p>你的名字 （必填）</p>
			<input type="text" name="name" class="fillinfotext"/>
			<p>你的邮箱 （必填）</p>
			<input type="text" name="email" class="fillinfotext"/>
			<p>主题</p>
			<input type="text" name="subject" class="fillinfotext"/>
			<p>你的留言</p>
			<textarea name="comment"></textarea>
			<input type="submit" value="发送"/>
			</form>
		</div>
	</div>
	<script>
		var map = new BMap.Map("map");
		var point = new BMap.Point(106.602546,29.552664);
		map.centerAndZoom(point, 18);
		map.addControl(new BMap.NavigationControl());
		map.addControl(new BMap.ScaleControl());
		map.addControl(new BMap.OverviewMapControl());
		// 将标注添加到地图中
		//marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
		
		var content = '<div style="margin:0;line-height:20px;padding:2px;">' +
                    '<img src="./images/logo.png" alt="公司LOGO" style="float:right;zoom:1;overflow:hidden;width:100px;height:100px;margin-left:3px;"/>' +
                    '地址：重庆市南岸区龙门浩街道金桂园A栋楼115室<br/>电话：(023)62622565<br/>简介：专注设计，放眼创新。' +
                  '</div>';

    //创建检索信息窗口对象
    var searchInfoWindow = null;
	searchInfoWindow = new BMapLib.SearchInfoWindow(map, content, {
			title  : "品点品牌",      //标题
			width  : 290,             //宽度
			height : 105,              //高度
			panel  : "panel",         //检索结果面板
			enableAutoPan : true,     //自动平移
			searchTypes   :[
				BMAPLIB_TAB_TO_HERE,  //到这里去
				BMAPLIB_TAB_FROM_HERE //从这里出发
			]
		});
    var marker = new BMap.Marker(point); //创建marker对象
    marker.enableDragging(); //marker可拖拽
    marker.addEventListener("click", function(e){
	    searchInfoWindow.open(marker);
    });
    map.addOverlay(marker); //在地图中添加marker
	    searchInfoWindow.open(marker);
	</script>
</body>
</html>