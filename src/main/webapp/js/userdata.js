$(function() {
	var percent = 0;
	if($("input[name=nickname]").val().length>0) {
		percent+=20;
	}
	if($("input[name=telephone]").val().length>0) {
		percent+=20;
	}
	if($("input[name=districtNum]").val().length>0) {
		percent+=20;
	}
	if($("input[name=email]").val().length>0) {
		percent+=20;
	}
	if($("input[name=school]").val().length>0) {
		percent+=20;
	}
	$(".main_progress p").text(percent+"%");
	$(".main_progress").css("width",2*percent+"px");
})