$(function(){
	$("#addAddress").click(function(){
		//使用ajax来实现前后台的交互
		var name = $("#name").val();
		var phone = $("#phone").val();
		var province = $("#province").val();
		var city = $("#city").val();
		var county = $("#county").val();
		var street = $("#street").val();
		var detail = $("#detail").val();
		$.ajax({
			type:"POST",
			url:"shop/Address/addAddress",
			data:{"name":name,"phone":phone,"prov":province,"city":city,"county":county,"town":street,"detailaddress":detail},
			dataType:"json",
			success:function(){
			},
			error:function(){
				window.location.href="order.html";
			}
		});
	});
	
});

//显示地址
$(function(){
		$.ajax({
			type:"POST",
			url:"shop/Address/ShowAddress",
			dataType:"json",
			success:function(data){
				$(".a-list").html("");
				var str="";
				for(var i=0;i<data.list.length;i++){
					if(i==0){
						str+='<div class="a-item active">';
					}else{
						str+='<div class="a-item">';
					}
				str+='<div class="i-info">';
				str+='<span  class="i-s-title">姓名: </span><span class="i-s-name">'+data.list[i].name+'</span>';
				str+='<span class="i-s-title">电话: </span><span class="i-s-phone">'+data.list[i].phone+'</span>';
				str+='<span class="i-s-title">邮寄编码: </span><span class="i-s-number">610620</span></div>';
				str+='<div class="i-address ">'+data.list[i].prov+data.list[i].city+data.list[i].country+data.list[i].town+data.list[i].detailaddress+'</div>';
				str+='<div class="i-delete"><img src="icon/关闭.png" alt='+data.list[i].id+' onclick="deleteAddress(this)"></div></div>';
				}
				$(".a-list").html(str);
			}
		});
});

//移除地址
function deleteAddress(obj){
	console.log(obj.alt);
	$.ajax({
		type:"POST",
		url:"shop/Address/DeleteAddress",
		data:{"id":obj.alt},
		datatype:"json",
		success:function(data){
			location.reload();
		}
	});
}
