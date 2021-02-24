package Java_chobo2.ch13;

public class ThreadEx01 {

	public static void main(String[] args) {
		Thread01 th1 = new Thread01();
		th1.start();
//		th1.run();
		
		Thread02 runnable = new Thread02();
		Thread th2 = new Thread(runnable);
		th2.start();

		for (int i = 0; i < 10; i++) {
			System.out.println(i + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Done.");
	}
}
