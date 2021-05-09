package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberFindController {
	private final String command = "/find.mem";
	private final String getPage = "find";
	@Autowired
	private MemberDao mDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doGet() {
		return getPage;
	}
	@RequestMapping(value="/findId.mem", method = RequestMethod.POST)
	public String dofindId(
							MemberBean member,
							Model model,
							HttpServletResponse response
							) throws IOException {
//		System.out.println("findId name :"+member.getM_name());
//		System.out.println("findId email :"+member.getM_email());
//		System.out.println("findId id :"+member.getM_id());
		MemberBean findId = mDao.findId(member);
		String id = null;
		if(findId != null) {
			id = findId.getM_id();			
		}
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		if(id==null) {
			pw.print("<script type='text/javascript'>");
			pw.print("alert('등록되지 않은 회원입니다.')");
			pw.print("</script>");
			pw.flush();
		}else {
			//System.out.println("findid:"+id);
			pw.print("<script type='text/javascript'>");
			pw.print("alert('회원님의 아이디는 ["+id+"] 입니다')");
			pw.print("</script>");
			pw.flush();
		}
		return getPage;
	}
	@RequestMapping(value="/findPw.mem", method = RequestMethod.POST)
	public String dofindPw(
							MemberBean member,
							HttpServletResponse response
							) throws IOException {
//		System.out.println("findPw name :"+member.getM_name());
//		System.out.println("findPw email :"+member.getM_email());
//		System.out.println("findPw id :"+member.getM_id());
	
		MemberBean findPw = mDao.findPw(member);
		String passwd = null;
		if(findPw != null) {
			passwd = findPw.getM_pw();
		}
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		if(passwd==null) {
			pw.print("<script type='text/javascript'>");
			pw.print("alert('등록되지 않은 회원입니다.')");
			pw.print("</script>");
			pw.flush();
		}else {
			//System.out.println("findpw:"+passwd);
			pw.print("<script type='text/javascript'>");
			pw.print("alert('회원님의 패스워드는 ["+passwd+"] 입니다')");
			pw.print("</script>");
			pw.flush();
		}
		return getPage;
	}
}
