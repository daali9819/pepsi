﻿/**
 * 数据分析-职员明细表管理的js脚本
 */
$(function(){
	$("#dataempList").datagrid({
		title : "职员列表",
		iconCls : "icon-search",
		url : "sys/data_emp_list.action",
		fitColumns:true, //列填充满表格
		pagination : true,
		pageList : [5,10,15,20],
		pageSize : 5,
		striped : true,
		showHeader:true,
		idField:"id",
		columns : [[
		            {field:"orgenization.text", title:"部门", width:30, formatter:function(value,row,index){
		            	if(row.orgenization){
		            		return row.orgenization.text;
		            	}
		            }},
		            {field:"empId", title:"档案编码", width:30},
		            {field:"empName", title:"员工姓名", width:30},
		            {field:"empSex", title:"性别", width:30},
		            {field:"position.positionName", title:"职位", width:30, formatter:function(value,row,index){
		            	if(row.position){
		            		return row.position.positionName;
		            	}
		            }},
		            {field:"title.titleName", title:"职称", width:30, formatter:function(value,row,index){
		            	if(row.title){
		            		return row.title.titleName;
		            	}
		            }},
		            {field:"empPhone", title:"电话", width:30},
		            {field:"empState", title:"档案状态", width:30},
		            {field:"empFilingDate", title:"建档时间", width:30, formatter:function(value,row,index){
		            	if(row.empFilingDate){
		            		var index = row.empFilingDate.indexOf("T");
		            		return row.empFilingDate.substring(0,index);
		            	}
		            }}
		]],
		loadFilter : function(data){
			var d = {total:0, rows:[]};
			d.total = data.total;
			d.rows = data.empList;
			return d;
		}
	});
});

/**
 * 设置查询条件
 */
function setEmpCondtion(){
	$("#dataempList").datagrid("reload",{
		"condition.orgenization.orgenizationId" : $("#orzen").combobox("getValue"),
		"condition.empName" : $("#empName").val(),
		"condition.empState" : $("#propertiesItems").combobox("getValue"),
		"condition.starttime" : $("#jdtimebegin").datebox("getValue"),
		"condition.endtime" : $("#jdtimeend").datebox("getValue")
	});
}

/**
 * 重置条件
 */
function resetEmpCondition(){
	$("#dataempconditionForm").form("clear");
}





