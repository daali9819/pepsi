<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<script type="text/javascript">
  		function hahaha(data){
  			data.unshift({
  				"sysrightId":-1,
  				"text":'父权限'
  			});
  			return data;
  		}
  		
  		function hehehe(){
  			$("#parent").combobox("select",-1);
  		}
  		
  		//图片的点击事件
  		function SearchImgs(){
		var d = $("<div id='div'></div>").appendTo("body");
		d.dialog({
			title : "选择图标",
			iconCls:"icon-search",
			width:408,
			height:300,
			modal : true,
			href:"sys/sysright/images.jsp",
			onClose:function(){$(this).dialog("destroy");},
			buttons:[{
				text : "确定",
				iconCls:"icon-ok",
				handler:function(){
					
					
				}
			},{
				text : "取消",
				iconCls:"icon-cancel",
				handler:function(){
					d.dialog("close");
				}
			}]
		});
			
	}
  		
  	</script>
  <style>
  	#img:HOVER {
			cursor:pointer;
		}
  </style>
  
    <form id="sysrightForm" method="post" style="position: relative;">
    	<input type="hidden" name="sysright.sysrightId"/>
    	<div class="form-item">
    		<label class="iblock">父节点:</label>
    		<input type="text" id = "parent" name="sysright.parent.sysrightId"  class="easyui-combobox" 
    data-options="valueField:'sysrightId',textField:'text',url:'sys/sysright_getfu.action',panelHeight:'auto',editable:false,loadFilter:hahaha,onLoadSuccess:hehehe" /> 
    	</div>
    	<div class="form-item">
    		<label class="iblock">名称:</label>
    		<input type="text" name="sysright.text" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item">
    		<label class="iblock">跳转路径:</label>
    		<input type="text" name="sysright.url" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item">
    		<label class="iblock">图标:</label>
    		<input type="text" id = "tu" name="sysright.iconCls" class="ipt" data-options="required:true"/>
    		<img id="img" title="选择图标" src="images/zoom_in.png" style="width:20px; height:20px;" onclick="SearchImgs()">
    	</div>
    </form>
  </body>
</html>













