package voc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import voc.model.VocBean;
import voc.model.VocDao;

@Controller
public class VocReplyController {
	
		private final String command = "/vocreplyForm.vd";
		private final String getPage = "vocreplyForm";
		private final String gotoPage = "redirect:/voclist.vd";
		
		@Autowired
		private VocDao vdao;
		
		@RequestMapping(value = command, method = RequestMethod.GET)
		public String doGet(
				@RequestParam("q_num") int q_num,
				@RequestParam("pageNumber") int pageNumber,
				Model model
				) {
			System.out.println("vocref:"+q_num);
			VocBean vbean = vdao.getContent(q_num);
			
			model.addAttribute("vbean", vbean);
			model.addAttribute("pageNumber", pageNumber);
			return getPage;
		}
		@RequestMapping(value = command, method = RequestMethod.POST)
		public String doPost(
				VocBean vbean,
				Model model,
				HttpServletRequest request
				) {
	
			vbean.setQ_ip(request.getRemoteAddr());
			int cnt = 0;
			cnt = vdao.insertReply(vbean);
			if(cnt>0) {
				System.out.println("답변달기 성공");
				return gotoPage;				
			}else {
				System.out.println("답변달기 실패");
				return getPage;
			}
		}
}

