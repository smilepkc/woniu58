/* 
退款点击操作 
 */
var refundbox = "refundBox";
$(".refund").click(function(){
	showblack();
	showBox();
});


/*退出弹出框*/
$(document).on("click",".close.active",function(){
	closeblack();
	closeBox();
});

/* 弹出退款框 */
function showBox(){
	$("#"+refundbox).fadeIn("fast");
	$("#"+refundbox).find(".close").addClass("active");
}
function closeBox(){
	$("#"+refundbox).fadeOut("fast");
	$("#"+refundbox).find(".close").removeClass("active");
}
$(function(){
	$.ajax({
		url:"/ShoppingCart/ShowCart",
		success:function(data){
				$(".d-goodlist").html("");
				var str="";
				for(var i=0;i<data.goodslist.length;i++){
					str+='<div class="g-item">';
					str+='<div class="item-img"><img src='+data.goodslist[i].img+' /></div>';
					str+='<div class="item-name"><a href="good.html">'+data.goodslist[i].name+'</a></div>';
					str+='<div class="item-price s-money">￥'+data.goodslist[i].price+'</div>';
					str+='<div class="item-count">'+data.total[i]+'</div>';
					str+='</div>';
				}
				$(".d-goodlist").html(str);
				var money=0;
				for(var i=0;i<data.goodslist.length;i++){
					money+=(data.goodslist[i].price)*(data.total[i]);
				}
				$(".d-total").html("￥"+money);
			}
	});
});

//显示地址
$(function(){
		$.ajax({
			type:"POST",
			url:"/Address/ShowAddress",
			dataType:"json",
			success:function(data){
				$(".d-number").html("");
				$(".a-list").html("");
				var str="";
				for(var i=0;i<data.list.length;i++){
					if(i==0){
						str+='<div class="a-item active">';
					}else{
						str+='<div class="a-item">';
					}
				str+='<div class="i-info">';
				str+='<input name="ipt-addrid" type="hidden" value='+data.list[i].id+'>';
				str+='<span  class="i-s-title">姓名: </span><span class="i-s-name">'+data.list[i].name+'</span>';
				str+='<span class="i-s-title">电话: </span><span class="i-s-phone">'+data.list[i].phone+'</span>';
				str+='<span class="i-s-title">邮寄编码: </span><span class="i-s-number">610620</span></div>';
				str+='<div class="i-address ">'+data.list[i].prov+data.list[i].city+data.list[i].country+data.list[i].town+data.list[i].detailaddress+'</div></div>';
				}
				var str1='<h1 class="d-number" id="h1-ordernumber">'+data.orderNumber+'</h1>';
				$(".d-number").html(str1);
				$(".a-list").html(str);
			}
		});
});


/* 
退款点击操作 
 */
var refundbox = "refundBox";
$(".refund").click(function(){
	showblack();
	showBox();
});


/*退出弹出框*/
$(document).on("click",".close.active",function(){
	closeblack();
	closeBox();
});

/* 弹出退款框 */
function showBox(){
	$("#"+refundbox).fadeIn("fast");
	$("#"+refundbox).find(".close").addClass("active");
}
function closeBox(){
	$("#"+refundbox).fadeOut("fast");
	$("#"+refundbox).find(".close").removeClass("active");
}


//提交订单
$(function(){
	// 给结账按钮绑定一个事件
	$("#btn-closefile").click(function(){
		//收集页面的数据，将数据通过异步请求传递给后台，后台要实现订单的新增;
		//数据:订单号，支付金额,地址id
		var addrid = $(".active div input").val();
		var ordernumber = $("#h1-ordernumber").html().replace("订单号：","");
		var paynumber1 = $("#span-totalMoney").html();
		var paynumber=paynumber1.split("￥");
		$.ajax({
			url:"/order/addOrder",
			data:{
				"addrid":addrid,
				"ordernumber":ordernumber,
				"paynumber":paynumber[1]
			},
			dataType:"json",
			type:"post",
			success:function(data){
				//成功回调：证明后台订单已经新增成功了，应该去付款了
				//....
				
				//新增成功后，应该跳转到allorder.jsp
				if(returnDate.code == "ORA_001"){
					window.location.href = "../order/toAllOrderPage";
				}
				
				
			}
		});
	});
	
});
$(function(){
	// 给结账按钮绑定一个事件
	$("#btn-closefile").click(function(){
		/*var ordernumber = $("#h1-ordernumber").html().replace("订单号：","");
		var paynumber1 = $("#span-totalMoney").html();
		var paynumber=paynumber1.split("￥");
		window.location.href="alipay.trade.page.pay.jsp?ordernumber="+ordernumber+"&paynumber="+paynumber[1]+"";*/
		//收集页面的数据，将数据通过异步请求传递给后台，后台要实现订单的新增;
		//数据:订单号，支付金额
		var ordernumber = $("#h1-ordernumber").html().replace("订单号：","");
		var paynumber1 = $("#span-totalMoney").html();
		var paynumber=paynumber1.split("￥");
		$.ajax({
			url:"/pay/pay",
			data:{
				"ordernumber":ordernumber,
				"paynumber":paynumber[1]
			},
			dataType:"json",
			type:"post",
			success:function(data){
				$('body').append(data.result);
				$("form").attr("target", "_blank");
			}
		});
	});
	
});














