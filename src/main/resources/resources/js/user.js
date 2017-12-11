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
	
	
})










