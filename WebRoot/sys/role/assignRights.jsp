<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'assignRights.jsp' starting page</title>
    
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
  		$(function(){
  			
  			//[{"sysright":{"sysrightId":1}},{"sysright":{"sysrightId":10}},{"sysright":{"sysrightId":11}},{"sysright":{"sysrightId":12}},{"sysright":{"sysrightId":13}}]
  			$.post("sys/rolesysright_search.action",{roleId:${param.roleId }},function(data){
  				$("#rightTree").tree({
  				url : "sys/sysright_list.action",
  				checkbox:true,
  				loadFilter : function(ddd){
  					var dd = ddd.sysrightList;
  					$.each(dd,function(){
  						$.each(this.children,function(){
  							var child = this;
  							$.each(data,function(){
  								if(this.sysright.sysrightId == child.sysrightId){
  									child.checked = true;
  								}
  							});
  						});
  					});
  					return dd;
  				}
  			});
  			});
  			
  		});
  	</script>
   <ul id="rightTree"></ul>
   
   
  </body>
</html>












