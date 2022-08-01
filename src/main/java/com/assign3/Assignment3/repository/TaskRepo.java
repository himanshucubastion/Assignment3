package com.assign3.Assignment3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assign3.Assignment3.entity.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {

	List<Task> findByAssignId(long assignId);



}
