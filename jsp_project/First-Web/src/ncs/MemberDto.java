package ncs;

public class MemberDto {
	private String id;
	private String pw;
	private String name;
	private String times;
	
	public MemberDto(String id, String pw, String name, String times) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.times = times;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}
	
}
