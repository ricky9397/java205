package ex.informanager3;

import java.util.ArrayList;
import java.util.Scanner;

public class FriendInfoHandler {
	
	// 저장 데이터(객체)를 배열로 저장하고 관리하는 기능을 가지는 클래스
	// 2021-5-31
	// 배열 -> 컬렉션 바꿔보자
	ArrayList<Friend> friends;
	
	//Friend[] friends;
	//int numOfFriend; // 배열의 입력 index 역할, 정보의 개수
	
	// 생성자 
	public FriendInfoHandler(int num) { // 배열의 사이즈 -> 배열 인스턴스 생성
		friends = new ArrayList<Friend>(num);
		//this.friends = new Friend[num];
		//this.numOfFriend = 0;
	}
	
	// 데이터의 입력 처리
	// 사용자로부터 친구의 정보를 입력 받아서 -> 인스턴스를 생성 -> 배열에 저장
	public void addFriend(int choice) { // choice -> 1(고교) or 2(대학)
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름을 입력해주세요 >> ");
		String name = sc.nextLine();
		System.out.println("전화번호를 입력해주세요 >> ");
		String phonNumber = sc.nextLine();
		System.out.println("주소를 입력해주세요 >> ");
		String address = sc.nextLine();
		
		if(choice == 1) { // 고교 친구
			System.out.println("직업을 입력해주세요 >> ");
			String work = sc.nextLine();
			
			// 인스턴스 생성
//			HighFriend hFriend = new HighFriend(name, phonNumber, address, work);
			addFriendInfo(new HighFriend(name, phonNumber, address, work));
			
			// 배열에 요소 추가
//			friends[numOfFriend] = hFriend;
//			numOfFriend++;
			
		} else { // 2. 대학친구
			System.out.println("전공을 입력해주세요 >> ");
			String major = sc.nextLine();
			
			// 인스턴스 생성
//			UnivFriend uFriend = new UnivFriend(name, phonNumber, address, major);
			addFriendInfo(new UnivFriend(name, phonNumber, address, major));
			
			// 배열 요소 추가
//			friends[numOfFriend] = uFriend;
//			numOfFriend++;
		}
	}
	
	// Friend 클래스를 상속하는 타입의 인스턴스를 받아 배열에 저장
	public void addFriendInfo(Friend f) {
		// 배열 요소 추가
//		friends[numOfFriend++] = f;
		
		// 컬렉션 : List에 요소 추가
		friends.add(f);
		System.out.println("정보가 저장되었습니다.");
	}
	
	// 모든 데이터를 출력하는 메소드
	public void showAllData() {
		System.out.println("친구의 모든 정보를 출력합니다.");
		System.out.println("--------------------------");
		// 2021-05-31 : 수정
		// 요소의 저장방식 배열 -> 컬렉션 => 반복문 수정
		if(friends.size() > 0) {
			for(int i = 0; i < friends.size(); i++) {
//				friends[i].showData();
				friends.get(i).showData();
				System.out.println("-------------------------");
			}
		} else {
			System.out.println("입력된 정보가 없습니다.");
		}
		
		System.out.println("--------------------------");
		
	}
	
	public void showAllBasicData() {
		System.out.println("친구의 모든 기본정보를 출력합니다.");
		System.out.println("--------------------------");
		
		if(!friends.isEmpty()) {
			for(int i = 0; i < friends.size(); i++) {
//				friends[i].showBasicInfo();
				friends.get(i).showBasicInfo();
				System.out.println("-------------------------");
			}
		} else {
			System.out.println("입력된 정보가 없습니다.");
		}
		
		System.out.println("--------------------------");
		
	}
}
