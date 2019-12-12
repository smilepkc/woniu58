function getQueryVariable(variable)
{
       var query = window.location.search.substring(1);
       if(query.search("&")!=-1){
    	   var vars = query.split("&");
           for (var i=0;i<vars.length;i++) {
                   var pair = vars[i].split("=");
                   if(pair[0] == variable){return pair[1];}
           }
           return(false);
       }else{
    	   var pair = query.split("=");
           if(pair[0] == variable){
        	   return pair[1];
           }
           return(false);
       }
       
}
$(function(){
	$.ajax({
		url:"/Details/page",
		data:{"goodsid":getQueryVariable("goodsid")},
		datatype:"json",
		success:function(data){
			$("#good").html("");
			var str="";
			str+='<div id="good"><div id="good-show">';
			str+='<img src='+data.img+'></div>	';
			str+='<div id="good-info"><table id="good-table">';
			str+='<tr><td colspan="2" style="text-align: center;"><h2>商品名称</h2></td></tr>	';
			str+='<tr class="tr-info"><td class="td-title">品牌：</td><td>'+data.name+'</td></tr>';
			str+='<tr class="tr-info"><td class="td-title">单价：</td><td><span class="s-money">￥ '+data.price+' </span></td></tr>';
			str+='<tr class="tr-info"><td class="td-title">描述：</td><td>'+data.description+'</td></tr>';
			str+='<tr class="tr-info"><td class="td-title">库存：</td><td>'+data.number+'</td></tr>';
			str+='<tr class="tr-info"><td class="td-title">数量：</td>';
			str+='<td><span class="s-btn"><button class="btn" onclick="numMulp()">-</button></span><input type="text" value="1" disabled="disabled" id="total"/><span class="s-btn" ><button class="btn" onclick="numAdd()">+</button></span></td></tr>';
			str+='</table>';
			str+='</div></div>';
			$("#good").html(str);
		}
	});
});

$("#gopay").click(function(){
	var total=$("#total").val();
	$.ajax({
		url:"/ShoppingCart/Cart",
		data:{"goodsid":getQueryVariable("goodsid"),"total":total},
		datatype:"json",
		success:function(data){
			if(data.flag == "true"){
				alert(data.msg);
			}else{
				alert(data.msg);
			}
		}
	});
});