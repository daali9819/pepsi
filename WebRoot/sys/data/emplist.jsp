<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@include file="../common.jsp" %>
  </head>
  
  <body>
	<script type="text/javascript" src="sys/data/empjs.js"></script>
  		<div class="easyui-panel" title="查询条件" style="width:100%;">
  			<form id="dataempconditionForm">
  				<div class="form-item">
  					<label class="iblock">部门</label>
  					<input id="orzen" class="easyui-combobox" 
    data-options="valueField:'orgenizationId',textField:'text',url:'sys/orgenization_search.action',panelHeight:'auto',editable:false" /> 
  					<label class="iblock">员工姓名</label>
  					<input type="text"  id="empName" class="ipt"/>
  					<label class="iblock">档案状态</label>
  					<input id="propertiesItems" class="easyui-combobox" 
    data-options="valueField:'propertiesItemsName',textField:'propertiesItemsName',url:'sys/propertiesitems_search.action?PId=1',panelHeight:'auto',editable:false" />
    				<label class="iblock">建档时间</label>
    				<input id="jdtimebegin" class="easyui-datebox" />
    				<label>至</label>
    				<input id="jdtimeend" class="easyui-datebox" />
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"  onclick="setEmpCondtion();return false;">查询</a> 
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-redo'"  onclick="resetEmpCondition();return false;">重置</a>
  				</div>
  			</form>
  		</div>
    	<table id="dataempList"></table>
  </body>
</html>












