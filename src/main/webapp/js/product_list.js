/**
 * @author Lonphy
 */
$(function() {
	// $(".product_container").mouseover(function() {
		// $(this).children(".red_block").stop().animate({marginTop:"-349px",opacity:"0.8"},500);
	// }).mouseout(function() {
		// $(this).children(".red_block").stop(true).animate({marginTop:"-17px",opacity:"1"},500);
	// });
	$(".product_container").hover(function() {
		$(this).children(".red_block").stop().animate({marginTop:"-349px",opacity:"0.8"},300);
	}, function() {
		$(this).children(".red_block").stop(true).animate({marginTop:"-18px",opacity:"1"},300);
	});
});
