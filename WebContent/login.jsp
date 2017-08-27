<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
  <title>用户登录</title>
	<meta charset="utf-8">
	
	<link href="${pageContext.request.contextPath }/common/bootstrap.min.css" rel="stylesheet" media="screen">
	<script src="${pageContext.request.contextPath }/common/jquery-3.2.1.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/common/bootstrap.min.js" type="text/javascript"></script>
      
		<style type="text/css">
			.panel-body{
				padding: 30px 50px 0 50px;
			}
			.form-group{
				margin-bottom: 35px;
			}
			.panel-title{
				font-size: 24px;
				font-weight: bold;
			}
		</style>
        
  </head>
<body>
<div class="container web-body" style="margin-top:100px;width: 900px;">
    <div class="row">
        <div class="col-lg-6 col-lg-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading" style="height: 50px;">
                    <div class="panel-title" style="text-align: left">用户登录</div>
                </div>
                <div class="panel-body">
                <!-- http://localhost:8080/EShop/user/login -->
                    <form action="http://localhost:8080/EShop/user/login" class="form-horizontal" role="form" method="post" >
                        <div class="form-group">
                            <input id="username" value="scott" type="text" class="form-control" name="username" placeholder="用户名" />
                        </div>
                        <div class="form-group">
                            <input id="password" value="tiger" type="password" class="form-control" name="password" autocomplete="off" placeholder="密码" />
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-success btn-block" value="登 陆" />
                            <a href="${pageContext.request.contextPath }/user/toRegister" class="btn btn-primary" style="float: right;margin-top: 20px;">注 册</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>



<script type="text/javascript">
   function login(){
       var username = $('#username').val(),password = $('#password').val();
       var data = { "uname": username, "upwd":password};
       $.ajax({
           url:'/login',
           type:'POST',
           data:data,
           success:function(data,status){
               if(status == 'success'){
                   location.href='home';
               }
           },
           error:function(data,status){
             if(status == "error"){
                 location.href='login'
             }
           }
       });
   }
</script>
</body>
</html>