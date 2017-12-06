var url = "http://127.0.0.1:8080/ssm-maven" ;

/* 刷新生成验证码 */  
function flushValidateCode() {  
    var validateImagObject = document.getElementById("codeValidateImg");  
    validateImagObject.src = url + "/util/getLoginImageCode.do?time=" + new Date();//向服务器请求验证码  
}

/*检查验证码 并确定提交数据的方向*/
function checkValidateCode(butt){
	var code = $("#ValiCode").val();
	if(code==null||code.trim().length!=4){
		$("#checkValidate").html("验证码输入错误");
		flushValidateCode();
		$("#ValiCode").val("");
		return;
	}else{
		$("#checkValidate").html("");
	}
	/*把验证码发送给服务器 让服务器去验证*/
	$.ajax({
		type : "get",
		datatype:"json",
		data:{"validateCode":code},
		url:url+"/util/checkImgCode.do",
		success:function(data){
			if(data == "true"){
				if(butt.value == "提交并注册"){
					commit();
					flushValidateCode();
				}else if(butt.value == "登录"){
					login();
					flushValidateCode();
				}
			}else{
				$("#checkValidate").html("验证码输入错误");
				$("#ValiCode").val("");
				flushValidateCode();
			}
		},
		error:function(){
			alert("网络超时");
			flushValidateCode();
		}
	});

}


function commit(){
	var check = true;
	var pwd1 = $("#rePwd1").val();
	var pwd2 = $("#rePwd2").val();
	var email = $("#email").val();
	var telephone = $("#telephone").val();
	var username = $("#username").val();
	var emailCheck = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
	var phoneCheck = /^1[3|4|5|8][0-9]\d{4,8}$/;
	 if(!emailCheck.test(email)){
		$("#checkEmail").html("email格式错误");
	}else{
		$("#checkEmail").html("");
	}
	
	if(!phoneCheck.test(telephone)){
		$("#checkPhone").html("手机号格式错误");
	}else{
		$("#checkPhone").html("");
	}
	
	if(username.length<4||username.length>16){
		$("#checkUserName").html("账号以字母开头，由小写英文字母和数字组成的4-16位字符");
		check = false ;
		return;
	}else{
		$("#checkUserName").html("");
	}
	if(pwd1==""||pwd1!=pwd2||pwd1==null){
		$("#checkPwd").html("密码为空或者2次密码不一致");
		check = false;
		return;
	}else{
		$("#checkPwd").html("");
	} 
	
	if(check){
		$.ajax({
			type : "post",
			datatype:"json",
			data:{username:username,password:pwd1,email:email,telephone:telephone},
			url:url+"/shoot/User/regist.do",
			success:function(data){
				if(data==1){
					alert("注册成功");
					window.location.href = url+"/register_2.html";
				}else if(data == -1){
					$("#checkPwd").html("密码格式错误");
				}else if(data == 0){
					alter("注册失败");	
				}
			},
			error:function(){
				alert("error");
			}
		});
	}
	
}