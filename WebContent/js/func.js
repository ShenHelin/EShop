//邮箱检测
function isEmail(){
	var obj = $("input[name='email']") ;
	var reg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/ ;
	if(!reg.test(obj)){
		$("#email_lable").html("<img src='images/no.png' /><font style='position: absolute;color: red;margin-top: 10px;font-size:13px;font-weight:bold;'>邮箱格式不正确</font>");
		return false ;
	}else{
		$("#email_lable").html("<img src='images/yes.png' /><font style='position: absolute;color: green;margin-top: 10px;font-size:13px;font-weight:bold;'>邮箱格式正确</font>");
		return true ;
	}
}
//昵称检测
function isName(){
	var obj = $("input[name='username']") ;
	var reg = /^([\u4e00-\u9fa5]+|([a-z]+\s?)+)$/ ;
	if(!reg.test(obj)){
		$("#username_lable").html("<img src='images/no.png' /><font style='position: absolute;color: red;margin-top: 10px;font-size:13px;font-weight:bold;'>请输入中文或者英文名</font>");
		return false ;
	}else{
		$("#username_lable").html("<img src='images/yes.png' /><font style='position: absolute;color: green;margin-top: 10px;font-size:13px;font-weight:bold;'>昵称格式正确</font>");
		return true ;
	}
}
//密码检测
function isPassword(){
	var obj = $("input[name='password']") ;
	var reg = /^[a-zA-Z0-9_-]{6,18}$/ ;
	if(!reg.test(obj)){
		$("#password_lable").html("<img src='images/no.png' /><font style='position: absolute;color: red;margin-top: 10px;font-size:13px;font-weight:bold;'>密码长度8~16位，数字、字母或下划线</font>");
		return false ;
	}else{
		$("#password_lable").html("<img src='images/yes.png' /><font style='position: absolute;color: green;margin-top: 10px;font-size:13px;font-weight:bold;'>密码格式正确</font>");
		return true ;
	}
}
//二次密码检测
function isRePassword(){
	var obj = $("input[name='repassword']") ;
	if(!($("input[name='password']").val() == obj)){
		$("#repassword_lable").html("<img src='images/no.png' /><font style='position: absolute;color: red;margin-top: 10px;font-size:13px;font-weight:bold;'>确认密码与密码不一致</font>");
		return false ;
	}else{
		$("#repassword_lable").html("<img src='images/yes.png' /><font style='position: absolute;color: green;margin-top: 10px;font-size:13px;font-weight:bold;'>确认密码与密码一致</font>");
		return true ;
	}
}
//切换验证码
function changeImageCode(obj){
	obj.src="createImageCode?time="+new Date().getTime() ;
};
//验证码验证
function check_code(){
	var code = $("input[name='identify_code']") ;
	alert(code.val()) ;
	if(code.value.length==4){
		$.ajax({
		   type: "POST",
		   url: "identifyCode",
		   async:false,
		   data: "identifyCode="+code.value,
		   success: function(msg){
		     if(msg.result!=1){
		     	$("#identity_code_lable").html("<img src='images/no.png' /><font style='position: absolute;color: red;margin-top: 10px;font-size:13px;font-weight:bold;'>"+msg.msg+"</font>") ;
		     	return false ;
		     }else{
		     	$("#identity_code_lable").html("<img src='images/no.png' /><font style='position: absolute;color: green;margin-top: 10px;font-size:13px;font-weight:bold;'>验证码正确</font>") ;
		     	return true ;
		     }
		   }
		});
	}else{
		$("#identity_code_lable").html("<img src='images/no.png' /><font style='position: absolute;color: red;margin-top: 10px;font-size:13px;font-weight:bold;'>验证码不正确</font>") ;
		return false ;
	}
};
//提交注册表单
function myform_submit(){
	boolean email_flag = isEmail();
	boolean name_flag = isName();
	boolean password_flag = isPassword();
	boolean repassword_flag = isRePassword();
	boolean code_flag = check_code() ;
	if(email_flag && name_flag && password_flag && repassword_flag && code_flag){
		$("#registerForm").submit();
	}
};
