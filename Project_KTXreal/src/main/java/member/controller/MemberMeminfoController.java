package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberMeminfoController {

	private final String command = "/meminfo.mem";
	private final String getPage = "meminfo";

	@Autowired
	private MemberDao mDao;

	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doGet() {
		return getPage;
		}
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doPOST(
			@Valid MemberBean member,
			BindingResult result,
			HttpServletResponse response
			) throws IOException {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.addObject("member", member);
			mav.setViewName(getPage);
			return mav;
		}else {
			mDao.updateMeminfo(member);
			
			System.out.println("수정 성공");
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html; charset=UTF-8");
			pw.print("<script type='text/javascript'>");
			pw.print("alert('성공적으로 변경되었습니다.'); location.href='list.mem'");
			pw.print("</script>");
			pw.flush();
			return null;
		}
	}
}