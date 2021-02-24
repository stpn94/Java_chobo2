package Java_chobo2.ch13;

public class Thread01 extends Thread {
	@Override
	public void run() {
		for(int i = 0; i<5; i++) {
			System.out.println("    " + getName());
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
