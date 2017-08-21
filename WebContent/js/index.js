/**
 * @author yrr
 */
$(document).ready(function(){
    $(".i_mall_content").hide();
    $(".minicart_content").hide();
    $(".searchBar_form").hover(
        function(){
            $(".search_button").css("background-color","#DCDCDC");
        },
        function(){
            $(".search_button").css("background-color","#ffffff");
        }
    );
    $(".i_mall_header").hover(
        function(){//鼠标选择工具栏项目
            $(".i_mall_content").show();
            $(".i_mall_header").css("border-bottom","0px");
            $(".i_mall_content").hover(
                function(){
                    $(".i_mall_content").show();
                    $(".i_mall_header").css("border-bottom","0px");
                },
                function(){
                    $(".i_mall_content").hide();
                    $(".i_mall_header").css("border-bottom","1px solid #000000");
                }
            );
        },
        function(){
            $(".i_mall_content").hide();
            $(".i_mall_header").css("border-bottom","1px solid #000000");
        }
    );
    $(".minicart_header").hover(
        function(){
            $(".minicart_content").show();
            $(".minicart").css("border-bottom","0px");
            $(".minicart_content").hover(
                function(){
                    $(".minicart_content").show();
                    $(".minicart").css("border-bottom","0px");
                },
                function(){
                    $(".minicart_content").hide();
                    $(".minicart").css("border-bottom","1px solid #000000");
                }
            );
        },
        function(){
            $(".minicart_content").hide();
            $(".minicart").css("border-bottom","1px solid #000000");
        }
    );
    $("#index_login").click(function(){
        $(".login_table").show();
    });
    $("#login_table_close").click(function(){
        $(".login_table").hide();
    });
    //滚动图片
    var li = $("#goods_display li") ;
    //var n = li.length ;
    var index = 1;
    var auto_show_pic ;
    $(li[0]).css({"display":"list-item"});
    auto_show_pic=setInterval(auto_pic, 6000);
    $(".goods_display_items span").mouseover(function(){//点击切换图片
        var num = $(this).index();
        show_pic(num);
        changge_items(num);
        index =num +1 ;
    });
    $("#goods_display").mouseover(function(){
        clearInterval(auto_show_pic);
    });
    $("#goods_display").mouseout(function(){
        auto_show_pic=setInterval(auto_pic, 6000);
    });
    function auto_pic(){//自动切换图片
        if(index == $("#goods_display li").length)
            index = 0;
        show_pic(index);
        changge_items(index);
        index=index+1;
    };
    function show_pic(index){//显示指定图片
         for(var i=0 ; i<=$("#goods_display li").length-1 ; i++){
            $($("#goods_display li")[i]).fadeOut(1000);
         }
        $($("#goods_display li")[index]).fadeIn(1500);
        
        $($(".goods_display_items span")[index]).addClass("goods_display_items_current"); 
    };
    function changge_items(index){
        var spanNode = $(".goods_display_items span");
        for(var i=0 ; i < spanNode.length ; i++){
             $(spanNode[i]).removeClass();
        }
        $(spanNode[index]).addClass("goods_display_items_current"); 
    }
});

