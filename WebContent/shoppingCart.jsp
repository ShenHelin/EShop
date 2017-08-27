<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.eshop.dao.pojo.ShoppingCart"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="s" uri="/struts-tags" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <title>购物车</title>
    <meta charset="utf-8">
    
    <link href="${pageContext.request.contextPath }/common/bootstrap.min.css" rel="stylesheet" media="screen">
	<script src="${pageContext.request.contextPath }/common/jquery-3.2.1.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/common/bootstrap.min.js" type="text/javascript"></script>
    
    <style type="text/css">
        .cart-heading{
            height: 40px;
            background-color: #EFEDED;
        }
        .cart-body{
            background-color: #F7F7F7;
        }
        .cart-body ul li {
            list-style-type: none;
            margin-left: -30px;
            width: 870px;
        }
        .cart-body ul li div{
            float: left;
            height: 80px;
        }
        .li-checkbox input{
            margin: 20px 5px 0 0;
        }
        .li-img a img{
            width: 40px;
            height: 50px;
        }
        .li-content{
            margin: 20px 0 0 30px;
            width: 280px;
        }
        .li-price{
            margin: 20px 0 0 60px;
            width: 100px;
        }
        .li-quantity{
            margin: 20px 0 0 130px;
            width: 100px;
        }
        .li-del{
            margin: 20px 0 0 30px;
            width: 50px;
        }
        .li-img{
            margin: 0 0 0 10px;
        }
    </style>
    
</head>

<body>
	<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">EShop</a>
    </div>	
    <div>
        <ul class="nav navbar-nav">
            <li><a href="http://localhost:8080/EShop/goods/findAll">商品首页</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    	${sessionScope.user.username}
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath }/orderInfo/findByUserId/${user.userId }">订单信息</a></li>
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

<div style="margin:50px auto;width: 900px;">
    <div >
        <div>
            <div style="float:right;">
                <a class="btn  btn-xs btn-success" href="http://localhost:8080/EShop/goods/findAll" style="margin-right: 35px;">商品页</a>
                <a class="btn btn-xs btn-info" href="login.html">退 出</a>
            </div>
            <h2>购物车</h2>
            <hr>
        </div>
        <div >
        <form action="http://localhost:8080/EShop/shoppingCart/buySome" method="post">
            <div class="cart-heading" >
                <div style="padding: 10px 0 0 10px">
                    <span style="margin-right: 200px;">
                        <input id="CheckAll"  type="checkbox" > 全选
                    </span>
                    <span style="margin-right: 180px;">商品</span>
                    <span style="margin-right: 210px;">价格</span>
                    <span style="margin-right: 80px;">数量</span>
                    <span style="padding-right: 0px;">操作</span>
                </div>
            </div>
            <div class="cart-body" >
                <ul >
                
                <c:forEach items="${requestScope.shoppingCartListFromServer }" var="shoppingCart" varStatus="s">
                	
		
	
	
                    <li >
                        <div class="li-checkbox">
                            <input name="chkItem" class="li-checkbox input" type="checkbox" value="${shoppingCart.shoppingCartId }"/>
                        </div>
                        <div class="li-img">
                            <a >
                                <img class="li-img a img" src="${pageContext.request.contextPath }/upload/${shoppingCart.goods.image }">
                            </a>
                        </div>
                        <div class="li-content">
                            <a href="detail1.html">${shoppingCart.goods.goodsName } </a>
                        </div>
                        <div class="li-price" >
                            <span id='price_num'>${shoppingCart.goods.price }</span>
                        </div>
                        <div class="li-quantity">
                        <!-- http://localhost:8080/ESh/op/shoppingCart_update.action?amount=$('#Q').val() -->
                            <a data-type="add" href="#" class="btn btn-default btn-xs ">+</a>
                            <input id="Q" style="width: 40px;"  type="text"  value="${shoppingCart.amount }">
                            <a data-type='subtr' href="javascript:void(0);" class="btn btn-default btn-xs">-</a>
                        </div>
                        <div class="li-del" >
         <%--                	<form action="${pageContext.request.contextPath }/EShop/shoppingCart/${shoppingCart.shoppingCartId }" method="post">
								<input type="hidden" name="_method" value="DELETE">
								<input type="submit" value="delete" class="btn btn-primary btn-xs">
							</form> --%>
                            <%-- <a href="http://localhost:8080/EShop/shoppingCart/delete/${shoppingCart.shoppingCartId }" class="btn btn-primary btn-xs">删除</a> --%>
                            <%-- <input type="button" class="btn btn-primary btn-xs" onclick="deleteShoppingCartItem(this)" value="删除" name="${shoppingCart.shoppingCartId }"/> --%> 
                            
                            
                            
                            <input type="hidden" name="_method" value="DELETE">
                            <button class="btn btn-primary btn-xs" onclick="deleteShoppingCartItem(this)" value="${shoppingCart.shoppingCartId }" name="${shoppingCart.shoppingCartId }"></button>
                            
                        </div>
                    </li>
                
                
                
                </c:forEach>
                
                
                
                
                
                
                    
                </ul>
            </div>
            <div style="float: right;height: 35px;width:330px;">总计：
                <span id="money" style="color: red;font-size: 25px">￥0.00</span>
                <!-- <input type="button" style="width: 130px;float:right;"  class="btn btn-success" onclick=" clearing();" value="结 算" /> -->
                
                <!-- <input type="hidden" name="_method" value="DELETE"> -->
                <input type="submit" style="width: 130px;float:right;"  class="btn btn-success" value="结 算"/>
            </div>
            </form>
        </div>
    </div>
