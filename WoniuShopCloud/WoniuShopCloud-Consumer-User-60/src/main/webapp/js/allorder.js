$(function(){
	$.ajax({
		type:"POST",
		url:"/order/toAllOrderPage",
		dataType:"json",
		success:function(data){
			console.dir(data);
			var str="";
			for(var i=0;i<data.length;i++){
				str+='<tr><td class="order-id">订单号:'+data[i].ordernumber+'</td>';
				str+='<td colspan="5"></td>';
				str+='<td><button type="button" class="btn btn-info refund">退款</button></td>';
				str+='</tr>';
				for(var k=0;k<data[i].ois.length;k++){
					str+='<tr ><td class="no-border"></td>';
					str+='<td ><img src='+data[i].ois[k].img+'></td>';
					str+='<td>'+data[i].ois[k].name+'</td>';
					str+='<td>￥'+data[i].ois[k].price+'</td>';
					str+='<td>'+data[i].ois[k].number+'</td>';
					str+='<td>'+data[i].ois[k].date+'</td>';
					str+='<td></td></tr>';
				}
			}
			$("#orders").append(str);
		}
	});
});
