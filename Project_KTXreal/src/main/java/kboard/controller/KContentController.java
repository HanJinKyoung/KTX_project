package kboard.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kboard.model.KBoardBean;
import kboard.model.KBoardDao;

@Controller
public class KContentController {
	private final String command = "/content.kbd";
	private final String getPage = "content";
	
	@Autowired
	private KBoardDao kbDao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public ModelAndView content(
			@RequestParam(value="k_num", required=true) int k_num,
			@RequestParam(value="pageNumber", required=true) int pageNumber) {
		kbDao.upCount(k_num);
		KBoardBean kboard = kbDao.getData(k_num);
		ModelAndView mav = new ModelAndView();
		mav.addObject("kboard", kboard);
		mav.addObject("pageNumber", pageNumber);
		mav.setViewName(getPage);
		return mav;
	}
}