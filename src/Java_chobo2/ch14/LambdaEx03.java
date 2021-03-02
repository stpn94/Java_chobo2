package Java_chobo2.ch14;

@FunctionalInterface
interface MyFunctions {
	void myMethod();
}

public class LambdaEx03 {

	public static void main(String[] args) {
		MyFunctions f = ()->System.out.println("myMethod");
		
		aMethod(f);
		aMethod(()->System.out.println("myTwomethod"));
	}
	
	public static void aMethod(MyFunctions f ) {
		f.myMethod();
	}
}
