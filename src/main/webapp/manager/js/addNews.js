$(function() {
	$("input[type=file]").change(function() {
		$("form").ajaxSubmit(options);
	});
	CKEDITOR.replace('content');
});

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

function showResponse(responseText, statusText, xhr, $form) {
	$("input[type=file]").val(null);
	$("#imageblock").append(
			"<img src='/image/get?path=" + responseText +"&width=80&height=80"+"' align='middle'/>");
	$("#imageblock").append(
			'<input type="hidden" name="contentimages" value="'
			+ responseText + '"/>');
	$("#imageblock").append(
			"<p>http://www.pindianpp.com/image/get?path=" + responseText +"</p>");
	$("#imageblock img").click(function() {
		$(this).next().attr("name","").hide(500).val(" ");
		$(this).next().next().hide(500);
		$(this).hide(500);
	});
}
