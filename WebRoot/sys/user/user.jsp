<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户管理</title>
    
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
    <form id="userForm" method="post" style="position: relative;">
    	<input type = "hidden" name = "user.userId">
    	<div class="form-item">
    		<label class="iblock">用户名:</label>
    		<input type="text" name="user.userUsername" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item">
    		<label class="iblock">密码:</label>
    		<input type="text" name="user.userPassword" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item">
    		<label class="iblock">手机号:</label>
    		<input type="text" name="user.userPhoto" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item">
    		<label class="iblock">描述:</label>
    		<input type="text" name="user.userMiaoshu" class="ipt" data-options="required:true"/>
    	</div>
    	<div class="form-item">
    		<label class="iblock">角色:</label>
    		<input type="text" name="user.role.roleId" class="easyui-combobox" 
    data-options="valueField:'roleId',textField:'roleName',url:'sys/role_search.action',panelHeight:'auto',editable:false" /> 
    	</div>
    </form>
  </body>
</html>













