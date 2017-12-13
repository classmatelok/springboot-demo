$(function(){
	$("#selectUser").click(function(){
		$.ajax({
			url:"/user",
			type:"GET",
			//data:,
			async:true,
			dataType:"json",
			success:function(resData,textStatus,jqXHR){
				//console.log(resData);
				//console.log(jqXHR.status);
				var tr = "";
				if(resData.status=='1'){
					$.each(resData.data,function(i,item){
						tr += "<tr id='tr_"+i+"'>";
						tr += "<td><input type='checkbox' id='box_"+i+"'/></td>";
						tr += "<td>"+item.id+"</td>";
						tr += "<td>"+item.name+"</td>";
						tr += "<td>"+item.sex+"</td>";
						tr += "<td>"+item.age+"</td>";
						tr += "</tr>";
						
					});
					$("#content").html(tr);
				}else{
					alert("服务器繁忙，请稍后再试！");
				}
			},
			error:function(){
				alert("出错了！");
			}
		});
	});
	
	$(document).on("click","input[id^='box_']",function(){
//		debugger;
//		var a = 1;
//		var b = 2;
//		var c = 3;
//		console.log("a:"+a+",b:"+b+",c:"+c);
	    $("tr[id='tr_"+this.id.substring(4)+"']").css("color","red");//4是因为取"box_"后面具体选中的i序号
	});
	
	
	/**
	 * ajax就是异步发请求到后台，异步的意思就是。。。回头再解释>_<!
	 * 格式可以模糊理解成：
	 * $.ajax({
	 * 		属性名：属性值，
	 * 		属性名：属性值，
	 * 		...
	 * });
	 */
//	$.ajax({
//		url:"/user",         // url - 也就是要请求后台服务器的地址
//		type:"GET",          // type - 请求方式，一般常用就两个：get、post
//		data:{"name":"Lok"}, // data - 请求参数，就是后台需要一些参数才能查出相关数据
//		async:true,          // async - 是否异步，这个跟整个ajax的异步两码事，回头解释
//		dataType:"json",     // dataType - 响应参数类型，可以是json可以是text文本等等，回头解释
//		success:function(responseData){ // 这个是当请求成功后要做的事情，在这个function里面写就行了，比如拿到数据后要怎么去展示
//			//responseData就是后台返回来的数据，"responseData"随便你写"abcd"都行，但它就是代表“返回数据”
//			
//		},
//		error:function(){ // 请求错误是要做的事，比如弹出一个弹窗说“出错了！”
//			alert("出错了！");
//		}
//	});
})










