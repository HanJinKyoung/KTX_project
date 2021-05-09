package lost.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import lost.model.LostBean;
import lost.model.LostDao;

@Controller
public class LostWriteController {
	private final String command = "/lostwrite.lt";
	private final String getPage = "lostwriteForm";
	private final String gotoPage = "redirect:/lostlist.lt";
	
	@Autowired
	private LostDao ldao;
	
	@Autowired
	ServletContext servletContext;
	
	
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String lostget() {
		return getPage;
	}
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public String writePost(LostBean lost) throws IllegalStateException, IOException {
		String filePath = servletContext.getRealPath("/resources/uploadlost/");
		String filename = lost.getL_image();
		MultipartFile multi = lost.getUpload();
// C:\Project\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Project_0414\resources\
//	uploadlost\	
		File f = new File(filePath+filename);
		if(filename.isEmpty()) {
			ldao.writeLost(lost);
			return gotoPage;
		}
		
		if(f.exists()) {
			String exfile = filename;
			
			String aex1 = exfile.substring(0,exfile.lastIndexOf("."));
			//System.out.println("파일:"+aex1);
			String aex2 = exfile.substring(exfile.lastIndexOf("."));
			//System.out.println("확장자"+aex2);
			
			lost.setL_image(aex1+"_1"+aex2);
			System.out.println(lost.getL_image());
			String l_content = ((String)lost.getL_content()).replace("\r\n","<br>");
			lost.setL_content(l_content);
			f = new File(filePath+lost.getL_image());
			ldao.writeLost(lost);
			multi.transferTo(f);
			return gotoPage;
		} else {
			ldao.writeLost(lost);
			multi.transferTo(f);
			return gotoPage;
		}
		
	}
}
