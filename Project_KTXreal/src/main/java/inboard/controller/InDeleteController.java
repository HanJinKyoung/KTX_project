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

import inboard.model.InBoardBean;
import inboard.model.InBoardDao;


@Controller
public class InDeleteController {
	private final String command = "indeleteForm.ib";
	private final String getPage = "IndeleteForm";
	private final String gotoPage = "redirect:/inlist.ib";

	@Autowired
	private InBoardDao idao;
	@Autowired
	ServletContext servletContext;

	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction(@RequestParam(value = "i_num", required = true) int i_num,
			@RequestParam(value = "pageNumber", required = true) int pageNumber, Model model) {

		InBoardBean inboard = idao.getData(i_num);

		model.addAttribute("inboard", inboard);
		model.addAttribute("pageNumber", pageNumber);
		return getPage;
	}

	@RequestMapping(value = command, method = RequestMethod.POST)
	public String doActionPost(@RequestParam(value = "pageNumber", required = true) int pageNumber,
			@RequestParam(value = "i_passwd", required = true) String i_passwd,
			InBoardBean inboard,
			HttpServletResponse response, Model model) throws IOException {

		
		System.out.println("파일이름"+inboard.getI_filename());
		int i_num = inboard.getI_num();
		
		String filePath = servletContext.getRealPath("/resources/upload/");
		File file = new File(filePath+File.separator+inboard.getI_filename());
		file.delete();
		
		int cnt = idao.deleteArticle(i_num, i_passwd);
		
		PrintWriter printw = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");

		if (cnt > 0) {
			int recordcount = idao.getArticleCount();
			int pageCount = recordcount / 10 + (recordcount % 10 == 0 ? 0 : 1);
			
			model.addAttribute("pageCount", pageCount);
			return gotoPage + "?pageNumber=" + pageNumber;
		} else {
			printw.print("<script type='text/javascript'>");
			printw.print("alert('비밀번호가 일치하지 않습니다')");
			printw.print("</script>");
			printw.print("<script type='text/javascript'>");
			printw.print("history.back()");
			printw.print("</script>");
			printw.flush();
			return null;
		}
	}
}