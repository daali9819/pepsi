<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>薪酬标准管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@include file="../common.jsp" %>
  </head>
  
	
  <body>
  <script type="text/javascript" src="sys/salayitems/salayitems.js"></script>
  <script type="text/javascript">
  
  		
  		function hahaha(data){
  			data.unshift({
  				"propertiesItemsId":-1,
  				"propertiesItemsName":'-请选择-'
  			});
  			return data;
  		}
  		
  		function hehehe(){
  			$("#salayitemsState").combobox("select",-1);
  		}
  		
  		
  </script>
  	<div  class="easyui-panel condition" title = "查询条件" style="width:100%;">
  		<form id="salayitemsForm">
  			<div class="form-item">
  				<label class="iblock">名称：</label>
  				<input type="text"  id="salayitemsName" class="ipt"/>
				<label class="iblock">审核状态：</label>
				<input type="text"  id="salayitemsState" class="easyui-combobox" 
    data-options="valueField:'propertiesItemsId',textField:'propertiesItemsName',url:'sys/propertiesitems_search.action?PId=2',panelHeight:'auto',editable:false,loadFilter:hahaha,onLoadSuccess:hehehe" />
				<label class="iblock">登记时间</label>
   				<input id="begin" class="easyui-datebox" />
   				<label>至</label>
   				<input id="end" class="easyui-datebox" />
   				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"  onclick="setsalayitemsCondtion();return false;">查询</a> 
    			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-redo'"  onclick="resetSalayitemsCondition();return false;">重置</a>
  			</div>
  		</form>
  	</div>
  
  
    	<table id="salayitemsList"></table>
  </body>
</html>












