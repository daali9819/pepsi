package org.hr_xiangmu.dao;

import java.util.List;

import org.hr_xiangmu.entity.Train;

public interface TrainDao {
	public List<Train> getAllTrains();
	
	public void addTrain(Train train);
	
	public void updateTrain(Train train);
	
	public Train getTrainById(Integer id);
	
	public void deleteTrainById(Integer id);
	
	public List<Train> getTrains(int pageNo, int pageSize, Train condition, String propertyName, String orderBy);
	
	public Integer getCountOfTrain(Train condtion);

}











