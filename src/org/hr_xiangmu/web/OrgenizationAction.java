﻿package org.hr_xiangmu.web;

import java.util.List;

import org.hr_xiangmu.dao.OrgenizationDao;
import org.hr_xiangmu.dao.impl.OrgenizationDaoImpl;
import org.hr_xiangmu.entity.Orgenization;

import com.opensymphony.xwork2.ActionSupport;

public class OrgenizationAction extends ActionSupport {
	private OrgenizationDao orgenizationDao = new OrgenizationDaoImpl();
	
	private Integer total; //总数据条数
	
	private List<Orgenization> orgenizationList; //用户列表
	
	private Integer page; //当前页
	
	private Integer rows; //每页显示的数据条数
	
	private String order; //升续还是降续
	
	private String sort; //属性
	
	private Orgenization condition; //封装查询条件
	
	private List<Integer> ids; //要删除的记录编号集合
	
	private Boolean result = false; //标示属性
	
	private Orgenization orgenization; //封装用户信息

	public Orgenization getOrgenization() {
		return orgenization;
	}

	public void setOrgenization(Orgenization orgenization) {
		this.orgenization = orgenization;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public Orgenization getCondition() {
		return condition;
	}

	public void setCondition(Orgenization condition) {
		this.condition = condition;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<Orgenization> getOrgenizationList() {
		return orgenizationList;
	}

	public void setOrgenizationList(List<Orgenization> orgenizationList) {
		this.orgenizationList = orgenizationList;
	}
	
	public String search() throws Exception {
		orgenizationList = orgenizationDao.getAllOrgenizations();
		return "search";
	}
	
	public String list() throws Exception {
		orgenizationList = orgenizationDao.getOrgenizations(1, Integer.MAX_VALUE, condition, null, null);
		total = orgenizationDao.getCountOfOrgenization(condition);
//		//去掉不启用的
//		if(condition != null){
//			if(condition.getOrganizationIstrue()){
//				//循环第一层
//				for (int i = 0; i < orgenizationList.size(); i++) {
//					Orgenization o = orgenizationList.get(i);
//					//循环第二层
//					for (int j = 0; j < o.getChildren().size(); j++) {
//						Orgenization or = o.getChildren().get(j);
//						//判断第二层中的是否有不启动的
//						if(!or.getOrganizationIstrue()){
//							//删除不启用的数据
//							o.getChildren().remove(or);
//						}else{
//							//如果第二层没有不启用，这是循环第三层
//							for (int k = 0; k < or.getChildren().size(); k++) {
//								Orgenization tion = or.getChildren().get(k);
//								if(!tion.getOrganizationIstrue()){
//									//删除第三层不启用的
//									or.getChildren().remove(tion);
//								}
//								
// 							}
//						}
//					}
// 				}
//			}
//			if(!condition.getOrganizationIstrue()){
//				//循环第一层
//				for (int i = 0; i < orgenizationList.size(); i++) {
//					Orgenization o = orgenizationList.get(i);
//					//循环第二层
//					for (int j = 0; j < o.getChildren().size(); j++) {
//						Orgenization or = o.getChildren().get(j);
//						//判断第二层中的是否有启动的
//						if(or.getOrganizationIstrue()){
//							System.out.println(or.getText());
//							//删除启用的数据
//							o.getChildren().remove(or);
//						}else{
//							//如果第二层没有启用，这是循环第三层
//							for (int k = 0; k < or.getChildren().size(); k++) {
//								Orgenization tion = or.getChildren().get(k);
//								if(tion.getOrganizationIstrue()){
//									//删除第三层启用的
//									or.getChildren().remove(tion);
//								}
//								
// 							}
//						}
//					}
// 				}
//			}
//		}
		
		if(condition != null){
			if(condition.getOrganizationIstrue() != null){
				//这是把没有启用的在集合中删除掉
				if(condition.getOrganizationIstrue()){
					//循环第一层的集合
					for(int i = 0; i< orgenizationList.size();i++){
						Orgenization o = orgenizationList.get(i);
						//循环第二层的子集合
						for (int j = 0; j < o.getChildren().size(); j++) {
							Orgenization orgen = o.getChildren().get(j);
							//判断第二层是否有不启用的
							if(!orgen.getOrganizationIstrue()){
								//从第二层集合中移除不启用的
								o.getChildren().remove(orgen);
							}
							if(orgen.getOrganizationIstrue()){
								//循环第三层的子集合
								for (int k = 0; k < orgen.getChildren().size(); k++) {
									Orgenization ooo = orgen.getChildren().get(k);
									if(!ooo.getOrganizationIstrue()){
										//从第三层集合中移除不启用的
										orgen.getChildren().remove(ooo);
									}
									
								}
							}
						}
					}
				}else {
					//这是把启用的在集合中删除掉
					for(int i = 0; i< orgenizationList.size();i++){
						Orgenization o = orgenizationList.get(i);
						//循环第二层的子集合
						for (int j = 0; j < o.getChildren().size(); j++) {
							Orgenization orgen = o.getChildren().get(j);
							//判断第二层是否有启用的
							if(orgen.getOrganizationIstrue()){
								System.out.println(orgen.getText()+"\t"+orgen.getOrganizationIstrue()+"\t你将去掉");
								//从第二层集合中移除启用的
								o.getChildren().remove(orgen);
								j--;
							}
							if(!orgen.getOrganizationIstrue()){
								//循环第三层的子集合
								for (int k = 0; k < orgen.getChildren().size(); k++) {
									Orgenization ooo = orgen.getChildren().get(k);
									if(ooo.getOrganizationIstrue()){
										//从第三层集合中移除不启用的
										//orgen.getChildren().remove(ooo);
										//k--;
									}
									
								}
							}
						}
					}
				}
			}
		}
		
		
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		if(ids != null) {
			for (Integer id : ids) {
				orgenizationDao.deleteOrgenizationById(id);
			}
		}
		result = true;
		return "biaoshi";
	}
	
	public String add() throws Exception {
		if(orgenization.getOrganizationIstrue() == null){
			orgenization.setOrganizationIstrue(false);
		}
		orgenizationDao.addOrgenization(orgenization);
		result = true;
		return "biaoshi";
	}
	
	public String toedit() throws Exception {
		orgenization = orgenizationDao.getOrgenizationById(orgenization.getOrgenizationId());
		return "edit";
	}
	
	public String edit() throws Exception {
		if(orgenization.getOrganizationIstrue() == null){
			orgenization.setOrganizationIstrue(false);
		}
		orgenizationDao.updateOrgenization(orgenization);
		result = true;
		return "biaoshi";
	}
	
	public String getfu() throws Exception {
		orgenizationList = orgenizationDao.orgenizations();
		return "getfu";
	}
}













