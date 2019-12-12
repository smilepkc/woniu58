$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};
// 实现注册数据的提交
function subReg(){
	var reg = /^1\d{10}$/;
	var formData =$("#form-register").serializeObject();
	console.log(formData);
	if(formData.account==""||!reg.test(formData.account)){
		$("#sp1").html("手机号输入不合法");
	}else{
		//使用ajax来实现前后台的交互
		$.ajax({
			type:"POST",
			url:"/user/register",
			data:formData,
			dataType:"json",
			success:function(data){
				if(data.flag == "true"){
					alert(data.msg);
					closeRegisterBox();
				}else{
					alert(data.msg);
				}
			}
		});
	}
}
function check_other_char(str)
{
    var arr = ["&", "\\", "/", "*", ">", "<", "@", "!",""];
    for (var i = 0; i < arr.length; i++)
    {
        for (var j = 0; j < str.length; j++)
        {
            if (arr[i] == str.charAt(j))
            {
                return true;
            }
        }
    }   
    return false;
}
//实现登陆数据的提交
function sublog(){
	var formData = $("#form-login").serializeObject();
	//使用ajax来实现前后台的交互
	$.ajax({
		type:"post",
		url:"/user/login",
		data:formData,
		dataType:"json",
		success:function(data){
			if(data.flag == "true"){
				console.log(data);
				$("#userzoom").html("");
				var str="<div id=\"y-inout\">";
				str+='<a href="allorder.html" class="icon i-order">订单</a>';
				str+='<a href="shopcar.html" class="icon i-shopcar">购物车</a>';
				str+='<a href="" class="icon i-user">'+data.msg+'</a>';
				str+='<a href="/user/loginout" class="icon i-loginout">注销</a>';
				str+='</div>';
				$("#userzoom").html(str);
				closeLoginBox();
			}else{
				alert(data.msg);
			}
		}
	});
}

$(function(){
	$("#ValidCode").click(function(){
		this.src="/Valid/getValidCode?"+Math.random();
	});
});
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
				str+='<a href="/user/loginout" class="icon i-loginout">注销</a>';
				str+='</div>';
				$("#userzoom").html(str);
			}
		}
	});
});

/*商品类型*/
$(function(){
	$.ajax({
		url:"/goodstype/type",
		datatype:"json",
		success:function(data){
			$(".types").html("");
			var str="";
			for(var i=0;i<data.length;i++){
				str+='<li class="type-item">';
				str+='<a href="paging.html?id='+data[i].id+'">';
				str+='<div class="type-img">';
				str+='<img src='+data[i].img+' ></div>';
				str+='<div class="type-content">';
				str+='<h3>'+data[i].name+'</h3>';
				str+='<p>'+data[i].description+' </p></div></a></li>';
			}
			$(".types").html(str);
		}
	});
});

$(function(){
	$.ajax({
		url:"/user/reload",
		datatype:"json",
		success:function(data){
			if(data.count==0){
				location.href="index.html";
			}
		}
	});
});

//实现手机验证码注册
//短信验证码倒计时
function countdownHandler(){
	var $button = $(".sendVerifyCode");
	var number = 60;
	var countdown = function(){
		if (number == 0) {
			$button.attr("disabled",false);
			$button.html("发送验证码");
            number = 60;
            return;
        } else {
        	$button.attr("disabled",true);
        	$button.html(number + "秒 重新发送");
        	number--;
        }
		setTimeout(countdown,1000);
	}
	setTimeout(countdown,1000);
}
//发送短信验证码
$(function(){
	$(".sendVerifyCode").click(function(){
		var reg = /^1\d{10}$/;
		var formData =$("#form-register").serializeObject();
		if(formData.account==""||!reg.test(formData.account)){
			$("#sp1").html("手机号输入不合法");
		}else{
			//使用ajax来实现前后台的交互
			$.ajax({
				type:"POST",
				data:{"account":formData.account},
				url:"/user/SendVerifyCode",
				dataType:"json",
				success:function(resultdata){
					if(resultdata.code =="0"){
						countdownHandler();
					}else{
						alert("发送失败请稍后再试");
					}
				}
			});
		}
	});
	
});


