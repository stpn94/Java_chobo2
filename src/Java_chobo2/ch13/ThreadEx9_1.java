package Java_chobo2.ch13;

class ThreadEx9_1 extends Thread {
	public void run() {
		int i = 10;

		while(i!=0 && !isInterrupted()) {
			System.out.println(i--);
			for(long x=0;x<2500000000L;x++); // �ð� ����
		}
		System.out.println("ī��Ʈ�� ����Ǿ����ϴ�.");
	} 
}