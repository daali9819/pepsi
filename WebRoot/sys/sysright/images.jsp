<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'images.jsp' starting page</title>
    
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
	<style type = "text/css">
		#photo ul li{
	  		list-style: none;
	  		float:left;
	  		}
	  	#photo ul li img{
			height:22px;
			width:22px;
			margin-left: 16px;
			margin-top: 16px;
			border:1px solid #fff;
			}
		#photo ul li img:HOVER {
			border:1px solid red;
			cursor:pointer;
		}
	</style>  
  	<script type="text/javascript">
  		$(function(){
  			$("#photo ul li img").bind("click",function(){
  				var iconCls = $(this).attr("class");
  				$("#tu").val(iconCls);
  				$("#div").dialog("close");
  			});
  		});
  	</script>
  
    <div id = "photo">
    	<ul>
    		<li><img class="icon-laptop_disk" src="images/laptop_disk.png"></li>
    		<li><img class="icon-cake" src="images/cake.png"></li>
    		<li><img class="icon-cancel" src="images/cancel.png"></li>
    		<li><img class="icon-laptop_magnify" src="images/laptop_magnify.png"></li>
    		<li><img class="icon-cut" src="images/cut.png"></li>
    		<li><img class="icon-door_in" src="images/door_in.png"></li>
    		<li><img class="icon-edit_add" src="images/edit_add.png"></li>
    		<li><img class="icon-laptop_connect" src="images/laptop_connect.png"></li>
    		<li><img class="icon-filesave" src="images/filesave.png"></li>
    		<li><img class="icon-laptop_start" src="images/laptop_start.png"></li>
    		<li><img class="icon-filter" src="images/filter.png"></li>
    		<li><img class="icon-help" src="images/help.png"></li>
    		<li><img class="icon-mini_add" src="images/mini_add.png"></li>
    		<li><img class="icon-mini_edit" src="images/mini_edit.png"></li>
    		<li><img class="icon-more" src="images/more.png"></li>
    		<li><img class="icon-no" src="images/no.png"></li>
    		<li><img class="icon-laptop_error" src="images/laptop_error.png"></li>
    		<li><img class="icon-pencil" src="images/pencil.png"></li>
    		<li><img class="icon-laptop_key" src="images/laptop_key.png"></li>
    		<li><img class="icon-laptop" src="images/laptop.png"></li>
    		<li><img class="icon-print" src="images/print.png"></li>
    		<li><img class="icon-redo" src="images/redo.png"></li>
    		<li><img class="icon-reload" src="images/reload.png"></li>
    		<li><img class="icon-search" src="images/search.png"></li>
    		<li><img class="icon-tip" src="images/tip.png"></li>
    		<li><img class="icon-undo" src="images/undo.png"></li>
    		<li><img class="icon-zoom_in" src="images/zoom_in.png"></li>
    		<li><img class="icon-zoom_out" src="images/zoom_out.png"></li>
    		<li><img class="icon-zoom.png" src="images/zoom.png"></li>
    		<li><img class="icon-laptop_add" src="images/laptop_add.png"></li>
    		<li><img class="icon-laptop_delete" src="images/laptop_delete.png"></li>
    		<li><img class="icon-filter" src="images/filter.png"></li>
    		<li><img class="icon-laptop_edit" src="images/laptop_edit.png"></li>
    		<li><img class="icon-sum" src="images/sum.png"></li>
    		<li><img class="icon-laptop_go" src="images/laptop_go.png"></li>
    		<li><img class="icon-back" src="images/back.png"></li>
    		<li><img class="icon-laptop_link" src="images/laptop_link.png"></li>
    		<li><img class="icon-clear" src="images/clear.png"></li>
    		<li><img class="icon-edit_remove" src="images/edit_remove.png"></li>
    		<li><img class="icon-laptop_stop" src="images/laptop_stop.png"></li>
    		<li><img class="icon-ok" src="images/ok.png"></li>
    		<li><img class="icon-laptop_wrench" src="images/laptop_wrench.png"></li>
    	</ul>
    </div>
  </body>
</html>
