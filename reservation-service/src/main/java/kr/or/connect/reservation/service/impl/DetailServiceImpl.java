package kr.or.connect.reservation.service.impl;

<<<<<<< HEAD
import java.util.Collection;
=======
import java.io.File;
import java.util.Collection;
import java.util.List;
>>>>>>> B_SungJiHyun_bb

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.DetailDao;
<<<<<<< HEAD
import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.dto.DetailBottom;
import kr.or.connect.reservation.dto.DetailTop;
import kr.or.connect.reservation.dto.ImgFile;
import kr.or.connect.reservation.dto.UserComment;
=======
import kr.or.connect.reservation.domain.dto.CommentImage;
import kr.or.connect.reservation.domain.dto.DetailBottom;
import kr.or.connect.reservation.domain.dto.DetailTop;
import kr.or.connect.reservation.domain.dto.UserCommentDto;
>>>>>>> B_SungJiHyun_bb
import kr.or.connect.reservation.service.DetailService;

@Service
public class DetailServiceImpl implements DetailService {
	
	@Autowired
<<<<<<< HEAD
	DetailDao detailDao;

	@Override
	public Collection<DetailTop> getDetailtop(Integer id) {
=======
	private	DetailDao detailDao;

	@Override
	public List<DetailTop> getDetailtop(Integer id) {
>>>>>>> B_SungJiHyun_bb
		// TODO Auto-generated method stub
		return detailDao.selectDetailTop(id);
	}

	@Override
<<<<<<< HEAD
	public ImgFile getFileAddr(Integer id) {
		// TODO Auto-generated method stub
		return detailDao.selectFileAddr(id);
	}

	@Override
	public Collection<UserComment> getUserComment(Integer id) {
=======
	public List<UserCommentDto> getUserComment(Integer id) {
>>>>>>> B_SungJiHyun_bb
		// TODO Auto-generated method stub
		return detailDao.selectComment(id);
	}

	@Override
<<<<<<< HEAD
	public Collection<CommentImage> getUserCommentImage(Integer id) {
=======
	public List<CommentImage> getUserCommentImage(Integer id) {
>>>>>>> B_SungJiHyun_bb
		// TODO Auto-generated method stub
		return detailDao.selectCommentImg(id);
	}

	@Override
	public DetailBottom getDetailContent(Integer id) {
		// TODO Auto-generated method stub
		return detailDao.selectDetailContent(id);
	}
}
