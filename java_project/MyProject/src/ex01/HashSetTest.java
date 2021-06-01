package ex01;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public static void main(String[] args) {
		// HashSet 저장 공간 생성 : 인스턴스저장,
		// 중복 저장을 허용하지 않는다.
		// 저장 순서를 저장하지 않는다.
		
		HashSet<String> hashSet = new HashSet<String>();
		
		// 데이터 저장
		hashSet.add("First");
		hashSet.add("Second");
		hashSet.add("Third");
		hashSet.add("First");
		
		// 데이터의 일괄 처리
		Iterator<String> itr = hashSet.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
