package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberDetailController {
	private final String command = "/memdetail.mem";
	private final String getPage = "meminfo";
	
	@Autowired
	private MemberDao mDao;
	
	@RequestMapping(command)
	public String detail(
			Model model,
			@RequestParam(value="m_num",required = false) int m_num
			) {
		MemberBean member = mDao.getBynum(m_num);
		model.addAttribute("member", member);
		return getPage;
	}
}
