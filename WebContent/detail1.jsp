<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.eshop.dao.pojo.Goods"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="UTF-8">
		<title></title>
		<style type="text/css">
			.panel-title{
				font-size: 24px;
				font-weight: bold;
			}
            .spys{
                list-style-type: none;
            }
            .spys li{
                float: left;
                margin: 10px 10px;
                width: 180px;
                height: 230px;
            }
            .spys li div strong{
                color: red;
            }

		</style>
  		<link href="common/bootstrap.min.css" rel="stylesheet" media="screen">
  		<script src="common/jquery-3.2.1.js" type="text/javascript"></script>
  		<script src="common/bootstrap.min.js" type="text/javascript"></script>
      
	</head>
	
<body>
	
	<%-- <%=request.getParameter("param")%> --%>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">苏宁易购</a>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li><a href="http://localhost:8080/EShop/goods_findAll.action">商品首页</a></li>
            <li><a href="cart.html">购物车</a></li>
            <li class="dropdown active">
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
	
	
	

        
        
<div style="margin:50px auto;width: 1300px;">
    <div class="panel panel-default" >
        <div class="panel-heading" style="height: 40px;">
            <div style="text-align: left">
                <span style="font-size:20px; font-weight:bold;">商品详情页</span>
                <div style="float: right;">
                    <!--<a class="btn  btn-xs btn-success" href="addcommodity" style="margin-right: 35px;">添加商品</a>-->
                    <a class="btn btn-xs btn-success" href="cart.html" style="margin-right: 35px;">购物车</a>
                    <a class="btn btn-xs btn-info" href="login.html">退 出</a>
                </div>
            </div>
        </div>
        <% 
			Goods goods = (Goods)request.getAttribute("goodsFromServer");
		%> 
        <div class="panel-body">
            <div class="top" style="width: 100%;">
            	<div class="left" style="float: left; width: 50%;">
            		<img width="560px" height="480px" src="${pageContext.request.contextPath }/upload/<%=goods.getImage() %>" alt="" />
            		<%-- ${pageContext.request.contextPath }/upload/<%=list.get(i).getImage() %> --%>
            		<%-- <img src="upload/${goods.image }" /> --%>
            	</div>
            	<div class="right" style="float: right; width: 50%;">
            		<h3><%-- <%=goods.getGoodsName() %> --%></h3>
            		<a style="font-size: 18px;"><%=goods.getGoodsName() + " 现货"%> </a>
                    <strong style="color:red; font-size: 30px;"><%=goods.getPrice() %></strong>
                    <p style="margin-top: 20px;"><%=goods.getDescription() %> 信誉诚信保障！每一代iPhone 首批都抢先开售，新iphone特性：新增亮面黑，压力感应HOME键，ip67级防水防尘，1200w像素光学防抖，全新A10处理器，续航提升，立体扬声器 ，lightning耳机接入方式，双摄像头。标配是近期激活，套餐一港版是后封未激活，大陆行是原封未激活</p>
                    <div>
                    	<a style="font-size: 15px;" href="#">产地：</a>
                    	<span>Made in America</span>
                    </div>
                    <div>
                    	<a style="font-size: 15px;" href="#">剩余数量：</a>
                    	<span><%=goods.getLeaveNum() %></span>
                    </div>
                    <div>
                    	<a style="font-size: 15px;" href="#">月销量：</a>
                    	<span><%=goods.getAmount()-goods.getLeaveNum() %> </span>
                    </div>
                    <div  style="margin-top: 50px;">
                        <a class="btn btn-success" style="width: 120px;" href="cart.html">加入购物车</a>
                        <a class="btn btn-warning" style="width: 120px;" href="#">立即购买</a>
                    </div>
            	</div>
            </div>
            
            <div class="content">
            	<div class="img" style="margin:0 auto;width: 760px;">
            		<img src="img/xq1.jpg" alt="" />
            		<img src="img/xq2.jpg" alt="" />
            		<img src="img/xq3.jpg" alt="" />
            		<img src="img/xq4.jpg" alt="" />
            		<img src="img/xq5.jpg" alt="" />
            		<img src="img/xq6.jpg" alt="" />
            		<img src="img/xq7.jpg" alt="" />
            		<img src="img/xq8.jpg" alt="" />
            	</div>
            </div>
            
        </div>
    </div>
</div>
	
	
	
<script>

</script>

</body>
</html>