package lost.model;

import org.springframework.web.multipart.MultipartFile;

public class LostBean {
	private int l_num;

	private String l_name;

	private String l_image;
	
	private String l_content;
	private String l_date;
	private String l_state;
	private MultipartFile upload;
	private String upload2;
	
	
	
	public LostBean() {
		super();
	}
	public LostBean(int l_num, String l_name, String l_image, String l_content, String l_date, String l_state) {
		super();
		this.l_num = l_num;
		this.l_name = l_name;
		this.l_image = l_image;
		this.l_content = l_content;
		this.l_date = l_date;
		this.l_state = l_state;
	}
	public int getL_num() {
		return l_num;
	}
	public void setL_num(int l_num) {
		this.l_num = l_num;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getL_image() {
		return l_image;
	}
	public void setL_image(String l_image) {
		this.l_image = l_image;
	}
	public String getL_content() {
		return l_content;
	}
	public void setL_content(String l_content) {
		this.l_content = l_content;
	}
	public String getL_date() {
		return l_date;
	}
	public void setL_date(String l_date) {
		this.l_date = l_date;
	}
	public String getL_state() {
		return l_state;
	}
	public void setL_state(String l_state) {
		this.l_state = l_state;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
		this.l_image = upload.getOriginalFilename();
	}
	public String getUpload2() {
		return upload2;
	}
	public void setUpload2(String upload2) {
		this.upload2 = upload2;
	}
	
	
}
