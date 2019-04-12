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
	<script type="text/javascript" src="sys/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		function yanzheng(asd){
			var asds = 0;
			$(".biao").each(function(){
				if($(this).val() != ""){
					asds += parseInt($(this).val());
					$("#money").val(asds);
				};
			});
		}
		
	</script>
	
	<style>
		#Mytab{
			margin-top: 10px;
		}
		#Mytab tr{
			float: left;
			margin-top: 10px;
			margin-left: 5px;
		}
		#Mytab #asd{
			margin-left: 50px;
		}
		.wotab{
			font-family:"微软雅黑";
			margin-top:10px;
			margin-left:30px;
			width:600px;
		}
		.wotab tr{
			height:30px;
		}
		.wotab td{
			text-align: center;
		}
		h2{
			margin-top: 10px;
		}
		h3{
			margin-top: 10px;
		}
		#aaaaa input{
			height:25px;
			text-align: center;
			width:100px;
		}
	</style>
    	<div>
    		<h3>薪酬管理>>薪酬标准管理>>标准登记</h3>
    		<div>
    			<form id = "salayitmesList" method="post">
    				<table id= "Mytab">
    					<tr>
    						<td>薪酬标准名称：</td>
    						<td><input type = "text" name = "salayitems.salayitemsName"/></td>
    					</tr>
    					<tr>
    						<td>薪酬总额：</td>
    						<td><input type = "text" id = "money" readonly='readonly' name = "salayitems.salayitemsMoney"/></td>
    					</tr>
    					<tr>
    						<td>制定人：</td>
    						<td><input type = "text" name = "salayitems.salayitemszhidingren"/></td>
    					</tr>
    					<tr id = "asd">
    						<td>登记人：</td>
    						<td><input type = "text" readonly='readonly' name = "salayitems.salayitemsdengluren" value="${login_user.userUsername}"/></td>
    					</tr>
    					<tr>
    						<td>登记时间：</td>
    						<td>
    							<input type = "text" name = "salayitems.salayitemsdate" onfocus="WdatePicker()" readonly='readonly'/>
    						</td>
    					</tr>
    				</table>
    				<br />
    				<br />
    				<hr />
    				<h2>薪酬项</h2>
    				<table class = "wotab">
    					<tr>
    						<td>序号</td>
    						<td>薪酬项目名称</td>
    						<td>金额</td>
    					</tr>
    					<c:forEach items="${salayList }" var="salay" varStatus="i">
    						<tr id= "aaaaa">
    							<td><input name="salayitems.salaySalayitems[${i.index }].salayId.salayId" type = "text" readonly="readonly" value = "${salay.salayId }"/></td>
    							<td><input type = "text" readonly="readonly" value = "${salay.salayName }"/></td>
    							<td><input name="salayitems.salaySalayitems[${i.index }].salayMoney" type = "text" class = "biao" id = "${salay.salayId }" onBlur = "yanzheng($(this).val());"/></td>
    						</tr>
    					</c:forEach>
    				</table>
    			</form>
    		</div>
    	</div>
    
  </body>
</html>













