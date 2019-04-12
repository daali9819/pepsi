<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addTrain.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@include file="../common.jsp" %>

  </head>
  
  <body>
  	<script type="text/javascript" src="sys/js/jquery.uploadify.min.js"></script>
  	<link rel="stylesheet" type="text/css" href="css/uploadify.css">
  	<link rel="stylesheet" type="text/css" href="sys/trian/train.css">
  	<script type="text/javascript">
  		$(function(){
  			
  			$("#hahaha").uploadify({
  				swf : "css/uploadify.swf",
  				buttonText:"上传文件",
  				fileObjName:"data", //指定参数名
  				'fileTypeExts' : '',
  				uploader : "<%=path%>/sys/train_upload.action", //处理上传的程序
  				onUploadSuccess:function(file,data){
  					data = eval("("+data+")");
  					$("#photo_haha").attr("src",data.path);
  					$("#data_hidden").val(data.path);
  				}
  			});
  			
  		})
  	</script>
    
	  			<form id="addTrainForm">
		  				<input type="hidden" name="train.trainId">
		  				<input type="hidden" name="train.trainState">
	  				<div class="form-item">
	  					<label class="iblock">培训名称:</label>
	  					<input style="width:85%;" type="text"  name="train.trainName" class="ipt"/>
	  					<br/>
	  					
	  					<label class="iblock">培训讲师:</label>
						<input style="width:35%;" type="text"  name="train.trainTeacher" class="ipt"/>
						
	  					<label class="iblock">培训时间:</label>
	  					<input type="text"  name="train.trainDate" class="easyui-datebox"/>
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
				    		<input type="hidden" id="data_hidden" name="train.trainData"/>
				    	</div>  					
  				</div>
  				
  			</form>
  			
  
  	
  </body>
</html>
