 package org.hr_xiangmu.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hr_xiangmu.dao.TrainDao;
import org.hr_xiangmu.entity.Train;
import org.hr_xiangmu.utils.BaseHibernateDao;
import org.hr_xiangmu.utils.HibernateSessionFactory;



public class TrainDaoImpl extends BaseHibernateDao<Train> implements TrainDao {
	@Override
	public List<Train> getAllTrains(){
		return super.getAll();
	}
	
	@Override
	public void addTrain(Train train) {
		super.save(train);
	}

	@Override
	public void updateTrain(Train train) {
		super.update(train);
	}

	@Override
	public Train getTrainById(Integer id) {
		return super.get(id);
	}

	@Override
	public void deleteTrainById(Integer id) {
		super.delete(id);
	}
	
	@Override
	public void setCondition(Criteria criteria, Train condition) {
		if(condition != null) {
			String trainname = condition.getTrainName();
			if(!StringUtils.isEmpty(trainname)) {
				criteria.add(Restrictions.ilike("trainName", trainname,MatchMode.ANYWHERE));
			}
			
			String trainId = condition.getTrainState();
			if(trainId!=null && !trainId.equals("")) {
				criteria.add(Restrictions.eq("trainState", trainId));
			}
			
			Date train_beginDate = condition.getTrain_BeginDate();
			Date train_endDate = condition.getTrain_EndDate();
			if(train_beginDate!=null&&train_endDate!=null){
				criteria.add(Restrictions.between("trainDate", train_beginDate, train_endDate));
			}
			
		}
	}

	@Override
	public List<Train> getTrains(int pageNo, int pageSize, Train condition,
			String propertyName, String orderBy) {
		return super.getPageList(pageNo, pageSize, condition, propertyName, orderBy);
	}

	@Override
	public Integer getCountOfTrain(Train condition) {
		return super.getCount(condition);
	}

	

}




