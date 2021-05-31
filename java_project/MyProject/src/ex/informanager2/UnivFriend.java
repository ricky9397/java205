package ex.informanager2;

public class UnivFriend extends Friend{
	
	// 대학 친구는 전공 정보를 가진다.
	String major;
	
	public UnivFriend(String name, String phonNumber, String address, String major) {
		super(name, phonNumber, address);
		this.major = major;
	}
	
	@Override
	public void showData() {
		super.showData();
		System.out.println("전      공 : " + major);
	}
	
	@Override
	public void showBasicInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phonNumber);
		System.out.println("전공 : " + major);
	}
}
