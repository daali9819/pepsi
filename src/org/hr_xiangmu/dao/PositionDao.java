package org.hr_xiangmu.dao;

import java.util.List;

import org.hr_xiangmu.entity.Position;

public interface PositionDao {
	public List<Position> getAllPositions();
	
	public void addPosition(Position position);
	
	public void updatePosition(Position position);
	
	public Position getPositionById(Integer id);
	
	public void deletePositionById(Integer id);
	
	public List<Position> getPositions(int pageNo, int pageSize, Position condition, String propertyName, String orderBy);
	
	public Integer getCountOfPosition(Position condtion);
}











