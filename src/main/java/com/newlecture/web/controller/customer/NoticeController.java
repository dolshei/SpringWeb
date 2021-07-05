package com.newlecture.web.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

@Controller
@RequestMapping("/customer/notice/")
public class NoticeController {

	@Autowired
	private NoticeService service;

	@RequestMapping("list")
	public String list(Model model) {

		List<NoticeView> list = service.getList();

		model.addAttribute("list", list);
		//return "customer/notice/list";
		return "customer.notice.list";
	}

	@RequestMapping("detail")
	public String detail() {
		return "customer.notice.detail";
	}
}
