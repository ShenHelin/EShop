<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <title>添加商品</title>
 <meta charset="utf-8">
 
<link href="${pageContext.request.contextPath }/common/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="${pageContext.request.contextPath }/common/jquery-3.2.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/common/bootstrap.min.js" type="text/javascript"></script>
 
 <style type="text/css">
	
	/*读取图片*/
.read_img {
	display: none;
	position: absolute;
	margin-left: 850px;
	margin-top: -400px;
	width: 200px;
	height: 200px;
	border: 1px solid #6F6F6F;
}

.read_img span {
	font-size: 12px;
	margin-top: 5px;
	margin-left: 70px;
	color: #6F6F6F;
	display: inline-block;
}

.read_img img {
	width: 200px;
	height: 200px;
	border: 0px;
}
	
	

 </style>
 
<!-- <script type="text/javascript" src="../js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="../js/ajaxfileupload.js"></script> -->
<script type="text/javascript">
	function ajaxFileUpload() {
		$("#loading").ajaxStart(function() {
			$(this).show();
		})//开始上传文件时显示一个图片
		.ajaxComplete(function() {
			$(this).hide();
		});//文件上传完成将图片隐藏起来

		$.ajaxFileUpload({
			url : '#',//用于文件上传的服务器端请求地址 fileUploadAction.action
			secureuri : false,//一般设置为false
			fileElementId : 'file',//文件上传空间的id属性  <input type="file" id="file" name="file" />
			dataType : 'json',//返回值类型 一般设置为json
			success : function(data, status) //服务器成功响应处理函数
			{
				alert(data.message);//从服务器返回的json中取出message中的数据,其中message为在struts2中action中定义的成员变量
				if (typeof (data.error) != 'undefined') {
					if (data.error != '') {
						alert(data.error);
					} else {
						alert(data.message);
					}
				}
				;
				$("#img_name").val("upload/" + data.fileFileName);
				$("#view_img")
						.attr("src", "/eshop/upload/" + data.fileFileName);
				$(".read_img").show();
				$("#res").text("已上传(" + data.fileFileName + ")");
			},
			error : function(data, status, e)//服务器响应失败处理函数
			{
				alert(e);
			}
		});
		return false;
	}
</script>
 
 
    
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">苏宁易购</a>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li><a href="http://localhost:8080/EShop/goods/findAll">商品首页</a></li>
            <li><a href="http://localhost:8080/EShop/shoppingCart/findByUserId?user.userId=${user.userId }">购物车</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    	我的
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">#</a></li>
                    <li class="divider"></li>
                    <li><a href="#">#</a></li>
                    <li class="divider"></li>
                    <li><a href="#">#</a></li>
                </ul>
            </li>
        </ul>
    </div>
    </div>
</nav>




<div style="margin:100px auto;width: 500px;" class="add_c">
    <h1>添加商品</h1>
    <a class="btn  btn-xs btn-success" href="home" style="margin-left: 400px;">返回商品页</a>
    

    <c:choose>
    	<c:when test="${goods==null }">
	    <form id="addGoods" action="${pageContext.request.contextPath}/goods/save"  role="form" method="post" enctype="multipart/form-data" >
	        <input style="margin-top: 30px;" value="lenovo T400" id="goodsName" type="text" class="form-control"  name="goodsName" placeholder="商品名称" />
	        <input style="margin-top: 30px;" value="lenovo T400..." id="description"  class="form-control" name="description"  placeholder="商品描述" />
	        <input style="margin-top: 30px;" value="999.9" id="price"  class="form-control" name="price"  placeholder="商品价格" />
	        <input style="margin-top: 30px;" value="99" id="amount"  class="form-control" name="amount"  placeholder="商品总数量" />
	        <input style="margin-top: 30px;" value="98" id="leaveNum"  class="form-control" name="leaveNum"  placeholder="商品剩余数量" />
	        <input style="margin-top: 30px;" value="2017-08-21" id="regTime"  class="form-control" name="regTime"  placeholder="商品上架时间" />
	        <input style="margin-top: 30px;" value="1" id="adminId"  class="form-control" name="admin.adminId"  placeholder="adminId" />
	        <input style="margin-top: 30px;" value="1" id="classId"  class="form-control" name="goodsClass.classId"  placeholder="classId" />
	        
	        
	        
	<!--         <span class="add_label">图 片：</span> <input type="text"
							name="goods_img" id="img_name" style="display: none;" /> <img
							src="../images/loading.gif" id="loading" style="display: none;">
						<input type="file" id="file" name="image" /> <input type="button"
							value="上传" style="width: 100px; height: 30px; cursor: pointer;"
							onclick="ajaxFileUpload();"> <span id="view"
							onclick="showImg()">预览</span> <span id="res"
							style="font-size: 12px; color: blue; position: absolute; margin-top: 15px;"></span> -->
	        <!-- <input style="margin-top: 30px;" type="button" class="btn btn-success btn-block" onclick="addcommodity()" value="添 加" /> -->
	        
	        <input style="margin-top: 30px;" type="submit" class="btn btn-success btn-block" value="添 加"/>
	    	</form>
    	</c:when>
		<c:otherwise>
		<form id="addGoods" action="${pageContext.request.contextPath}/goods/update/${goods.goodsId }"  method="post" >
	        <input style="margin-top: 30px;" value="${goods.goodsName }" id="goodsName" type="text" class="form-control"  name="goodsName" placeholder="商品名称" />
	        <input style="margin-top: 30px;" value="${goods.description }" id="description"  class="form-control" name="description"  placeholder="商品描述" />
	        <input style="margin-top: 30px;" value="${goods.price }" id="price"  class="form-control" name="price"  placeholder="商品价格" />
	        <input style="margin-top: 30px;" value="${goods.amount }" id="amount"  class="form-control" name="amount"  placeholder="商品总数量" />
	        <input style="margin-top: 30px;" value="${goods.leaveNum }" id="leaveNum"  class="form-control" name="leaveNum"  placeholder="商品剩余数量" />
	        <input style="margin-top: 30px;" value="${goods.regTime }" id="regTime"  class="form-control" name="regTime"  placeholder="商品上架时间" />
	        <input style="margin-top: 30px;" value="1" id="adminId"  class="form-control" name="admin.adminId"  placeholder="adminId" />
	        <input style="margin-top: 30px;" value="1" id="classId"  class="form-control" name="goodsClass.classId"  placeholder="classId" />
	        
	        <input type="hidden" name="_method" value="PUT">
	       <!--  <input style="margin-top: 30px;" type="submit" class="btn btn-success btn-block" value="修 改"/> -->
	        <button name="123" >xxx</button>
	    	</form>
		</c:otherwise>
    </c:choose>
    
    
</div>

<!-- 预览图 -->
<!-- 	<div class="read_img">
		<img id="view_img" src="../upload/imgs/honor_6.jpg" /><br> <span>商品图片预览</span>
	</div> -->


<script type="text/javascript">
        function addcommodity(){
                var name = $('#goodsName').val(), price = $('#price').val();
                var data = { "name": name, price:price,"imgSrc": "xmsz-"+Math.floor(Math.random()*5+1)+".jpg"};
                alert('addcommodity()方法');
                $.ajax({
                    url:'http://localhost:8080/EShop/goods_save.action',
                    type:'POST',
                    data:data,
                    success:function(data,status){
                        if(status == 'success'){
                            alert('添加成功！')
                        }
                    },
                    error:function(data,err){
                        alert('添加失败！')
                    }
                });
        }
</script> 
</body>
</html>
