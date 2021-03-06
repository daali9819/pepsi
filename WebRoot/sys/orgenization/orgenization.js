﻿/**
 * Orgenization管理的js脚本
 */
$(function(){
	$("#orgenizationList").treegrid({
		title : "部门列表",
		iconCls : "icon-search",
		url : "sys/orgenization_list.action",
		fitColumns:true, //列填充满表格
		rownumbers : true, //是否显示行号
		striped : true,
		showHeader:true,
		idField:"orgenizationId",
		treeField:"text",
		animate:true,
		columns : [[
		            {field:'sdsd',checkbox:true},
		            {field:'orgenizationId',title:"编号",width:10},
		            {field:"text", title:"名称", width:30},
		            {field:"organizationIstrue", title:"是否启用", width:30,formatter:function(value,row,index){
		            	if(row.organizationIstrue){
		            		return "<input type = 'checkbox' checked='checked' disabled='disabled'/>";
		            	}
		            	return "<input type = 'checkbox' disabled='disabled'/>";
		            	
		            }},
		            {field:"orgenizationAddress", title:"地址", width:30},
		            {field:"orgenizationDesc", title:"简介", width:30}
		]],
		loadFilter : function(data){
			var d = {total:0, rows:[]};
			d.total = data.total;
			d.rows = data.orgenizationList;
			return d;
		},
		toolbar:[{
			iconCls:"icon-add",
			text : "添加",
			handler:function(){
				addOrgenization();
			}
		},{
			iconCls:"icon-edit",
			text : "编辑",
			handler:function(){
				editOrgenization();
			}
		},{
			iconCls:"icon-remove",
			text : "删除",
			handler:function(){
				deleteOrgenization();
			}
		}]
	});
});

/**
 * 设置查询条件
 */
function setOrgenization(){
	var combox = $("#qiyong").combobox("getText");
	if(combox == "启用"){
		$("#orgenizationList").treegrid("reload",{
			"condition.text":$("#orgenizationname").val(),
			"condition.organizationIstrue":true
		});
	}
	if(combox == "不启用"){
		$("#orgenizationList").treegrid("reload",{
			"condition.text":$("#orgenizationname").val(),
			"condition.organizationIstrue":false
		});
	}
	if(combox == "-请选择-"){
		$("#orgenizationList").treegrid("reload",{
			"condition.text":$("#orgenizationname").val(),
		});
	}
	
	
}

/**
 * 重置条件
 */
function resetOrgenizationCondition(){
	$("#orgenizationname").val("");
	$("#qiyong").combobox("select",-1);
}

function editOrgenization(){
	//获取选中的行，只要第一次
	var selRow = $("#orgenizationList").datagrid("getSelected");
	if(selRow == null){
		$.messager.alert("提示","必须选择要编辑的数据","warning");
		return;
	}
	//去掉其他的选中行
	$("#orgenizationList").datagrid("clearSelections");
	// 调用这个方法必须配置idField属性
	$("#orgenizationList").treegrid("selectRecord",selRow.orgenizationId);
	
	
	
	var d = $("<div></div>").appendTo("body");
	d.dialog({
		title : "编辑Orgenization",
		iconCls : "icon-edit",
		width:700,
		height:400,
		modal : true,
		href : "sys/orgenization/orgenization.jsp",
		onLoad:function(){
			//发送一个异步请求，加载数据
			$.post("sys/orgenization_toedit.action",{"orgenization.orgenizationId":selRow.orgenizationId},function(data){
				//转换数据
				var d = {};
				//foreach语法：
				// object：ｋｅｙ代表的是属性
				// array: 代表循环变量
				// string : 代表一个一个的字符
				for(var key in data){
					d["orgenization."+key] = data[key];
					//如果属性是object类型
					if(typeof data[key] == "object"){
						for(var e in data[key]){
							d["orgenization."+key+"."+e] = data[key][e];
						}
					}
				}
				//让表单显示数据
				$("#orgenizationForm").form("load",d);
			});
		},
		onClose:function(){$(this).dialog("destroy");},
		buttons:[{
			text : "确定",
			iconCls:"icon-ok",
			handler:function(){
				$("#orgenizationForm").form("submit",{
					url : "sys/orgenization_edit.action",
					success:function(data){
						if(typeof data == "string"){
							data = eval("("+data+")");
						}
						if(data.result == true){
							d.dialog("close");
							$("#orgenizationList").treegrid("reload");
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
function addOrgenization(){
	var d = $("<div></div>").appendTo("body");
	d.dialog({
		title : "添加部门",
		iconCls : "icon-add",
		width:350,
		height:400,
		modal : true,
		href : "sys/orgenization/orgenization.jsp",
		onClose:function(){$(this).dialog("destroy");},
		buttons:[{
			text : "确定",
			iconCls:"icon-ok",
			handler:function(){
				$("#orgenizationForm").form("submit",{
					url : "sys/orgenization_add.action",
					success:function(data){
						if(typeof data == "string"){
							data = eval("("+data+")");
						}
						if(data.result == true){
							d.dialog("close");
							$("#orgenizationList").treegrid("reload");
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
function deleteOrgenization(){
	//获取选中的记录
	var selRows = $("#orgenizationList").datagrid("getSelections");
	//如果没有选中，提示
	if(selRows.length == 0){
		$.messager.alert("提示","必须选择要删除的行","warning");
		return;
	}
	$.messager.confirm("提示","你确定要删除这些记录吗?",function(r){
		if(r){
			var postData = {};
			$.each(selRows,function(i){
				postData["ids["+i+"]"] = this.orgenizationId;
			});
			//发送异步请求去删除数据
			$.post("sys/orgenization_delete.action",postData,function(data){
				//成功了就刷新datagrid
				if(data.result == true){
					$("#orgenizationList").treegrid("reload");
				}
			});
		}
	});
	
}







