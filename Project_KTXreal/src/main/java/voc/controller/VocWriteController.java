package voc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import voc.model.VocBean;
import voc.model.VocDao;


@Controller
public class VocWriteController {
	private final String command = "/vocwriteForm.vd";
	private final String getPage = "vocwriteForm";
	private final String gotoPage = "redirect:/voclist.vd";
	
	@Autowired
	private VocDao vdao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doGet(HttpSession session,
			HttpServletResponse response) throws IOException {
		String m_id = (String)session.getAttribute("m_id");
		String m_grade = (String)session.getAttribute("m_grade");
		PrintWriter pw = response.getWriter();
		if(m_id == null) {
			session.setAttribute("destination", "redirect:/vocwriteForm.vd");
			return "redirect:/login.mem";
			
		} else {
			if(m_grade.equals("A")||m_grade.equals("S")) {
				response.setContentType("text/html; charset=UTF-8");
				pw.println("<script>alert('관리자 계정은 관리자 페이지를 이용해주세요.'); location.replace('main.jsp')</script>");
				pw.flush();
				return null;
			} else {
				
				return getPage;
			}
		}
	}
	@RequestMapping(value = command, method = RequestMethod.POST)
	public String doPost(VocBean voc, HttpServletRequest request) {
		voc.setQ_ip(request.getRemoteAddr());
		String q_content = ((String)voc.getQ_content()).replace("\r\n","<br>");
		voc.setQ_content(q_content);
		vdao.writeVoc(voc);   
		return gotoPage;
	}
}
