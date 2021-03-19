$(function() {
	$password = $("input[name=password]");
	$mobile = $("input[name=mobile]");
	$("input[type=submit]").click(function() {
		var content = /^\w+$/;
		if (content.test($mobile.val())) {
			if (content.test($password.val())) {
				return true;
			}
		}
		$(".message").children().text("手机号和密码不能为空!");
		return false;
	});
});
