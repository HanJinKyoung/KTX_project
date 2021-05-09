package member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberDao;

@Controller
public class MemberDeleteController {
	private final String command = "/delete.mem";
	private final String command2 = "/mydelete.mem";
	private final String getpage = "../../main";
	private final String gotoPage = "redirect:/list.mem";
	
	@Autowired
	private MemberDao mDao;
	
	@RequestMapping(command)
	public String doAction(
			@RequestParam(value="m_num",required = true) int m_num,
			@RequestParam(value="pageNumber",required = true) String pageNumber,
			Model model) {
		
		
		int cnt = mDao.deleteMember(m_num);
		
		model.addAttribute("pageNumber", pageNumber);
		return gotoPage;
	}
	
	
	@RequestMapping(command2)
	public String doAction(
			HttpSession session,
			@RequestParam(value="m_num",required = true) int m_num
			) {
		
		
		int cnt = mDao.deleteMember(m_num);
		session.invalidate();
		return getpage;
	}
	
}
