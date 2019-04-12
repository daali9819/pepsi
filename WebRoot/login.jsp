<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@include file="sys/common.jsp" %>
	<script type="text/javascript">
		$(function(){
			$("#btn").click(function(){
				$("#form1").trigger("submit");
				return false;
			});
		});
	</script>
  </head>
  
  <body>
  	<c:remove var="login_user" scope="session"/>
  	<p id="biaoti">人力资源管理系统</p>
  	<img id="logo" src="images/logo.jpg">
  	<div id="denglukuang" style="width:300px;margin: 10px auto;">
	  	<form id="form1" action="login.action" method="post">
		    <div class="denglu">
		    	<div class="form-item-login">
		    		<label class="iblock-login">用户名:</label>
		    		<input type="text" name="user.userUsername" class="ipt" />
		    	</div>
		    	<div class="form-item-login">
		    		<label class="iblock-login">密码:</label>
		    		<input type="password" id="pwd" name="user.userPassword" class="ipt"/>
		    	</div>
		    	<div class="form-item-login">
		    		<label class="iblock-login"></label>
		    		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">登 录</a> 
		    	</div>
		    	<div style="color:red; margin-left:20px;">${err }</div>
		    	<c:remove var="err"/>
		    </div>
	    </form>
    </div>
  </body>
</html>












