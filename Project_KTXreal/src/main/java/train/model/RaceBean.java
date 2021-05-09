package train.model;

public class RaceBean {
	private int r_num;
	private String r_start;
	private String r_end;
	private int r_starth;
	private int r_startm;
	private int r_endh;
	private int r_endm;
	private int r_price;
	private int t_num;
	//티켓중복방지
	private int stime;
	private int etime;
	
	public RaceBean() {
		super();
	}
	public RaceBean(int r_num, String r_start, String r_end, int r_starth, int r_startm, int r_endh, int r_endm,
			int r_price, int t_num) {
		super();
		this.r_num = r_num;
		this.r_start = r_start;
		this.r_end = r_end;
		this.r_starth = r_starth;
		this.r_startm = r_startm;
		this.r_endh = r_endh;
		this.r_endm = r_endm;
		this.r_price = r_price;
		this.t_num = t_num;
	}
	public int getStime() {
		return stime;
	}
	public void setStime(int stime) {
		this.stime = stime;
	}
	public int getEtime() {
		return etime;
	}
	public void setEtime(int etime) {
		this.etime = etime;
	}
	public int getR_num() {
		return r_num;
	}
	public void setR_num(int r_num) {
		this.r_num = r_num;
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
	public int getR_starth() {
		return r_starth;
	}
	public void setR_starth(int r_starth) {
		this.r_starth = r_starth;
	}
	public int getR_startm() {
		return r_startm;
	}
	public void setR_startm(int r_startm) {
		this.r_startm = r_startm;
	}
	public int getR_endh() {
		return r_endh;
	}
	public void setR_endh(int r_endh) {
		this.r_endh = r_endh;
	}
	public int getR_endm() {
		return r_endm;
	}
	public void setR_endm(int r_endm) {
		this.r_endm = r_endm;
	}
	public int getR_price() {
		return r_price;
	}
	public void setR_price(int r_price) {
		this.r_price = r_price;
	}
	public int getT_num() {
		return t_num;
	}
	public void setT_num(int t_num) {
		this.t_num = t_num;
	}
	
	
}
