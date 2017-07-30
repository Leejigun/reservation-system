package kr.or.reservation.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.reservation.dao.FileDao;
import kr.or.reservation.dao.ImgDao;
import kr.or.reservation.domain.FileDomain;
import kr.or.reservation.dto.ImgDTO;
import kr.or.reservation.service.ImgService;

@Service
public class ImgServiceImpl implements ImgService {

	ImgDao imgDao;
	FileDao fileDao;

	@Autowired
	public void setImgDao(ImgDao imgDao) {
		this.imgDao = imgDao;
	}

	@Autowired
	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}

	@Override
	public List<ImgDTO> selectList(int id) {
		// TODO Auto-generated method stub
		if (id > 0) {
			return imgDao.selectList(id);
		}
		return null;
	}

	@Override
	public ImgDTO selectOne(long fileId) {
		if (fileId > 0) {
			return imgDao.selectOne(fileId);
		}
		return null;
	}

	@Override
	public boolean insertFileArray(FileDomain[] files) {
		if (files == null) {
			return false;
		}
		return fileDao.insertArray(files);
	}

}
