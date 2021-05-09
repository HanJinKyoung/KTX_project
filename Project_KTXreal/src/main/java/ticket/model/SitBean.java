package ticket.model;

public class SitBean {
	private int s_no;
	private int r_num;
	private String s_code;
	
	
	public SitBean() {
		super();
	}
	public SitBean(int s_no, int r_num, String s_code) {
		super();
		this.s_no = s_no;
		this.r_num = r_num;
		this.s_code = s_code;
	}
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public int getR_num() {
		return r_num;
	}
	public void setR_num(int r_num) {
		this.r_num = r_num;
	}
	public String getS_code() {
		return s_code;
	}
	public void setS_code(String s_code) {
		this.s_code = s_code;
	}
}
