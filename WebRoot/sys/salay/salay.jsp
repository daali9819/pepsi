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
    <form id="salayForm" method="post" style="position: relative;">
    	<input type="hidden" name="salay.id"/>
    	<div class="form-item">
    		<label class="iblock">排序:</label>
    		<input type="text" name="salay.salayId" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item">
    		<label class="iblock">名称:</label>
    		<input type="text" name="salay.salayName" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item">
    		<label class="iblock">是否启用:</label>
    		<input type="checkbox" value="true" name="salay.salayIstrue"/>
    	</div>
    </form>
  </body>
</html>













