package Java_chobo2.ch13;
class Ex13_12 {
	public static void main(String args[]) {
		Runnable r = new RunnableEx12();
		new Thread(r).start(); // ThreadGroup
		new Thread(r).start(); // ThreadGroup
	}
}

class Account {
	private int balance = 1000;

	public  int getBalance() {
		return balance;
	}

	public void withdraw(int money){
		if(balance >= money) {
			try { Thread.sleep(1000);} catch(InterruptedException e) {}
			balance -= money;
		}
	} // withdraw
}

class RunnableEx12 implements Runnable {
	Account acc = new Account();

	public void run() {
		while(acc.getBalance() > 0) {
			// 100, 200, 300              (withdraw)
			int money = (int)(Math.random() * 2 + 1) * 100;
			acc.withdraw(money);
			System.out.println("balance:"+acc.getBalance());
		}
	} // run()
}