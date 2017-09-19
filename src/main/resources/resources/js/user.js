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
						tr += "<tr>";
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
})