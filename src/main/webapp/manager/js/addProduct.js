$(function() {
	techs = $(".techs").length;
	
	$(".addTechDesc")
			.bind(
					"click",
					function() {
						if($(this).attr("name")!="image")
						$(this)
								.parent()
								.children(".techDescBlock")
								.append(
										'<br /><label>描述:<input type="text" name="techDescription'
												+ techs
												+ '"/></label><label>增加的价格:<input type="text" name="techPriceDelta'
												+ techs + '"/></label>');
					});
	$(".addTechDesc").change(function() {
		$("form").ajaxSubmit(options3);
	});
	$("#addTech")
			.click(
					function() {
						techs++;
						$(".techs:last")
								.after(
										'<tr class="techs"><td><p>工艺<span class="techPosition">'
												+ techs
												+ '</span>：<input type="text" name="techName"/></p></td><td><label><input type="radio" name="inputType'
												+ techs
												+ '" value="1"  checked="checked"/>单选</label><label><input type="radio" name="inputType'
												+ techs
												+ '" value="2"/>输入</label><div class="techDescBlock"><br /><label>描述:<input type="text" name="techDescription'
												+ techs
												+ '"/></label><label>增加的价格:<input type="text" name="techPriceDelta'
												+ techs
												+ '"/></label></div><input type="button" value="添加描述" class="addTechDesc"></td></tr>');
						$(".addTechDesc").unbind("click");
						$(".addTechDesc")
								.bind(
										"click",
										function() {
											$tech = $(this).parent().parent();
											pos = $tech.children().children()
													.children().html();
											$(this)
													.parent()
													.children(".techDescBlock")
													.append(
															'<br /><label>描述:<input type="text" name="techDescription'
																	+ pos
																	+ '"/></label><label>增加的价格:<input type="text" name="techPriceDelta'
																	+ pos
																	+ '"/></label>');
										});
						$(".addTechDesc:first").unbind("click");
					});

	function showResponse(responseText, statusText, xhr, $form) {
		$("#single_pic").attr("src", "/image/get?path=" + responseText+"&width=80&height=80");
		$("#single_image_file").val(null);
		$("#product_image").val(responseText);
	}
	function showResponse2(responseText, statusText, xhr, $form) {
		$("#images_file").val(null);
		$(".images").append(
				"<img src='/image/get?path=" + responseText + "&width=80&height=80"+"' />");
		$(".images").append(
				'<input type="hidden" name="details_image" value="'
						+ responseText + '"/>');
		$(".images img:last").click(function() {
			$(this).next().attr("name","").val(" ");
			$(this).hide(500);
		});
	}
	function showResponse3(responseText, statusText, xhr, $form) {
		$("input[type=file]").val(null);
		$("#product_images").append(
				"<img src='/image/get?path=" + responseText +"&width=80&height=80"+"' align='middle'/>");
		$("#product_images").append(
				'<input type="hidden" name="techDescription1" value="'
				+ responseText + '"/>');
		$("#product_images").append('<input type="text" name="techPriceDelta1"/>');
		$("#product_images img:last").click(function() {
			$(this).next().next().attr("name","").hide(500).val(" ");
			$(this).next().attr("name","").val(" ");
			$(this).hide(500);
		});
	}
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

		// here we could return false to prevent the form from being submitted;
		// returning anything other than false will allow the form submit to
		// continue
		return true;
	}
	var options = {
		// target: '#output2', // target element(s) to be updated with server
		// response
		// beforeSubmit : showRequest, // pre-submit callback
		success : showResponse, // post-submit callback
		// other available options:
		url : "/upload/uploadImage", // override for form's 'action'
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
	var options2 = {
		// target: '#output2', // target element(s) to be updated with server
		// response
		// beforeSubmit : showRequest, // pre-submit callback
		success : showResponse2, // post-submit callback
		// other available options:
		url : "/upload/uploadImage", // override for form's 'action'
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
	var options3 = {
			// target: '#output2', // target element(s) to be updated with server
			// response
			// beforeSubmit : showRequest, // pre-submit callback
			success : showResponse3, // post-submit callback
			// other available options:
			url : "/upload/uploadImage", // override for form's 'action'
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

	$("#single_image_file").change(function() {
		$("form").ajaxSubmit(options);
	});
	$("#images_file").change(function() {
		$("form").ajaxSubmit(options2);
	});
//	$("form").submit(function() {
//		ok = true;
//		$("input[type=text]").each(function() {
//			if ($(this).val() == null || $(this).val() == "") {
//				ok = false;
//			}
//		});
//		if(!ok) {
//			alert("请填写好所有的信息");
//		}
//		return ok;
//	})
	$(".addPic").change(function() {
		type = 2;
		$(this).closest("td").children("input").attr({"type":"file","value":"添加图片样式","name":"image"});
		$(this).closest("td").children("div").empty();
		$(this).closest("td").children("div").attr("id","product_images");
		
	});
	$(".addText").change(function() {
		type = 1;
		$(this).closest("td").children("input").attr({"type":"button","value":"添加描述","name":""});
		$(this).closest("td").children("div").empty();
		$(this).closest("td").children("div").attr("id","");
	});
	$(".images img").click(function() {
		$(this).next().attr("name","").val(" ");
		$(this).hide(500);
	});
	$("#product_images img").click(function() {
		$(this).next().next().attr("name","").hide(500).val(" ");
		$(this).next().attr("name","").val(" ");
		$(this).hide(500);
	});
});
