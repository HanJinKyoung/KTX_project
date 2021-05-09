package ticket.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import train.model.RaceBean;

@Component("myTicketDao")
public class TicketDao {
	private String ns = "ticket.model.TicketBean.";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int getSitno(SitBean sit) {
		System.out.println("sitinfo:"+sit.getR_num()+","+sit.getS_code());
		int cnt = sqlSessionTemplate.selectOne(ns+"GetSitcount",sit);
		return cnt;
	}

	public int insertSit(SitBean sit) {//count구하기
		int cnt = sqlSessionTemplate.insert(ns+"InsertSit", sit);
		return cnt;
	}

	public void insertTdata(String m_id, int t_num, int tk_partner, int r_num, int s_no, String tk_date, String r_start, String r_end, String s_code) {
		
		RaceBean race = new RaceBean();
		race.setR_start(r_start);
		race.setR_end(r_end);
		race.setR_num(r_num);
		int stime = sqlSessionTemplate.selectOne(ns+"Stime",race);
		int etime = sqlSessionTemplate.selectOne(ns+"Etime",race);
		List<RaceBean> rnumarr = new ArrayList<RaceBean>();
		TicketBean ticket = new TicketBean();
		race.setStime(stime);
		race.setEtime(etime);
		race.setT_num(t_num);
		rnumarr = sqlSessionTemplate.selectList(ns+"RnumArr",race);
		for(RaceBean rbean : rnumarr) {
			 String tk_num = tk_date.replaceAll("-", "")+Integer.toString(r_num)+s_code;
			 ticket.setTk_num(tk_num);
	         ticket.setM_id(m_id);
	         ticket.setT_num(t_num);
	         ticket.setR_num(rbean.getR_num());
	         ticket.setS_no(s_no);
	         ticket.setR_start(r_start);
	         ticket.setR_end(r_end);
	         ticket.setTk_partner(tk_partner);
	         ticket.setTk_date(tk_date);

	         for( int j=tk_partner;j>tk_partner-1; j--) {
	            sqlSessionTemplate.insert(ns+"InsertTk", ticket);               
	         	}
			}
	   }

	public int getSno(SitBean sit) {
		int s_no = sqlSessionTemplate.selectOne(ns+"GetSno", sit);
		return s_no;
	}

	//중복체크 : tk_date, s_no, t_num, r_num같으면 중복
	public int TkChk(int t_num, int r_num, int s_no, String tk_date) {
		System.out.println("tdao TkChk:"+t_num+" "+r_num+" "+s_no+" "+tk_date);
		TicketBean ticket = new TicketBean();
		ticket.setT_num(t_num);
		ticket.setR_num(r_num);
		ticket.setS_no(s_no);
		ticket.setTk_date(tk_date);
		System.out.println("ticket.get():"+ticket.getT_num()+" "+ticket.getR_num()+" "+ticket.getS_no()+" "+ticket.getTk_date());
		int cnttk = sqlSessionTemplate.selectOne(ns+"TkChk", ticket);
		System.out.println("tdao 중복된티켓(cnttk):"+cnttk);
		return cnttk;
	}

	public int getTkcnt(int t_num, int r_num) {
		TicketBean ticket = new TicketBean();
		ticket.setT_num(t_num);
		ticket.setR_num(r_num);
		int tkcnt = sqlSessionTemplate.selectOne(ns+"GetTkcnt", ticket);
		return tkcnt;//현재 차량의 발권된 티켓수량
	}

	public List<TicketBean> getretkById(String m_id) {
		List<TicketBean> reservelist = new ArrayList<TicketBean>();
		reservelist = sqlSessionTemplate.selectList(ns+"GetRetkById", m_id);
		return reservelist;
	}
	public List<TicketBean> getpaytkById(String m_id) {
		List<TicketBean> paylist = new ArrayList<TicketBean>();
		paylist = sqlSessionTemplate.selectList(ns+"GetPaytkById", m_id);
		return paylist;
	}

	public int paytk(String tk_num) {
		System.out.println("tkdao:"+tk_num);
		int cnt = sqlSessionTemplate.update(ns+"UpdateReserve", tk_num);
		return cnt;
	}

	public int cancletk(String tk_num) {
		int cnt = sqlSessionTemplate.delete(ns+"DeleteTk", tk_num);
		return cnt;
	}
	
	public int allpay(String[] rc) {
		int cnt = 0;
		String tk_num = "";
		for(int i=0; i<rc.length; i++) {			
			tk_num = rc[i];
			cnt = sqlSessionTemplate.update(ns+"UpdateReserve", tk_num);
		}
		System.out.println("결제:"+cnt);
		return cnt;		
	}

	public int alldel(String[] rc) {
		int cnt = 0;
		String tk_num = "";
		for(int i=0; i<rc.length; i++) {			
			tk_num = rc[i];
			cnt = sqlSessionTemplate.update(ns+"DeleteTk", tk_num);
		}
		System.out.println("결제취소:"+cnt);
		return cnt;
	}
	
}
