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
            <li><a href="${pageContext.request.contextPath }/goods/findAll">商品首页</a></li>
            <li class="active"><a href="${pageContext.request.contextPath }/shoppingCart/findByUserId/${user.userId }">购物车</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    	${sessionScope.user.username }
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath }/orderInfo/findByUserId?user.userId=${user.userId }">订单信息</a></li>
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



<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="panel-group" id="panel-87906">
			
			
			<div style="padding: 10px 0 0 10px">
                    <span style="margin-right: 85px;">
                        <span style="margin-right: 10px;">orderId</span>
                    </span>
                    <span style="margin-right: 65px;">订单编号</span>
                    <span style="margin-right: 65px;">订单提交时间</span>
                    <span style="margin-right: 65px;">订单收货人姓名</span>
                    <span style="margin-right: 65px;">收货地址</span>
                    <span style="margin-right: 65px;">订单邮编</span>
                    <span style="margin-right: 65px;">订单收货手机</span>
                    <span style="margin-right: 65px;">总价格</span>
            </div>
                
			<c:forEach items="${requestScope.orderInfoListFromServer }" var="orderInfo" varStatus="s">
				<div class="panel panel-default">
					<div class="panel-heading">
						 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-87906" href="#panel-element-727385">
						 ${orderInfo.orderId }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						 ${orderInfo.orderNo }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						 ${orderInfo.submitTime }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						 ${orderInfo.orderName }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						 ${orderInfo.orderAddress }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						 ${orderInfo.orderCode }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						 ${orderInfo.orderPhone }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						 ${orderInfo.totalPrice }</a>
					</div>
					<div id="panel-element-727385" class="panel-collapse collapse">
						<div class="panel-body">
							<div class="cart-body" >
				                <ul >
				                
				                
				                <c:forEach items="${orderInfo.orderItemSet }" var="orderItem" varStatus="s">
				                    <li >
				                        <div class="li-checkbox">
				                            <!-- <input name="chkItem" class="li-checkbox input" type="checkbox" /> -->
				                        </div>
				                        <div class="li-img">
				                            <a >
				                                <img class="li-img a img" src="${pageContext.request.contextPath }/upload/${orderItem.goods.image }">
				                            </a>
				                        </div>
				                        <div class="li-content">
				                            <a href="detail1.html">${orderItem.goods.goodsName }</a>
				                        </div>
				                        <div class="li-price" >
				                            <span id='price_num'>￥ ${orderItem.goods.price }</span>
				                        </div>
				                        <div class="li-quantity">
				                            <!-- <a data-type="add" href="#" class="btn btn-default btn-xs ">+</a>
				                            <input id="Q" style="width: 40px;"  type="text"  value="1">
				                            <a data-type='subtr' href="javascript:void(0);" class="btn btn-default btn-xs">-</a> -->
				                            <span id='price_num'>amount: ${orderItem.amount }</span>
				                        </div>
				                        <div class="li-del" >
				                            <a href="#" class="btn btn-primary btn-xs">删除</a>
				                        </div>
				                    </li>
				               </c:forEach>
				               
				               
				               
				               
				               
				               
				                    
				                </ul>
				            </div>
						</div>
					</div>
				</div>
			</c:forEach>
			
				
				
			</div>
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
                num += 1;
            }else if(type == 'subtr'){
                if(num > 1){
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
    function  Clearing(){
        $('input[name="chkItem"]:checked').each(function(){
            var self = $(this),
                    index = self.attr('data-index'),
                    cid = self.attr('data-id');
            var quantity = $('#Q').val();
            var data = { "cid": cid, "cnum":quantity};
            $.ajax({
                url:'/',
                type:'post',
                data:data,
                success:function(data,status){

                },
                error:function(data,status){

                }
            });
        });
        alert('￥'+sum);
        location.href = "pay_success.html";
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
</script>
</body>
</html>