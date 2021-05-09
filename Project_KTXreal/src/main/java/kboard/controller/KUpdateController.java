package kboard.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kboard.model.KBoardBean;
import kboard.model.KBoardDao;

@Controller
public class KUpdateController {
	
	private final String command = "/update.kbd";
	private final String getPage = "updateForm";
	private final String gotoPage = "redirect:/klist.kbd";
	@Autowired
	private KBoardDao kbdao;
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String doGet(
			@RequestParam("k_num") int k_num,
			@RequestParam("pageNumber") int pageNumber,
			Model model
			) {
		KBoardBean kboard = kbdao.getData(k_num);
		String k_content = ((String)kboard.getK_content()).replace("<br>","\r\n");
		kboard.setK_content(k_content);
		model.addAttribute("kboard", kboard);
		model.addAttribute("pageNumber", pageNumber);
		return getPage;
	}

	@RequestMapping(value=command,method = RequestMethod.POST)
	public String doPost(
			KBoardBean kboard,
			@RequestParam("pageNumber") int pageNumber,
			Model model,
			HttpServletResponse response
			) throws IOException {
		String k_content = ((String)kboard.getK_content()).replace("\r\n","<br>");
		kboard.setK_content(k_content);
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		
		int cnt = -1;
		cnt = kbdao.updateKBoard(kboard);
		model.addAttribute("pageNumber", pageNumber);
		if(cnt<1) {
			model.addAttribute("kboard",kboard);
			pw.print("<script type='text/javascript'>");
			pw.print("alert('비밀번호가 일치하지 않습니다')");
			pw.print("</script>");
			pw.flush();
			return getPage;
		}else {
			return gotoPage;
		}
	}
}
