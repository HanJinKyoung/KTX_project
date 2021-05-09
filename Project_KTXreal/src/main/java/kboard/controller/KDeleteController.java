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
public class KDeleteController {
	private final String command = "kdeleteForm.kbd";
	private final String getPage = "kdeleteForm";
	private final String gotoPage = "redirect:/klist.kbd";

	@Autowired
	private KBoardDao kdao;

	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction(@RequestParam(value = "k_num", required = true) int k_num,
			@RequestParam(value = "pageNumber", required = true) int pageNumber, Model model) {

		KBoardBean kboard = kdao.getData(k_num);

		model.addAttribute("kboard", kboard);
		model.addAttribute("pageNumber", pageNumber);
		return getPage;
	}

	@RequestMapping(value = command, method = RequestMethod.POST)
	public String doActionPost(@RequestParam(value = "pageNumber", required = true) int pageNumber,
			@RequestParam(value = "k_passwd", required = true) String k_passwd, KBoardBean kboard,
			HttpServletResponse response, Model model) throws IOException {
		System.out.println(k_passwd);
		System.out.println(pageNumber);
		System.out.println(kboard.getK_num());
		int k_num = kboard.getK_num();

		int cnt = kdao.deleteArticle(k_num, k_passwd);
		PrintWriter printw = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");

		if (cnt > 0) {
			int recordcount = kdao.getArticleCount();
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