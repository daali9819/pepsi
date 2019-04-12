/**
 * Properties管理的js脚本
 */
$(function(){

	$("#propertiesList").datagrid({
		title : "公共属性列表",
		iconCls : "icon-search",
		url : "sys/properties_list.action",
		fitColumns:true, //列填充满表格
		pagination : true,
		pageList : [5],
		pageSize : 5,
		rownumbers : true, //是否显示行号
		striped : true,
		showHeader:true,
		singleSelect:true,
		idField:"propertiesId",
		onLoadSuccess : function(){
			$(this).datagrid("selectRow",0);
		},
		onSelect : function(rowIndex, rowData){
			//获取到字典表的Id作为条件筛选)
			if(rowData != null){
				
				//alert(d.d_id);
				//重新加载第二个页面
				$("#dierge").datagrid("reload",{
					"condition.properties.propertiesId" : rowData.propertiesId
				});
			};
		},
		columns : [[
		            {field:'hello', checkbox:true},
		            {field:"propertiesId", title:"编号", width:10},
		            {field:"propertiesName", title:"名称", width:30},
		            {field:"propertiesDesc", title:"描述", width:30}
		]],
		loadFilter : function(data){
			var d = {total:0, rows:[]};
			d.total = data.total;
			d.rows = data.propertiesList;
			return d;
		},
		toolbar:[{
			iconCls:"icon-add",
			text : "添加",
			handler:function(){
				addProperties();
			}
		},{
			iconCls:"icon-edit",
			text : "编辑",
			handler:function(){
				editProperties();
			}
		},{
			iconCls:"icon-remove",
			text : "删除",
			handler:function(){
				deleteProperties();
			}
		}]
		
	});

	//第二个datagrid的属性方法
	$("#dierge").datagrid({
		title : "公共属性子项列表",
		iconCls : "icon-search",
		fitColumns:true,//填充列
		url:"sys/propertiesitems_list.action",
		pagination:true,//分页
		pageList:[5],
		pageSize:5,
		singleSelect:true,
		idField:"propertiesItemsId",
		striped:true,
		rownumbers : true, 
		loadFilter:function(data){//参数data表示url返回的属性
			var d = {};//声明json格式变量
			d.total = data.total;
			d.rows = data.propertiesitemsList;
			return d;
		},
		toolbar:[{
			text:"添加",
			iconCls:"icon-add",
			handler:function(){
				//添加方法
				add();
			}		
		},{
			text:"编辑",
			iconCls:"icon-edit",
			handler:function(){
				//修改方法
				edit();
			}	
		},{
			text:"删除",
			iconCls:"icon-remove",
			handler:function(){
				//删除方法
				remove();
			}	
		}]
	});
});

/**
 * 第二个修改
 */
