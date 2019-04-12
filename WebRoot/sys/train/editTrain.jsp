<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editTrain.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
  		$(function(){
  			function delDate(){
  				$("#data").clear();
  			}
  			
  		})
  	</script>
    
	
  <body>
  			<form id="editTrainForm">
	  			<input type="hidden" name="train.trainId">
	  				<div class="form-item">
	  					<label class="iblock">培训名称:</label>
	  					<input style="width:85%;" type="text"  name="train.trainName" class="ipt"/>
	  					<br/>
	  					
	  					<label class="iblock">培训讲师:</label>
						<input style="width:35%;" type="text"  name="train.trainTeacher" class="ipt"/>
						
	  					<label class="iblock">培训时间:</label>
	  					<input type="text"  name="train.train_beginDate" class="easyui-datebox"/>
	  					<label>至</label>
	  					<input type="text"  name="train.train_endDate" class="easyui-datebox"/>
	  					<br/>
	  					
	  					<label class="iblock">培训目的:</label>
						<textarea style="width:85%;" class="train_1" name="train.trainGoal"></textarea>
	  					<br/>
						
	  					<label class="iblock">培训人员:</label>
						<textarea style="width:85%;" class="train_1" name="train.trainRenyuan"></textarea>
	  					<br/>
						
						<label class="iblock">培训简介:</label>
						<textarea style="width:85%;" class="train_1" name="train.trainAbstract"></textarea>
	  					<br/>
						
										
				    	<div class="form-item">
				    		<label class="iblock" style="float: left;">上传文件:</label>
				    		<div style="float: left;" >
				    			<input id="hahaha" type="file" name="data"/>
				    		</div>
				    		<div style="both:clear;"></div>
				    		<input type="hidden" id="haha_hidden" name="train.trainData"/>
				    	</div> 
				    	<br/>
				    	
				    	<label id="data" class="iblock">${train.trainData}</label>
				    	<a href='#' onclick='delDate();return false'><span>删除</span></a>
				    	
	  					<br/>
						 
				    	
				    						
  				</div>
  				
  			</form>
  
  </body>
</html>
