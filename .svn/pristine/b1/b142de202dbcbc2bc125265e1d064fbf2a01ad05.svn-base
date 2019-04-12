<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'position.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<%@include file="../common.jsp" %>
  </head>
  
  <body>
  <script type="text/javascript">
  $(function(){
	$("#positionList").datagrid({
		url : "sys/position_list.action",
		fitColumns:true, //列填充满表格
		singleSelect:true,
		pagination : true,
		pageList : [5,10,15,20],
		pageSize : 5,
		rownumbers : true, //是否显示行号
		striped : true,
		showHeader:true,
		idField:"positionId",
		columns : [[
		            {field:'hello', checkbox:true},
		            {field:"positionId", title:"编号", width:10},
		            {field:"positionName", title:"名称", width:30},
		            {field:"position.orgenization.text",title:"所属部门",width:30,formatter:function(value,row,index){
		            	if(row.orgenization){
		            		return row.orgenization.text;
		            	}
		            	
		            }},
		            {field:"positionType", title:"分类", width:30},
		           
		]],
		loadFilter : function(data){
			var d = {total:0, rows:[]};
			d.total = data.total;
			d.rows = data.positionList;
			return d;
		},toolbar:[{
			iconCls:"icon-ok",
			text : "确定",
			handler:function(node){
				aaa();
			}
		},{
			iconCls:"icon-cancel",
			text : "返回",
			handler:function(){
				$("#div").dialog("close");
			}
		}]
	});
});
function aaa(){
	var selRow = $("#positionList").datagrid("getSelected");
	$("#positionName").val(selRow.positionName);
	$("#div").dialog("close");
};
  </script>
    	<table id="positionList"></table>
  </body>
</html>