function edit(){
	//获取选中的行，只要第一次
	var selRow = $("#dierge").datagrid("getSelected");
	if(selRow == null){
		$.messager.alert("提示","必须选择要编辑的数据","warning");
		return;
	}
	//去掉其他的选中行
	$("#propertiesitemsList").datagrid("clearSelections");
	// 调用这个方法必须配置idField属性
	$("#propertiesitemsList").datagrid("selectRecord",selRow.propertiesItemsId);
	
	
	var d = $("<div></div>").appendTo("body");
	d.dialog({
		title : "编辑公共属性子项",
		iconCls : "icon-edit",
		width:400,
		height:300,
		modal : true,
		href : "sys/properties/propertiesitems.jsp",
		onLoad:function(){
			//发送一个异步请求，加载数据
			$.post("sys/propertiesitems_toedit.action",{"propertiesitems.propertiesItemsId" : selRow.propertiesItemsId},function(data){
				//转换数据
				var d = {};
				//foreach语法：
				// object：ｋｅｙ代表的是属性
				// array: 代表循环变量
				// string : 代表一个一个的字符
				for(var key in data){
					d["propertiesitems."+key] = data[key];
					//如果属性是object类型
					if(typeof data[key] == "object"){
						for(var e in data[key]){
							d["propertiesitems."+key+"."+e] = data[key][e];
						}
					}
				}
				//让表单显示数据
				$("#propertiesitemsForm").form("load",d);
			});
		},
		onClose:function(){$(this).dialog("destroy");},
		buttons:[{
			text : "确定",
			iconCls:"icon-ok",
			handler:function(){
				$("#propertiesitemsForm").form("submit",{
					url : "sys/propertiesitems_edit.action",
					success:function(data){
						if(typeof data == "string"){
							data = eval("("+data+")");
						}
						if(data.result == true){
							d.dialog("close");
							$("#dierge").datagrid("reload");
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
 * 第二个删除
 */
function remove(){
	//获取选中的记录
	var selRows = $("#dierge").datagrid("getSelections");
	//如果没有选中，提示
	if(selRows.length == 0){
		$.messager.alert("提示","必须选择要删除的行","warning");
		return;
	}
	$.messager.confirm("重要提示","你确定要删除这些记录吗?不建议删除，删除后其他会受影响！！！",function(r){
		if(r){
			var postData = {};
			$.each(selRows,function(i){
				postData["ids["+i+"]"] = this.propertiesItemsId;
			});
			//发送异步请求去删除数据
			$.post("sys/propertiesitems_delete.action",postData,function(data){
				//成功了就刷新datagrid
				if(data.result == true){
					$("#dierge").datagrid("reload");
				}
			});
		}
	});
}



/**
 * 第二个添加
 */	
function add(){
	var d = $("<div></div>").appendTo("body");
	d.dialog({
		title : "添加公共属性子项",
		iconCls : "icon-add",
		width:400,
		height:500,
		modal : true,
		href : "sys/properties/propertiesitems.jsp",
		onClose:function(){$(this).dialog("destroy");},
		buttons:[{
			text : "确定",
			iconCls:"icon-ok",
			handler:function(){
				$("#propertiesitemsForm").form("submit",{
					url : "sys/propertiesitems_add.action",
					success:function(data){
						if(typeof data == "string"){
							data = eval("("+data+")");
						}
						if(data.result == true){
							d.dialog("close");
							$("#dierge").datagrid("reload");
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
 * 设置查询条件
 */
function setPropertiesCondtion(){
	$("#propertiesList").datagrid("reload",{
		
	});
}

/**
 * 重置条件
 */
function resetPropertiesCondition(){
	$("#propertiesconditionForm").form("clear");
}

function editProperties(){
	//获取选中的行，只要第一次
	var selRow = $("#propertiesList").datagrid("getSelected");
	if(selRow == null){
		$.messager.alert("提示","必须选择要编辑的数据","warning");
		return;
	}
	//去掉其他的选中行
	$("#propertiesList").datagrid("clearSelections");
	// 调用这个方法必须配置idField属性
	$("#propertiesList").datagrid("selectRecord",selRow.propertiesId);
	
	
	
	var d = $("<div></div>").appendTo("body");
	d.dialog({
		title : "编辑公共属性",
		iconCls : "icon-edit",
		width:400,
		height:300,
		modal : true,
		href : "sys/properties/properties.jsp",
		onLoad:function(){
			//发送一个异步请求，加载数据
			$.post("sys/properties_toedit.action",{"properties.propertiesId":selRow.propertiesId},function(data){
				//转换数据
				var d = {};
				//foreach语法：
				// object：ｋｅｙ代表的是属性
				// array: 代表循环变量
				// string : 代表一个一个的字符
				for(var key in data){
					d["properties."+key] = data[key];
					//如果属性是object类型
					if(typeof data[key] == "object"){
						for(var e in data[key]){
							d["properties."+key+"."+e] = data[key][e];
						}
					}
				}
				//让表单显示数据
				$("#propertiesForm").form("load",d);
			});
		},
		onClose:function(){$(this).dialog("destroy");},
		buttons:[{
			text : "确定",
			iconCls:"icon-ok",
			handler:function(){
				$("#propertiesForm").form("submit",{
					url : "sys/properties_edit.action",
					success:function(data){
						if(typeof data == "string"){
							data = eval("("+data+")");
						}
						if(data.result == true){
							d.dialog("close");
							$("#propertiesList").datagrid("reload");
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
function addProperties(){
	var d = $("<div></div>").appendTo("body");
	d.dialog({
		title : "添加公共属性",
		iconCls : "icon-add",
		width:500,
		height:300,
		modal : true,
		href : "sys/properties/properties.jsp",
		onClose:function(){$(this).dialog("destroy");},
		buttons:[{
			text : "确定",
			iconCls:"icon-ok",
			handler:function(){
				$("#propertiesForm").form("submit",{
					url : "sys/properties_add.action",
					success:function(data){
						if(typeof data == "string"){
							data = eval("("+data+")");
						}
						if(data.result == true){
							d.dialog("close");
							$("#propertiesList").datagrid("reload");
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
function deleteProperties(){
	//获取选中的记录
	var selRows = $("#propertiesList").datagrid("getSelections");
	//如果没有选中，提示
	if(selRows.length == 0){
		$.messager.alert("提示","必须选择要删除的行","warning");
		return;
	}
	$.messager.confirm("重要提示","你确定要删除这些记录吗?不建议删除，删除后其他会受影响！！！",function(r){
		if(r){
			var postData = {};
			$.each(selRows,function(i){
				postData["ids["+i+"]"] = this.propertiesId;
			});
			//发送异步请求去删除数据
			$.post("sys/properties_delete.action",postData,function(data){
				//成功了就刷新datagrid
				if(data.result == true){
					$("#propertiesList").datagrid("reload");
				}
			});
		}
	});
	
}







