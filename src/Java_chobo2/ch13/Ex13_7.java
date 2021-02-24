package Java_chobo2.ch13;

public class Ex13_7 {

	public static void main(String[] args) {
		Thread t = new Thread(new Thread03());
		t.setDaemon(true); // 이 부분이 없으면 종료 안함.
		t.start();

		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			System.out.println(i);

			if (i == 5)
				Thread03.autoSave = true;
		}

		System.out.println("프로그램을 종료합니다..");
	}

}