package lost.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lost.model.LostBean;
import lost.model.LostDao;

@Controller
public class LostDeleteController {
	private final String command = "lostdelete.lt";
	private final String gotoPage = "redirect:/lostlist.lt";
	@Autowired
	private LostDao ldao;
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(command)
	public String delete(
			@RequestParam(value = "pageNumber", required = true) int pageNumber,
			@RequestParam(value = "l_num", required = true) int l_num,
			Model model) {
		LostBean lbean = ldao.getData(l_num);
		
		String filePath = servletContext.getRealPath("/resources/uploadlost/");
		File file = new File(filePath+File.separator+lbean.getL_image());
		file.delete();
		
		ldao.deletaData(l_num);
		int recordcount = ldao.getArticleCount();
		int pageCount = recordcount / 10 + (recordcount % 10 == 0 ? 0 : 1);
		
		model.addAttribute("pageCount", pageCount);
		return gotoPage + "?pageNumber=" + pageNumber;
		
	}
}
