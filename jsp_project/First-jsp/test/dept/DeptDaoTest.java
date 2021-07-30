package dept;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dept.dao.DeptDao;
import dept.domain.Dept;
import jdbc.util.ConnectionProvider;

public class DeptDaoTest {
	
	static DeptDao dao;
	static Connection conn;
	Dept dept;
	List<Dept> list;
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		conn = ConnectionProvider.getConnection();
		dao = DeptDao.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDeptList() {
		assertNotNull("list 확인", dao.getDeptList(conn));
		
	}

	@Test
	public void testInsertDept() {
		int resultCnt = dao.insertDept(conn, new Dept(60, "test", "LA"));
		assertSame("입력 확인", resultCnt, 1);
	}

	@Test
	public void testDeleteDept() {
		int resultCnt = dao.deleteDept(conn, 60);
		assertSame("삭제 확인", resultCnt, 1);
	}

	@Test
	public void testSelectByDeptno() {
		dept = dao.selectByDeptno(conn, 10);
		assertNotNull("deptno 확인", dept);
	}

	@Test
	public void testUpdateDept() {
		int resultCnt = dao.updateDept(conn, new Dept(40, "SALES", "서울"));
		assertEquals("업데트확인", resultCnt, 1);
	}

}
