package kr.or.connect.reservation.service;

<<<<<<< HEAD
import java.util.Collection;

import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.dto.DetailBottom;
import kr.or.connect.reservation.dto.DetailTop;
import kr.or.connect.reservation.dto.ImgFile;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.UserComment;

public interface DetailService {
	
	public Collection<DetailTop> getDetailtop(Integer id);
	public ImgFile getFileAddr(Integer id);
	public Collection<UserComment> getUserComment(Integer id);
	public Collection<CommentImage> getUserCommentImage(Integer id);
	public DetailBottom getDetailContent(Integer id);
=======
import java.io.File;
import java.util.Collection;
import java.util.List;

import kr.or.connect.reservation.domain.dto.CommentImage;
import kr.or.connect.reservation.domain.dto.DetailBottom;
import kr.or.connect.reservation.domain.dto.DetailTop;
import kr.or.connect.reservation.domain.dto.UserCommentDto;

public interface DetailService {
	
	List<DetailTop> getDetailtop(Integer id);
	List<UserCommentDto> getUserComment(Integer id);
	List<CommentImage> getUserCommentImage(Integer id);
	DetailBottom getDetailContent(Integer id);
>>>>>>> B_SungJiHyun_bb
}
