package com.wc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.wc.domain.Locker;
import com.wc.domain.User;
import com.wc.repo.LockerDao;
import com.wc.repo.UserRepo;
import com.wc.service.LockerService;

public class LockerServiceImpl implements LockerService {

	@Autowired
	LockerDao lockerRepo;
	@Autowired
	UserRepo userRepo;

	@Override
	public List<Locker> getAvailableLockers() {
		return lockerRepo.findByStatus(Locker.FREE);

	}

	@Override
	public String bookLocker(Locker locker) {
		String validation = validateReq(locker);
		if (validation != null)
			return validation;

		Optional<Locker> optional = lockerRepo.findById(locker.getId());
		if (optional.isPresent() && Locker.FREE.equals(optional.get().getStatus())) {
			User save = userRepo.save(locker.getUserDetails());
			locker.setUserDetails(save);
			lockerRepo.save(locker);
			return "Boooked Successfully";
		}
		return "Locker not found or allready BOOKED with given id,Please try again with valid locker id";
	}

	private String validateReq(Locker locker) {
		if (!StringUtils.hasLength(locker.getPassword()))
			return "Passowr Not Found";
		if (locker.getUserDetails() == null)
			return "User Details are missing";
		return null;
	}

	@Override
	public String checkOutLocker(Integer id, String password) {
		if (!StringUtils.hasLength(password))
			return "Password should not be null";
		Locker locker = lockerRepo.findByIdAndPassword(id, password);
		if (locker != null && Locker.BOOKED.equals(locker.getStatus())) {
			locker.setStatus(Locker.FREE);
			locker.setBookedDate(null);
			locker.setUserDetails(null);
			lockerRepo.save(locker);
			return "CheckOut Success";
		}

		return "Lock Not found with provided id and password";
	}

}
