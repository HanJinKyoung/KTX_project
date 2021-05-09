package inboard.controller;



import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import inboard.model.InBoardBean;
import inboard.model.InBoardDao;

@Controller
public class InWriteController {
	private final String command = "/inwrite.ib";
	private final String getPage = "InwriteForm";
	private final String gotoPage = "redirect:/inlist.ib";
	
	@Autowired
	private InBoardDao idao;
	@Autowired
	ServletContext servletContext;
	
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doGet() {
		return getPage;
	}
	@RequestMapping(value = command, method = RequestMethod.POST)
	public String doPost(InBoardBean inboard) throws IllegalStateException, IOException  {
		String filePath = servletContext.getRealPath("/resources/upload/");
		String filename = inboard.getI_filename();
		MultipartFile multi = inboard.getUploadFile();
//경로 : 	C:\Project\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Project_0414\resources\
//		+upload
		File f = new File(filePath+filename);
		if(filename.isEmpty()) {
	         idao.writeIBoard(inboard);
	         return gotoPage;
	      }
	      
		if(f.exists()) {
			String exfile = filename;
			
			String aex1 = exfile.substring(0,exfile.lastIndexOf("."));
			//System.out.println("파일:"+aex1);
			String aex2 = exfile.substring(exfile.lastIndexOf("."));
			//System.out.println("확장자"+aex2);
			inboard.setI_filename(aex1+"_1"+aex2);
			System.out.println(inboard.getI_filename());
			f = new File(filePath+inboard.getI_filename());
			String i_content = ((String)inboard.getI_content()).replace("\r\n","<br>");
			inboard.setI_content(i_content);
			idao.writeIBoard(inboard);
			multi.transferTo(f);
			return gotoPage;
		} else {
			idao.writeIBoard(inboard);
			multi.transferTo(f);
			return gotoPage;
		}

	}
	
}
