package train.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import train.model.RaceBean;
import train.model.TrainDao;

@Controller
public class TrainBookController {
	private final String command = "/trainbook.tr";
	private final String getPage = "trainbook";
	private final String gotoPage = "redirect:/login.mem";
	private final String admin = "redirect:/main.jsp";
	
	@Autowired
	private TrainDao tdao;
	
	@RequestMapping(value = command,method = RequestMethod.GET)
	public String doGet(HttpSession session) {//로그아웃 상태일때 로그인창으로
		String m_id = (String)session.getAttribute("m_id");
		String m_grade = (String)session.getAttribute("m_grade");
		if(m_id == null) {
			session.setAttribute("destination", "redirect:/trainbook.tr");
			return gotoPage;
		}else {			
			if(m_grade.equals("A")||m_grade.equals("S")) {
				return admin;
			}else{
				return getPage;
			}
		}
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public String doPost(
			@RequestParam("tk_date") String tk_date,
			@RequestParam("r_start") String r_start,
			@RequestParam("r_end") String r_end,
			@RequestParam("r_starth") int r_starth,
			@RequestParam("tk_partner") int tk_partner,
			Model model
			) {
		System.out.println("book:"+r_start+" "+r_end+" "+r_starth);
		
		RaceBean race = new RaceBean();
		
		race.setR_start(r_start);
		race.setR_end(r_end);
		race.setR_starth(r_starth);
		
		List<RaceBean> trainlist = new ArrayList<RaceBean>();
		trainlist = tdao.getData(race);
		System.out.println("trainlist.size"+trainlist.size());
		for(RaceBean tlist : trainlist) {
			System.out.println(tlist.getT_num());
			System.out.println(tlist.getR_start());
			System.out.println(tlist.getR_end());
			System.out.println(tlist.getR_starth()+":"+tlist.getR_startm());
			System.out.println(tlist.getR_endh()+":"+tlist.getR_endm());
		}
		model.addAttribute("tk_partner", tk_partner);
		model.addAttribute("tk_date", tk_date);
		model.addAttribute("trainlist", trainlist);
		return getPage;
	}
}
