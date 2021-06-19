package emp;

import java.util.Scanner;

public class EmpMain {

	public static void main(String[] args) {
		
		EmpManager em = new EmpManager(EmpDao.getInstance());
		
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			while(true) {
				System.out.println("회사원관리 프로그램");
				System.out.println("---------------------------------------");
				System.out.println("[1]회사리스트");
				System.out.println("[2]회사원정보입력");
				System.out.println("[3]회사원정보수정");
				System.out.println("[4]회사원정보삭제");
				System.out.println("[5]프로그램종료");
				System.out.println("---------------------------------------");
				System.out.println("원하시는 기능의 번호를 입력해주세요.");

				int num = Integer.parseInt(sc.nextLine());
				switch(num) {
				case 1:
					em.Emplist();
					break;
				case 2:
					em.inputData();
					break;
				case 3:
					em.editEmp();
					break;
				case 4:
					em.delEmp();
					break;
				case 5:
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("잘못입력하셧습니다. 다시입력하세요.");
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
