<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<script type="text/javascript">
		function get_time(){	
			var date=new Date();
			var year="",month="",day="",week="",hour="",minute="",second="";
			year=date.getFullYear();
			month=add_zero(date.getMonth()+1);
			day=add_zero(date.getDate());
			week=date.getDay();
			switch (date.getDay()) {
				case 0:val="周日";break
				case 1:val="周一";break
				case 2:val="周二";break
				case 3:val="周三";break
				case 4:val="周四";break
				case 5:val="周五";break
				case 6:val="周六";break
			}
			hour=add_zero(date.getHours());
			minute=add_zero(date.getMinutes());
			second=add_zero(date.getSeconds());
			document.getElementById("timetable").innerHTML=year+"年"+month+"月"+day+"日"+hour+":"+minute+":"+second+" "+val;
			
		}
		
		function add_zero(temp)
		{
			if(temp<10) return "0"+temp;
			else return temp;
		}
		setInterval("get_time()",1000);
	</script>
	
	<%@ include file="common.jsp" %>

  </head>
  
  <body class="easyui-layout" style="height: 100%;">
  	 <div data-options="region:'north'" class="header" style="height:80px;">
  	 	<h1 style="text-align: center; font-family:'楷体'; font-size: 40px;">人力资源管理系统</h1>
  	 	<div id="themes">
        	<p>
	        	欢迎：${sessionScope.login_user.userUsername }&nbsp;&nbsp;职责：${sessionScope.login_user.role.roleName }
	        	<a style="margin-left:20px;" href="login.jsp" onclick="return confirm('确定要退出吗?');">退出系统</a>&nbsp;&nbsp;
        	</p>
        	<img src="images/main_11.gif" style="position:absolute; top:-10px; left:-1000px;">
        	<p id="timetable" style="position:absolute; top:0px; left:-1060px; font-size:13px; color: orange;"></p>
    		<span class="theme1" title="gray"></span>
    		<span class="theme3" title="metro"></span>
    		<span class="theme5 active" title="default"></span>
    	</div>
  	 </div>
    <div data-options="region:'west',title:'管理菜单',href:'sys/nav.jsp'"  style="width:250px;"></div>
    <div data-options="region:'center'" > 	
    	<div id="tt" class="easyui-tabs" data-options="fit:true">
    		<div title="首页">
    			<img src="images/psb.jpg" width="100%" height="100%" />
    		</div>
    	</div>
    </div>
  </body>
</html>









