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
        <a class="navbar-brand" href="#">EShop</a>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="http://localhost:8080/EShop/goods_findAll.action">商品首页</a></li>
            <li><a href="http://localhost:8080/EShop/shoppingCart_findByUserId.action?user.userId=${user.userId }">购物车</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    	${user.username }
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="http://localhost:8080/EShop/orderInfo_findByUserId.action?user.userId=${user.userId }">订单信息</a></li>
                    <li class="divider"></li>
                    <li><a href="#">#</a></li>
                    <li class="divider"></li>
                    <li><a href="#">#</a></li>
                </ul>
            </li>
            <li><a href="http://localhost:8080/EShop/goods_findByAdminId.action">商品信息</a></li>
        </ul>
    </div>
    </div>
</nav>
	
	
	
	
	
<div class="container">
	<div class="row clearfix">
		<div class="col-md-2 column">
			<div class="panel-group" id="panel-66203">
				<div class="panel panel-default">
					<div class="panel-heading">
						 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-66203" href="#panel-element-40789">Collapsible Group Item #1</a>
					</div>
					<div id="panel-element-40789" class="panel-collapse collapse">
						<div class="panel-body">
							Anim pariatur cliche...
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						 <a class="panel-title" data-toggle="collapse" data-parent="#panel-66203" href="#panel-element-668943">Collapsible Group Item #2</a>
					</div>
					<div id="panel-element-668943" class="panel-collapse in">
						<div class="panel-body">
							Anim pariatur cliche...
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6 column">
			<div class="carousel slide" id="carousel-313593">
				<ol class="carousel-indicators">
					<li data-slide-to="0" data-target="#carousel-313593">
					</li>
					<li data-slide-to="1" data-target="#carousel-313593" class="active">
					</li>
					<li data-slide-to="2" data-target="#carousel-313593">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item">
						<img alt="" src="img/Image2.png" />
						<div class="carousel-caption">
							<h4>
								l
							</h4>
							<p>
							</p>
						</div>
					</div>
					<div class="item active">
						<img alt="" src="img/Image3.png" />
						<div class="carousel-caption">
							<h4>
							</h4>
							<p>
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src="img/Image1.png" />
						<div class="carousel-caption">
							<h4>
							</h4>
							<p>
							</p>
						</div>
					</div>
				</div> <a class="left carousel-control" href="#carousel-313593" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-313593" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
		</div>
		<div class="col-md-4 column">
			<div class="media">
				 <a href="#" class="pull-left"><img src="v3/default7.jpg" class="media-object" alt='' /></a>
				<div class="media-body">
					<h4 class="media-heading">
						Nested media heading
					</h4> Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
					<div class="media">
						 <a href="#" class="pull-left"><img src="v3/default8.jpg" class="media-object" alt='' /></a>
						<div class="media-body">
							<h4 class="media-heading">
								Nested media heading
							</h4> Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
						</div>
					</div>
				</div>
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
                    <a class="btn btn-xs btn-success" href="http://localhost:8080/EShop/shoppingCart_findByUserId.action?user.userId=${user.userId }" style="margin-right: 35px;">购物车</a>
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
                        <a href="http://localhost:8080/EShop/shoppingCart_save.action?user.userId=${user.userId }&goods.goodsId=<%=list.get(i).getGoodsId() %>" class="btn btn-success" style="width: 120px;" >加入购物车</a>
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
