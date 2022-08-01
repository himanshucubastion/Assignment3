package com.assign3.Assignment3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assign3.Assignment3.entity.Assignment;
import com.assign3.Assignment3.entity.Task;

public interface AssignmentRepo extends JpaRepository<Assignment, Long>{

	List<Assignment> findByUserId(long userId);
	
	@Query(value="select a.id, a.assignName, t.id,t.taskName,t.description, t.total "
			+ "from assignment a full join task t on a.id=t.assignId",nativeQuery=true)
	List<Assignment> findAllAssign();
	
	@Query(value="select a.id, a.assignName from assignment a", nativeQuery=true)
	List<Assignment> findOnlyAssignName();

}


