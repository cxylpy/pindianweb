$(function() {
	if ($(".onsale_price").text() == "" || $(".onsale_price").text() == null) {
		basePrice = $(".normal_price").text().substring(1);
		showOnsalePrice = false;
	} else {
		onsalePrice = $(".onsale_price").text().substring(1);
		basePrice = $(".normal_price").text().substring(1);
		showOnsalePrice = true;
	}

//	numberPriceDelta = parseFloat($("input[type=text].number_input").not(
//			"input[name=number]").val());
	numberPriceDelta = basePrice;
	if ($("input[type=text].number_input").length > 1) {
		$("input[type=text].number_input").not("input[name=number]").keyup(
				function() {
					modifyInput($(this));
					calc();
				});
		$("input[type=text].number_input").not("input[name=number]").val(0);
//		modifyInput($("input[type=text].number_input")
//				.not("input[name=number]"));
	}
	if(parseInt($("input[name=large_type]").val())!=2) {
	calc();
	}
	$("input").click(function() {
		calc();
	});
	$(".littleImg").click(function() {
		var src = $(this).attr("src");
		$(".product_image").attr("src", src);
	});
	$("#addCart").click(function() {
		$("form").submit();
	});
	$("#buyNow").click(function() {
		$("form").attr("action","/cart/buyNow");
		$("form").submit();
	});
	$("input[name=number]").keyup(function() {
		modifyInput($(this));
		calc();
	});
	function calc() {
		$totalPrice = $(".total_price label");
		var totalPrice = 0;
		var delta = 0;
		var showOnsalePrice = true;
		var num = 0;
		if(parseInt($("input[name=large_type]").val())!=2) { 
			totalPrice = accAdd(totalPrice, parseFloat(basePrice));
		}
		$("input").not($("input[type=button]")).not($("input[name=number]"))
				.each(
						function() {
							if ($(this).prop("checked")) {
								// totalPrice +=
								// parseFloat($(this).val().split(",")[1]);
								delta = accAdd(delta, parseFloat($(this).val()
										.split(",")[1]));
							}
						});
		if (!isNaN(numberPriceDelta)) {
			var addPrice = accMul(parseFloat($("input[type=text].number_input")
					.not("input[name=number]").val()), numberPriceDelta);
			if(!isNaN(addPrice))
			delta = accAdd(delta, addPrice);
		}
		num = $("input[name=number]").val();
		if(typeof(onsalePrice)=="undefined") {
			showOnsalePrice = false;
		}
		if (showOnsalePrice) {
			if(parseInt($("input[name=large_type]").val())!=2) {
			totalPrice = accMul(num, accAdd(onsalePrice, delta));
			$(".onsale_price").text(
					"￥" + formatFloat(accAdd(onsalePrice, delta)));
			} else {
				totalPrice = accMul(num,  delta);
				$(".onsale_price").text(
						"￥" + formatFloat(delta));
			}
		} else {
			if(parseInt($("input[name=large_type]").val())!=2) {
			totalPrice = accMul(num, accAdd(basePrice, delta));
			} else {
				totalPrice = accMul(num,delta);
			}
		}
		
		if(parseInt($("input[name=large_type]").val())!=2)
		$(".normal_price").text(formatFloat(accAdd(basePrice, delta)))
		else 
			$(".normal_price").text(formatFloat(delta));
			
		$totalPrice.text(formatFloat(totalPrice));
	}
});

function modifyInput(obj) {
	var numStr = obj
			.val()
			.replace(
					/[\u4e00-\u9fa5_a-zA-Z \-~`!@#\$%\^&\*\(\)\+=\}\{\[\]。，？、:;"'\.,\/?\<\>《》￥‘“：；【】]/g,
					"");
	obj.val(numStr);
	if (parseFloat(obj.val()) < 1)
		obj.val(1);
	if (obj.val() == "")
		obj.val(1);
}

/**
 * * 加法函数，用来得到精确的加法结果 * 说明：javascript的加法结果会有误差，在两个浮点数相加的时候会比较明显。这个函数返回较为精确的加法结果。 *
 * 调用：accAdd(arg1,arg2) * 返回值：arg1加上arg2的精确结果
 */
function accAdd(arg1, arg2) {
	var r1, r2, m, c;
	try {
		r1 = arg1.toString().split(".")[1].length;
	} catch (e) {
		r1 = 0;
	}
	try {
		r2 = arg2.toString().split(".")[1].length;
	} catch (e) {
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

function formatFloat(floatvar) {
	var f_x = parseFloat(floatvar);
	if (isNaN(f_x)) {
		return '0.00';
	}
	var f_x = Math.round(f_x * 100) / 100;
	var s_x = f_x.toString();
	var pos_decimal = s_x.indexOf('.');
	if (pos_decimal < 0) {
		pos_decimal = s_x.length;
		s_x += '.';
	}
	while (s_x.length <= pos_decimal + 2) {
		s_x += '0';
	}
	return s_x;
}

// 给Number类型增加一个add方法，调用起来更加方便。
Number.prototype.add = function(arg) {
	return accAdd(arg, this);
};

// 乘法函数，用来得到精确的乘法结果
// 说明：javascript的乘法结果会有误差，在两个浮点数相乘的时候会比较明显。这个函数返回较为精确的乘法结果。
// 调用：accMul(arg1,arg2)
// 返回值：arg1乘以arg2的精确结果
function accMul(arg1, arg2) {
	var m = 0, s1 = arg1.toString(), s2 = arg2.toString();
	try {
		m += s1.split(".")[1].length
	} catch (e) {
	}
	try {
		m += s2.split(".")[1].length
	} catch (e) {
	}
	return Number(s1.replace(".", "")) * Number(s2.replace(".", ""))
			/ Math.pow(10, m)
}
// 给Number类型增加一个mul方法，调用起来更加方便。
Number.prototype.mul = function(arg) {
	return accMul(arg, this);
}