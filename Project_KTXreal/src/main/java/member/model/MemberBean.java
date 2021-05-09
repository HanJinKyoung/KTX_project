package member.model;

import java.sql.Timestamp;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class MemberBean {

	private int m_num;
	private String m_grade;
	@Pattern(regexp = "^[0-9a-zA-Z]+$", message = "영문과 숫자만 입력가능합니다")
	@Length(max=20,message="20글자 이내로 적어주세요")
	private String m_id;
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{1,}$", message = "영문,숫자,!@#$%^*+=- 포함 1자리 이상  적어주세요")
	@Length(max=20,message="20글자 이내로 적어주세요")
	private String m_pw;
	@NotBlank(message = "이름을 적어주세요.")
	@Length(max=10,message="10글자 이내로 적어주세요")
	private String m_name;
	@Pattern(regexp = "^[0-9]+$", message = "나이는 숫자로 입력하세요")
	@Length(max=3,message="3자리 이내로 적어주세요")
	private String m_age;
	@Pattern(regexp = "^01(?:0|1|[6-9])$", message = "올바른 번호를 입력하세요")
	private String m_phone_1;
	@Pattern(regexp = "^(\\d{3,4})$", message = "올바른 번호를 입력하세요")
	private String m_phone_2;
	@Pattern(regexp = "^(\\d{4})$", message = "올바른 번호를 입력하세요")
	private String m_phone_3;
	@Email(message="올바른 이메일 형식이 아닙니다")
	@NotBlank(message="올바른 이메일 형식이 아닙니다")
	@Length(max=30,message="30글자 이내로 적어주세요")
	private String m_email;
	@NotBlank(message = "주소는 필수 입력입니다.")
	@Length(max=25,message="25글자 이내로 적어주세요")
	private String m_addr;
	private Timestamp  m_date;
	
	
	public MemberBean() {
		super();
	}
	public MemberBean(int m_num, String m_grade, String m_id, String m_pw, String m_name, String m_age,
			String m_phone_1, String m_phone_2, String m_phone_3, String m_email, String m_addr, Timestamp m_date) {
		super();
		this.m_num = m_num;
		this.m_grade = m_grade;
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_age = m_age;
		this.m_phone_1 = m_phone_1;
		this.m_phone_2 = m_phone_2;
		this.m_phone_3 = m_phone_3;
		this.m_email = m_email;
		this.m_addr = m_addr;
		this.m_date = m_date;
	}
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	public String getM_grade() {
		return m_grade;
	}
	public void setM_grade(String m_grade) {
		this.m_grade = m_grade;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_age() {
		return m_age;
	}
	public void setM_age(String m_age) {
		this.m_age = m_age;
	}
	public String getM_phone_1() {
		return m_phone_1;
	}
	public void setM_phone_1(String m_phone_1) {
		this.m_phone_1 = m_phone_1;
	}
	public String getM_phone_2() {
		return m_phone_2;
	}
	public void setM_phone_2(String m_phone_2) {
		this.m_phone_2 = m_phone_2;
	}
	public String getM_phone_3() {
		return m_phone_3;
	}
	public void setM_phone_3(String m_phone_3) {
		this.m_phone_3 = m_phone_3;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_addr() {
		return m_addr;
	}
	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}
	public Timestamp getM_date() {
		return m_date;
	}
	public void setM_date(Timestamp m_date) {
		this.m_date = m_date;
	}
}