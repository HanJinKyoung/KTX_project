package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;



@Controller
public class MemberLoginController {
	private final String command = "/login.mem";
	private final String getPage = "login";
	private final String gotoPage = "redirect:/main.jsp";
	
	@Autowired
	private MemberDao mDao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String login(HttpSession session) {
		String des = (String)session.getAttribute("destination");
		System.out.println("login"+des);
		return getPage;
	}
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView doActionPost(
									HttpServletRequest request,
									HttpServletResponse response,
									HttpSession session
									) throws IOException {
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		MemberBean loginMember = mDao.getMember(m_id);
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		ModelAndView mav = new ModelAndView();
		
		if(loginMember == null) {
			System.out.println("존재하지 않는 회원");
			pw.print("<script type='text/javascript'>");
			pw.print("alert('해당 아이디가 존재하지 않습니다')");
			pw.print("</script>");
			pw.flush();
			mav.setViewName(getPage);
		} else {
			if(m_pw.equals(loginMember.getM_pw()) ) {
				session.setAttribute("m_id", loginMember.getM_id());
				session.setAttribute("m_grade", loginMember.getM_grade());
				session.setAttribute("m_num", loginMember.getM_num());
				String destination = (String)session.getAttribute("destination");
				System.out.println("destination :"+destination);
					if(destination==null) {
						mav.setViewName(gotoPage);
					}else {											
						mav.setViewName(destination);
					}
			}else {
				pw.print("<script type='text/javascript'>");
				pw.print("alert('비번이 일치하지 않습니다')");
				pw.print("</script>");
				pw.flush();
				mav.setViewName(getPage);
			}
		}
		return mav;
	}
	@RequestMapping("/logout.mem")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mav = new ModelAndView(gotoPage);
		return mav;
	}
}
