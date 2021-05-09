package voc.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import voc.model.VocBean;
import voc.model.VocDao;


@Controller
public class VocUpdateController {
	

	private final String command = "/vocupdate.vd";
	private final String getPage = "vocupdateForm";
	private final String gotoPage = "redirect:/voclist.vd";
	@Autowired
	private VocDao vdao;
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String doGet(
			@RequestParam("q_num") int q_num,
			@RequestParam("pageNumber") int pageNumber,
			Model model
			) {
		VocBean voc = vdao.getContent(q_num);
		String q_content = ((String)voc.getQ_content()).replace("<br>","\r\n");
		voc.setQ_content(q_content);
		model.addAttribute("voc", voc);
		model.addAttribute("pageNumber", pageNumber);
		return getPage;
	}

	@RequestMapping(value=command,method = RequestMethod.POST)
	public String doPost(
			VocBean voc,
			@RequestParam("pageNumber") int pageNumber,
			Model model,
			HttpServletResponse response
			){
		
		String q_content = ((String)voc.getQ_content()).replace("\r\n","<br>");
		voc.setQ_content(q_content);
		
		vdao.updateVoc(voc);
		model.addAttribute("pageNumber", pageNumber);
		return gotoPage;
	}
	
}