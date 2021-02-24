package Java_chobo2.ch13;

class Thread04 extends Thread{

	@Override
	public void run() {
		for(int i = 0; i<300 ; i++) {
			System.out.printf("%s", "|");
		}
		System.out.printf("%n %s %d 나노초%n" , "두번째 작업", System.currentTimeMillis() - ThreadEx02.this);
	}
	
	
	
	
	
}
public class ThreadEx04 {
	static long startTime = 0;
	
	public static void main(String[] args) {
		Thread04

	}

}
