package com.wc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wc.domain.Locker;
import com.wc.service.LockerService;

/**
 * 
 * @author Sushen
 * 
 *         This controller is only for check, book, and checkout the lock lock
 *         will be created by only management that will be the different
 *         controller
 *
 */
@RestController
public class LockerController {
	@Autowired
	LockerService lockerService;

	@GetMapping("/availableLockers")
	public List<Locker> getAvailableLocker() {
		try {
			return lockerService.getAvailableLockers();
		} catch (Exception e) {
			System.err.println("Error while fetching available lockers : " + e.getMessage());
			return new ArrayList<Locker>();
		}
	}

	@PostMapping("/locke")
	public String bookLocker(@RequestBody Locker locker) {
		try {
			return lockerService.bookLocker(locker);
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	@PostMapping("/chekcout")
	public String checkout(@RequestParam("id") Integer id, @RequestParam("password") String password) {
		try {
			return lockerService.checkOutLocker(id, password);
		} catch (Exception e) {
			return e.getMessage();
		}

	}

}
