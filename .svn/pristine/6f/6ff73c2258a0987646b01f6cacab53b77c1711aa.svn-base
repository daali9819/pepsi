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
  	<script type="text/javascript">
  		function hahaha(data){
  			data.unshift({
  				"orgenizationId":-1,
  				"text":'父权限'
  			});
  			return data;
  		}
  		
  		
  		function hehehe(){
  			$("#parent").combobox("select",-1);
  		}
  		
  	</script>
  	

  
    <form id="orgenizationForm" method="post" style="position: relative;">
    	<input type="hidden" name="orgenization.orgenizationId"/>
    	<div class="form-item">
    		<label class="iblock">所属部门:</label>
    		<input type="text" id="parent" name="orgenization.parent.orgenizationId" class="easyui-combobox" 
    data-options="valueField:'orgenizationId',textField:'text',url:'sys/orgenization_getfu.action',panelHeight:'auto',editable:false" /> 
    	</div>
    	<div class="form-item">
    		<label class="iblock">简称:</label>
    		<input type="text" name="orgenization.orgenizationSimpleName" class="ipt" data-options="required:true"/>
    	</div>
    	<div class="form-item">
    		<label class="iblock">全称:</label>
    		<input type="text" name="orgenization.text" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item">
    		<label class="iblock">地址:</label>
    		<input type="text" name="orgenization.orgenizationAddress" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item">
    		<label class="iblock">简介:</label>
    		<input type="text" name="orgenization.orgenizationDesc" class="ipt" data-options="required:true"/>
    	</div>
    	<div class="form-item">
    		<label class="iblock">描述:</label>
    		<input type="text" name="orgenization.orgenizationRemark" class="ipt" data-options="required:true"/>
    	</div>
    	<div class="form-item">
    		<label class="iblock">是否启用:</label>
    		<input type="checkbox" value="true" name="orgenization.organizationIstrue" class="" data-options="required:true"/>
    	</div>
    </form>
  </body>
</html>













