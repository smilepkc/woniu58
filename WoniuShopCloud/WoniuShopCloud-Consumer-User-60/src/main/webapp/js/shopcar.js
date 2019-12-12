$(function(){
	$.ajax({
		url:"/ShoppingCart/ShowCart",
		success:function(data){
			console.dir(data);
				$("#lists").html("");
				var str="";
				str+="<tr><th></th><th>商品名称</th><th>单价</th><th>数量</th><th>操作</th></tr>";
				for(var i=0;i<data.goodslist.length;i++){
					str+='<tr><td class="td-g-img"><img src='+data.goodslist[i].img+'></td>';
					str+='<td>'+data.goodslist[i].name+'</td>';
					str+='<td>'+data.goodslist[i].price+'</td>';
					str+='<td>'+data.total[i]+'</td>';
					str+='<td><img src="icon/关闭.png" alt='+data.goodslist[i].id+' onclick="deleteGoods(this)" ></td></tr>';
				}
				$("#lists").html(str);
				var money=0;
				for(var i=0;i<data.goodslist.length;i++){
					money+=(data.goodslist[i].price)*(data.total[i]);
				}
				$(".s-money").html("￥"+money);
			}
	});
});
function deleteGoods(obj){
	$.ajax({
		url:"/ShoppingCart/DeleteCart",
		data:{"goodsid":obj.alt},
		success:function(data){
			location.reload();
			}
	});
}