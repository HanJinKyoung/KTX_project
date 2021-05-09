package lost.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lost.model.LostBean;
import lost.model.LostDao;

@Controller
public class LostUpdateController {
	private final String command = "lostupdate.lt";
	private final String getPage = "lostUpdate";
	private final String gotoPage = "redirect:/lostlist.lt";
	
	@Autowired
	private LostDao ldao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String lostget(
			@RequestParam(value="l_num", required=true) int l_num,
			@RequestParam(value="pageNumber", required=true) int pageNumber,			
			Model model) {
		LostBean lbean = ldao.getData(l_num);
		model.addAttribute("lbean", lbean);
		model.addAttribute("pageNumber", pageNumber);
		return getPage;
		
	}
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public String lostPost(
			LostBean lbean,
			@RequestParam("pageNumber") int pageNumber,
			Model model,
			HttpServletResponse response
			) throws IllegalStateException, IOException {
		String l_content = ((String)lbean.getL_content()).replace("\r\n","<br>");
		lbean.setL_content(l_content);
		
		String file = lbean.getL_image();
		
		String filePath = servletContext.getRealPath("/resources/uploadlost/");
		
		if(file.isEmpty()) {
			lbean.setL_image(lbean.getUpload2());
			System.out.println(lbean.getUpload2());
			System.out.println(lbean.getL_image());
			ldao.noUpImage(lbean);
			
			return gotoPage;
		} else {
			
			ldao.updateLost(lbean);
			
			File upload = new File(filePath+file);
			if(upload.exists()) {
				String exfile = file;
				String aex1 = exfile.substring(0,exfile.lastIndexOf("."));
				String aex2 = exfile.substring(exfile.lastIndexOf("."));
				lbean.setL_image(aex1+"-1"+aex2);
				System.out.println(lbean.getL_image());
				upload = new File(filePath+lbean.getL_image());
					
				ldao.upexist(lbean);
				MultipartFile multi = lbean.getUpload();
				multi.transferTo(upload);
				return gotoPage;
			} 
				
			File delete = new File(filePath+lbean.getUpload2());
			delete.delete();
					
			MultipartFile multi = lbean.getUpload();
			multi.transferTo(upload);
					
			return gotoPage;	
					
		}
	}
}
