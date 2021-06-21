package teamProject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class JoinDAO {
	
	Scanner sc = new Scanner(System.in);
	List<MemberDTO> m = new ArrayList<>();
	
	
	public void run() {
		
		int key = 0;
		while((key = menu()) != 0) {
			switch(key) {
			case 1:
				Login();
				break;
			case 2:
				MemberJoin();
				break;
			case 3:
				SelectMember();
			}
		}
	}
	
	private void SelectMember() {
		Iterator<MemberDTO> ite = m.iterator();
		
		while(ite.hasNext()) {
			System.out.println(ite.next() + " ");
			
		}
	}
	
	private void MemberJoin() {
		sc.nextLine();
		String id = getStrInput("id : ");
		String pw = getStrInput("pw : ");
		String pw2 = getStrInput("pw confirm : ");
		String name = getStrInput("name : ");
		String phone = getStrInput("phone : ");
		String email = getStrInput("email : ");
		
		if(idCheck(id)) {
			System.out.println("중복된 id입니다.");
		} else if (pw.equals(pw2)) {
			m.add(new MemberDTO(id, pw, name, phone, email));
			System.out.println(id + "님 가입을 축하드립니다.");
		} else {
			System.out.println("비밀번호를 확인해주세요.");
		}
	}
		
	private boolean idCheck(String id) {
		boolean check = true;
		MemberDTO member = FindByID(id);
		if(member == null) {
			check = false;
			return check;
		}
		return check;
	}
	
	private void Login() {
		sc.nextLine();
		String id = getStrInput("id : ");
		String pw = getStrInput("pw : ");
		
		MemberDTO member = FindByID(id);
		if(member == null) {
			System.out.println("등록되지 않은 ID입니다.");
		} else if(member.getPw().equals(pw)) {
			System.out.println("[" + member.getId() + "]님께서 로그인 하셨습니다.");
		} else {
			System.out.println("비밀번호가 틀렸습니다.");
		}
	}
	
	private MemberDTO FindByID(String id) {
		for(MemberDTO memberDTO : m) {
			if(memberDTO.getId().equals(id)) {
				return memberDTO;
			}
		}
		return null;
	}
	
	private String getStrInput(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}
	private int getNumInput(String msg) {
		System.out.println(msg);
		return sc.nextInt();
	}
	
	private int menu() {
		System.out.println("어서오세용");
		return getNumInput("[1]로그인 [2]회원가입 [3]전체 회원 보기 [0]종료");
				
	}
}
