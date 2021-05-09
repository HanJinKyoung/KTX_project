package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import admin.model.AdminDao;
import admin.model.CheckBean;
import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class CheckController {
	private final String command = "check.ad";
	private final String getPage = "check";
	private final String incommand = "intimecheck.ad";
	private final String outcommand = "outtimecheck.ad";
	
	@Autowired
	private AdminDao aDao;
	@Autowired
	private MemberDao mDao;
	
	@RequestMapping(command)
	public String doAction(HttpSession session,Model model) {
		int num = (Integer)session.getAttribute("m_num");
		
		MemberBean member = mDao.getBynum(num);
		
		model.addAttribute("member", member);
		
		return getPage;
	}
	
	@RequestMapping(incommand)
	public String InAction(CheckBean cbean,HttpSession session,
			HttpServletResponse response) throws IOException {
		
		int num = (Integer)session.getAttribute("m_num");
		
		int cnt = aDao.returnCheck(num);

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		if(cnt==0) {
			cbean.setC_count(0);
			aDao.InTimeChk(cbean);
			pw.print("<script type='text/javascript'>");
			pw.print("alert('출근체크 되셨습니다'); location.replace('admin.jsp')");
			pw.print("</script>");
			pw.flush();
			return null;
			 
		} else {
			
			pw.print("<script type='text/javascript'>");
			pw.print("alert('이미 출근체크 하셨습니다'); location.href='checklist.ad'");
			pw.print("</script>");
			pw.flush();
			return null;
		}
				
	}
	
	@RequestMapping(outcommand)
	public String OutAction(CheckBean cbean,
			HttpServletResponse response) throws IOException {

		CheckBean check = aDao.findIncheck(cbean);
		
		int count = (Integer)check.getC_count();
		System.out.println(count);
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		if(count==0) {
			aDao.OutTimeChk(check);
			pw.print("<script type='text/javascript'>");
			pw.print("alert('퇴근체크 되셨습니다'); location.replace('admin.jsp')");
			pw.print("</script>");
			pw.flush();
			return null;
		} else {
			pw.print("<script type='text/javascript'>");
			pw.print("alert('이미 퇴근체크 하셨습니다'); location.href='checklist.ad'");
			pw.print("</script>");
			pw.flush();
			
			return null;
		}

	}
}
