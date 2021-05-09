package kboard.model;

public class KBoardBean {
	private int k_num;
	private String k_reg_date;
	private String k_writer;
	private String k_subject;
	private String k_passwd;
	private int k_readcount;
	private String k_content;
	
	public KBoardBean() {
		super();
	}
	public KBoardBean(int k_num, String k_reg_date, String k_writer, String k_subject, String k_passwd, int k_readcount,
			String k_content) {
		super();
		this.k_num = k_num;
		this.k_reg_date = k_reg_date;
		this.k_writer = k_writer;
		this.k_subject = k_subject;
		this.k_passwd = k_passwd;
		this.k_readcount = k_readcount;
		this.k_content = k_content;
	}
	public int getK_num() {
		return k_num;
	}
	public void setK_num(int k_num) {
		this.k_num = k_num;
	}
	public String getK_reg_date() {
		return k_reg_date;
	}
	public void setK_reg_date(String k_reg_date) {
		this.k_reg_date = k_reg_date;
	}
	public String getK_writer() {
		return k_writer;
	}
	public void setK_writer(String k_writer) {
		this.k_writer = k_writer;
	}
	public String getK_subject() {
		return k_subject;
	}
	public void setK_subject(String k_subject) {
		this.k_subject = k_subject;
	}
	public String getK_passwd() {
		return k_passwd;
	}
	public void setK_passwd(String k_passwd) {
		this.k_passwd = k_passwd;
	}
	public int getK_readcount() {
		return k_readcount;
	}
	public void setK_readcount(int k_readcount) {
		this.k_readcount = k_readcount;
	}
	public String getK_content() {
		return k_content;
	}
	public void setK_content(String k_content) {
		this.k_content = k_content;
	}
	
	
}
