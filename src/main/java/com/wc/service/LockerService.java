package com.wc.service;

import java.util.List;

import com.wc.domain.Locker;

public interface LockerService {
	public List<Locker>  getAvailableLockers();

	public String bookLocker(Locker locker);
	public String checkOutLocker(Integer id, String password);
}
