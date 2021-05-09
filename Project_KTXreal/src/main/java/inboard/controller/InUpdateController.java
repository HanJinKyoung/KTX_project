package inboard.controller;


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

import inboard.model.InBoardBean;
import inboard.model.InBoardDao;

@Controller
public class InUpdateController {
	
	private final String command = "/inupdate.ib";
	private final String getPage = "InupdateForm";
	private final String gotoPage = "redirect:/inlist.ib";
	
	@Autowired
	private InBoardDao idao;
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String doGet(
			@RequestParam("i_num") int i_num,
			@RequestParam("pageNumber") int pageNumber,
			Model model
			) {
		InBoardBean inboard = idao.getData(i_num);
		String i_content = ((String)inboard.getI_content()).replace("<br>","\r\n");
		inboard.setI_content(i_content);
		model.addAttribute("inboard", inboard);
		model.addAttribute("pageNumber", pageNumber);
		return getPage;
	}

	@RequestMapping(value=command,method = RequestMethod.POST)
	public String doPost(
			InBoardBean inboard,
			@RequestParam("pageNumber") int pageNumber,
			Model model,
			HttpServletResponse response
			) throws IOException {
		String i_content = ((String)inboard.getI_content()).replace("\r\n","<br>");
		inboard.setI_content(i_content);
		
		String file = inboard.getI_filename();
		System.out.println(inboard.getI_preuploadFile());
		
		String filePath = servletContext.getRealPath("/resources/upload/");
		PrintWriter pw = response.getWriter();
		if(file.isEmpty()) {
			inboard.setI_filename(inboard.getI_preuploadFile());
			int cnt = -1;
			cnt  = idao.updateIBoard(inboard);
			if(cnt<1) {
				response.setContentType("text/html; charset=UTF-8");
				pw.print("<script type='text/javascript'>");
				pw.print("alert('비밀번호가 일치하지 않습니다')");
				pw.print("</script>");
				pw.flush();
				model.addAttribute("inboard",inboard);
				model.addAttribute("pageNumber", pageNumber);
				return getPage;
			}
			return gotoPage;
		} else {
			int cnt = -1;
			cnt = idao.updateIBoard(inboard);
			
			if(cnt<1) {
				response.setContentType("text/html; charset=UTF-8");
				pw.print("<script type='text/javascript'>");
				pw.print("alert('비밀번호가 일치하지 않습니다')");
				pw.print("</script>");
				pw.flush();
				inboard.setI_filename(inboard.getI_preuploadFile());
				model.addAttribute("inboard",inboard);
				model.addAttribute("pageNumber", pageNumber);
				return getPage;
				
			} else {
				File upload = new File(filePath+file);
				if(upload.exists()) {
					String exfile = file;
					String aex1 = exfile.substring(0,exfile.lastIndexOf("."));
					String aex2 = exfile.substring(exfile.lastIndexOf("."));
					inboard.setI_filename(aex1+"-1"+aex2);
					System.out.println(inboard.getI_filename());
					upload = new File(filePath+inboard.getI_filename());
					
					idao.upexist(inboard);
					MultipartFile multi = inboard.getUploadFile();
					multi.transferTo(upload);
					return gotoPage;
				} 
				
				File delete = new File(filePath+inboard.getI_preuploadFile());
				delete.delete();
					
				MultipartFile multi = inboard.getUploadFile();
				multi.transferTo(upload);
					
				return gotoPage;	
			}		
		}
	}
}
