<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.eshop.dao.pojo.Goods"%>
<%@page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
      
      
		<%
		List<Goods> list = new ArrayList();
			if(request.getAttribute("goodsListFromServer") != null){
				list = (List<Goods>)request.getAttribute("goodsListFromServer");
			}
		%>
      
	</head>
	
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">苏宁易购</a>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="home_page.html">商品首页</a></li>
            <li><a href="cart.html">购物车</a></li>
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
            <li><a href="http://localhost:8080/EShop/goods_findByAdminId.action">商品信息</a></li>
        </ul>
    </div>
    </div>
</nav>
	
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="carousel slide" id="carousel-323235">
				<ol class="carousel-indicators">
					<li class="active" data-slide-to="0" data-target="#carousel-323235">
					</li>
					<li data-slide-to="1" data-target="#carousel-323235">
					</li>
					<li data-slide-to="2" data-target="#carousel-323235">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<img alt="" src="img/Image1.png" />
						<div class="carousel-caption">
							<h4>
								First Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src="img/Image2.png" />
						<div class="carousel-caption">
							<h4>
								Second Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src="img/Image3.png" />
						<div class="carousel-caption">
							<h4>
								Third Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
				</div> <a class="left carousel-control" href="#carousel-323235" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-323235" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
		</div>
	</div>
</div>
	
	
<div style="margin:50px auto;width: 900px;">
    <div class="panel panel-default" >
        <div class="panel-heading" style="height: 40px;">
            <div style="text-align: left">
                <span style="font-size:20px; font-weight:bold;">商品展示页</span>
                <div style="float: right;">
                    <!--<a class="btn  btn-xs btn-success" href="addcommodity" style="margin-right: 35px;">添加商品</a>-->
                    <a class="btn btn-xs btn-success" href="cart.html" style="margin-right: 35px;">购物车</a>
                    <a class="btn btn-xs btn-info" href="login.html">退 出</a>
                </div>
            </div>
        </div>
        <div class="panel-body">
            <ul class="spys" >
            <%
           	 for(int i =0 ; i < list.size() ; i++){
            %>
                <li class="spys li">
                    <div >
                    	<a href="http://localhost:8080/EShop/goods_findById.action?goodsId=<%=list.get(i).getGoodsId() %>">
                        	<!-- <img width="80" height="100" src="img/xmsz-1.jpg"> -->
                        	<%-- <img width="80" height="100" src="upload/${goods.image }" /> --%>
                        	
                        	<img width="120" height="100" src="${pageContext.request.contextPath }/upload/<%=list.get(i).getImage() %>" /> 
                        </a>
                    </div>
                    <div >
                        <a href="http://localhost:8080/EShop/goods_findById.action?goodsId=<%=list.get(i).getGoodsId() %>" ><%=list.get(i).getGoodsName() %></a>
                        <strong style="color:red;"><%=list.get(i).getPrice() %></strong>
                    </div>
                    <div >
                        <a class="btn btn-success" style="width: 120px;" href="#">加入购物车</a>
                    </div>
                </li> 
                
               <%}%>
            </ul>
        </div>
    </div>
</div>


	
	
<script>

</script>
</body>
</html>
