﻿/**
 * Role管理的js脚本
 */
$(function(){
	$("#roleList").datagrid({
		title : "角色列表",
		iconCls : "icon-search",
		url : "sys/role_list.action",
		fitColumns:true, //列填充满表格
		pagination : true,
		pageList : [5,10,15,20],
		pageSize : 15,
		rownumbers : true, //是否显示行号
		striped : true,
		showHeader:true,
		idField:"roleId",
		columns : [[
		            {field:'hello', checkbox:true},
		            {field:"roleId", title:"编号", width:30},
		            {field:"roleName", title:"名称", width:30},
		            {field:"role_miaoshu",title:"描述",width:40},
		            {field:'rolesss',title:'分配权限',width:30, formatter:function(value,row,index){
		            	return "<a href='#' title='分配权限' onclick='quanxian("+row.roleId+"); return false;'><img src='easyui/themes/icons/door_in.png'/></a>";
		            }}
		]],
		loadFilter : function(data){
			var d = {total:0, rows:[]};
			d.total = data.total;
			d.rows = data.roleList;
			return d;
		},
		toolbar:[{
			iconCls:"icon-add",
			text : "添加",
			handler:function(){
				addRole();
			}
		},{
			iconCls:"icon-edit",
			text : "编辑",
			handler:function(){
				editRole();
			}
		},{
			iconCls:"icon-remove",
			text : "删除",
			handler:function(){
				deleteRole();
			}
		}]
	});
})

/**
 * 分配权限
 */
function quanxian(roleId){
	$("#roleList").datagrid("clearSelections");
	var d = $("<div></div>").appendTo("body");
	d.dialog({
		title : '分配权限',
		width:300,
		height:600,
		modal:true,
		href : "sys/role/assignRights.jsp?roleId="+roleId,
		onClose:function(){$(this).dialog("destroy");},
		buttons:[{
			text:"确定",
			iconCls:"icon-ok",
			handler:function(){
				//获得所有选中的节点
				var checked_nodes = $("#rightTree").tree("getChecked","checked");
				var half_nodes = $("#rightTree").tree("getChecked","indeterminate");
				$.merge(checked_nodes,half_nodes);
				//发送异步请求
				var postData = {
						roleId : roleId
				};
				
				$.each(checked_nodes,function(i){
					postData["rolesysRightList["+i+"].sysright.sysrightId"]=this.sysrightId,
					postData["rolesysRightList["+i+"].role.roleId"] =roleId
				});
				
				$.post("sys/rolesysright_assign.action",postData,function(data){
					//关闭对话框
					d.dialog("close");
				});
				
				
			}
		},{
			text:"取消",
			iconCls:"icon-cancel",
			handler:function(){
				d.dialog("close");
			}
		}]
	});
	
}


/**
 * 设置查询条件
 */
function setRoleCondtion(){
	$("#roleList").datagrid("reload",{
		
	});
}

/**
 * 重置条件
 */
function resetRoleCondition(){
	$("#roleconditionForm").form("clear");
}

function editRole(){
	//获取选中的行，只要第一次
	var selRow = $("#roleList").datagrid("getSelected");
	if(selRow == null){
		$.messager.alert("提示","必须选择要编辑的数据","warning");
		return;
	}
	//去掉其他的选中行
	$("#roleList").datagrid("clearSelections");
	// 调用这个方法必须配置idField属性
	$("#roleList").datagrid("selectRecord",selRow.roleId);
	
	
	
	var d = $("<div></div>").appendTo("body");
	d.dialog({
		title : "编辑角色",
		iconCls : "icon-edit",
		width:400,
		height:300,
		modal : true,
		href : "sys/role/role.jsp",
		onLoad:function(){
			//发送一个异步请求，加载数据
			$.post("sys/role_toedit.action",{"role.roleId":selRow.roleId},function(data){
				//转换数据
				var d = {};
				//foreach语法：
				// object：ｋｅｙ代表的是属性
				// array: 代表循环变量
				// string : 代表一个一个的字符
				for(var key in data){
					d["role."+key] = data[key];
					//如果属性是object类型
					if(typeof data[key] == "object"){
						for(var e in data[key]){
							d["role."+key+"."+e] = data[key][e];
						}
					}
				}
				//让表单显示数据
				$("#roleForm").form("load",d);
			});
		},
		onClose:function(){$(this).dialog("destroy");},
		buttons:[{
			text : "确定",
			iconCls:"icon-ok",
			handler:function(){
				$("#roleForm").form("submit",{
					url : "sys/role_edit.action",
					success:function(data){
						if(typeof data == "string"){
							data = eval("("+data+")");
						}
						if(data.result == true){
							d.dialog("close");
							$("#roleList").datagrid("reload");
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
function addRole(){
	var d = $("<div></div>").appendTo("body");
	d.dialog({
		title : "添加角色",
		iconCls : "icon-add",
		width:400,
		height:300,
		modal : true,
		href : "sys/role/role.jsp",
		onClose:function(){$(this).dialog("destroy");},
		buttons:[{
			text : "确定",
			iconCls:"icon-ok",
			handler:function(){
				$("#roleForm").form("submit",{
					url : "sys/role_add.action",
					success:function(data){
						if(typeof data == "string"){
							data = eval("("+data+")");
						}
						if(data.result == true){
							d.dialog("close");
							$("#roleList").datagrid("reload");
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
function deleteRole(){
	//获取选中的记录
	var selRows = $("#roleList").datagrid("getSelections");
	//如果没有选中，提示
	if(selRows.length == 0){
		$.messager.alert("提示","必须选择要删除的行","warning");
		return;
	}
	$.messager.confirm("提示","删除角色此角色中的用户也将删除，同意吗?",function(r){
		if(r){
			var postData = {};
			$.each(selRows,function(i){
				postData["ids["+i+"]"] = this.roleId;
			});
			//发送异步请求去删除数据
			$.post("sys/role_delete.action",postData,function(data){
				//成功了就刷新datagrid
				if(data.result == true){
					$("#roleList").datagrid("reload");
				}
			});
		}
	});
	
}







