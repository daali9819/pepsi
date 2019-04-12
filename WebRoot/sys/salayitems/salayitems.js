﻿/**
 * Salayitems管理的js脚本
 */
$(function(){
	$("#salayitemsList").datagrid({
		title : "薪酬标准列表",
		iconCls : "icon-search",
		url : "sys/salayitems_list.action",
		fitColumns:true, //列填充满表格
		pagination : true,
		pageList : [5,10,15,20],
		pageSize : 5,
		rownumbers : true, //是否显示行号
		striped : true,
		showHeader:true,
		idField:"salayitemsId",
		columns : [[
		            {field:'hello', checkbox:true},
		            {field:"salayitemsId", title:"编号", width:10},
		            {field:"salayitemsName", title:"名称", width:30},
		            {field:"salayitemsState", title:"审核状态", width:30},
		            {field:"salayitemsdate", title:"登记时间", width:30,formatter:function(value,row,index){
		            	var aaa = row.salayitemsdate.indexOf("T");
		            	var sss = row.salayitemsdate.substring(0,aaa);
		            	return sss;
		            }},
		            {field:"Word", title:"操作", width:30,formatter:function(value,row,index){
		            	if(row.salayitemsState == "起草"){
		            		return "<a href ='#' onclick='editSalayitems();return false;'>修改</a>&nbsp;&nbsp;<a href ='#' onclick='fuhe("+row.salayitemsId+");return false;'>审核</a>&nbsp;&nbsp;<a href='#' onclick='deletea("+row.salayitemsId+");return false;'>删除</a> ";
		            	}
		            	if(row.salayitemsState == "审核中"){
		            		return "<a href ='#'>明细</a>";
		            	}
		            	if(row.salayitemsState == "审核通过"){
		            		return "<a href ='#'>变更</a>&nbsp;&nbsp;<a href ='#'>明细</a>";
		            	}
		            }}
		]],
		loadFilter : function(data){
			var d = {total:0, rows:[]};
			d.total = data.total;
			d.rows = data.salayitemsList;
			return d;
		},
		toolbar:[{
			iconCls:"icon-add",
			text : "标准登记",
			handler:function(){
				addSalayitems();
			}
		}]
	});
});

/**
 * 删除的方法
 */
function deletea(asd){
	if(asd != null){
		$.messager.confirm("提示","确定删除这条数据吗？删除将无法恢复！谨慎删除。", function(r){
			if(r){
				var postdata = {};
				postdata["ids["+0+"]"] = asd;
				$.post("sys/salayitems_delete.action",postdata,function(data){
					if(data.result == true){
						$("#salayitemsList").datagrid("reload");
					}
				});
			}
		});
	}
}





/**
 * 设置查询条件
 */
function setsalayitemsCondtion(){
	var asd = $("#salayitemsState").combobox("getText");
	if(asd != "-请选择-"){
		$("#salayitemsList").datagrid("reload",{
			"condition.salayitemsName":$("#salayitemsName").val(),
			"condition.salayitemsState":asd,
			"condition.beginDate":$("#begin").datebox("getText"),
			"condition.endDate" : $("#end").datebox("getText")
		});
	}else{
		$("#salayitemsList").datagrid("reload",{
			"condition.salayitemsName":$("#salayitemsName").val(),
			"condition.beginDate":$("#begin").datebox("getText"),
			"condition.endDate" : $("#end").datebox("getText")
		});
	}
	
}

/**
 * 重置条件
 */
function resetSalayitemsCondition(){
	$("#salayitemsState").combobox("select",-1);
	$("#salayitemsName").val("");
	$("#begin").datebox("clear");
	$("#end").datebox("clear");
}

function editSalayitems(){
	var selRow = $("#salayitemsList").datagrid("getSelected");
	if(selRow == null){
		$.messager.alert("提示","必须选择要编辑的数据","warning");
		return;
	}
	$("#salayitemsList").datagrid("clearSelections");
	$("#salayitemsList").datagrid("selectRecord",selRow.salayitemsId);
	var d = $("<div></div>").appendTo("body");
	d.dialog({
		title : "标准登记",
		iconCls : "icon-edit",
		width:800,
		height:600,
		modal : true,
		href : "sys/salayitems/salayitems.jsp",
		onLoad:function(){
			//发送一个异步请求，加载数据
			$.post("sys/salayitems_toedit.action",{"salayitems.salayitemsId":selRow.salayitemsId},function(data){
				var d = {};
				for(var key in data){
					d["salayitems."+key] = data[key];
					if(typeof data[key] == "object"){
						for(var e in data[key]){
							d["salayitems."+key+"."+e] = data[key][e];
							if (typeof data[key][e] == "object") {
								for ( var h in data[key][e]) {
									d["salayitems."+key+"."+e+"."+h] = data[key][e][h];
								}
							}
						}
					}
				}
				//让表单显示数据
				$("#salayitmesList").form("load",d);
			});
		},
		onClose:function(){$(this).dialog("destroy");},
		buttons:[{
			text : "确定",
			iconCls:"icon-ok",
			handler:function(){
				$("#salayitemsForm").form("submit",{
					url : "sys/salayitems_edit.action",
					success:function(data){
						if(typeof data == "string"){
							data = eval("("+data+")");
						}
						if(data.result == true){
							d.dialog("close");
							$("#salayitemsList").datagrid("reload");
						}
					}
				});
			}
		},{
			text : "取消",
			iconCls:"icon-cancel",
			handler:function(){
				d.dialog("close");
			}
		}]
	});
}

/**
 * 添加  
 */
function addSalayitems(){
	var d = $("<div></div>").appendTo("body");
	d.dialog({
		title : "添加薪酬标准项",
		iconCls : "icon-add",
		width:800,
		height:600,
		modal : true,
		href : "sys/salay_getAll.action",
		onClose:function(){$(this).dialog("destroy");},
		buttons:[{
			text : "保存",
			iconCls:"icon-ok",
			handler:function(){
				$("#salayitmesList").form("submit",{
					url : "sys/salayitems_add.action",
					success:function(data){
						if(typeof data == "string"){
							data = eval("("+data+")");
						}
						if(data.result == true){
							d.dialog("close");
							$("#salayitemsList").datagrid("reload");
						}
					}
				});
			}
		},{
			text : "取消",
			iconCls:"icon-cancel",
			handler:function(){
				d.dialog("close");
			}
		}]
	});
}

/**
 * 复核
 */
function fuhe(asd){
	var selRows = $("#salayitemsList").datagrid("getSelections");
	if(selRows.length == 0){
		$.messager.alert("提示","必须选择要审核的行","warning");
		return;
	}
	var postdata = {};
	postdata["ids["+0+"]"] = asd;
	$.post("sys/backlog_addsalayitems.action",postdata,function(data){
		if(data.result == true){
			$("#salayitemsList").datagrid("reload");
		}
	});
}





