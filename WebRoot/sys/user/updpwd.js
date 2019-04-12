/**
 * 我的工作平台的js脚本
 */
$(function(){
	$(".oldpwd").blur(function(){
		var pwd = $("#pwd").val();
		var oldpwd = $(".oldpwd").val();
		if(pwd != oldpwd){
			$("#bzyi").css("color","red");
			return false;
		}
		if(pwd == oldpwd){
			$("#bzyi").css("color","blue");
		}
	});
	$(".newpwd").blur(function(){
		var newpwd = $(".newpwd").val();
		var qrnewpwd = $(".qrnewpwd").val();
		if(newpwd.length < 6){
			$("#bzer").css("color","red");
			return false;
		} else {
			$("#bzer").css("color","blue");
		}
		if(newpwd == qrnewpwd){
			$("#bzsan").css("color","blue");
		}
	});
	$(".qrnewpwd").blur(function(){
		var newpwd = $(".newpwd").val();
		var qrnewpwd = $(".qrnewpwd").val();
		if(qrnewpwd.length < 6){
			$("#bzsan").css("color","red");
			return false;
		} else {
			$("#bzsan").css("color","blue");
		}
		if(newpwd != qrnewpwd){
			$("#bzsan").css("color","red");
			return false;
		} else {
			if(qrnewpwd.length < 6){
				$("#bzsan").css("color","red");
				return false;
			} else {
				$("#bzsan").css("color","blue");
			}
		}
	});

	$("#form1").submit(function(){
		var oldpwd = $(".oldpwd").val();
		var newpwd = $(".newpwd").val();
		var qrnewpwd = $(".qrnewpwd").val();
		if (oldpwd == "" || newpwd == "" || qrnewpwd == "") {
			return false;
		}
	});
});