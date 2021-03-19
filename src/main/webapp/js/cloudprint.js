$(function() {
	ok = false;
	$(".upload_button").click(function() {
		$("input[type=file]").trigger("click");
	});

	if (navigator.userAgent.indexOf("MSIE") > 0) {
		$(".upload_button").unbind("click");
		$("input[type=file]").show();
	}
	if (isFirefox = navigator.userAgent.indexOf("Firefox") > 0) {
	}
	if (isSafari = navigator.userAgent.indexOf("Safari") > 0) {
	}
	if (isCamino = navigator.userAgent.indexOf("Camino") > 0) {
	}
	if (isMozilla = navigator.userAgent.indexOf("Gecko/") > 0) {
	}
	$("input[type=file]").change(function() {
		$("#uploadfile").ajaxSubmit(options);
		ok = false;
		query = setInterval(function() {
			$.get("/upload/queryProgress", function(data) {
				$("#progress p").text(data + "%");
				$("#progress").css("width", data + "%");
				if (parseInt(data) >= 100) {
					clearInterval(query);
				}
			}, "text");
		}, 100);
	});

	$("input[type=text].number_input").not("input[name=number]").prop(
			"readOnly", "readOnly");
	$("#buyNow").unbind("click");
	$("input[type=submit]").click(function() {
		if ($("input[name=file]").val().length > 1 && ok)
			return true;
		else {
			alert("请先上传文件并等待完成解析");
			return false;
		}

	});

	/**
	 * * 加法函数，用来得到精确的加法结果 *
	 * 说明：javascript的加法结果会有误差，在两个浮点数相加的时候会比较明显。这个函数返回较为精确的加法结果。 *
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
	var options = {
		// target: '#output2', // target element(s) to be updated with server
		// response
		// beforeSubmit : showRequest, // pre-submit callback
		success : showResponse, // post-submit callback
		// other available options:
		// url : "/upload/uploadFile", // override for form's 'action'
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
		var queryString = $.param(formData);

		// jqForm is a jQuery object encapsulating the form element. To access
		// the
		// DOM element for the form do this:
		// var formElement = jqForm[0];

		alert('About to submit: \n\n' + queryString);
		alert(jqForm[0]);

		// here we could return false to prevent the form from being submitted;
		// returning anything other than false will allow the form submit to
		// continue
		return true;
	}

	function showResponse(responseText, statusText, xhr, $form) {
		if (responseText == "error") {
			alert("请正确上传.doc，.doczx和pdf文件");
			return;
		}
		$("input[type=text].number_input").not("input[name=number]").val(
				responseText);
		$("input[name=number]").trigger("click");
		ok = true;
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
});