package ticket.model;

import java.sql.Timestamp;

public class TicketBean {
	private String tk_num;
	private String tk_date;
	private int tk_partner;
	private String m_id;
	private int t_num;
	private int r_num;
	private int s_no;
	private String r_start;
	private String r_end;
	private String tk_reserve;
	private Timestamp tk_bookday;
	private String s_code;
	private int r_price;
	
	
	public TicketBean() {
		super();
	}
	public TicketBean(String tk_num, String tk_date, int tk_partner, String m_id, int t_num, int r_num, int s_no,
			String tk_reserve, Timestamp tk_bookday) {
		super();
		this.tk_num = tk_num;
		this.tk_date = tk_date;
		this.tk_partner = tk_partner;
		this.m_id = m_id;
		this.t_num = t_num;
		this.r_num = r_num;
		this.s_no = s_no;
		this.tk_reserve = tk_reserve;
		this.tk_bookday = tk_bookday;
	}
	
	
	public int getR_price() {
		return r_price;
	}
	public void setR_price(int r_price) {
		this.r_price = r_price;
	}
	public String getS_code() {
		return s_code;
	}
	public void setS_code(String s_code) {
		this.s_code = s_code;
	}
	public String getR_start() {
		return r_start;
	}
	public void setR_start(String r_start) {
		this.r_start = r_start;
	}
	public String getR_end() {
		return r_end;
	}
	public void setR_end(String r_end) {
		this.r_end = r_end;
	}
	public String getTk_num() {
		return tk_num;
	}
	public void setTk_num(String tk_num) {
		this.tk_num = tk_num;
	}
	public String getTk_date() {
		return tk_date;
	}
	public void setTk_date(String tk_date) {
		this.tk_date = tk_date;
	}
	public int getTk_partner() {
		return tk_partner;
	}
	public void setTk_partner(int tk_partner) {
		this.tk_partner = tk_partner;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public int getT_num() {
		return t_num;
	}
	public void setT_num(int t_num) {
		this.t_num = t_num;
	}
	public int getR_num() {
		return r_num;
	}
	public void setR_num(int r_num) {
		this.r_num = r_num;
	}
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public String getTk_reserve() {
		return tk_reserve;
	}
	public void setTk_reserve(String tk_reserve) {
		this.tk_reserve = tk_reserve;
	}
	public Timestamp getTk_bookday() {
		return tk_bookday;
	}
	public void setTk_bookday(Timestamp tk_bookday) {
		this.tk_bookday = tk_bookday;
	}
	
	
}
