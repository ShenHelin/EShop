<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>添加商品</title>
    <meta charset="utf-8">
    <link href="common/bootstrap.min.css" rel="stylesheet" media="screen">
  	<script src="common/jquery-3.2.1.js" type="text/javascript"></script>
  	<script src="common/bootstrap.min.js" type="text/javascript"></script>
    
    <style type="text/css">

    </style>
    
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">苏宁易购</a>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li><a href="http://localhost:8080/EShop/goods_findAll.action">商品首页</a></li>
            <li><a href="http://localhost:8080/EShop/shoppingCart_findByUserId.action?user.userId=${user.userId }">购物车</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    	我的
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">jmeter</a></li>
                    <li><a href="#">EJB</a></li>
                    <li><a href="#">Jasper Report</a></li>
                    <li class="divider"></li>
                    <li><a href="#">分离的链接</a></li>
                    <li class="divider"></li>
                    <li><a href="#">另一个分离的链接</a></li>
                </ul>
            </li>
        </ul>
    </div>
    </div>
</nav>
<div style="margin:100px auto; width: 300px;">
    <div class="image">
    	<img src="img/success.jpg" alt="" />
    </div>
    <p style="font-size: 24px; color: limegreen; margin: 10px 5px;">恭喜！您已经付款成功！</p>
</div>


<script type="text/javascript">
       
</script>
</body>
</html>