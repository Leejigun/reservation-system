package kr.or.connect.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.UserDao;
<<<<<<< HEAD
import kr.or.connect.reservation.dto.User;
=======
import kr.or.connect.reservation.domain.User;
>>>>>>> B_SungJiHyun_bb
import kr.or.connect.reservation.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
<<<<<<< HEAD
	UserDao userDao;
	
	@Override
	public long addUser(User user) {
		// TODO Auto-generated method stub
=======
	private UserDao userDao;
	
	@Override
	public Integer addUser(User user) {
>>>>>>> B_SungJiHyun_bb
		return userDao.insert(user);
	}

	@Override
	public User getUser(String id) {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		return userDao.SelectUser(id);
=======
		return userDao.selectUser(id);
>>>>>>> B_SungJiHyun_bb
	}
}
