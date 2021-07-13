package com.newlecture.web.controller.admin.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

@Controller("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class NoticeController {

	@Autowired
	private NoticeService service;		//controller 가 필요로 하는 interface

	@RequestMapping("list")
	public String list() {

		List<NoticeView> list = service.getViewList();

		return "admin.board.notice.list";
	}

	@RequestMapping("detail")
	public String detail() {

		Notice notice = service.getView(1);
		return "admin.board.notice.detail";
	}

	@RequestMapping("reg")
	public String reg() {
		return "admin.board.notice.reg";
	}
}
