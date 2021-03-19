$(function() {
	$(".toptitle:first").click(function() {
		window.location.href="/news/getSumNews";
	});
	$(".toptitle").not(":first").click(function() {
		alert("此页面正在建设中...");
		return false;
	});
});