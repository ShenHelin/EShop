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
		
		<link href="${pageContext.request.contextPath }/common/bootstrap.min.css" rel="stylesheet" media="screen">
		<script src="${pageContext.request.contextPath }/common/jquery-3.2.1.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath }/common/bootstrap.min.js" type="text/javascript"></script>
  		
  		<script type="text/javascript">
  		

  		function F_Open_dialog(){
  			document.getElementById("btn_file").click();
  		}
  		
  		
  		
  		function doUpload(btn) {  
  		     var formData = new FormData($( "#uploadForm" )[0]);  
  		     $.ajax({  
  		          url: 'http://localhost:8080/EShop/goods/upload?goodsId='+btn.name ,  
  		          type: 'POST',  
  		          data: formData,  
  		          async: true,  
  		          cache: true,  
  		          contentType: false,  
  		          processData: false,  
  		          success: function (data) { 

  		            alert(data);  
  		            $("#img"+btn.name).attr("src", data);  
  		              
  		            
  		            
  		          },  
  		          error: function (returndata) {  
  		              alert(returndata);  
  		          }  
  		     });  
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
            <li class="active"><a href="${pageContext.request.contextPath }/goods/findAll">商品首页</a></li>
            <li><a href="${pageContext.request.contextPath }/addGoods.jsp">添加商品</a></li>
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
			
				<c:forEach items="${requestScope.adminGoodsListFromServer }" var="goods" varStatus="s">
				<form id= "uploadForm">
				<div class="col-md-4">
					<div class="thumbnail">
					
        				<input type="file" id="btn_file" name="fileFromClient" style="display:none">
        				<c:choose>
        					<c:when test="${goods.image==null }">
        						<img width="350px" height="180px" src="${pageContext.request.contextPath }/images/macPro.jpg" onclick="F_Open_dialog()" id="img${goods.goodsId }">
        					</c:when>
        					<c:when test="${goods.image=='' }">
        						<img width="350px" height="180px" src="${pageContext.request.contextPath }/images/macPro.jpg" onclick="F_Open_dialog()" id="img${goods.goodsId }">
        					</c:when>
        					<c:otherwise>
        						<img width="350px" height="180px" src="${pageContext.request.contextPath }/upload/${goods.image }" onclick="F_Open_dialog()" id="img${goods.goodsId }">
        					</c:otherwise>
        					
        				</c:choose>
       					
						
						
						<div class="caption">
							<h3>
								${goods.goodsName }
							</h3>
							<p>
							
								${goods.description }Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
							<p>
								 <a class="btn btn-primary" href="${pageContext.request.contextPath }/goods/findById/${goods.goodsId }&1">修改</a> 
								 <a class="btn" href="#">	
								 <input type="text" name="filename" value= "${goods.goodsId }"/>
								 <input type="button" value="上传" onclick="doUpload(this)" name="${goods.goodsId }" />
								 </a>
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