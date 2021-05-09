package admin.model;

import java.sql.Timestamp;

public class CheckBean {
	private int c_num;
	private String c_name;
	private Timestamp c_date;
	private Timestamp c_intime;
	private Timestamp c_outtime;
	private int c_count;
	private int m_num;

	public CheckBean() {
		super();
	}
	public CheckBean(int c_num, String c_name, Timestamp c_date, Timestamp c_intime, Timestamp c_outtime, int c_count,
			int m_num) {
		super();
		this.c_num = c_num;
		this.c_name = c_name;
		this.c_date = c_date;
		this.c_intime = c_intime;
		this.c_outtime = c_outtime;
		this.c_count = c_count;
		this.m_num = m_num;
	}
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	public int getC_num() {
		return c_num;
	}
	public void setC_num(int c_num) {
		this.c_num = c_num;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public Timestamp getC_date() {
		return c_date;
	}
	public void setC_date(Timestamp c_date) {
		this.c_date = c_date;
	}
	public Timestamp getC_intime() {
		return c_intime;
	}
	public void setC_intime(Timestamp c_intime) {
		this.c_intime = c_intime;
	}
	public Timestamp getC_outtime() {
		return c_outtime;
	}
	public void setC_outtime(Timestamp c_outtime) {
		this.c_outtime = c_outtime;
	}
	public int getC_count() {
		return c_count;
	}
	public void setC_count(int c_count) {
		this.c_count = c_count;
	}
}
