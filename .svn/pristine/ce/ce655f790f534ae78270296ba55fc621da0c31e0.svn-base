<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>部门管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@include file="../common.jsp" %>
  </head>
  
  <body>
	<script type="text/javascript" src="sys/orgenization/orgenization.js"></script>
  	<script type="text/javascript">
  		function hahaha(data){
  			data.unshift({
  				"propertiesItemsId":-1,
  				"propertiesItemsName":'-请选择-'
  			});
  			return data;
  		}
  		
  		function hehehe(){
  			$("#qiyong").combobox("select",-1);
  		}
  		
  	</script>
  	
  
  	<div class="easyui-panel condition" title="查询条件" style="width:100%;">
	<form id="orgenizationconditionForm">
		<div class="form-item">
			<label class="iblock">名称：</label>
			<input type="text"  id="orgenizationname" class="ipt"/>
			<label class="iblock">是否启用：</label>
			<input id="qiyong" class="easyui-combobox" 
    data-options="valueField:'propertiesItemsId',textField:'propertiesItemsName',url:'sys/propertiesitems_search.action?PId=4',panelHeight:'auto',editable:false,loadFilter:hahaha,onLoadSuccess:hehehe" /> 
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"  onclick="setOrgenization();return false;">查询</a> 
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-redo'"  onclick="resetOrgenizationCondition();return false;">重置</a>
		</div>
	</form>
</div>
  
  
    	<table id="orgenizationList"></table>
  </body>
</html>












