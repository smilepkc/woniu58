$(function(){
	$.ajax({
		url:"/user/loginstate",
		success:function(data){
			if(data.flag == "true"){
				$("#userzoom").html("");
				var str="<div id=\"y-inout\">";
				str+='<a href="allorder.html" class="icon i-order">订单</a>';
				str+='<a href="shopcar.html" class="icon i-shopcar">购物车</a>';
				str+='<a href="" class="icon i-user">'+data.msg+'</a>';
				str+='<a href="shop/user/loginout" class="icon i-loginout">注销</a>';
				str+='</div>';
				$("#userzoom").html(str);
			}
		}
	});
});