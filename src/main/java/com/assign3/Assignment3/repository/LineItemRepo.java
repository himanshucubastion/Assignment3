package com.assign3.Assignment3.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assign3.Assignment3.entity.LineItem;

public interface LineItemRepo extends JpaRepository<LineItem, Long> {

	List<LineItem> findByTaskId(long taskId);
	
	
//	@Query("select sum(l.amount)from line_item l where task_id=:task_id")
//	public double sumOfItems();
	
	

}