</div>





<script type="text/javascript">
    $(function () {
        // 商品+-
        $('.li-quantity a').click(function(){
            var self = $(this);
            var type = self.attr('data-type'),
                num = parseFloat(self.siblings('input').val());
            if(type == 'add'){
                
            	/* $.ajax({
            		url: 'http://localhost:8080/EShop/shoppingCart_update.action',
            		data:{'amount':num},
            		type:'post',
            		dataType:'text',
            		success:function(data){
            			alert(data);
            		}
            	}); */
            	
            	num += 1;
            	
            }else if(type == 'subtr'){
                if(num > 1){
                	
                	//减
                	num -= 1;
                	
                	
                	
                	
                	
                }else{
                    return false;
                }
            }
            self.siblings('input').val(num);
            tamount();
        });

        //checkbox 单选事件
        $('input[name="chkItem"]:checkbox').click(function(){
            var isCheck = $('input[name="chkItem"]:not(:checked)').length?false:true;
            $('#CheckAll').prop("checked",isCheck);
            tamount();
        });

        //checkbox 全选事件
        $('#CheckAll').click(function(){
            var self = $(this);
            $('input[name="chkItem"]').each(function(){
                $(this).prop("checked",self.is(':checked'));
            });
            tamount();
        });

    });
    var sum = 0;
    //用户结算
    function  clearing(){
        $('input[name="chkItem"]:checked').each(function(){
        	alert($(this).val());
            var self = $(this),
                    index = self.attr('data-index'),
                    cid = self.attr('data-id');
            var quantity = $('#Q').val();
            var data = { "cid": cid, "cnum":quantity};
            $.ajax({
                url:'http://localhost:8080/EShop/shoppingCart_delete.action',
                type:'post',
                data:data,
                success:function(data,status){
					
                },
                error:function(data,status){

                }
            });
        });
        alert('￥'+sum);
        location.href = "pay_success.jsp";
    }
    
    //计算商品总价格
    function tamount(){
        sum = 0;
        $('input[name="chkItem"]:checked').each(function(){
            var self = $(this),
                index = self.attr('data-index');
            var price = $('#price_num').html();
            var quantity = $('#Q').val(); 
            console.log(price)
            console.log(quantity)
            sum +=(parseFloat(price)*parseFloat(quantity));
        });
        $("#money").html('￥'+ sum +'.00');
    }
    
    function deleteShoppingCartItem(btn){
    	alert(btn.val());
    	alert(btn.val);
    	alert(btn.value());
    	alert(btn.value);
    	$.ajax({
            url:'http://localhost:8080/EShop/shoppingCart/delete/'+btn.val,
            type:'post',
            data:data,
            success:function(data,status){
				
            },
            error:function(data,status){

            }
        }); 
    }
    
    $(document).ready(function(){  
        $("#button1").click(function(){  
              
            $("#draw").attr("action","url1");   
            $("form").submit();  
        });  
        $("#button2").click(function(){  
              
            $("#draw").attr("action","url2");   
            $("form").submit();  
        });  
    });
    
</script>
</body>
</html>