$(function() {
	var banner = setInterval(floatBanner, 3000);
	var width = $("body").width();
	$(".indicator label").click(function() {
		clearInterval(banner);
		var index = $(this).index();
		$(".banners").animate({
			"marginLeft" : -width*index+"px"
		}, 500);
			banner=setInterval(floatBanner,3000);
	});
	$(".left_arrow").click(function() {
		clearInterval(banner);
		var index = $("input[name=indicators]:checked").parent().index();
		var imgs = $(".banners").children().length;
		if(index>0) {
			index--;
			$(".banners").animate({
				"marginLeft" : "+="+width+"px"
			}, 500);
			$("input[name=indicators]").eq(index).prop("checked",true);
		} else {
			index=imgs-1;
			$(".banners").animate({
				"marginLeft" : "-="+width*(imgs-1)+"px"
			}, 500);
			$("input[name=indicators]").eq(index).prop("checked",true);
			
		}
		banner=setInterval(floatBanner,3000);
	});
	$(".right_arrow").click(function() {
		clearInterval(banner);
		var index = $("input[name=indicators]:checked").parent().index();
		var imgs = $(".banners").children().length;
		if(index<imgs-1) {
			index++;
			$(".banners").animate({
				"marginLeft" : "-="+width+"px"
			}, 500);
			$("input[name=indicators]").eq(index).prop("checked",true);
		} else {
			index=0;
			$(".banners").animate({
				"marginLeft" : "0px"
			}, 500);
			$("input[name=indicators]").eq(index).prop("checked",true);
			
		}
		banner=setInterval(floatBanner,3000);
	});
	
	
	
	
});
function floatBanner() {
	var imgs = $(".banners").children().length;
	var width = $("body").width();
	var marginleft = parseInt($(".banners").css("marginLeft").substring(0,$(".banners").css("marginLeft").length-2));
	if (marginleft <= -(imgs - 1) * width) {
		$(".banners").animate({
			"marginLeft" : "0px"
		}, 500);
		$("input[name=indicators]:eq(0)").prop("checked",true);
	} else {
		$(".banners").animate({
			"marginLeft" : "-="+width+"px"
		}, 500);
		var index = marginleft/(-width);
		$("input[name=indicators]").eq(index+1).prop("checked",true);
	}
}

