hasSent = false;
$(function() {
	validNumber = 1;
	nicknameok = false, passwordok = false, phoneok = false;
	$nickname = $("input[name=nickname]");
	$password = $("input[name=password]");
	$password2 = $("input[name=password2]");
	$phone = $("input[name=phone]");
	$nickname.change(checkName);
	$nickname.keyup(checkName);
	$password.keyup(checkPass1);
	$password.change(checkPass1);
	$password2.keyup(checkPass2);
	$password2.change(checkPass2);
	$phone.keyup(checkPhone);
	$phone.change(checkPhone);
	$(".getSms").click(function() {
		checkPhone();
		if (phoneok&&!hasSent) {
			$.get("user/getSms", {
				phone : $phone.val()
			}, function(data) {
				if (data != "error") {
					validNumber = data;
				}
			}, "text");
			hasSent = true;
			showCounter();
		}
	});
	$("input[type=submit]").click(function() {
		checkName();
		checkPhone();
		if ($("#validator").val() == validNumber) {
			return passwordok && phoneok && nicknameok;
		} else {
			setWrongMessage($("#validator"), "验证码不正确");
			return false;
		}
	});

});
function checkNickname(obj) {
	var nicknameReg = /^[\u4e00-\u9fa5_a-zA-Z0-9]{2,12}$/;
	var name = obj;
	if (nicknameReg.test(name))
		return true;
	else
		return false;
}
function checkPasswordLength(obj) {
	var password1 = obj;
	if (password1.trim().length >= 6 && password1.trim().length <= 18) {
		return true;
	} else {
		return false;
	}
}
function checkPasswordSame(obj1, obj2) {
	var password1 = obj1;
	var password2 = obj2;
	if (password1 == password2)
		return true;
	else
		return false;
}
function checkPhoneValid(obj) {
	var phoneNumber = obj;
	var phoneReg = /^1[3|4|5|7|8][0-9]\d{8}$/;
	if (phoneReg.test(phoneNumber)) {
		return true;
	} else {
		return false;
	}
}
function setWrongMessage(obj, msg) {
	obj.parent().parent().next().children().children().text(msg);
}
function checkName() {
	$nicknameValid = $("img[name=nicknameValid]");
	if (checkNickname($nickname.val())) {
		$nicknameValid.prop("src", "images/tick.png");
		setWrongMessage($nickname, "");
		nicknameok = true;
	} else {
		$nicknameValid.prop("src", "images/cross.png");
		setWrongMessage($nickname, "昵称2-12位，数字、字母、汉字、下划线");
		nicknameok = false;
	}
}
function checkPass1() {
	$passwordValid1 = $("img[name=passwordValid1]");
	if (checkPasswordLength($password.val())) {
		$passwordValid1.prop("src", "images/tick.png");
		setWrongMessage($password, "");
		passwordok = true;
	} else {
		setWrongMessage($password, "密码6-18位，数字、字母、下划线");
		$passwordValid1.prop("src", "images/cross.png");
		passwordok = false;
	}
}

function checkPass2() {
	$passwordValid2 = $("img[name=passwordValid2]");
	if (checkPasswordSame($password.val(), $password2.val())) {
		setWrongMessage($password2, "");
		$passwordValid2.prop("src", "images/tick.png");
		passwordok = true;
	} else {
		setWrongMessage($password2, "两次密码不一致");
		$passwordValid2.prop("src", "images/cross.png");
		passwordok = false;
	}
}

function checkPhone() {
	$phoneValid = $("img[name=phoneValid]");
	if (checkPhoneValid($phone.val())) {
		$.get("user/hasRegister", {
			phone : $phone.val()
		}, function(data) {
			if (data == "ok") {
				setWrongMessage($phone, "");
				$phoneValid.prop("src", "images/tick.png");
				phoneok = true;
			} else {
				setWrongMessage($phone, "该手机号已注册");
				$phoneValid.prop("src", "images/cross.png");
				phoneok = false;
			}
		}, "text");
	} else {
		setWrongMessage($phone, "无效手机号");
		$phoneValid.prop("src", "images/cross.png");
		phoneok = false;
	}
}

function showCounter() {
	var time = 60;
	var interval = setInterval(function() {
		$(".getSms").text(time + "秒后重新获取");
		time--;
		if (time == 0) {
			clearInterval(interval);
			time = 60;
			$(".getSms").text("获取短信验证码");
			hasSent = false;
		}
	}, 1000);
}