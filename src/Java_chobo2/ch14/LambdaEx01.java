package Java_chobo2.ch14;

interface LambdaInter {
	public int max(int a, int b);
}

interface LambdaInter1 {
	void printVar(String name, int i);
}

interface LambdaInter2 {
	int square(int x);
}

interface LambdaInter3 {
	int roll();
}

interface LambdaInter4 {
	int sumArr(int[] arr);
}

class LambdaInterClass implements LambdaInter {
	@Override
	public int max(int a, int b) {
		return a > b ? a : b;
	}

}

public class LambdaEx01 {
	public static void main(String[] args) {

		LambdaInterClass lic = new LambdaInterClass();
		int c = lic.max(5, 4);
		System.out.println("max = " + c);
		
		LambdaInter lbi0 = new LambdaInter() {

			@Override
			public int max(int a, int b) {
				return a>b ? a:b;
			}
			
		};
		System.out.println("max  =" + lbi0.max(1, 3));
	

		System.out.println("--------------------------------------------");

		LambdaInter Ibi = (i, j) -> i > j ? i : j;
		int b = Ibi.max(5, 3);
		System.out.println("max = " + b);

		System.out.println("--------------------------------------------");

		LambdaInter1 lbi1 = (String name, int i) -> {
			System.out.println(name + " : " + i);
		};
		lbi1.printVar("김상건", 5);

		System.out.println("--------------------------------------------");

		LambdaInter1 lbi2 = (name, i) -> {
			System.out.println(name + " : " + i);
		};
		lbi1.printVar("김굿굿", 10);

		System.out.println("--------------------------------------------");

		LambdaInter1 lbi3 = (name, i) -> System.out.println(name + " : " + i);
		;
		lbi1.printVar("김건우", 15);

		System.out.println("--------------------------------------------");

		LambdaInter2 lbi4 = (int x) -> x * x;
		LambdaInter2 lbi5 = x -> x * x * x;
		System.out.println("square : " + lbi4.square(5));
		System.out.println("square : " + lbi5.square(5));

		System.out.println("--------------------------------------------");

		LambdaInter3 lbi6 = () -> {
			return (int) (Math.random() + 1 * 6);
		};
		LambdaInter3 lbi7 = () -> (int) (Math.random() * 6); // 리턴 생략 중괄호 생략

		System.out.println("random 값 : " + lbi6.roll());
		System.out.println("random 값 : " + lbi7.roll());

		System.out.println("--------------------------------------------");
		LambdaInter4 lbi8 = (int[] arr) -> {
			int sum = 0;
			for (int i : arr)
				sum += i;
			return sum;
		};
		System.out.println(lbi8.sumArr(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
	}

}
