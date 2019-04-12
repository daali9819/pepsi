<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updpwd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
	<link rel="stylesheet" type="text/css" href="sys/user/updpwd.css">
	<script type="text/javascript" src="sys/user/updpwd.js"></script>
	<div id="updmima">
		<form id="form1" action="sys/user_updpwd.action" method="post">
			<input name="user.userId" type="hidden" value="${sessionScope.login_user.userId}">
			<input id="pwd" type="hidden" value="${sessionScope.login_user.userPassword}">
			<span>请输入旧密码：</span>
			<input class="oldpwd" type="password">
			<span><label class="redxing">*</label> <label id="bzyi" class="bluezi">您本次登录时的密码</label></span><br><br>
			
			<span>请输入新密码：</span>
			<input class="newpwd" type="password">
			<span><label class="redxing">*</label> <label id="bzer" class="bluezi">新密码不少于6个字符</label></span><br><br>
			
			<span>请确认新密码：</span>
			<input name="user.userPassword" class="qrnewpwd" type="password">
			<span><label class="redxing">*</label> <label id="bzsan" class="bluezi">新密码不少于6个字符</label></span><br><br>
			
			<button type="submit">确认修改密码</button>
			<button type="reset">取消</button>
		</form><br>
		<span class="tishi">修改成功后会自动跳到登录页面以确定</span>
	</div>
  </body>
</html>










