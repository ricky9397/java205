package ex01;

public class ThreadSyncTest {

	public static void main(String[] args) {
		
		Increment inc = new Increment();
		
		// 스레드 생성
		IncThread it1 = new IncThread(inc);
		IncThread it2 = new IncThread(inc);
		IncThread it3 = new IncThread(inc);
		
		it1.start();
		it2.start();
		it3.start();
		
		try {
			it1.join();
			it2.join();
			it3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(inc.getNum());
		
	}

}

class IncThread extends Thread {
	
	Increment inc;
	
	IncThread(Increment inc) {
		this.inc = inc;
	}
	public void run() {
		for (int i = 0; i < 10000; i++) {
			inc.increment();
		}
	}
}

class Increment {
	int num = 0;
	
	public synchronized void increment() {
		num++;
	}
	public int getNum() {
		return num;
	}
	
}
