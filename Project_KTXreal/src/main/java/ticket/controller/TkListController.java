package ticket.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ticket.model.TicketBean;
import ticket.model.TicketDao;

@Controller
public class TkListController {
	private final String command = "/tklist.tk";
	private final String getPage = "ticketList";
	private final String gotoPage = "redirect:/login.mem";
	
	@Autowired
	private TicketDao kdao;
	
	@RequestMapping(command)
	public String doGet(HttpSession session,Model model,
			HttpServletResponse response) throws IOException {//로그아웃 상태일때 로그인창으로
		String m_id = (String)session.getAttribute("m_id");
		String m_grade = (String)session.getAttribute("m_grade");
		PrintWriter pw = response.getWriter();
		if(m_id == null) {
			session.setAttribute("destination", "redirect:/tklist.tk");
			return gotoPage;
		}else {			
			if(m_grade.equals("A")||m_grade.equals("S")) {
				response.setContentType("text/html; charset=UTF-8");
				pw.println("<script>alert('관리자 계정은 관리자 페이지를 이용해주세요.'); location.replace('main.jsp')</script>");
				pw.flush();
				return null;
			} else {				
				List<TicketBean> reservelist = kdao.getretkById(m_id);
				List<TicketBean> paylist = kdao.getpaytkById(m_id);
				model.addAttribute("reservelist", reservelist);
				model.addAttribute("paylist", paylist);
				return getPage;
			}
		}
	}
}
