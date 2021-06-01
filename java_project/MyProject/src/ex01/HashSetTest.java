package ex01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		// HashSet 저장 공간 생성 : 인스턴스저장,
		// 중복 저장을 허용하지 않는다.
		// 저장 순서를 저장하지 않는다.
		
		Set<SimpleNumber> hashSet = new HashSet<>();
		
		// 데이터 저장
		hashSet.add(new SimpleNumber(10));
		hashSet.add(new SimpleNumber(20));
		hashSet.add(new SimpleNumber(20));
		
		// 데이터의 일괄 처리
		Iterator<SimpleNumber> itr = hashSet.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}

class SimpleNumber {
	
	int num;
	
	SimpleNumber(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return String.valueOf(num);
	}
	
	
	
}
