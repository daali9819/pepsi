/**
 * Position管理的js脚本
 */
$(function(){
	$("#positionList").datagrid({
		title : "职位列表",
		iconCls : "icon-search",
		url : "sys/position_list.action",
		fitColumns:true, //列填充满表格
		pagination : true,
		pageList : [5,10,15,20],
		pageSize : 5,
		rownumbers : true, //是否显示行号
		striped : true,
		showHeader:true,
		idField:"positionId",
		columns : [[
		            {field:'hello', checkbox:true},
		            {field:"positionId", title:"编号", width:10},
		            {field:"positionName", title:"名称", width:30},
		            {field:"position.orgenization.text",title:"所属部门",width:30,formatter:function(value,row,index){
		            	if(row.orgenization){
		            		return row.orgenization.text;
		            	}
		            	
		            }},
		            {field:"positionType", title:"分类", width:30},
		            {field:"positionIstrue", title:"是否启用", width:20,formatter:function(value,row,index){
		            	if(row.positionIstrue){
		            		return "<input type = 'checkbox' checked='checked' disabled='disabled'/>";
		            	}
		            	return "<input type = 'checkbox' disabled='disabled'/>";
		            }}
		]],
		loadFilter : function(data){
			var d = {total:0, rows:[]};
			d.total = data.total;
			d.rows = data.positionList;
			return d;
		},
		toolbar:[{
			iconCls:"icon-add",
			text : "添加",
			handler:function(){
				addPosition();
			}
		},{
			iconCls:"icon-edit",
			text : "编辑",
			handler:function(){
				editPosition();
			}
		},{
			iconCls:"icon-remove",
			text : "删除",
			handler:function(){
				deletePosition();
			}
		}]
	});
})

/**
 * 设置查询条件
 */
function setPositionCondtion(){
	$("#positionList").datagrid("reload",{
		
	});
}

/**
 * 重置条件
 */
function resetPositionCondition(){
	$("#positionconditionForm").form("clear");
}

function editPosition(){
	//获取选中的行，只要第一次
	var selRow = $("#positionList").datagrid("getSelected");
	if(selRow == null){
		$.messager.alert("提示","必须选择要编辑的数据","warning");
		return;
	}
	//去掉其他的选中行
	$("#positionList").datagrid("clearSelections");
	// 调用这个方法必须配置idField属性
	$("#positionList").datagrid("selectRecord",selRow.positionId);
	
	
	
	var d = $("<div></div>").appendTo("body");
	d.dialog({
		title : "编辑职位",
		iconCls : "icon-edit",
		width:700,
		height:400,
		modal : true,
		href : "sys/position/position.jsp",
		onLoad:function(){
			//发送一个异步请求，加载数据
			$.post("sys/position_toedit.action",{"position.positionId":selRow.positionId},function(data){
				//转换数据
				var d = {};
				//foreach语法：
				// object：ｋｅｙ代表的是属性
				// array: 代表循环变量
				// string : 代表一个一个的字符
				for(var key in data){
					d["position."+key] = data[key];
					//如果属性是object类型
					if(typeof data[key] == "object"){
						for(var e in data[key]){
							d["position."+key+"."+e] = data[key][e];
						}
					}
				}
				//让表单显示数据
				$("#positionForm").form("load",d);
			});
		},
		onClose:function(){$(this).dialog("destroy");},
		buttons:[{
			text : "确定",
			iconCls:"icon-ok",
			handler:function(){
				$("#positionForm").form("submit",{
					url : "sys/position_edit.action",
					success:function(data){
						if(typeof data == "string"){
							data = eval("("+data+")");
						}
						if(data.result == true){
							d.dialog("close");
							$("#positionList").datagrid("reload");
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
function addPosition(){
	var d = $("<div></div>").appendTo("body");
	d.dialog({
		title : "添加职位",
		iconCls : "icon-add",
		width:500,
		height:400,
		modal : true,
		href : "sys/position/position.jsp",
		onClose:function(){$(this).dialog("destroy");},
		buttons:[{
			text : "确定",
			iconCls:"icon-ok",
			handler:function(){
				$("#positionForm").form("submit",{
					url : "sys/position_add.action",
					success:function(data){
						if(typeof data == "string"){
							data = eval("("+data+")");
						}
						if(data.result == true){
							d.dialog("close");
							$("#positionList").datagrid("reload");
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
function deletePosition(){
	//获取选中的记录
	var selRows = $("#positionList").datagrid("getSelections");
	//如果没有选中，提示
	if(selRows.length == 0){
		$.messager.alert("提示","必须选择要删除的行","warning");
		return;
	}
	$.messager.confirm("提示","你确定要删除这些记录吗?",function(r){
		if(r){
			var postData = {};
			$.each(selRows,function(i){
				postData["ids["+i+"]"] = this.positionId;
			});
			//发送异步请求去删除数据
			$.post("sys/position_delete.action",postData,function(data){
				//成功了就刷新datagrid
				if(data.result == true){
					$("#positionList").datagrid("reload");
				}
			});
		}
	});
	
}







