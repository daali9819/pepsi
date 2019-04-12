/**
 * 首页的js脚本
 */
$(function(){
	
	
	
	var name = $.cookie("skinName");
	if(name){
		changeTheme(name);
		$("#themes span[title='"+name+"']").addClass("active").siblings("span").removeClass("active")
	}
	
	$("ul.tree").tree({
		onClick : function(node){
			console.log(node);
			if($("#tt").tabs("exists",node.text)){
				$("#tt").tabs("select",node.text);
			}else{
				$("#tt").tabs("add",{
					title : node.text,
					iconCls : node.iconCls,
					closable : true,
					href : node.attributes.url
				});
			}
		}
	});
	
	$("#themes span").click(function(){
		$(this).addClass("active").siblings("span").removeClass("active");
		var skinName = $(this).attr("title"); 
		
		changeTheme(skinName);
		$.cookie("skinName",skinName,{expires:7, path:'/'});
	});
})

function changeTheme(skinName){
	
	$("link").each(function(){
		var old = $(this).attr("href");
		var newSkin = old.replace(/themes\/.*\/easyui/,"themes/"+skinName+"/easyui");
		$(this).attr("href",newSkin);
	});
}















