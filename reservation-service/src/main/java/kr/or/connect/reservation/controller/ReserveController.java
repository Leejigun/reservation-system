package kr.or.connect.reservation.controller;

<<<<<<< HEAD
import java.util.HashMap;
=======
>>>>>>> B_SungJiHyun_bb
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
<<<<<<< HEAD
import javax.servlet.http.HttpSession;

=======

import kr.or.connect.reservation.service.ReserveService;
>>>>>>> B_SungJiHyun_bb
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
<<<<<<< HEAD

import kr.or.connect.reservation.dto.ReserveInfo;
=======
import kr.or.connect.reservation.domain.ReserveInfo;
import kr.or.connect.reservation.service.ReserveService;
>>>>>>> B_SungJiHyun_bb
import kr.or.connect.reservation.service.impl.ReserveServiceImpl;

@RestController
@RequestMapping("/reserve")
public class ReserveController {
	
	@Autowired
<<<<<<< HEAD
	ReserveServiceImpl reserveServieImpl;
	
	@GetMapping("/top/{id}")
	public List<ReserveInfo> getReserveInfo(@PathVariable Integer id, HttpServletRequest request) {
=======
	ReserveService reserveServieImpl;
	
	@GetMapping("/top/{id}")
	public List<ReserveInfo> getReserveInfo(@PathVariable Integer id) {
>>>>>>> B_SungJiHyun_bb
		
		return reserveServieImpl.getReserveInfo(id);
		
	}
	
<<<<<<< HEAD
	@GetMapping("/middle")
	public Map<String,Object> getReserverInfo(HttpServletRequest request) {
		
		return reserveServieImpl.getInfo(request);
	}
=======
>>>>>>> B_SungJiHyun_bb
}
