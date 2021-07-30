package cal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
	
	//Calculator cal = new Calculator();
	Calculator cal;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("@Before");
		cal = new Calculator();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After");
	}

	@Test
	public void testAdd() {
		System.out.println("testAdd()");
		//Calculator cal = new Calculator();
		assertEquals("add() 메소드 테스트", 12, cal.add(10, 2));;
//		fail("Not yet implemented");
	}

	@Test
	public void testSubstract() {
		System.out.println("testSubstract()");
		assertEquals("substract() 메소드 테스트", 8 , cal.substract(10, 2));
//		fail("Not yet implemented");
	}

	@Test
	public void testMultiply() {
		System.out.println("testMultiply()");
		assertEquals("multiply() 메소드 테스트", 20, cal.multiply(10, 2));
//		fail("Not yet implemented");
	}

	@Test
	public void testDivide() {
		System.out.println("testDivide()");
		assertEquals("divide() 메소드 테스트", 5, cal.divide(10, 2));
//		fail("Not yet implemented");
	}
	
	@Test(expected = RuntimeException.class)
	public void test1() {
		System.out.println("@Test 실행 중 예외타입을 확인");
		throw new RuntimeException();
	}
	
	
	// 예외타입 비교 테스트
	@Test(timeout = 100) // 100/ 1000 
	public void test2() {
		System.out.println("@Test 테스트중 허용시간 ms 안에 실행 완료 되는지");
		cal.add(100, 200);
		cal.substract(10, 2);
	}
	
	
	@Test
	public void test3() {
		//fail("테스트 미실행");
		//assertTrue("메소드의 반환값이 boolean 인경우 사용", true);
		//assertNull("메소드의 실행 값이 null이 예상되는 경우",new Object());
		//assertNotNull("메소드의 실행 값이 null이 아닌 값이 예상되는 경우", null);
		//assertSame("같은 값일 경우", 1, 1);
		//assertNotSame("같은 값이 아닌 경우", 1, 2);
		assertTrue("메소드의 반환 값이 true 예상할떄", false);
	}
	
}
