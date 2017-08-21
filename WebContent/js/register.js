function submitForm(){
	if(isEmail() && isPassword() && isName() && isRePassword() && check_code()){
		$("#registerForm").submit();
	}
};

function submit_login(){
	if(isEmail() && isPassword2()){
		$("#loginform").submit();
	}
}

function isEmail(){
	var flag = false ;
	 var info = document.getElementById("email_lable") ;
	 var objs = document.getElementsByTagName("input") ;
	 var reg = new RegExp("^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$");
	    if(!objs[0].value.match(reg)){
	        info.innerHTML="<img src='images/no.png' /><font style='position: absolute;color: red;margin-top: 10px;font-size:13px;font-weight:bold;'>邮箱格式不正确</font>";
	    } else{
	        info.innerHTML="<img src='images/yes.png' /><font style='position: absolute;color: green;margin-top: 10px;font-size:13px;font-weight:bold;'>邮箱格式正确</font>";
	        flag = true ;
	    }
	    return flag ;
};

function isName(){
	var flag = false ;
	 var info = document.getElementById("username_lable") ;
	 var objs = document.getElementsByTagName("input") ;
	 var reg = new RegExp("^([\u4e00-\u9fa5a-zA-Z0-9]+)$");
	    if(!objs[1].value.match(reg)){
	        info.innerHTML="<img src='images/no.png' /><font style='position: absolute;color: red;margin-top: 10px;font-size:13px;font-weight:bold;'>请输入中文或者英文名</font>";
	    } else{
	        info.innerHTML="<img src='images/yes.png' /><font style='position: absolute;color: green;margin-top: 10px;font-size:13px;font-weight:bold;'>昵称格式正确</font>";
	        flag = true ;
	    }
	    return flag ;
};

function isPassword(){
	var flag = false ;
	 var info = document.getElementById("password_lable") ;
	 var objs = document.getElementsByTagName("input") ;
	 var reg = new RegExp("^[a-zA-Z0-9_-]{6,18}$");
	    if(!objs[2].value.match(reg)){
	        info.innerHTML="<img src='images/no.png' /><font style='position: absolute;color: red;margin-top: 10px;font-size:13px;font-weight:bold;'>密码长度8~16位，数字、字母或下划线</font>";
	    } else{
	        info.innerHTML="<img src='images/yes.png' /><font style='position: absolute;color: green;margin-top: 10px;font-size:13px;font-weight:bold;'>密码格式正确</font>";
	        flag = true ;
	    }
	    return flag ;
};
function isPassword2(){
	var flag = false ;
	 var info = document.getElementById("password_lable") ;
	 var objs = document.getElementsByTagName("input") ;
	 var reg = new RegExp("^[a-zA-Z0-9_-]{6,18}$");
	    if(!objs[1].value.match(reg)){
	        info.innerHTML="<img src='images/no.png' /><font style='position: absolute;color: red;margin-top: 10px;font-size:13px;font-weight:bold;'>密码长度8~16位，数字、字母或下划线</font>";
	    } else{
	        info.innerHTML="<img src='images/yes.png' /><font style='position: absolute;color: green;margin-top: 10px;font-size:13px;font-weight:bold;'>密码格式正确</font>";
	        flag = true ;
	    }
	    return flag ;
};
function isRePassword(){
	var flag = false ;
	 var info = document.getElementById("repassword_lable") ;
	 var objs = document.getElementsByTagName("input") ;
	    if(!(objs[3].value == objs[2].value)){
	        info.innerHTML="<img src='images/no.png' /><font style='position: absolute;color: red;margin-top: 10px;font-size:13px;font-weight:bold;'>确认密码与密码不一致</font>";
	    } else{
	        info.innerHTML="<img src='images/yes.png' /><font style='position: absolute;color: green;margin-top: 10px;font-size:13px;font-weight:bold;'>确认密码与密码一致</font>";
	        flag = true ;
	    }
	    return flag ;
};

function check_code(){
	var flag = false ;
	var code = document.getElementsByTagName("input")[4] ;
	if(code.value.length==4){
		$.ajax({
		   type: "POST",
		   url: "identifyCode",
		   async:false,
		   data: "identifyCode="+code.value,
		   success: function(msg){
		     if(msg.result!=1){
		     	$("#identity_code_lable").html("<img src='images/no.png' /><font style='position: absolute;color: red;margin-top: 10px;font-size:13px;font-weight:bold;'>"+msg.msg+"</font>") ;
		     	flag = false ;
		     }else{
		     	$("#identity_code_lable").html("<img src='images/yes.png' /><font style='position: absolute;color: green;margin-top: 10px;font-size:13px;font-weight:bold;'>验证码正确</font>") ;
		     	flag = true ;
		     }
		   }
		});
	}else{
		$("#identity_code_lable").html("<img src='images/no.png' /><font style='position: absolute;color: red;margin-top: 10px;font-size:13px;font-weight:bold;'>验证码不正确</font>") ;
		flag = false ;
	}
	return flag ;
};
//切换验证码
function changeImageCode(obj){
	obj.src="createImageCode?time="+new Date().getTime() ;
};