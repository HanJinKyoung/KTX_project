package kboard.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import kboard.model.KBoardBean;
import kboard.model.KBoardDao;

@Controller
public class KWriteController {
	private final String command = "/write.kbd";
	private final String getPage = "writeForm";
	private final String gotoPage = "redirect:/klist.kbd";
	
	@Autowired
	private KBoardDao kbdao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doGet() {
		return getPage;
	}
	@RequestMapping(value = command, method = RequestMethod.POST)
	public String doPost(KBoardBean kboard, HttpServletRequest request) {
		String k_content = ((String)kboard.getK_content()).replace("\r\n","<br>");
		kboard.setK_content(k_content);
		kbdao.writeKBoard(kboard);
		return gotoPage;
	}
}
