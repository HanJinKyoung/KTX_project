package train.model;

public class TrainBean {
	private int t_num;
	private String t_type;
	private String t_way;
	private int t_count;
	//t_way 삽입
	private String t_way1;
	private String t_way2;
	
	
	public TrainBean() {
		super();
	}
	public TrainBean(int t_num, String t_type, String t_way, int t_count) {
		super();
		this.t_num = t_num;
		this.t_type = t_type;
		this.t_way = t_way;
		this.t_count = t_count;
	}
	public int getT_num() {
		return t_num;
	}
	public void setT_num(int t_num) {
		this.t_num = t_num;
	}
	public String getT_type() {
		return t_type;
	}
	public void setT_type(String t_type) {
		this.t_type = t_type;
	}
	public String getT_way() {
		return t_way;
	}
	public void setT_way(String t_way) {
		this.t_way = t_way;
	}
	public int getT_count() {
		return t_count;
	}
	public void setT_count(int t_count) {
		this.t_count = t_count;
	}
	public String getT_way1() {
		return t_way1;
	}
	public void setT_way1(String t_way1) {
		this.t_way1 = t_way1;
	}
	public String getT_way2() {
		return t_way2;
	}
	public void setT_way2(String t_way2) {
		this.t_way2 = t_way2;
	}
	
	
}
