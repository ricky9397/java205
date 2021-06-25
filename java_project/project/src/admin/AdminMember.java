package admin;

public class AdminMember {
	private int idx;
	private String id;
	private String pw;
	private String name;
	private String phonenum;
	private String email;
	
	
	public AdminMember(int idx, String id, String pw, String name, String phonenum, String email) {
		this.idx = idx;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phonenum = phonenum;
		this.email = email;
	}


	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
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


	public String getPhonenum() {
		return phonenum;
	}


	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "AdminMember [idx=" + idx + ", id=" + id + ", pw=" + pw + ", name=" + name + ", phonenum=" + phonenum
				+ ", email=" + email + "]";
	}
	
	
	
}
