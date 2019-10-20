/**闭包demo1*/
//var CommonObj = {
//	
//	test:function(){
//		console.log("Call common demo1 success!");
//	}
//}

/**闭包demo2*/
var CommonObj = (function(){
	
	return{
		
		test:function(){
			console.log("Call common demo2 success!");
		}
	}
})();
