/**
 * Title管理的js脚本
 */
$(function(){
	$("#titleList").datagrid({
		title : "职称列表",
		iconCls : "icon-search",
		url : "sys/title_list.action",
		fitColumns:true, //列填充满表格
		pagination : true,
		pageList : [5,10,15,20],
		pageSize : 5,
		rownumbers : true, //是否显示行号
		striped : true,
		showHeader:true,
		idField:"id",
		columns : [[
		            {field:'hello', checkbox:true},
		            {field:"titleId", title:"职称编号", width:30},
		            {field:"titleName", title:"职称名称", width:30},
		            {field:"position.positionName", title:"职位", width:30, formatter:function(value,row,index){
		            	if(row.position){
		            		return row.position.positionName;
		            	} 
		            }},
		            {field:"orgenization.text", title:"所属部门", width:30, formatter:function(value,row,index){
		            	if(row.orgenization){
		            		return row.orgenization.text;
		            	} 
		            }},
		            {field:"titleDesc", title:"职称描述", width:30},
		            {field:"titleRemark", title:"职称备注", width:30},
		            {field:"titleIstrue", title:"是否启用", width:20,formatter:function(value,row,index){
		            	if(row.titleIstrue){
		            		return "<input type = 'checkbox' checked='checked' disabled='disabled'/>";
		            	}
		            	return "<input type = 'checkbox' disabled='disabled'/>";
		            }}
		]],
		loadFilter : function(data){
			var d = {total:0, rows:[]};
			d.total = data.total;
			d.rows = data.titleList;
			return d;
		},
		toolbar:[{
			iconCls:"icon-add",
			text : "添加",
			handler:function(){
				addTitle();
			}
		},{
			iconCls:"icon-edit",
			text : "编辑",
			handler:function(){
				editTitle();
			}
		},{
			iconCls:"icon-remove",
			text : "删除",
			handler:function(){
				deleteTitle();
			}
		}]
	});
})

/**
 * 设置查询条件
 */
function setTitleCondtion(){
	$("#titleList").datagrid("reload",{
		
	});
}

/**
 * 重置条件
 */
function resetTitleCondition(){
	$("#titleconditionForm").form("clear");
}

function editTitle(){
	//获取选中的行，只要第一次
	var selRow = $("#titleList").datagrid("getSelected");
	if(selRow == null){
		$.messager.alert("提示","必须选择要编辑的数据","warning");
		return;
	}
	//去掉其他的选中行
	$("#titleList").datagrid("clearSelections");
	// 调用这个方法必须配置idField属性
	$("#titleList").datagrid("selectRecord",selRow.titleId);
	
	
	
	var d = $("<div></div>").appendTo("body");
	d.dialog({
		title : "编辑职称",
		iconCls : "icon-edit",
		width:350,
		height:400,
		modal : true,
		href : "sys/title/title.jsp",
		onLoad:function(){
			//发送一个异步请求，加载数据
			$.post("sys/title_toedit.action",{"title.titleId":selRow.titleId},function(data){
				//转换数据
				var d = {};
				//foreach语法：
				// object：ｋｅｙ代表的是属性
				// array: 代表循环变量
				// string : 代表一个一个的字符
				for(var key in data){
					d["title."+key] = data[key];
					//如果属性是object类型
					if(typeof data[key] == "object"){
						for(var e in data[key]){
							d["title."+key+"."+e] = data[key][e];
						}
					}
				}
				//让表单显示数据
				$("#titleForm").form("load",d);
			});
		},
		onClose:function(){$(this).dialog("destroy");},
		buttons:[{
			text : "确定",
			iconCls:"icon-ok",
			handler:function(){
				$("#titleForm").form("submit",{
					url : "sys/title_edit.action",
					success:function(data){
						if(typeof data == "string"){
							data = eval("("+data+")");
						}
						if(data.result == true){
							d.dialog("close");
							$("#titleList").datagrid("reload");
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
function addTitle(){
	var d = $("<div></div>").appendTo("body");
	d.dialog({
		title : "添加职称",
		iconCls : "icon-add",
		width:350,
		height:400,
		modal : true,
		href : "sys/title/title.jsp",
		onClose:function(){$(this).dialog("destroy");},
		buttons:[{
			text : "确定",
			iconCls:"icon-ok",
			handler:function(){
				$("#titleForm").form("submit",{
					url : "sys/title_add.action",
					success:function(data){
						if(typeof data == "string"){
							data = eval("("+data+")");
						}
						if(data.result == true){
							d.dialog("close");
							$("#titleList").datagrid("reload");
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
function deleteTitle(){
	//获取选中的记录
	var selRows = $("#titleList").datagrid("getSelections");
	//如果没有选中，提示
	if(selRows.length == 0){
		$.messager.alert("提示","必须选择要删除的行","warning");
		return;
	}
	$.messager.confirm("提示","你确定要删除这些记录吗?",function(r){
		if(r){
			var postData = {};
			$.each(selRows,function(i){
				postData["ids["+i+"]"] = this.titleId;
			});
			//发送异步请求去删除数据
			$.post("sys/title_delete.action",postData,function(data){
				//成功了就刷新datagrid
				if(data.result == true){
					$("#titleList").datagrid("reload");
				}
			});
		}
	});
	
}







