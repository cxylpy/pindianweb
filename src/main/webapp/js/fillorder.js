$(function() {
	$transCost = $(".transport_cost");
	transPrice = $transCost.first().text();
	$("input[name=transportType]:first").change(function() {
		$transCost.each(function() {
			$(this).text(transPrice);
		});
		calc();
	});
	$("input[name=transportType]:eq(1)").change(function() {
		$transCost.each(function() {
			$(this).text("￥0.00");
		});
		calc();
	});
	$(".receiver_address").each(function() {
		var infos = $(this).text().split(" ");
		var mobile = infos[1];
		var name = infos[0];
		var address = infos[2];
		$(".receive_address").html("寄送至："+address+"<br/>收货人："+name+"  联系电话："+mobile);
	});
	$(".receiver_address").click(function() {
		var infos = $(this).text().split(" ");
		var mobile = infos[1];
		var name = infos[0];
		var address = infos[2];
		$(".receive_address").html("寄送至："+address+"<br/>收货人："+name+"  联系电话："+mobile);
		calc();
	});
	$("#useBribery").closest("td").click(function() {
		calc();
	});
	$(".useBonus").click(function() {
		modifyInput($(this).parent().next());
//		$(this).parent().next().val(1);
		calc();
	});
	$(".useBonus").parent().next().keyup(function() {
		modifyInput($(this));
		calc();
	});
	$(".usePackage").click(function() {
		modifyInput($(this).parent().next());
//		$(this).parent().next().val(1);
		calc();
	});
	$(".usePackage").parent().next().keyup(function() {
		modifyInput($(this));
		calc();
	});
	$("input[type=submit]").click(function() {
		$("form").ajaxSubmit(options);
		return false;
	});
	$(".close").click(function() {
		$(".dialog").css("display","none");
		$(".shadow").css("display","none");
	});
	calc();
	$(".formatprice").each(function() {
		var price = $(this).text().trim().substring(1);
		$(this).text("￥"+formatFloat(parseFloat(price)));
	});
});
function calc() {
	var basePrice = $(".java_gen_price").text().trim().substring(1);
	if($("input[name=transportType]:first").prop("checked")) {
		basePrice = accAdd(basePrice,parseFloat(transPrice.trim().substring(1)));
	}
	$(".with_trans_price").text("￥"+formatFloat(basePrice));
	if($("#useBribery").prop("checked")) {
		var decrease = parseFloat($("#useBribery").parent().next().children(":selected").html().split(" ")[1]);
		$(".decrease_price").text("￥-"+formatFloat(decrease));
		basePrice -= decrease;
	} else {
		$(".decrease_price").text("￥-"+formatFloat(0.0));
	}
	var ratio = $("input[name=ratio]").val();
	var getRatio = $("input[name=getRatio]").val();
	var usableBonus = $("input[name=ratio]").next().text().split(' ')[1];
	usableBonus = parseInt(usableBonus);
	var val = parseInt($(".useBonus").parent().next().val());
	if(val>usableBonus) {
		$(".useBonus").parent().next().val(parseInt(usableBonus));
	}
	val = usableBonus;
	var decreation = val/ratio;
	if(decreation>basePrice) {
		$(".useBonus").parent().next().val(basePrice*ratio);
	}
	val = parseInt($(".useBonus").parent().next().val());
	decreation = val/ratio;
	if($(".useBonus").prop("checked")) {
		basePrice = accAdd(basePrice, -decreation)
	}
	$(".useBonus").parent().next().closest("td").next().children().text("￥-"+formatFloat(decreation));
	if($(".usePackage").prop("checked")) {
		var pages = $(".usePackage").parent().next().val();
		$(".usePackage").parent().next().closest("td").next().children().text("-"+pages+"页");
		var a4price = $("input[name=a4price]").val();
		var dprice = accMul(pages,a4price);
		if(dprice>basePrice) {
			var pp = basePrice / a4price;
			var ppp = parseInt($("input[name=restPage]").val());
			if(pp>ppp) pp = ppp;
			$(".usePackage").parent().next().val(parseInt(pp+0.5));
			dprice = basePrice;
			calc();
		}
		basePrice = accAdd(basePrice,-dprice);
	}
	if(basePrice<=0.1)
		basePrice = 0.1;
	$("#lastTotal").text("￥"+formatFloat(basePrice));
	var getBonus = formatFloat(basePrice*getRatio);
	$(".get_bonus").text("可获得品点积分："+parseInt(getBonus));
}


function accMul(arg1,arg2)
{
var m=0,s1=arg1.toString(),s2=arg2.toString();
try{m+=s1.split(".")[1].length}catch(e){}
try{m+=s2.split(".")[1].length}catch(e){}
return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m)
}


