package inboard.model;

import org.springframework.web.multipart.MultipartFile;

public class InBoardBean {
	private int i_num;
	private String i_reg_date;
	private String i_writer;
	private String i_subject;
	private String i_passwd;
	private int i_readcount;
	private String i_content;
	private String i_filename;
	private MultipartFile uploadFile;
	private String i_preuploadFile;
	
	
	public InBoardBean() {
		super();
	}
	public InBoardBean(int i_num, String i_reg_date, String i_writer, String i_subject, String i_passwd,
			int i_readcount, String i_content, String i_filename) {
		super();
		this.i_num = i_num;
		this.i_reg_date = i_reg_date;
		this.i_writer = i_writer;
		this.i_subject = i_subject;
		this.i_passwd = i_passwd;
		this.i_readcount = i_readcount;
		this.i_content = i_content;
		this.i_filename = i_filename;
	}
	public int getI_num() {
		return i_num;
	}
	public void setI_num(int i_num) {
		this.i_num = i_num;
	}
	public String getI_reg_date() {
		return i_reg_date;
	}
	public void setI_reg_date(String i_reg_date) {
		this.i_reg_date = i_reg_date;
	}
	public String getI_writer() {
		return i_writer;
	}
	public void setI_writer(String i_writer) {
		this.i_writer = i_writer;
	}
	public String getI_subject() {
		return i_subject;
	}
	public void setI_subject(String i_subject) {
		this.i_subject = i_subject;
	}
	public String getI_passwd() {
		return i_passwd;
	}
	public void setI_passwd(String i_passwd) {
		this.i_passwd = i_passwd;
	}
	public int getI_readcount() {
		return i_readcount;
	}
	public void setI_readcount(int i_readcount) {
		this.i_readcount = i_readcount;
	}
	public String getI_content() {
		return i_content;
	}
	public void setI_content(String i_content) {
		this.i_content = i_content;
	}
	public String getI_filename() {
		return i_filename;
	}
	public void setI_filename(String i_filename) {
		this.i_filename = i_filename;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
		this.i_filename = uploadFile.getOriginalFilename();
	}
	public String getI_preuploadFile() {
		return i_preuploadFile;
	}
	public void setI_preuploadFile(String i_preuploadFile) {
		this.i_preuploadFile = i_preuploadFile;
	}
	
	
}
