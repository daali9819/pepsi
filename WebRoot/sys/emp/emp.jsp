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
<%-- 	<%@include file="../common.jsp" %> --%>
	
  </head>
  
  <body>
  	<script type="text/javascript">
  		
  			//图片的点击事件
		  		function SearchImgs(){
				var d = $("<div id='div'></div>").appendTo("body");
				d.dialog({
					title : "选择部门",
					iconCls:"icon-search",
					width:308,
					height:500,
					modal : true,
					href:"sys/emp/dept.jsp",
					onClose:function(){$(this).dialog("destroy");},
					
					});
				}
				function Searchposition(){
						var d = $("<div id= 'div'></div").appendTo("body");
						d.dialog({
							title : "选择职位",
							iconCls:"icon-search",
							width:580,
							height:250,
							modal:true,
							href:"sys/emp/position.jsp",
							onClose:function(){$(this).dialog("destroy");},
						});						
				}  	
				
  			
  	</script>
  	<style>
  		img:HOVER{
  			cursor: pointer;
  		}
  	</style>
  
 <div style="cursor: pointer;" id="u17" class="text">
        <p><span>人事</span><span>管理</span><span>&nbsp;</span><span>&gt;&gt;</span><span>&nbsp;</span><span>人事档案</span><span>管理</span><span> &gt;&gt; </span><span>档案</span><span>修改</span></p>
 </div>
    <form id="empForm" method="post" style="position: relative;" enctype="multipart/form-data" >
    	<input type="hidden" name="emp.empId"/>
    	<input type = "hidden" id = "de" name = "emp.orgenization.orgenizationId"/>
    	<div class="form-item one">
    		<label class="iblock">所属部门:</label>
    			<input type="text" readonly="readonly" id = "dept" name="emp.orgenization.text" class="ipt easyui-validatebox" data-options="required:true"/>
    		<img src="images/search.png" style="width:20px; height:20px;" onclick="SearchImgs()">
    		<!-- <input id="position" name="emp.orgenization.orgenizationId" class="ipt easyui-combobox" data-options="valueField:'orgenizationId',textField:'orgenizationSimpleName',url:'sys/orgenization_search.action',panelHeight:'auto',editable:false" /> -->
    	</div>
    	<div class="form-item one">
    		<label class="iblock">职位名称:</label>
    		<input type="text" readonly="readonly" id="positionName" name="emp.position.positionName" class="ipt easyui-validatebox" data-options="required:true"/>
    		<img src="images/search.png" style="width:20px; height:20px;" onclick="Searchposition()">
    	</div>
    	<div class="form-item one">
    		<label class="iblock">姓名:</label>
    		<input type="text" name="emp.empName" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item one">
    		<label class="iblock">邮箱:</label>
    		<input type="text" name="emp.empEmail" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item one">
    		<label class="iblock">地址:</label>
    		<input type="text" style="width:550px"  name="emp.empAddress" class="ipt easyui-validatebox add" data-options="required:true"/>
    	</div>
    	<div class="form-item one">
    		<label class="iblock">身份证号:</label>
    		<input type="text" name="emp.empIdentity" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item one">
    		<label class="iblock">毕业学校:</label>
    		<input type="text" name="emp.empSchool" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item one">
    		<label class="iblock">薪酬:</label>
    		<input id="empState" name="emp.salayitems.salayitemsId" class="easyui-combobox"  data-options="valueField:'salayitemsId',textField:'salayitemsName',url:'sys/salayitems_search.action',panelHeight:'auto',editable:false" />
    	</div>
    	<div class="form-item one">
    		<label class="iblock">社保卡号:</label>
    		<input type="text" name="emp.empCard" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	
    	<div class="form-item two">
    		<label class="iblock">档案状态:</label>
    		<input id="empState" class="easyui-combobox" name="emp.empState"  data-options="valueField:'propertiesItemsName',textField:'propertiesItemsName',url:'sys/propertiesitems_search.action?PId=1',panelHeight:'auto',editable:false" />
    	</div>
    	<div class="form-item two">
    		<label class="iblock">职位编号:</label>
    		<input type="text" name="emp.position.positionId" class="ipt easyui-validatebox" data-options="required:true"/>
<!--     		<input id="titleName" name="emp.title.titleName" class="ipt easyui-combobox" data-options="valueField:'titleId',textField:'titleName',url:'sys/title_search.action',panelHeight:'auto',editable:false" />
 -->    </div>
    	<div class="form-item two">
    		<label class="iblock">性别:</label>
    		<input type="text" name="emp.empSex" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item two">
    		<label class="iblock">电话:</label>
    		<input type="text" name="emp.empPhone" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item three">
    		<label class="iblock">户口所在地:</label>
    		<input type="text" name="emp.empLocalhost" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item three">
    		<label class="iblock">专业:</label>
    		<input type="text" name="emp.empCareer" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item three">
    		<label class="iblock">开户行:</label>
    		<input type="text" name="emp.empBank" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item three">
    		<label class="iblock">登记人:</label>
    		<input type="text" class="ipt easyui-validatebox"  readonly="readonly" data-options="required:true" value = "${login_user.userUsername }"/>
    	</div>
    	
    	
    	
    	<div class="form-item fore">
    		<div style="width: 250px;height: 190px;">
    			<img alt="图片" id="haha" src="sys/imgs/318768-1504131T15470.jpg" style="width:250px; height: 190px;" />
    		</div>
    	</div>
    	<div class="form-item fore">
    		<label class="iblock">政治面貌:</label>
    		<input type="text" name="emp.empStatus" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item fore">
    		<label class="iblock">学历:</label>
    		<input type="text" name="emp.empXueli" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item fore">
    		<label class="iblock">银行卡号:</label>
    		<input type="text" name="emp.empBankcard" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item fore">
    		<label class="iblock">建档时间:</label>
    		<input type="text" name="emp.empFilingDate" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	
    	<div class="form-item five">
    		<label class="iblock">个人履历:</label>
    		<input type="text" style="width:815px; height:83px;" name="emp.empRecord" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item five"  style="margin-top: 10px;">
    		<label class="iblock">家庭关系信息:</label>
    		<input type="text" style="width:815px; height:63px;" name="emp.empInfo" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item five">
    		<label class="iblock">备注:</label>
    		<input type="text" style="width:815px; height:53px;" name="emp.empRemark" class="ipt easyui-validatebox" data-options="required:true"/>
    	</div>
    	<div class="form-item five" style="margin-top: -20px;">
		选择附近<input type="file" name="empAccessory"  />
		<input  type="hidden" name="emp.empAccessory" readonly="readonly"/>
    	选择图片<input type="file" id="img" name="empPhoto"  label="选择照片"  />
    	<input  type="hidden" name="emp.empPhoto" readonly="readonly"/>
    	</div>
    </form>
  </body>
</html>













