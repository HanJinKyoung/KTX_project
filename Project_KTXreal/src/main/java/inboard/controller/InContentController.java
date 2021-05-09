package inboard.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import inboard.model.InBoardBean;
import inboard.model.InBoardDao;

@Controller
public class InContentController {
	private final String command = "/incontent.ib";
	private final String getPage = "Incontent";
	
	@Autowired
	private InBoardDao idao;
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public ModelAndView content(
			@RequestParam(value="i_num", required=true) int i_num,
			@RequestParam(value="pageNumber", required=true) int pageNumber) {
		idao.upCount(i_num);
		InBoardBean inboard = idao.getData(i_num);
		
		String uploadPath = servletContext.getRealPath("/resources/upload/");
		String filename = inboard.getI_filename();
		String root = uploadPath+filename;
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("inboard", inboard);
		mav.addObject("pageNumber", pageNumber);
		mav.addObject("root", root);
		mav.setViewName(getPage);
		return mav;
	}
	
}