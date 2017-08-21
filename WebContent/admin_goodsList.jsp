<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.eshop.dao.pojo.Goods"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

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
  		
  		<script type="text/javascript">
        function F_Open_dialog() 
       { 
            document.getElementById("btn_file").click(); 
       } 

   		 </script>
      
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
            <li><a href="http://localhost:8080/EShop/addcommodity.html">添加商品</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    	我的
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">jmeter</a></li>
                    <li><a href="#">EJB</a></li>
                    <li><a href="#">Jasper Report</a></li>
                    <li class="divider"></li>
                    <li><a href="#">åç¦»çé¾æ¥</a></li>
                    <li class="divider"></li>
                    <li><a href="#">å¦ä¸ä¸ªåç¦»çé¾æ¥</a></li>
                </ul>
            </li>
        </ul>
    </div>
    </div>
</nav>
	
<%-- 	<%
		List<Goods> list = new ArrayList();
			if(request.getAttribute("adminGoodsListFromServer") != null){
				list = (List<Goods>)request.getAttribute("adminGoodsListFromServer");
			}
		%> --%>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="row">
			
			
			
				<%-- <%for(int i=0;i<list.size();i++){ %>
				<form action="http://localhost:8080/EShop/upload.action?goodsId=<%=list.get(i).getGoodsId() %>" method="post" enctype="multipart/form-data">
				<div class="col-md-4">					
					<div class="thumbnail">
					
        					<input type="file" id="btn_file" name="upload" style="display:none">
       						<img width="350" height="180" alt="300x200" src="images/macPro.jpg" onclick="F_Open_dialog()">
						
						
						<div class="caption">
							<h3>
								<%=list.get(i).getGoodsName() %>
							</h3>
							<p>
								<%=list.get(i).getDescription() %>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
							<p>
								 <a class="btn btn-primary" href="#">Action</a> 
								 <a class="btn" href="#"><input type="submit" value="submit"/></a>
							</p>
						</div>
						
					</div>
				</div>
				
				</form>
				<%} %> --%>
				
				<c:forEach items="${requestScope.adminGoodsListFromServer }" var="goods" varStatus="s">
				<form action="http://localhost:8080/EShop/upload.action?goodsId=${goods.goodsId }" method="post" enctype="multipart/form-data">
				<div class="col-md-4">					
					<div class="thumbnail">
					
        					<input type="file" id="btn_file" name="upload" style="display:none">
       						<img width="350" height="180" alt="300x200" src="images/macPro.jpg" onclick="F_Open_dialog()">
						
						
						<div class="caption">
							<h3>
								${goods.goodsName }
							</h3>
							<p>
							
								${goods.description }Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
							<p>
								 <a class="btn btn-primary" href="#">Action</a> 
								 <a class="btn" href="#"><input type="submit" value="submit"/></a>
							</p>
						</div>
						
					</div>
				</div>
				
				</form>
				</c:forEach>
				
				
			</div>
		</div>
	</div>
</div>
	
	
	
	
	
	

	
	
	
<script>

</script>
</body>
</html>