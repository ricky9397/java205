 package Scool;

import java.util.*;

public class Student {
	Scanner sc = new Scanner(System.in);
	private String studentName;
	private String phonNumber;
	private String major;
	private int grade;
	private String email;
	private int birthday;
	private String address;
    ArrayList<Student> student = new ArrayList<Student>();
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getPhonNumber() {
		return phonNumber;
	}
	public void setPhonNumber(String phonNumber) {
		this.phonNumber = phonNumber;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBirthday() {
		return birthday;
	}
	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}	
	
	void showInfo() throws InterruptedException {
		while(true) {
			System.out.println("안녕하세요. 학생관리팀입니다.");
			System.out.println("[1]학생프로필입력 [2]학생프로필변경 [3]총학생목록 [4]학생데이터삭제 [5]프로그램종료");
			int input = sc.nextInt();
			switch(input) {
			case 1:
				profile(); 
				break;
			case 2:
				change();
				break;
			case 3:
				allSelect();
				break;
			case 4:
				delete();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				System.exit(5);
			default:
				System.out.println("잘못입력하셧습니다. 다시입력해주세요.");
				break;
			} //switch end
		} //while end
	} // 메소드 끝
	
	void profile() throws InterruptedException {
		while(true) {
			Student st = new Student();
			
			while(true) {
				System.out.println("학생이름을 입력하세요.");
				String name = sc.next();
				int cnt = 0;
				for(int i = 0; i < student.size(); i++) {
					if(name.equals(student.get(i).getStudentName())) {
						cnt++;
						System.out.println("학생이름 중복입니다. 다시입력하세요.");
						break;
					}
				}
				if(cnt == 0) {
					st.setStudentName(name);
					break;
				}
			}
			System.out.println("전화번호입력");
			st.setPhonNumber(sc.next());
			System.out.println("전공입력");
			st.setMajor(sc.next());
			System.out.println("학년입력");
			st.setGrade(sc.nextInt());
			System.out.println("이메일입력");
			st.setEmail(sc.next());
			System.out.println("생일입력");
			st.setBirthday(sc.nextInt());
			System.out.println("주소입력");
			st.setAddress(sc.next());
			
			System.out.println("이름 : " + st.getStudentName());
			System.out.println("전화번호 : " + st.getPhonNumber());
			System.out.println("전공 : " + st.getMajor());
			System.out.println("학년 : " + st.getGrade());
			System.out.println("이메일 : " + st.getEmail());
			System.out.println("생일 : " + st.getBirthday());
			System.out.println("주소 : " + st.getAddress());
			Thread.sleep(1000);
			
			System.out.println("입력한 사항이 모두 맞습니까? 예(y) 아니오(n)");
			String input = sc.next();
			
			if(input.equalsIgnoreCase("y")) {
				student.add(st);
				System.out.println("입력완료");
				break;
			} else if(input.equalsIgnoreCase("n")) {
				System.out.println("학생을 새로 입력하세요.");
			} else {
				System.out.println("잘못 누르셨습니다. 초기 메뉴로 이동합니다.");
				break;
			}
		}
	}
	
	void change() {
		while(true) {
			System.out.println("수정할 학생을 입력해주세요.");
			String name = sc.next();
			int cnt = 0;
			for (int i = 0; i < student.size(); i++) {
				if(name.equals(student.get(i).getStudentName())) {
					System.out.println("새로운 전화번호 입력");
					student.get(i).setPhonNumber(sc.next());
					System.out.println("새로운 학련 입력");
					student.get(i).setGrade(sc.nextInt());
					System.out.println("새로운 주소 입력");
					student.get(i).setAddress(sc.next());
					cnt++;
					System.out.println("수정완료");
					break;
				}
			}
			if(cnt == 0) {
				System.out.println("해당 이름이 존재하지않습니다.");
			} else {
				break;
			}
		}
	}
	
	void allSelect() throws InterruptedException {
		while(true) {
			for(int i = 0; i < student.size(); i++) {
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
				System.out.println("이름 : " + student.get(i).getStudentName());
				System.out.println("전화번호 : " + student.get(i).getPhonNumber());
				System.out.println("전공 : " + student.get(i).getMajor());
				System.out.println("학년 : " + student.get(i).getGrade());
				System.out.println("이메일 : " + student.get(i).getEmail());
				System.out.println("생일 : " + student.get(i).getBirthday());
				System.out.println("주소 : " + student.get(i).getAddress());
			}
			System.out.println("초기 메뉴 이동:[z] \t 프로그램종료:[0]");
			String input = sc.next();
			if(input.equalsIgnoreCase("z")) {
				break;
			} else if (input.equalsIgnoreCase("0")) {
				System.out.println("프로그램을 종료합니다.");
				Thread.sleep(1000);
				System.exit(0);
			} else {
				System.out.println("잘못 누르셧습니다. 초기화면으로 이동");
				break;
			}
		}
	}
	
	void delete() {
		while(true) {
			System.out.println("삭제할 이름을 입력해주세요.");
			String input = sc.next();
			int cnt = 0;
			for (int i = 0; i < student.size(); i++) {
				if(input.equals(student.get(i).getStudentName())) {
					student.remove(i);
					cnt++;
					System.out.println("삭제 완료");
					break;
				}
			}
			if(cnt == 0) {
				System.out.println("존재하지 않는 이름입니다. 다시입력해주세요.");
			} else {
				break;
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Student str = new Student();
		str.showInfo();
	}
}
