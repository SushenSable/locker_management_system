package com.wc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wc.domain.Locker;

public interface LockerDao  extends JpaRepository<Locker, Integer>{
	List<Locker> findByStatus(String status);
	Locker findByIdAndPassword(Integer id,String password);
}
