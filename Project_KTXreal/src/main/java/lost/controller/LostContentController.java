package lost.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lost.model.LostBean;
import lost.model.LostDao;

@Controller
public class LostContentController {
	private final String command = "lostcontent.lt";
	private final String getPage = "lostContent";
	
	@Autowired
	private LostDao ldao;
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public ModelAndView content(
			@RequestParam(value="l_num", required=true) int l_num,
			@RequestParam(value="pageNumber", required=true) int pageNumber			
			) {
		LostBean lbean = ldao.getData(l_num);
		
		String uploadPath = servletContext.getRealPath("/resources/uploadlost/");
		String filename = lbean.getL_image();
		String root = uploadPath+filename;
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("lbean", lbean);
		mav.addObject("pageNumber", pageNumber);
		mav.addObject("root", root);
		mav.setViewName(getPage);
		return mav;
	}
}
