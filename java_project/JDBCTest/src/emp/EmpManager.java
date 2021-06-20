package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmpManager {
	
	private EmpDao dao;
	private Scanner sc;
	private String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "hr";
	private String pw = "tiger";
	
	
	public EmpManager(EmpDao dao) {
		this.dao = dao;
		sc = new Scanner(System.in);
	}
	
	// 전체리스트 출력메소드
	void Emplist() {
		// Connection 객체 생성 -> 트렌젝션 처리 가능
		Connection con = null;

		try {
			con = DriverManager.getConnection(jdbcUrl, user, pw);
			
			List<EmpDto> list = dao.getdeptList(con);
			
			System.out.println("회사 정보 리스트");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("직원번호\t 직원이름\t 직책\t 담당매니저\t 입사일\t 월급\t 보너스\t 부서번호\t");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			
			for(EmpDto emp : list) {
				System.out.printf("%d\t %s\t %s %d\t %s\t %d\t %d\t %d \n",
									emp.getEmpno(),
									emp.getEname(),
									emp.getJob(),
									emp.getMgr(),
									emp.getHiredate(),
									emp.getSal(),
									emp.getComm(),
									emp.getDeptno());
			}
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("데이터베이스 연결성공!!!");
	}
	
	// 데이터 입력
	void inputData() {
		// Connection 객체 생성 -> 트렌젝션 처리 가능
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(jdbcUrl, user, pw);
			
			System.out.println("회사원 정보를 입력합니다.");
			System.out.println("직원번호 직원명 직책 담당매니저 입사일 월급 보너스 부서번호");
			System.out.println("예)8150 SCOTT MANAGER 7900 21/06/19 1500 300 20");
			String inputData = sc.nextLine();
			String[] EmpData = inputData.split(" ");
			
			EmpDto emp = new EmpDto(Integer.parseInt(EmpData[0]), EmpData[1], EmpData[2], Integer.parseInt(EmpData[3]), EmpData[4], Integer.parseInt(EmpData[5]), Integer.parseInt(EmpData[6]), Integer.parseInt(EmpData[7]));
			
			int result = dao.insertEmp(con, emp);
			
			if(result > 0) {
				System.out.println("입력되었습니다.");
			} else {
				System.out.println("입력 실패!!!!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 데이터 수정
	void editEmp() {
		// Connection 객체 생성 -> 트렌젝션 처리 가능
		Connection con = null;

		try {
			con = DriverManager.getConnection(jdbcUrl, user, pw);
			
			System.out.println("회사원 정보를 수정합니다.");
			System.out.println("회사원의 월급을수정합니다.");
			System.out.println("이름 월급을 입력해주세요.");
			String editEmp = sc.nextLine();
			String[] eData = editEmp.split(" ");
			
			EmpDto emp = new EmpDto(0, eData[0], null, 0, null, Integer.parseInt(eData[1]), 0, 0);
			
			int result = dao.updateEmp(con, emp);
			
			if(result > 0) {
				System.out.println("수정되었습니다.");
			} else {
				System.out.println("수정실패!!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void delEmp() {
		// Connection 객체 생성 -> 트렌젝션 처리 가능
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(jdbcUrl, user, pw);
			
			Emplist();
			System.out.println("삭제를 원하신느 사원번호를 입력해주세요.");
			int empno = sc.nextInt();
			
			int result = dao.deleteEmp(con, empno);
			
			if(result > 0) {
				System.out.println("삭제되었습니다.");
			} else {
				System.out.println("삭제실패! 해당 사원의 정보가없습니다.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
