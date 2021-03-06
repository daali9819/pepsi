﻿package org.hr_xiangmu.web;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hr_xiangmu.dao.TrainDao;
import org.hr_xiangmu.dao.impl.TrainDaoImpl;
import org.hr_xiangmu.entity.Train;

import com.opensymphony.xwork2.ActionSupport;

public class TrainAction extends ActionSupport {
	private TrainDao trainDao = new TrainDaoImpl();
	
	private Integer total; //总数据条数
	
	private List<Train> trainList; //用户列表
	
	private Integer page; //当前页
	
	private Integer rows; //每页显示的数据条数
	
	private String order; //升续还是降续
	
	private String sort; //属性
	
	private Train condition; //封装查询条件
	
	private List<Integer> ids; //要删除的记录编号集合
	
	private Boolean result = false; //标示属性
	
	private Train train; //封装用户信息
	
	//辅助属性》》开始时间		 结束时间
		private Date train_BeginDate;
		private Date train_EndDate;

		private File data; //文件
		private String dataFileName;

		private String path; //文件的存储路径

		public String getDataFileName() {
			return dataFileName;
		}
		
		public void setDataFileName(String dataFileName) {
			this.dataFileName = dataFileName;
		}

		public File getData() {
				return data;
		}

		public void setData(File data) {
			this.data = data;
		}



		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

	public Date getTrain_BeginDate() {
			return train_BeginDate;
		}

		public void setTrain_BeginDate(Date train_BeginDate) {
			this.train_BeginDate = train_BeginDate;
		}

		public Date getTrain_EndDate() {
			return train_EndDate;
		}

		public void setTrain_EndDate(Date train_EndDate) {
			this.train_EndDate = train_EndDate;
		}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
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

	public Train getCondition() {
		return condition;
	}

	public void setCondition(Train condition) {
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

	public List<Train> getTrainList() {
		return trainList;
	}

	public void setTrainList(List<Train> trainList) {
		this.trainList = trainList;
	}
	
	public String search() throws Exception {
		trainList = trainDao.getAllTrains();
		return "search";
	}
	
	public String list() throws Exception {
		trainList = trainDao.getTrains(page, rows, condition, sort, order);
		total = trainDao.getCountOfTrain(condition);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		if(ids != null) {
			for (Integer id : ids) {
				trainDao.deleteTrainById(id);
		
			}
		}
		result = true;
		return "biaoshi";
	}
	
	public String add() throws Exception {
			
			train.setTrainState("起草");
			trainDao.addTrain(train);
			result = true;
		
		return "biaoshi";
		}
	
	public String toedit() throws Exception {
		
		train = trainDao.getTrainById(train.getTrainId());
		return "edit";
	}
	
	public String edit() throws Exception {
		trainDao.updateTrain(train);
		result = true;
		return "biaoshi";
	}
	
	public String upload() throws Exception {
		String realPath = ServletActionContext.getServletContext().getRealPath("/images");
		if(data != null){
			File dest = new File(realPath + File.separator +dataFileName);
			FileUtils.copyFile(data, dest);
			
			path = "data/"+dataFileName;
		}
		return "uploadSuccess";
	}

}













