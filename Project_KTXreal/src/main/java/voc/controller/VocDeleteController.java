package voc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import voc.model.VocBean;
import voc.model.VocDao;


@Controller
public class VocDeleteController {
	private final String command = "vocdeleteForm.vd";
	private final String gotoPage = "redirect:/voclist.vd";

	@Autowired
	private VocDao vdao;

	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction(@RequestParam(value = "q_num", required = true) int q_num,
			@RequestParam(value = "pageNumber", required = true) int pageNumber, Model model) {

		VocBean vbean = vdao.getContent(q_num);
		vdao.delete(vbean);
		model.addAttribute("vbean", vbean);
		model.addAttribute("pageNumber", pageNumber);
		return gotoPage;
	}
}