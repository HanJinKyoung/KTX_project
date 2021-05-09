package ticket.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ticket.model.SitBean;
import ticket.model.TicketDao;
import train.model.RaceBean;
import train.model.TrainDao;

@Controller
public class TicketController {
	private final String command = "/reserveform.tk";
	private final String getPage = "reserveForm";
	
	@Autowired
	TrainDao tdao;
	@Autowired
	TicketDao kdao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String goGet(
			@RequestParam("tk_date") String tk_date,
			@RequestParam("r_num") int r_num,
			@RequestParam("tk_partner") String tk_partner,		
			HttpServletResponse response,
			Model model
			) throws IOException {
		System.out.println("Ticketctrl r_num:"+r_num);
		System.out.println("Ticketctrl tk_date:"+tk_date);
		RaceBean race = tdao.getByRnum(r_num);
		int t_num = race.getT_num();
		int tkcnt = kdao.getTkcnt(t_num,r_num);
		model.addAttribute("tk_date", tk_date);
		model.addAttribute("tk_partner", tk_partner);
		if(tkcnt==40) {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html; charset=UTF-8");
			pw.print("<script type='text/javascript'>");
			pw.print("alert('만차(예약불가) 다른시간을 선택하세요'); history.go(-1);");
			pw.print("</script>");
			pw.flush();
			return null;
		}else {
//			RaceBean race = new RaceBean();
//			race = tdao.getByRnum(r_num); 
			System.out.println("race.getR_num"+race.getR_num());
			model.addAttribute("race",race);
			return getPage;			
		}
	}
	//좌석이 여러개들어왔을 때
	@RequestMapping(value = command, method = RequestMethod.POST)
	public String goPost(
			@RequestParam("t_num") int t_num,
			@RequestParam("r_num") int r_num,
			@RequestParam("s_code") String[] scode,
			@RequestParam("tk_date") String tk_date,
			@RequestParam("r_start") String r_start,
			@RequestParam("r_end") String r_end,
			@RequestParam("tk_partner") int tk_partner,
			HttpSession session,
			HttpServletResponse response,
			Model model
			) throws IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		if(scode.length<tk_partner) {
			pw.print("<script type='text/javascript'>");
			pw.print("alert('좌석이 인원수보다 적습니다'); history.go(-1)");
			pw.print("</script>");
			pw.flush();
			return null;
		}
		String m_id = (String)session.getAttribute("m_id");
		SitBean sit = new SitBean();
		
		System.out.println("동승자:"+tk_partner);
		
		String msg = "";
		boolean flag = true;
		for(int i=0;i<scode.length;i++) {
			sit.setR_num(r_num);
			sit.setS_code(scode[i]);
			int cnt = kdao.getSitno(sit);
			System.out.println("s_no cnt: "+cnt);
			if(cnt==0) {//p_sit에 좌석 등록하기
				kdao.insertSit(sit);
			}
			int s_no = kdao.getSno(sit);//좌석고유번호가져오기
			//중복체크 : tk_date, s_no, t_num, r_num
			System.out.println("tnum:"+t_num);
			System.out.println("rnum:"+r_num);
			System.out.println("sno:"+s_no);
			System.out.println("date:"+tk_date);
			int cnttk = kdao.TkChk(t_num,r_num,s_no,tk_date);
			System.out.println("중복 cnttk:"+cnttk);
			if(cnttk>0) {//중복
				flag = false;
				msg += scode[i]+"좌석은 중복된 좌석입니다.";
				break;
			}else {
				flag = true;
			}
		}//for
		System.out.println("flag:"+flag);
		if(flag == true) {
			for(String s_code : scode) {
				SitBean sit2 = new SitBean();
				sit2.setS_code(s_code);
				sit2.setR_num(r_num);
				int s_no = kdao.getSno(sit2);
				kdao.insertTdata(m_id, t_num, tk_partner, r_num, s_no, tk_date, r_start, r_end,s_code);
				pw.print("<script type='text/javascript'>");
				pw.print("alert('예약되었습니다'); location.href='trainbook.tr'");
				pw.print("</script>");
				pw.flush();
			}
			return null;
		}else {
			RaceBean race = new RaceBean();
			race = tdao.getByRnum(r_num); 
			model.addAttribute("race",race);
			model.addAttribute("tk_date",tk_date);
			model.addAttribute("tk_partner",tk_partner);
			pw.print("<script type='text/javascript'>");
			pw.print("alert('"+msg+"'); history.go(-1);");
			pw.print("</script>");
			pw.flush();
			return null;
		}
	}
}

