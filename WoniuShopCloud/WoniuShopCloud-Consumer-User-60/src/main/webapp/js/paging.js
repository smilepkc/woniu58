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
	var page=0;
	$.ajax({
		url:"/goodspage/page",
		data:{"id":getQueryVariable("id"),"page":page},
		datatype:"json",
		success:function(data){
			
			$("#good-list").html("");
			var str="";
			for(var i=0;i<data.list.length;i++){
				str+='<div class="good">';
				str+='<div class="good-img">';
				str+='<a href="good.html?goodsid='+data.list[i].id+'"><img src='+data.list[i].img+' ></a></div>';
				str+='<div class="good-info"><div class="good-left">';
				str+='<div class="good-price"><span class="s-money">'+data.list[i].price+'</span></div>';
				str+='<div class="good-add"><img src="icon/加.png" alt='+data.list[i].id+' onclick="goodadd(this)"></div></div>';
				str+='<div class="good-right">';
				str+='<p>'+data.list[i].name+'</p>';
				str+='<p>'+data.list[i].description+'</p>';
				str+='</div></div></div>';
			}
			$("#good-list").html(str);
		}
	});
});
function goodadd(obj){
	$.ajax({
		url:"/ShoppingCart/Cart",
		data:{"goodsid":obj.alt,"total":1},
		datatype:"json",
		success:function(data){
			if(data.flag == "true"){
				alert(data.msg);
			}else{
				alert(data.msg);
			}
		}
	});
}
function byPage(classname){
	var page=0;
	if(classname=='首页'){
		page=0;
	}else if(classname=='上一页'){
		page=-1;
	}else if(classname=='下一页'){
		page=1;
	}else if(classname=='末页'){
		page=2;
	}
	$.ajax({
		url:"/goodspage/page",
		data:{"id":getQueryVariable("id"),"page":page},
		datatype:"json",
		success:function(data){
			var str1="";
			str1+=data.page+'/'+data.allpage;
			$(".presentPage").html(str1);
			$("#good-list").html("");
			var str="";
			for(var i=0;i<data.list.length;i++){
				str+='<div class="good">';
				str+='<div class="good-img">';
				str+='<a href="good.html?goodsid='+data.list[i].id+'"><img src='+data.list[i].img+' ></a></div>';
				str+='<div class="good-info"><div class="good-left">';
				str+='<div class="good-price"><span class="s-money">'+data.list[i].price+'</span></div>';
				str+='<div class="good-add"><img src="icon/加.png"></div></div>';
				str+='<div class="good-right">';
				str+='<p>'+data.list[i].name+'</p>';
				str+='<p>'+data.list[i].description+'</p>';
				str+='</div></div></div>';
			}
			$("#good-list").html(str);
		}
	});
}