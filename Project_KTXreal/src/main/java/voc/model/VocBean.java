package voc.model;

public class VocBean {

	private int	q_num ; 
	private String	q_writer ;/* -- 작성자 */
	private String q_receiver ; /*-- 받는사람*/
	private String q_subject ;
	private String q_reg_date ;
	private int  q_ref ;
    private int q_re_step ;
    private int q_re_level ;
    private String  q_content ;
    private String  q_ip ;
    private String q_state;
    
    
    public VocBean() {
		super();
	}

	public VocBean(int q_num, String q_writer, String q_receiver, String q_subject, String q_reg_date, int q_ref,
			int q_re_step, int q_re_level, String q_content, String q_ip, String q_state) {
		super();
		this.q_num = q_num;
		this.q_writer = q_writer;
		this.q_receiver = q_receiver;
		this.q_subject = q_subject;
		this.q_reg_date = q_reg_date;
		this.q_ref = q_ref;
		this.q_re_step = q_re_step;
		this.q_re_level = q_re_level;
		this.q_content = q_content;
		this.q_ip = q_ip;
		this.q_state = q_state;
	}

	public int getQ_num() {
		return q_num;
	}

	public void setQ_num(int q_num) {
		this.q_num = q_num;
	}

	public String getQ_writer() {
		return q_writer;
	}

	public void setQ_writer(String q_writer) {
		this.q_writer = q_writer;
	}

	public String getQ_receiver() {
		return q_receiver;
	}

	public void setQ_receiver(String q_receiver) {
		this.q_receiver = q_receiver;
	}

	public String getQ_subject() {
		return q_subject;
	}

	public void setQ_subject(String q_subject) {
		this.q_subject = q_subject;
	}

	public String getQ_reg_date() {
		return q_reg_date;
	}

	public void setQ_reg_date(String q_reg_date) {
		this.q_reg_date = q_reg_date;
	}

	public int getQ_ref() {
		return q_ref;
	}

	public void setQ_ref(int q_ref) {
		this.q_ref = q_ref;
	}

	public int getQ_re_step() {
		return q_re_step;
	}

	public void setQ_re_step(int q_re_step) {
		this.q_re_step = q_re_step;
	}

	public int getQ_re_level() {
		return q_re_level;
	}

	public void setQ_re_level(int q_re_level) {
		this.q_re_level = q_re_level;
	}

	public String getQ_content() {
		return q_content;
	}

	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}

	public String getQ_ip() {
		return q_ip;
	}

	public void setQ_ip(String q_ip) {
		this.q_ip = q_ip;
	}

	public String getQ_state() {
		return q_state;
	}
	
	public void setQ_state(String q_state) {
		this.q_state = q_state;
	}
    
}