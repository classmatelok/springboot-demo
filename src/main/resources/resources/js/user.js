$(function(){
	$("#selectUser").click(function(){
		$.ajax({
			url:"/user",
			type:"GET",
			//data:,
			async:true,
			dataType:"json",
			success:function(resData){
				if(resData.status==1){
					$("#show").html(data);
				}else{
					alert("服务器繁忙，请稍后再试！");
				}
			},
			error:function(){
				
			}
		});
	});
})