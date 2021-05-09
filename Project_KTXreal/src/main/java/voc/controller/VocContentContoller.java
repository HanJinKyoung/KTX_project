package voc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import voc.model.VocBean;
import voc.model.VocDao;


@Controller
public class VocContentContoller {
	private final String command = "/voccontent.vd";
	private final String getPage = "voccontent";
	
	@Autowired
	private VocDao vdao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public ModelAndView content(
			@RequestParam(value="q_num", required=true) int q_num,
			@RequestParam(value="pageNumber", required=true) int pageNumber) {
		VocBean voc = vdao.getContent(q_num);
		ModelAndView mav = new ModelAndView();
		mav.addObject("voc", voc);
		mav.addObject("pageNumber", pageNumber);
		mav.setViewName(getPage);
		return mav;
	}
}
	
	
	

