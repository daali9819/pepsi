<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'propertiesitemsUpdate.jsp' starting page</title>
    
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
  	<form id="propertiesitemsForm" method="post" style="position: relative;">
    	<input type="hidden" name="propertiesitems.propertiesItemsId"/>
    	<div class="form-item">
    		<label class="iblock">名称:</label>
    		<input type="text" name="propertiesitems.propertiesItemsName" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item">
    		<label class="iblock">描述:</label>
    		<input type="text" name="propertiesitems.propertiesItemsDesc" class="ipt" data-options="required:true"/>
    	</div>
    	<input type = "hidden" id="fu" name = "propertiesitems.properties.propertiesId"/>
    </form>
  </body>
</html>
