package project03;

public class CompanyContact extends Contact {
	private String cpName;
	private String dmName;
	private String position;
	
	public String getCpName() {
		return cpName;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	public String getDmName() {
		return dmName;
	}
	public void setDmName(String dmName) {
		this.dmName = dmName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public void showInfo() {
		System.out.println("회사이름 : " + getCpName());
		System.out.println("부서이름 : " + getDmName());
		System.out.println("직급 : " + getPosition());
	}
	
	public void company() {
		
	}
}
