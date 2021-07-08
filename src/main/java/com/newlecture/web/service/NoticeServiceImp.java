package com.newlecture.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;


@Service
public class NoticeServiceImp implements NoticeService {

	@Autowired
	private NoticeDao noticeDao;

//	@Override
//	public List<NoticeView> getViewList() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<NoticeView> getViewList(String field, String query) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<NoticeView> getViewList(int page, String field, String query) {
		
		int size = 10;
		int offset = 0+(page-1)*size;

		List<NoticeView> list = noticeDao.getList(offset, size, field, query);
		return list;
	}


//	@Override
//	public List<NoticeView> getViewList(int page, String field, String query) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public int getCount(String field, String query) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePubAll(int[] pubIds, int[] closeIds) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public NoticeView getView(int id) {

		NoticeView notice = noticeDao.getView(id);

		return notice;
	}

	@Override
	public Notice getNext(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notice getPrev(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}


}