function modifyInput(obj) {
	var numStr = obj.val().replace(/[\u4e00-\u9fa5_a-zA-Z \-~`!@#\$%\^&\*\(\)\+=\}\{\[\]。，？、:;"'\.,\/?\<\>《》￥‘“：；【】]/g,"");
	obj.val(numStr);
	if(parseInt(obj.val())<1)
		obj.val(1);
	if(obj.val()=="")
		obj.val(1);
}




/**
 ** 加法函数，用来得到精确的加法结果
 ** 说明：javascript的加法结果会有误差，在两个浮点数相加的时候会比较明显。这个函数返回较为精确的加法结果。
 ** 调用：accAdd(arg1,arg2)
 ** 返回值：arg1加上arg2的精确结果
 **/
function accAdd(arg1, arg2) {
    var r1, r2, m, c;
    try {
        r1 = arg1.toString().split(".")[1].length;
    }
    catch (e) {
        r1 = 0;
    }
    try {
        r2 = arg2.toString().split(".")[1].length;
    }
    catch (e) {
        r2 = 0;
    }
    c = Math.abs(r1 - r2);
    m = Math.pow(10, Math.max(r1, r2));
    if (c > 0) {
        var cm = Math.pow(10, c);
        if (r1 > r2) {
            arg1 = Number(arg1.toString().replace(".", ""));
            arg2 = Number(arg2.toString().replace(".", "")) * cm;
        } else {
            arg1 = Number(arg1.toString().replace(".", "")) * cm;
            arg2 = Number(arg2.toString().replace(".", ""));
        }
    } else {
        arg1 = Number(arg1.toString().replace(".", ""));
        arg2 = Number(arg2.toString().replace(".", ""));
    }
    return (arg1 + arg2) / m;
}

function formatFloat(floatvar){ 
    var f_x = parseFloat(floatvar); 
    if (isNaN(f_x)){ 
        return '0.00'; 
    } 
    var f_x = Math.round(f_x*100)/100; 
    var s_x = f_x.toString(); 
    var pos_decimal = s_x.indexOf('.'); 
    if (pos_decimal < 0){ 
        pos_decimal = s_x.length; 
        s_x += '.'; 
    } 
    while (s_x.length <= pos_decimal + 2){ 
        s_x += '0'; 
    } 
    return s_x; 
}  

//给Number类型增加一个add方法，调用起来更加方便。
Number.prototype.add = function (arg) {
    return accAdd(arg, this);
};



var options = {
		// target: '#output2', // target element(s) to be updated with server
		// response
		 beforeSubmit : showRequest, // pre-submit callback
		success : showResponse, // post-submit callback
		// other available options:
//		url : "/upload/uploadFile", // override for form's 'action'
		// attribute
		type : 'post' // 'get' or 'post', override for form's 'method'
	// attribute
	// dataType: null // 'xml', 'script', or 'json' (expected server response
	// type)
	// clearForm: true // clear all form fields after successful submit
	// resetForm: true // reset the form after successful submit

	// $.ajax options can be used here too, for example:
	// timeout: 3000
	};

function showRequest(formData, jqForm, options) {
	// formData is an array; here we use $.param to convert it to a string
	// to display it
	// but the form plugin does this for you automatically when it submits
	// the data
//	var queryString = $.param(formData);

	// jqForm is a jQuery object encapsulating the form element. To access
	// the
	// DOM element for the form do this:
	// var formElement = jqForm[0];

//	alert('About to submit: \n\n' + queryString);

	// here we could return false to prevent the form from being submitted;
	// returning anything other than false will allow the form submit to
	// continue
	$(".dialog").css("display", "block");
	$(".shadow").css("display", "block");
	var fullHeight = document.body.scrollHeight;
	var fullWidth = document.body.scrollWidth;
	var screenTop = document.body.clientHeight;
	var screenLeft = document.body.clientWidth;
	var scrollTop = $(window).scrollTop();
	$(".dialog").css({
		"display" : "block",
		"top" : (scrollTop - 400) / 2 + scrollTop + "px",
		"left" : (screenLeft - 460) / 2 + "px"
	});
	$(".shadow").css("top",scrollTop);
	time = 1799;
	counter = setInterval(function() {
		var minutes = time / 60;
		var seconds = time % 60;
		$(".counterblock span").text(parseInt(minutes)+"分"+parseInt(seconds)+"秒");
		time --;
		if(time<=0) {
			clearInterval(counter);
			window.location.href="http://www.pindianpp.com"; 
		}
	},1000);
	return true;
}


function showResponse(responseText, statusText, xhr, $form) {
	$("body").append(responseText);
}

String.prototype.trim = function() {
	return this.replace(/\s*/g,"");
}