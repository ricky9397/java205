package project03;

public class CompanyContact2 extends Contact{
	private String cName;
	private String buyName;
	private String position;
	
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getBuyName() {
		return buyName;
	}
	public void setBuyName(String buyName) {
		this.buyName = buyName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	@Override
	public void showInfo() {
		System.out.println("거래처회사이름 : " + getcName());
		System.out.println("부서이름 : " + getBuyName());
		System.out.println("직급 : " + getPosition());
	}
}
