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
  		
  			//图片的点击事件
		  		function Searchorg(){
				var d = $("<div id='org'></div>").appendTo("body");
				d.dialog({
					title : "选择部门",
					iconCls:"icon-search",
					width:308,
					height:500,
					modal : true,
					href:"sys/title/addsearch.jsp",
					onClose:function(){$(this).dialog("destroy");},
					
					});
				}
				function Searchposition(){
					var d = $("<div id='position'></div>").appendTo("body");
					d.dialog({
						title:"选择职位",
						iconCls:"icon-search",
						width:308,
						height:500,
						modal:true,
						href:"sys/title/postiton.jsp",
						onClose:function(){$(this).dialog("destroy");},
					});
				}
  
  		
  	</script>
  	<style>
  		img:HOVER{
  			cursor: pointer;
  		}
  	</style>
    <form id="titleForm" method="post" style="position: relative;">
    	<input type="hidden" name="title.titleId"/>
    	<input type = "hidden" id = "de" name = "title.orgenization.orgenizationId"/>
    	<div class="form-item">
    		<label class="iblock">职称名称:</label>
    		<input type="text" name="title.titleName" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item">
    		<label class="iblock">职称描述:</label>
    		<input type="text" name="title.titleDesc" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item">
    		<label class="iblock">职称备注:</label>
    		<input type="text" name="title.titleRemark" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item">
    		<label class="iblock">职位名称:</label>
    		<input id="position" name="title.position.positionId" class="ipt easyui-combobox" data-options="valueField:'positionId',textField:'positionName',url:'sys/position_search.action',panelHeight:'auto',editable:false" />
    	</div>
    	<div class="form-item">
    		<label class="iblock">所属部门:</label>
    		<input type="text" id="dept" name="title.orgenization.text" class="ipt easyui-validatebox" data-options="required:true"/>
    	<img id="img" title="选择部门" src="images/search.png" style="width:20px; height:20px;" onclick="Searchorg()">
    	</div>
    	<div class="form-item">
    		<label class="iblock">是否启用:</label>
    		<input type="checkbox" value="true" name="title.titleIstrue"/>
    	</div>
    	
    </form>
  </body>
</html>













