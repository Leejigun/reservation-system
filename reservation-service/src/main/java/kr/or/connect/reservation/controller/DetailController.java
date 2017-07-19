package kr.or.connect.reservation.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.dto.DetailBottom;
import kr.or.connect.reservation.dto.DetailTop;
import kr.or.connect.reservation.dto.UserComment;
import kr.or.connect.reservation.service.impl.DetailServiceImpl;

@RestController
@RequestMapping("/details")
public class DetailController {
	
	@Autowired
	DetailServiceImpl detailServiceImpl;
	
	@GetMapping("/top/{id}")
	public Collection<DetailTop> getDetailTop(@PathVariable Integer id)
	{
		return detailServiceImpl.getDetailtop(id);
	}
	
	@GetMapping("/comment/{id}")
	public Collection<UserComment> getUserComment(@PathVariable Integer id)
	{
		return detailServiceImpl.getUserComment(id);
	}
	
	@GetMapping("/image/{id}")
	public Collection<CommentImage> getCommentImage(@PathVariable Integer id)
	{
		return detailServiceImpl.getUserCommentImage(id);
	}
	
	@GetMapping("/content/{id}")
	public DetailBottom getDetailBottomContent(@PathVariable Integer id)
	{
		return detailServiceImpl.getDetailContent(id);
	}

}
