package Java_chobo2.ch13;

public class Thread02 implements Runnable {

	@Override
	public void run() {
		for(char ch='a' ; ch <= 'z'; ch++) {
			System.out.println(ch);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
