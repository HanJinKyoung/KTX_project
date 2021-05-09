package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberMyPageController {

	private final String command = "/mypage.mem";
	private final String getPage = "mypage";
	private final String gotoPage = "redirect:/login.mem";
	
	@Autowired
	private MemberDao mDao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String doGet(
			HttpSession session,
			Model model,
			@RequestParam(value="m_id",required = false) String listId
			){
		//System.out.println("listId:"+listId);
		String m_id = (String)session.getAttribute("m_id");
		if(m_id == null) {
			//로그아웃 상태일 때 로그인창으로
			session.setAttribute("destination", "redirect:/mypage.mem");
			return gotoPage;
		}else {//로그인 상태일 때 마이페이지로
			if(listId==null) {
				MemberBean member = mDao.getData(m_id);
				model.addAttribute("member", member);
				
			} else {
				MemberBean member = mDao.getData(listId);
				model.addAttribute("member", member);
			}
			
			return getPage;
		}
	}
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView doPost(
			@RequestParam(value="repassword", required=true) String repassword,
			@Valid MemberBean member,
			BindingResult result,
			HttpServletResponse response,
			HttpSession session
			) throws IOException {

		ModelAndView mav = new ModelAndView();
		MemberBean originmem = mDao.getData(member.getM_id());
		
		if(result.hasErrors()) {
			//System.out.println("수정 오류");
			mav.addObject("member", originmem);
			mav.setViewName(getPage);
			return mav;
		}
		
		if(repassword.equals(member.getM_pw())) {
			//System.out.println("비번일치");
			mDao.updateMember(member);
			session.invalidate();
			mav.setViewName(gotoPage);
				
		}else {
			//System.out.println("비번 불일치");
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html; charset=UTF-8");
			pw.print("<script type='text/javascript'>");
			pw.print("alert('비밀번호가 일치하지 않습니다')");
			pw.print("</script>");
			pw.flush();
			
			mav.addObject("member", originmem);
			mav.setViewName(getPage);
		}
		return mav;
		
	}
}
