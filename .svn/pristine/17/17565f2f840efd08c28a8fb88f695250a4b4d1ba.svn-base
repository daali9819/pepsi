/**
 * Sysright管理的js脚本
 */
$(function(){
	$("#sysrightList").treegrid({
		title : "权限列表",
		iconCls : "icon-search",
		url : "sys/sysright_list.action",
		fitColumns:true, //列填充满表格
		rownumbers : true, //是否显示行号
		striped : true,
		showHeader:true,
		idField:"sysrightId",
		treeField:"text",
		fit:true,
		animate:true,
		columns : [[
		            {field:'sdsd',checkbox:true},
		            {field:'sysrightId',title:"编号",width:10},
		            {field:"text", title:"名称", width:30},
		            {field:"iconCls", title:"图标", width:30},
		            {field:"url", title:"跳转路径", width:30}
		]],
		loadFilter : function(data){
			var d = {total:0, rows:[]};
			d.total = data.total;
			d.rows = data.sysrightList;
			
			$.each(d.rows,function(){
				this.state = "closed";
			});
			
			
			
			return d;
		},
		toolbar:[{
			iconCls:"icon-add",
			text : "添加",
			handler:function(){
				addSysright();
			}
		},{
			iconCls:"icon-edit",
			text : "编辑",
			handler:function(){
				editSysright();
			}
		},{
			iconCls:"icon-remove",
			text : "删除",
			handler:function(){
				deleteSysright();
			}
		}]
	});
})

/**
 * 设置查询条件
 */
function setSysrightCondtion(){
	$("#sysrightList").datagrid("reload",{
		
	});
}

/**
 * 重置条件
 */
function resetSysrightCondition(){
	$("#sysrightconditionForm").form("clear");
}

function editSysright(){
	//获取选中的行，只要第一次
	var selRow = $("#sysrightList").treegrid("getSelected");
	if(selRow == null){
		$.messager.alert("提示","必须选择要编辑的数据","warning");
		return;
	}
	
	
	
	var d = $("<div></div>").appendTo("body");
	d.dialog({
		title : "编辑权限",
		iconCls : "icon-edit",
		width:330,
		height:360,
		modal : true,
		href : "sys/sysright/sysright.jsp",
		onLoad:function(){
			//发送一个异步请求，加载数据
			$.post("sys/sysright_toedit.action",{"sysright.sysrightId":selRow.sysrightId},function(data){
				//转换数据
				var d = {};
				//foreach语法：
				// object：ｋｅｙ代表的是属性
				// array: 代表循环变量
				// string : 代表一个一个的字符
				for(var key in data){
					d["sysright."+key] = data[key];
					//如果属性是object类型
					if(typeof data[key] == "object"){
						for(var e in data[key]){
							d["sysright."+key+"."+e] = data[key][e];
						}
					}
				}
				//让表单显示数据
				$("#sysrightForm").form("load",d);
			});
		},
		onClose:function(){$(this).dialog("destroy");},
		buttons:[{
			text : "确定",
			iconCls:"icon-ok",
			handler:function(){
				$("#sysrightForm").form("submit",{
					url : "sys/sysright_edit.action",
					success:function(data){
						if(typeof data == "string"){
							data = eval("("+data+")");
						}
						if(data.result == true){
							d.dialog("close");
							$("#sysrightList").treegrid("reload");
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
function addSysright(){
	var d = $("<div></div>").appendTo("body");
	d.dialog({
		title : "添加权限",
		iconCls : "icon-add",
		width:700,
		height:400,
		modal : true,
		href : "sys/sysright/sysright.jsp",
		onClose:function(){$(this).dialog("destroy");},
		buttons:[{
			text : "确定",
			iconCls:"icon-ok",
			handler:function(){
				$("#sysrightForm").form("submit",{
					url : "sys/sysright_add.action",
					success:function(data){
						if(typeof data == "string"){
							data = eval("("+data+")");
						}
						if(data.result == true){
							d.dialog("close");
							$("#sysrightList").treegrid("reload");
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
function deleteSysright(){
	//获取选中的记录
	var selRow = $("#sysrightList").treegrid("getSelected");
	//如果没有选中，提示
	if(selRow == null){
		$.messager.alert("提示","必须选择要删除的行","warning");
		return;
	}
	$.messager.confirm("提示","你确定要删除这些记录吗?,如果是父节点的话，子节点将一起删除",function(r){
		if(r){
			var postData = {};
				//$("#sysrightList").treegrid("remove",this.sysrightId);
			postData["ids["+0+"]"] = selRow.sysrightId;
			
			//发送异步请求去删除数据
			$.post("sys/sysright_delete.action",postData,function(data){
				//成功了就刷新datagrid
				if(data.result == true){
					$("#sysrightList").treegrid("reload");
				}
			});
		}
	});
	
}







