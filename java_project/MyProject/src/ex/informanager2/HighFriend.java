package ex.informanager2;

public class HighFriend extends Friend {
	
	// 고교 친구는 직장 정보를 추가적으로 가진다.
	String work;
	
	public HighFriend(String name, String phonNumber, String address, String work) {
		super(name, phonNumber, address);
		this.work = work;
	}

	@Override
	public void showData() {
		super.showData();
		System.out.println("직      업 : " + work);
	}

	@Override
	public void showBasicInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phonNumber);
	}
}
