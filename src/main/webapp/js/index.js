$(function() {
	var mousewheel = document.all?"mousewheel":"DOMMouseScroll"; 
	var fullWidth = document.documentElement.scrollWidth;
	var margin = (fullWidth-1024)/2-120-20;
	$(".left_ad").css("marginLeft",margin+"px");
	$(".right_ad").css("marginRight",margin+"px");
	var margin2 = (fullWidth-1024)/2-140-30;
	$("#side_navi").css("marginLeft",margin2+"px");
	$("body").bind(mousewheel,function() {
		var top = document.documentElement.scrollTop;
		var height = document.documentElement.clientHeight;
		var $side = $("#side_navi");
		if(top>height-100) {
			$side.show();
		} else {
			$side.hide();	
		}
	});
});