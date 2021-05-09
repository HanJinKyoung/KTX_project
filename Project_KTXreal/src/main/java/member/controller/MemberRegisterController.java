package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberRegisterController {
	private final String command = "/register.mem";
	private final String getPage = "register";
	
	private final String Scommand = "register_S.mem";
	private final String SPage = "register_S";
	
	private final String Mcommand = "register_M.mem";
	private final String MPage = "register_M";
	
	private final String Mcheck = "Midcheck.mem";
	private final String Scheck = "Sidcheck.mem";

	
	@Autowired
	private MemberDao mDao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String reg() {
		return getPage;
	}
	
	@RequestMapping(value=Mcommand,method=RequestMethod.GET)
	public String Mreg() {
		return MPage;
	}
	@RequestMapping(value=Scommand,method=RequestMethod.GET)
	public String Sreg() {
		return SPage;
	}
	@RequestMapping(value=Mcheck,method=RequestMethod.POST)
	public ModelAndView MChkId(
						HttpServletRequest request,
						@RequestParam(value="repassword") String repassword,
						@ModelAttribute("member")MemberBean member
							) {
		//System.out.println("체크");
		//System.out.println("repw:"+repassword);
		//System.out.println("id2:"+member.getM_id());
		ModelAndView mav = new ModelAndView();	
		
		
		
		int cnt = mDao.ChkId(member.getM_id());
		String check = "";
		//id 중복 있으면 1 없으면 0

		if(cnt ==0) {
			check = "사용가능한 아이디입니다";

		} else {
			check = "이미 사용 중인 아이디입니다";
		}
		mav.addObject("check",check);
		System.out.println(check);
		mav.addObject("cnt",cnt);
		System.out.println(cnt);
		mav.addObject("member",member);
		mav.addObject("repassword",repassword);
		mav.setViewName(MPage);
		
		//request.setAttribute("textid", textid);
		
		return mav;
	}
	@RequestMapping(value=Scheck,method=RequestMethod.POST)
	public ModelAndView SChkId(
						HttpServletRequest request,
						@RequestParam(value="repassword") String repassword,
						MemberBean member
							) {
		ModelAndView mav = new ModelAndView();	
		
		int cnt = mDao.ChkId(member.getM_id());
		String check = "";
		//id 중복 있으면 1 없으면 0

		if(cnt ==0) {
			check = "사용가능한 아이디입니다";

		} else {
			check = "이미 사용 중인 아이디입니다";
		}
		mav.addObject("check",check);
		System.out.println(check);
		mav.addObject("cnt",cnt);
		System.out.println(cnt);
		mav.addObject("member",member);
		mav.addObject("repassword",repassword);
		mav.setViewName(SPage);
		
		return mav;
	}
	

	@RequestMapping(value=Scommand,method=RequestMethod.POST)
	public ModelAndView Sregister(@Valid MemberBean member, 
							BindingResult result,
							HttpServletResponse response,
							@RequestParam(value="repassword", required = true) String repassword) throws IOException {
		//서브관리자 회원가입
		
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.addObject("member", member);
			mav.addObject("repassword", repassword);
			mav.setViewName(SPage);
			return mav;
		}
		PrintWriter writer = response.getWriter(); 
		
		if(repassword.equals(member.getM_pw())) {
			int cnt = mDao.chkEmail(member.getM_email());
			System.out.println("입력값:"+member.getM_email());
			if(cnt>0) {
				response.setContentType("text/html; charset=UTF-8");
				writer.println("<script>alert('이미 등록된 email입니다'); </script>");
				writer.flush();
				mav.addObject("member", member);
				mav.addObject("repassword", repassword);
				mav.setViewName(SPage);
				return mav;
			}
			mDao.insertMember(member);
			response.setContentType("text/html; charset=UTF-8");
			writer.println("<script>alert('계정이 등록 되었습니다'); location.href='login.mem';</script>");
			writer.flush();
			
		} else {
			response.setContentType("text/html; charset=UTF-8");
			writer.println("<script>alert('비밀번호가 일치하지 않습니다'); </script>");
			writer.flush();
			mav.addObject("member", member);
			mav.addObject("repassword", repassword);
			mav.setViewName(SPage);
			return mav;
		}
		return null;
	}
	@RequestMapping(value=Mcommand,method=RequestMethod.POST)
	public ModelAndView Mregister(@Valid MemberBean member, 
							BindingResult result,
							HttpServletResponse response,
							@RequestParam(value="repassword", required = true) String repassword) throws Exception {
		//일반 회원가입
		//System.out.println(repassword);
		System.out.println("가입");
		
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.addObject("member", member);
			mav.addObject("repassword", repassword);
			mav.setViewName(MPage);
			return mav;
		}
		PrintWriter writer = response.getWriter(); 
		
		if(repassword.equals(member.getM_pw())) {
			int cnt = mDao.chkEmail(member.getM_email());

			if(cnt>0) {
				response.setContentType("text/html; charset=UTF-8");
				writer.println("<script>alert('이미 등록된 email입니다'); </script>");
				writer.flush();
				mav.addObject("member", member);
				mav.addObject("repassword", repassword);
				mav.setViewName(MPage);
				return mav;
			}
			mDao.insertMember(member);
			response.setContentType("text/html; charset=UTF-8");
			writer.println("<script>alert('계정이 등록 되었습니다'); location.href='login.mem';</script>");
			writer.flush();
			
		} else {
			response.setContentType("text/html; charset=UTF-8");
			writer.println("<script>alert('비밀번호가 일치하지 않습니다'); </script>");
			writer.flush();
			mav.addObject("member", member);
			mav.addObject("repassword", repassword);
			mav.setViewName(MPage);
			return mav;
		}
		
		return null;
	}
	
}