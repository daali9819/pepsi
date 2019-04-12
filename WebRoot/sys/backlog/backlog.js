﻿/**
 * Backlog管理的js脚本
 */
$(function(){
	$("#backlogList").datagrid({
		title : "待办列表",
		iconCls : "icon-search",
		url : "sys/backlog_list.action",
		fitColumns:true, //列填充满表格
		pagination : true,
		pageList : [5,10,15,20],
		pageSize : 5,
		rownumbers : true, //是否显示行号
		striped : true,
		showHeader:true,
		singleSelect:true,
		idField:"backlogId",
		columns : [[
		            {field:'hello', checkbox:true},
		            {field:"backlogId", title:"编号", width:30},
		            {field:"backlogType", title:"待办类型", width:30},
		            {field:"backlogName", title:"待办任务名称", width:30},
		            {field:"backlogDate", title:"到达时间", width:30},
		]],
		loadFilter : function(data){
			var d = {total:0, rows:[]};
			d.total = data.total;
			d.rows = data.backlogList;
			return d;
		},
		toolbar:[{
			iconCls:"icon-add",
			text : "处理",
			handler:function(){
				editBacklog();
			}
		}]
	});
})

/**
 * 设置查询条件
 */
function setBacklogCondtion(){
	$("#backlogList").datagrid("reload",{
		
	});
}

/**
 * 重置条件
 */
function resetBacklogCondition(){
	$("#backlogconditionForm").form("clear");
}

function editBacklog(){
	//获取选中的行，只要第一次
	var selRow = $("#backlogList").datagrid("getSelected");
	if(selRow == null){
		$.messager.alert("提示","请选择要处理的数据","warning");
		return;
	}
	
	
	
	var d = $("<div></div>").appendTo("body");
	d.dialog({
		title : "处理待办项",
		iconCls : "icon-edit",
		width:800,
		height:600,
		modal : true,
		href : "sys/backlog/backlog.jsp",
		onLoad:function(){
			
			//得到什么类型的申请
			//发送一个异步请求，加载数据
			$.post("sys/salayitems_toedit.action",{"salayitems.salayitemsId":selRow.id},function(data){
				//转换数据
				var d = {};
				//foreach语法：
				// object：ｋｅｙ代表的是属性
				// array: 代表循环变量
				// string : 代表一个一个的字符
				for(var key in data){
					d["backlog."+key] = data[key];
					//如果属性是object类型
					if(typeof data[key] == "object"){
						for(var e in data[key]){
							d["backlog."+key+"."+e] = data[key][e];
						}
					}
				}
				//让表单显示数据
				$("#backlogForm").form("load",d);
			});
		},
		onClose:function(){$(this).dialog("destroy");},
		buttons:[{
			text : "确定",
			iconCls:"icon-ok",
			handler:function(){
				$("#backlogForm").form("submit",{
					url : "sys/backlog_edit.action",
					success:function(data){
						if(typeof data == "string"){
							data = eval("("+data+")");
						}
						if(data.result == true){
							d.dialog("close");
							$("#backlogList").datagrid("reload");
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
function addBacklog(){
	var d = $("<div></div>").appendTo("body");
	d.dialog({
		title : "添加Backlog",
		iconCls : "icon-add",
		width:700,
		height:400,
		modal : true,
		href : "sys/backlog/backlog.jsp",
		onClose:function(){$(this).dialog("destroy");},
		buttons:[{
			text : "确定",
			iconCls:"icon-ok",
			handler:function(){
				$("#backlogForm").form("submit",{
					url : "sys/backlog_add.action",
					success:function(data){
						if(typeof data == "string"){
							data = eval("("+data+")");
						}
						if(data.result == true){
							d.dialog("close");
							$("#backlogList").datagrid("reload");
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
 * 删除记录
 */
function deleteBacklog(){
	//获取选中的记录
	var selRows = $("#backlogList").datagrid("getSelections");
	//如果没有选中，提示
	if(selRows.length == 0){
		$.messager.alert("提示","必须选择要删除的行","warning");
		return;
	}
	$.messager.confirm("提示","你确定要删除这些记录吗?",function(r){
		if(r){
			var postData = {};
			$.each(selRows,function(i){
				postData["ids["+i+"]"] = this.id;
			});
			//发送异步请求去删除数据
			$.post("sys/backlog_delete.action",postData,function(data){
				//成功了就刷新datagrid
				if(data.result == true){
					$("#backlogList").datagrid("reload");
				}
			});
		}
	});
	
}







