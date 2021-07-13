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

	//페이지를 요청할 때
	@Override
	public List<NoticeView> getViewList() {
		// TODO Auto-generated method stub
		return getViewList(1, "title", "");
	}

	//검색을 요청할 때
	@Override
	public List<NoticeView> getViewList(String field, String query) {
		// TODO Auto-generated method stub
		return getViewList(1, field, query);
	}
	
	//페이지를 요청할 때
	@Override
	public List<NoticeView> getViewList(int page, String field, String query) {
		
		int size = 10;
		int offset = 0+(page-1)*size;

		List<NoticeView> list = noticeDao.getViewList(offset, size, field, query, false);
		return list;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return getCount("title", "");
	}

	@Override
	public int getCount(String field, String query) {
		// TODO Auto-generated method stub
		return noticeDao.getCount(field, query);
	}

	//일괄 공개를 요청할 때
	@Override
	public int updatePubAll(int[] pubIds, int[] closeIds) {
		// TODO Auto-generated method stub
		return noticeDao.updatePubAll(pubIds, closeIds);
	}

	//일괄 삭제를 요청할 때
	@Override
	public int deleteAll(int[] ids) {
		
		return noticeDao.deleteAll(ids);
	}
	
	//자세한 페이지 요청할 때
	@Override
	public NoticeView getView(int id) {

		NoticeView notice = noticeDao.getView(id);

		return notice;
	}

	@Override
	public Notice getNext(int id) {
		// TODO Auto-generated method stub
		return noticeDao.getNext(id);
	}

	@Override
	public Notice getPrev(int id) {
		// TODO Auto-generated method stub
		return noticeDao.getPrev(id);
	}

	//수정 페이지를 요청할 때
	@Override
	public int update(Notice notice) {
		// TODO Auto-generated method stub
		return noticeDao.update(notice);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return noticeDao.delete(id);
	}

	@Override
	public int insert(Notice notice) {
		// TODO Auto-generated method stub
		return noticeDao.insert(notice);
	}



}
