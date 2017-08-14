package kr.or.connect.reservation.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

<<<<<<< HEAD
import kr.or.connect.reservation.dto.ReserveInfo;


public interface ReserveService {
	
	public List<ReserveInfo> getReserveInfo(Integer id);
	public Map<String, Object> getInfo(HttpServletRequest request);
=======
import kr.or.connect.reservation.domain.ReserveInfo;


public interface ReserveService {
	List<ReserveInfo> getReserveInfo(Integer id);
	Map<String, Object> getInfo(HttpServletRequest request);

>>>>>>> B_SungJiHyun_bb
}
