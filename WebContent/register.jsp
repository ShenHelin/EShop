<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <title>用户注册</title>
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
<div class="container web-body" style="margin-top:100px;width: 980px;">
    <div class="row">
        <div class="col-lg-6 col-lg-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading" style="height: 50px;">
                    <div class="panel-title" style="text-align: left">用户注册</div>
                </div>
                <div class="panel-body">
                    <form action="http://localhost:8080/EShop/user/save" class="form-horizontal" role="form" method="post" >
                       <div class="form-group">
                            <input id="username" type="text" class="form-control" name="username" placeholder="用户名" value="scott" />
                        </div>
                        <div class="form-group">
                            <input id="password" type="password" class="form-control" name="password"  placeholder="密码" value="tiger" />
                        </div>
                        <div class="form-group">
                            <input id="name" type="text" class="form-control" name="userInfo.name" placeholder="昵称" value="scott..."/>
                        </div>
                        <div class="form-group">
                            <input id="sex" type="text" class="form-control" name="userInfo.sex" placeholder="性别" value="M" />
                        </div>
                        <div class="form-group">
                            <input id="phone" type="text" class="form-control" name="userInfo.phone" placeholder="电话号码" value="13366666666"/>
                        </div>
                        <div class="form-group">
                            <input id="email" type="text" class="form-control" name="userInfo.email" placeholder="邮箱" value="666666666@163.com"/>
                        </div>
                        
                        
                        
                        
                        
                        
                        
                        
                        <div class="form-group">
                            <input type="submit" class="btn btn-success btn-block" value="注 册" />
                            <a href="login.html" class="btn btn-primary" style="float: right;margin-top: 20px;">登 陆</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript">
    function register(){
        var name = $('#username').val(),
                password = $('#password').val();
        var data = { "uname": name, upwd:password};
        $.ajax({
            url:'/register',
            type:'POST',
            data:data,
            success:function(data,status){
                if(status == 'success'){
                    location.href='login';
                }
            },
            error:function(data,err){
                location.href='register';
            }
        });
    }
</script>
</body>
</html>