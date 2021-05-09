package kboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kboard.model.KBoardBean;
import kboard.model.KBoardDao;

@Controller
public class NoticeController {
	private final String command = "notice.kbd";
	private final String getPage = "notice";
	
	@Autowired
	private KBoardDao kbdao;
	
	@RequestMapping(value=command)
	public ModelAndView doAction() {      
		List<KBoardBean> klists = kbdao.getmainklist();
		ModelAndView mav = new ModelAndView();
		mav.addObject("klists", klists);		
		mav.setViewName(getPage);
		return mav;   
	}
}
